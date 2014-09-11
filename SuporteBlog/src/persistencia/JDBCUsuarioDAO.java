package persistencia;

import interfaces.UsuarioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocios.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO{

	private Connection con;
	
	
	public JDBCUsuarioDAO() {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public void salvarDados(Usuario usuario) {
		
		try {
			String sql = "insert into Usuario(id, nome, login, senha, end, tel, mail)" +
					" values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getId());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getEnd());
			ps.setString(6, usuario.getTel());
			ps.setString(7, usuario.getMail());
			
			ps.executeUpdate();
			
			ps.close();
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao salvar dados em JDBCUsuarioDAO", e);
		}
		
	}

	@Override
	public void atualizarDados(Usuario usuario) {
		
		try{
		String sql = "update Usuario set nome = ?, senha = ?, end = ?, tel = ?, mail = ? where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, usuario.getNome());
		ps.setString(2, usuario.getSenha());
		ps.setString(3, usuario.getEnd());
		ps.setString(4, usuario.getTel());
		ps.setString(5, usuario.getMail());
		
		ps.executeUpdate();
		ps.close();
		//con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao atualizar dados em JDBCUsuarioDAO", e);
		}	
		
	}

	@Override
	public Usuario consultarUsuario(String id) {
		
		try{
			Usuario usuario = new Usuario();
		String sql = "select * from Usuario where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		usuario.setId(rs.getString("id"));
		usuario.setLogin(rs.getString("login"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setNome(rs.getString("nome"));
		usuario.setEnd(rs.getString("end"));
		usuario.setTel(rs.getString("tel"));
		usuario.setMail(rs.getString("mail"));
		}
		
		return usuario;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar usuario em JDBCUsuarioDAO", e);
		}
		
	}

	@Override
	public void removerUsuario(String id) {
		
		try{
		String sql = "delete from Usuario where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		ps.close();
		//con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover usuario em JDBCUsuarioDAO", e);
		}
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			String sql = "select * from Usuario";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getString("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEnd(rs.getString("end"));
				usuario.setTel(rs.getString("tel"));
				usuario.setMail(rs.getString("mail"));
				usuarios.add(usuario);
			}
			ps.close();
			rs.close();
			//con.close();
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new RuntimeException("Falha ao listar pessoas em JDBCUsuarioDAO", e);
		}
		
	}
	
	

}
