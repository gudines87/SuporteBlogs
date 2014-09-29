package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Profile;
import negocios.Blog;
import negocios.Post;
import interfaces.PostDAO;

public class JDBCPostDAO implements PostDAO{

	private Connection con;
	
	
	public JDBCPostDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public int criarPost(Post post) {
		
		try{			
			int codigo = 0;
			String sql = "insert into Post(idBlog, usuarioLogin, titulo, texto)"
					+ " values (?,?,?,?)";
			String sqlRecuperaCodigo = "select max(cod) from Post";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, post.getBlog().getId());
			ps.setString(2, post.getUsuario().getLogin());
			ps.setString(3, post.getTitulo());
			ps.setString(4, post.getTexto());
			ps.executeUpdate();
			
			ps = con.prepareStatement(sqlRecuperaCodigo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				codigo = rs.getInt(1);
			}
			ps.close();
			con.close();
			return codigo;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao criar post em JDBCPostDAO", e);
		}
		
	}

	@Override
	public Post consultarPost(int cod) {
		
		try{
			Post post = new Post();
			Blog blog = new Blog();
			Profile usuario = new Profile();
			
			String sql = "select * from Post where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				post.setCod(rs.getInt("cod"));
				post.setBlog(blog.consultarBlog(rs.getInt("idBlog")));
				post.setUsuario(usuario.consultarPorLogin(rs.getString("usuarioLogin")));
				post.setTexto(rs.getString("texto"));
				post.setTitulo(rs.getString("titulo"));
			}
			ps.close();
			con.close();
			return post;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar post em JDBCPostDAO", e);
		}
	}

	@Override
	public void removerPost(int cod) {
		
		try{
			String sql = "delete from Post where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover post em JDBCPostDAO", e);
		}
		
	}
	

}
