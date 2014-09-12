package negocios;

import interfaces.AdministradorDAO;

public class Administrador extends Usuario {
	
	private Blog blog;
	
	public Administrador(){
		
	}

	public Administrador(String login, String senha, String nome, Blog blog) {
		super(login, senha, nome);
		this.blog = blog;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Administrador [blog=" + blog + ", nome=" + nome
				+ ", login=" + login + ", senha=" + senha + ", end=" + end
				+ ", tel=" + tel + ", mail=" + mail + "]";
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
	
	public void removerAdministrador(){
		AdministradorDAO ad = FactoryDAO.createAdministradorDAO();
		ad.removerAdministrador(id);
	}
}
