package negocios;

import interfaces.EspectadorDAO;

public class Espectador extends Usuario{

	public Espectador() {
		super();
	}

	public Espectador(String login, String senha, String nome) {
		super(login, senha, nome);
	}
	
	public void salvarDados(Espectador espectador){
		EspectadorDAO ed = FactoryDAO.createEspectadorDAO();
		ed.salvarDados(espectador);
	}
	
	public void atualizarDados(Espectador espectador){
		EspectadorDAO ed = FactoryDAO.createEspectadorDAO();
		ed.atualizarDados(espectador);
	}
	
	public Espectador consultarEspectador(String id){
		EspectadorDAO ed = FactoryDAO.createEspectadorDAO();
		return ed.consultarEspectador(id);
	}
	
	public void removerEspectador(String id){
		EspectadorDAO ed = FactoryDAO.createEspectadorDAO();
		ed.removerEspectador(id);
	}
	
}
