package negocios;

public class UsuarioFactory {
	
	
	//Ainda vamos consertar isso aqui!
	public static Usuario criarUsuario(String blog) {
		if (blog != null) {
			return new Administrador();
		} else{
			return new Espectador();
		}
	}

}