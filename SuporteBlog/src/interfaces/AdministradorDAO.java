package interfaces;

import java.util.List;

import negocios.Administrador;

public interface AdministradorDAO {
	
	public void salvarDados(Administrador administrador);
	public void atualizarDados(Administrador administrador);
	public Administrador consultarAdministrador(String id);
	public void removerAdministrador(String id);
	public List<Administrador> listar();
	

}
