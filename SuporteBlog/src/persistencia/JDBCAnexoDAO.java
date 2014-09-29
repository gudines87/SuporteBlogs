package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocios.Anexo;
import negocios.Comentario;
import negocios.Post;
import interfaces.AnexoDAO;

public class JDBCAnexoDAO implements AnexoDAO {

	private Connection con;
	
	
	public JDBCAnexoDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	@Override
	public int salvarAnexo(Anexo anexo) {
		
		try{
			int codigo = 0;
			String sqlRecuperaCodigo = "select max(cod) from Anexo";
			String sql = "insert into Anexo(nome,tipo,end,codComentario,codPost)" +
					"values (?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, anexo.getNome());
			ps.setObject(2, anexo.getTipo());
			ps.setString(3, anexo.getEnd());
			ps.setInt(4, anexo.getComentario().getCodigo());
			ps.setInt(5,anexo.getPost().getCod());
			
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
			throw new RuntimeException("Falha ao salvar anexo em JDBCAnexoDAO", e);
		}
		
	}

	@Override
	public Anexo consultarAnexo(int cod) {
		
		try{
			Anexo anexo = new Anexo();
			Comentario comentario = new Comentario();
			Post post = new Post();
			String sql = "select * from Anexo where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				anexo.setCod(rs.getInt("cod"));
				anexo.setNome(rs.getString("nome"));
				anexo.setTipo(rs.getInt("tipo"));
				anexo.setEnd(rs.getString("end"));
				anexo.setComentario(comentario.consultarComentario(rs.getInt("codComentario")));
				anexo.setPost(post.consultarPost(rs.getInt("codPost")));
			}			
			ps.close();
			con.close();
			return anexo;
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao consultar anexo em JDBCAnexoDAO", e);
		}
	}

	@Override
	public void removerAnexo(int cod) {
		
		try{
			String sql = "delete from Anexo where cod = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod);
			
			ps.executeUpdate();
			ps.close();
			//con.close();
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover anexo em JDBCAnexoDAO", e);
		}
		
	}

}
