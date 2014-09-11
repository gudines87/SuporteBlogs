package interfaces;

import java.util.List;

import negocios.Usuario;
   
public interface UsuarioDAO {
	
	public void salvarDados(Usuario usuario);
	public void atualizarDados(Usuario usuario);
	public Usuario consultarUsuario(String id);
	public void removerUsuario(String id);
	public List<Usuario> listar();

}
