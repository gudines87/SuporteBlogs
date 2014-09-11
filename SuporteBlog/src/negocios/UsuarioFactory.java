package negocios;

public class UsuarioFactory {
	
	public static Usuario criarUsuario(String blog) {
		if (blog != null) {
			return new Administrador();
		} else{
			return new Espectador();
		}
	}

}