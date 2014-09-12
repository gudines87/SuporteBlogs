package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocios.Espectador;
import interfaces.EspectadorDAO;

public class JDBCEspectadorDAO implements EspectadorDAO {
	
	private Connection con;
	
	
	public JDBCEspectadorDAO() {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public void salvarDados(Espectador espectador) {
		
		try {
			String sql = "insert into Espectador(id, nome, login, senha, end, tel, mail)" +
					" values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, espectador.getId());
			ps.setString(2, espectador.getNome());
			ps.setString(3, espectador.getLogin());
			ps.setString(4, espectador.getSenha());
			ps.setString(5, espectador.getEnd());
			ps.setString(6, espectador.getTel());
			ps.setString(7, espectador.getMail());
			
			ps.executeUpdate();
			
			ps.close();
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao salvar dados em JDBCEspctadorDAO", e);
		}

	}

	@Override
	public void atualizarDados(Espectador espectador) {
		try{
			String sql = "update Espectador set nome = ?, senha = ?, end = ?, tel = ?, mail = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, espectador.getNome());
			ps.setString(2, espectador.getSenha());
			ps.setString(3, espectador.getEnd());
			ps.setString(4, espectador.getTel());
			ps.setString(5, espectador.getMail());
			ps.setString(6, espectador.getId());
			
			ps.executeUpdate();
			ps.close();
			//con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao atualizar dados em JDBCEspectadorDAO", e);
			}

	}

	@Override
	public Espectador consultarEspectador(String id) {
		
		try{
			Espectador espectador = new Espectador();
		String sql = "select * from Espectador where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		espectador.setId(rs.getString("id"));
		espectador.setLogin(rs.getString("login"));
		espectador.setSenha(rs.getString("senha"));
		espectador.setNome(rs.getString("nome"));
		espectador.setEnd(rs.getString("end"));
		espectador.setTel(rs.getString("tel"));
		espectador.setMail(rs.getString("mail"));
		}
		
		return espectador;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar espectador em JDBCEspectadorDAO", e);
		}
	}

	@Override
	public void removerEspectador(String id) {
		try{
			String sql = "delete from Espectador where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
			//con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao remover espectador em JDBCEspectadorDAO", e);
			}

	}

	@Override
	public List<Espectador> listar() {
		List<Espectador> espectadores = new ArrayList<>();
		try {
			String sql = "select * from Usuario";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Espectador espectador = new Espectador();
				espectador.setId(rs.getString("id"));
				espectador.setLogin(rs.getString("login"));
				espectador.setSenha(rs.getString("senha"));
				espectador.setEnd(rs.getString("end"));
				espectador.setTel(rs.getString("tel"));
				espectador.setMail(rs.getString("mail"));
				espectadores.add(espectador);
			}
			ps.close();
			rs.close();
			//con.close();
			return espectadores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new RuntimeException("Falha ao listar pessoas em JDBCEspectadorDAO", e);
		}
	}

}
