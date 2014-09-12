package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocios.Administrador;
import interfaces.AdministradorDAO;

public class JDBCAdministradorDAO implements AdministradorDAO {
	
	private Connection con;
	
	
	public JDBCAdministradorDAO() {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public void salvarDados(Administrador administrador) {
		try {
			String sql = "insert into Administrador(id, nome, login, senha, end, tel, mail)" +
					" values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, administrador.getId());
			ps.setString(2, administrador.getNome());
			ps.setString(3, administrador.getLogin());
			ps.setString(4, administrador.getSenha());
			ps.setString(5, administrador.getEnd());
			ps.setString(6, administrador.getTel());
			ps.setString(7, administrador.getMail());
			
			ps.executeUpdate();
			
			ps.close();
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao salvar dados em JDBCAdministradorDAO", e);
		}

	}

	@Override
	public void atualizarDados(Administrador administrador) {
		try{
			String sql = "update Administrador set nome = ?, senha = ?, end = ?, tel = ?, mail = ? where id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, administrador.getNome());
			ps.setString(2, administrador.getSenha());
			ps.setString(3, administrador.getEnd());
			ps.setString(4, administrador.getTel());
			ps.setString(5, administrador.getMail());
			ps.setString(6, administrador.getId());
			
			ps.executeUpdate();
			ps.close();
			//con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao atualizar dados em JDBCAdministradorDAO", e);
			}	

	}

	@Override
	public Administrador consultarAdministrador(String id) {
		try{
			Administrador administrador = new Administrador();
		String sql = "select * from Administrador where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		administrador.setId(rs.getString("id"));
		administrador.setLogin(rs.getString("login"));
		administrador.setSenha(rs.getString("senha"));
		administrador.setNome(rs.getString("nome"));
		administrador.setEnd(rs.getString("end"));
		administrador.setTel(rs.getString("tel"));
		administrador.setMail(rs.getString("mail"));
		}
		
		return administrador;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar administrador em JDBCAdministradorDAO", e);
		}
	}

	@Override
	public void removerAdministrador(String id) {
		try{
			String sql = "delete from Administrador where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
			//con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao remover administrador em JDBCAdministradorDAO", e);
			}

	}

	@Override
	public List<Administrador> listar() {
		List<Administrador> administradores = new ArrayList<>();
		try {
			String sql = "select * from Usuario";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Administrador administrador = new Administrador();
				administrador.setId(rs.getString("id"));
				administrador.setLogin(rs.getString("login"));
				administrador.setSenha(rs.getString("senha"));
				administrador.setEnd(rs.getString("end"));
				administrador.setTel(rs.getString("tel"));
				administrador.setMail(rs.getString("mail"));
				administradores.add(administrador);
			}
			ps.close();
			rs.close();
			//con.close();
			return administradores;
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new RuntimeException("Falha ao listar pessoas em JDBCAdministradorDAO", e);
		}
	}
	
	

}
