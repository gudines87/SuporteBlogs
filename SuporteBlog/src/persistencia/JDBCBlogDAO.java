package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Profile;
import negocios.Blog;
import interfaces.BlogDAO;

public class JDBCBlogDAO implements BlogDAO {

	
	private Connection con;
	
	
	public JDBCBlogDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@SuppressWarnings("null")
	@Override
	public int createBlog(Blog blog) {
		
		try{
			int id = 0;
			int qtdBlogs = 0;
			String sql = "insert into Blog(titulo, descricao, imagemFundo, autz_comment, autz_comment_annon, "
					+ "blackground, usuarioLogin) values(?,?,?,?,?,?,?)";
			String sqlRecuperaCodigo = "select max(cod) from Blog";			
			String sql2 = "select count(*) from Blog where dono = "+blog.getProfile().getLogin();
			
			PreparedStatement ps = con.prepareStatement(sql2);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				qtdBlogs = rs.getInt(1);
			}
			
			if(qtdBlogs < 3){
			ps = con.prepareStatement(sql);
			ps.setString(1, blog.getTitulo());
			ps.setString(2, blog.getDescricao());
			ps.setString(3, blog.getImagemFundo());
			ps.setBoolean(4, blog.getAutz_comment());
			ps.setBoolean(5, blog.getAutz_comment_annon());
			ps.setString(6, blog.getBackground());
			ps.setString(7, blog.getProfile().getLogin());
			ps.executeUpdate();
			
				ps = con.prepareStatement(sqlRecuperaCodigo);
				ResultSet rs2 = ps.executeQuery();
				if(rs2.next()){
					id = rs2.getInt(1);
				}
			
			
			ps.close();
			con.close();
			return id;
			}
			
			
			ps.close();
			con.close();
			return (Integer) null;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao criar blog em JDBCBlogDAO", e);
		}
		
	}

	@Override
	public Blog consultarBlog(int id) {
		try{
			Blog blog = new Blog();
			Profile profile = new Profile();
			String sql = "select * from Blog where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				blog.setAutz_comment(rs.getBoolean("autz_comment"));
				blog.setAutz_comment_annon(rs.getBoolean("autz_comment_annon"));
				blog.setBackground(rs.getString("backgroud"));
				blog.setImagemFundo(rs.getString("imagemFundo"));
				blog.setProfile(profile.consultarPorLogin(rs.getString("dono")));
				blog.setTitulo(rs.getString("titulo"));
			}
			ps.close();
			con.close();
			return blog;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar blog em JDBCBlogDAO", e);
		}
		
	}

	@Override
	public void removerBlog(int id) {
		
		try{
			String sql = "delete from Blog where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover blog em JDBCBlogDAO", e);
		}
	}

	@Override
	public void changeBlogInformation(int id, String atributo, String conteudo) {
		try{
			String sql = "";
			if(atributo.equals("titulo")){
				sql = "update Blog set titulo = ? where id = ?";
			}else if(atributo.equals("descricao")){
				sql = "update Blog set descricao = ? where id = ?";
			}else if(atributo.equals("imagemFundo")){
				sql = "update Blog set imagemFundo = ? where id = ?";
			}else if(atributo.equals("autz_comment")){
				sql = "update Blog set autz_comment = ? where id = ?";
			}else if(atributo.equals("autz_comment_annon")){
				sql = "update Blog set autz_comment_annon = ? where id = ?";
			}else if(atributo.equals("background")){
				sql = "update Blog set backgroud = ? where id = ?";
			}else if(atributo.equals("dono")){
				sql = "update Blog set dono = ? where id = ?";
			}
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, conteudo);
			
			ps.executeUpdate();
			ps.close();
			con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao atualizar blog em JDBCBlogDAO", e);
			}
		
	}
	
	
}
