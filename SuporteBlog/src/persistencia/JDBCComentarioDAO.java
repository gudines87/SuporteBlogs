package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Administrador;
import negocios.Comentario;
import negocios.Espectador;
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
		String sql = "insert into Comentario(comentario,idAdministrador, idEspectador) values (?,?,?)";
		String sqlRecuperaCodigo = "select max(cod) from Comentario";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, comentario.getComentario());
		ps.setString(2, comentario.getAdministrador().getId()); //
		ps.setString(3, comentario.getEspectador().getId());
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
			throw new RuntimeException("Falha ao salvar comentario em JDBCComentarioDAO", e);
		}
	}

	@Override
	public Comentario consultarComentario(int cod) {
		
		try{
			Comentario comentario = new Comentario();
			Administrador adm = new Administrador();
			Espectador espec = new Espectador();
			String sql = "select * from Comentario where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				comentario.setCod(rs.getInt("cod"));
				comentario.setComentario(rs.getString("comentario"));
				comentario.setAdministrador(adm.consultarAdministrador(rs.getString("codAdministrador")));
				comentario.setEspectador(espec.consultarEspectador(rs.getString("codEspectador")));
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
