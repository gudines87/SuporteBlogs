package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Comentario;
//import negocios.Usuario;
import interfaces.ComentarioDAO;

public class JDBCComentarioDAO implements ComentarioDAO {

	private Connection con;
	
	
	public JDBCComentarioDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public void salvarComentario(Comentario comentario) {
		
		try{
		String sql = "insert into Comentario(comentario,idUsuario) values (?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, comentario.getComentario());
		ps.setString(2, comentario.getUsuario().getId()); //
		ps.executeUpdate();
		ps.close();
		//con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao salvar comentario em JDBCComentarioDAO", e);
		}
	}

	@Override
	public Comentario consultarComentario(int cod) {
		
		try{
			Comentario comentario = new Comentario();
			//Usuario u = new Usuario();
			String sql = "select * from Comentario where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				comentario.setCod(rs.getInt("cod"));
				comentario.setComentario(rs.getString("comentario"));
				//comentario.setUsuario(u.consultarUsuario(rs.getString("idUsuario")));
			}
			ps.close();
			//con.close();
			return comentario;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar comentario em JDBCComentarioDAO", e);
		}
	}

	@Override
	public void removerComentario(int cod) {
		
		try{
			String sql = "delete from Comentario where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ps.executeUpdate();
			ps.close();
			//con.close;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover comentario em JDBCComentarioDAO", e);
		}
	}

}
