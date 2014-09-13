package interfaces;

import java.util.List;

import negocios.Usuario;

public interface UsuarioDAO {

	public void salvarUsuario(Usuario usuario);
	public void atualizarUsuario(Usuario usuario);
	public void removerUsuario(String id);
	public Usuario consultarUsuario(String id);
	public List<Usuario> listarUsuarios();
	
}
