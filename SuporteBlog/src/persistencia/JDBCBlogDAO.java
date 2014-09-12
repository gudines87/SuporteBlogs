package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Administrador;
import negocios.Blog;
import interfaces.BlogDAO;

public class JDBCBlogDAO implements BlogDAO {

	
	private Connection con;
	
	
	public JDBCBlogDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public int criarBlog(Blog blog) {
		
		try{
			int codigo = 0;
			String sql = "insert into Blog(nome,url,imagemDeFundo,palavrasChave, idAdministrador)" +
					"values (?,?,?,?,?,?)";
			String sqlRecuperaCodigo = "select max(cod) from Blog";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, blog.getNome());
			ps.setString(2, blog.getUrl());
			ps.setString(3, blog.getImagemDeFundo());
			ps.setString(4, blog.getPalavrasChave());
			ps.setString(5, blog.getAdministrador().getId());
			
			ps.executeUpdate();
			
			ps = con.prepareStatement(sqlRecuperaCodigo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				codigo = rs.getInt(1);
			}
			ps.close();
			//con.close();
			return codigo;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao criar blog em JDBCBlogDAO", e);
		}
		
	}

	@Override
	public Blog consultarBlog(int cod) {
		try{
			Blog blog = new Blog();
			Administrador ad = new Administrador();
			String sql = "select * from Blog where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				blog.setCod(rs.getInt("cod"));
				blog.setUrl(rs.getString("url"));
				blog.setImagemDeFundo(rs.getString("imagemDeFundo"));
				blog.setNome(rs.getString("nome"));
				blog.setPalavrasChave(rs.getString("palavrasChave"));
				blog.setAdministrador(ad.consultarAdministrador(rs.getString("idAdministrador")));
			}
			ps.close();
			//con.close();
			return blog;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar blog em JDBCBlogDAO", e);
		}
		
	}

	@Override
	public void removerBlog(int cod) {
		
		try{
			String sql = "delete from Blog where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ps.executeUpdate();
			ps.close();
			//con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover blog em JDBCBlogDAO", e);
		}
	}

}
