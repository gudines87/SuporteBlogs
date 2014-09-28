package interfaces;

import java.util.List;

import negocios.Profile;

public interface ProfileDAO {

	public void createProfile(Profile usuario);
	public void changeProfileInformation(String id, String atributo);
	public void removerUsuario(String id);
	public Profile consultarUsuario(String id);
	public List<Profile> listarUsuarios();
	public Profile consultaPorLogin(String login);
	
}
