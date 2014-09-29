package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Post;
import negocios.Profile;
import negocios.Comentario;

//import negocios.Usuario;
import interfaces.ComentarioDAO;

public class JDBCComentarioDAO implements ComentarioDAO {

	private Connection con;
	
	
	public JDBCComentarioDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public int salvarComentario(Comentario comentario) {
		
		try{
			
		int codigo = 0;
		String sql = "insert into Comentario(tipo, conteudo, codPost, usuarioLogin)"
				+ " values (?,?,?,?)";
		String sqlRecuperaCodigo = "select max(codigo) from Comentario";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, comentario.getTipo());
		ps.setString(2, comentario.getConteudo());
		ps.setInt(3, comentario.getPost().getCod());
		ps.setString(4, comentario.getUsuario().getLogin());
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
			throw new RuntimeException("Falha ao salvar comentario em JDBCComentarioDAO", e);
		}
	}

	@Override
	public Comentario consultarComentario(int id) {
		
		try{
			Profile usuario = new Profile();
			Comentario comentario = new Comentario();
			Post post = new Post();
			String sql = "select * from Comentario where codigo = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			comentario.setCodigo(id);
			comentario.setConteudo(rs.getString("conteudo"));
			comentario.setPost(post.consultarPost(rs.getInt("codPost")));
			comentario.setTipo(rs.getString("tipo"));
			comentario.setUsuario(usuario.consultarPorLogin(rs.getString("usuarioLogin")));
			}
			ps.close();
			con.close();
			return comentario;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar comentario em JDBCComentarioDAO", e);
		}
	}

	@Override
	public void removerComentario(int cod) {
		
		try{
			String sql = "delete from Comentario where codigo = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover comentario em JDBCComentarioDAO", e);
		}
	}

}
