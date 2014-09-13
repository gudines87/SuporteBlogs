package interfaces;

import java.util.List;

import negocios.Profile;

public interface UsuarioDAO {

	public void salvarUsuario(Profile usuario);
	public void atualizarUsuario(Profile usuario);
	public void removerUsuario(String id);
	public Profile consultarUsuario(String id);
	public List<Profile> listarUsuarios();
	
}
