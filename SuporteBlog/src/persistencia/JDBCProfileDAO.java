package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocios.Profile;
import interfaces.ProfileDAO;

public class JDBCProfileDAO implements ProfileDAO{
	
	private Connection con;
	
	
	public JDBCProfileDAO() {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public void createProfile(Profile usuario) {
		
		try {
			String sql = "insert into Profile(login, nome_exibicao, senha, sexo, email,"
					+ "data_nasc, endereco, quem_sou_eu, interesses, filmes, musicas, livros)" +
					" values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getSexo());
			ps.setString(5, usuario.getEmail());
			ps.setDate(6, (Date) usuario.getDataNascimento());
			ps.setString(7, usuario.getEndereco());
			ps.setString(8, usuario.getQuemSouEu());
			ps.setString(9, usuario.getInteresses());
			ps.setString(10, usuario.getFilmes());
			ps.setString(11, usuario.getMusicas());
			ps.setString(12, usuario.getLivros());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao criar perfil em JDBCProfilesDAO", e);
		}

	}

	@Override
	public void changeProfileInformation(String id, String atributo){
		try{
			String sql = "";
			if(atributo.equals("senha")){
				sql = "update Profile set senha = ? where id = ?";
			}else if(atributo.equals("nome")){
				sql = "update Profile set nome = ? where id = ?";
			}else if(atributo.equals("sexo")){
				sql = "update Profile set sexo = ? where id = ?";
			}else if(atributo.equals("dataNasc")){
				sql = "update Profile set dataNasc = ? where id = ?";
			}else if(atributo.equals("endereco")){
				sql = "update Profile set endereco = ? where id = ?";
			}else if(atributo.equals("musicas")){
				sql = "update Profile set musicas = ? where id = ?";
			}else if(atributo.equals("filmes")){
				sql = "update Profile set filmes = ? where id = ?";
			}else if(atributo.equals("livros")){
				sql = "update Profile set livros = ? where id = ?";
			}else if(atributo.equals("quem_sou_eu")){
				sql = "update Profile set quem_sou_eu = ? where id = ?";
			}else if(atributo.equals("interesses")){
				sql = "update Profile set interesses = ? where id = ?";
			}
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, atributo);
			
			ps.executeUpdate();
			ps.close();
			con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao atualizar perfil em JDBCUsuarioDAO", e);
			}

	}

	@Override
	public void removerUsuario(String id) {
		try{
			String sql = "delete from Profile where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
			//con.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw new RuntimeException("Falha ao remover perfil em JDBCProfileDAO", e);
			}

	}

	@Override
	public Profile consultarUsuario(String id) {
		
		try{
			Profile usuario = new Profile();
		String sql = "select * from Profile where id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		usuario.setDataNascimento(rs.getDate("data_nasc"));
		usuario.setLogin(rs.getString("login"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setNome(rs.getString("nome_exibicao"));
		usuario.setEmail(rs.getString("email"));
		usuario.setEndereco(rs.getString("endereco"));
		usuario.setFilmes(rs.getString("filmes"));
		usuario.setInteresses(rs.getString("interesses"));
		usuario.setLivros(rs.getString("livros"));
		usuario.setMusicas(rs.getString("musicas"));
		usuario.setQuemSouEu(rs.getString("quem_sou_eu"));
		usuario.setSexo(rs.getString("sexo"));
		}
		
		return usuario;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar espectador em JDBCProfileDAO", e);
		}
	}

	@Override
	public List<Profile> listarUsuarios() {
		List<Profile> usuarios = new ArrayList<>();
		try {
			String sql = "select * from Profile";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Profile usuario = new Profile();
				usuario.setDataNascimento(rs.getDate("data_nasc"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNome(rs.getString("nome_exibicao"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setFilmes(rs.getString("filmes"));
				usuario.setInteresses(rs.getString("interesses"));
				usuario.setLivros(rs.getString("livros"));
				usuario.setMusicas(rs.getString("musicas"));
				usuario.setQuemSouEu(rs.getString("quem_sou_eu"));
				usuario.setSexo(rs.getString("sexo"));
				usuarios.add(usuario);
			}
			ps.close();
			rs.close();
			con.close();
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new RuntimeException("Falha ao listar perfils em JDBCProfileDAO", e);
		}
	}

	@Override
	public Profile consultaPorLogin(String login) {
		try{
			Profile usuario = new Profile();
		String sql = "select * from Profile where login = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, login);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
		usuario.setDataNascimento(rs.getDate("data_nasc"));
		usuario.setLogin(rs.getString("login"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setNome(rs.getString("nome_exibicao"));
		usuario.setEmail(rs.getString("email"));
		usuario.setEndereco(rs.getString("endereco"));
		usuario.setFilmes(rs.getString("filmes"));
		usuario.setInteresses(rs.getString("interesses"));
		usuario.setLivros(rs.getString("livros"));
		usuario.setMusicas(rs.getString("musicas"));
		usuario.setQuemSouEu(rs.getString("quem_sou_eu"));
		usuario.setSexo(rs.getString("sexo"));
		}
		
		return usuario;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar perfil em JDBCProfileDAO", e);
		}
	}

}
