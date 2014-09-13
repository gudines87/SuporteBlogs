package negocios;

import interfaces.AdministradorDAO;

public class Administrador extends Usuario {
	
	public Administrador(){
		
	}

	public Administrador(String login, String senha, String nome, Blog blog) {
		super(login, senha, nome);
	}
	
	public void salvarDados(Administrador administrador){
		AdministradorDAO ad = FactoryDAO.createAdministradorDAO();
		ad.salvarDados(administrador);
	}
	
	public void atualizarDados(Administrador administrador){
		AdministradorDAO ad = FactoryDAO.createAdministradorDAO();
		ad.atualizarDados(administrador);
	}
	
	public Administrador consultarAdministrador(String id){
		AdministradorDAO ad = FactoryDAO.createAdministradorDAO();
		return ad.consultarAdministrador(id);
	}
	
	public void removerAdministrador(String id){
		AdministradorDAO ad = FactoryDAO.createAdministradorDAO();
		ad.removerAdministrador(id);
	}
}
