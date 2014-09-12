package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Blog;
import negocios.Post;
import interfaces.PostDAO;

public class JDBCPostDAO implements PostDAO{

	private Connection con;
	
	
	public JDBCPostDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public void criarPost(Post post) {
		
		try{
			String sql = "insert into Post(codBlog, idAdministrador) values (?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, post.getBlog().getCod());
			ps.setString(2, post.getAdministrador().getId());
			ps.executeUpdate();
			ps.close();
			//con.close();
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
			//Administrador ad = new Administrador();
			
			String sql = "select * from Post where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				post.setCod(rs.getInt("cod"));
				post.setBlog(blog.consultarBlog(rs.getInt("codBlog")));
				////post.setAdministrador(ad.consultarUsuario(rs.getString("idAdministrador")));
			}
			ps.close();
			//con.close();
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
			//con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover post em JDBCPostDAO", e);
		}
		
	}
	

}
