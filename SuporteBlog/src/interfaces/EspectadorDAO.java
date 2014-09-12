package interfaces;

import java.util.List;

import negocios.Espectador;

public interface EspectadorDAO {
	
	public void salvarDados(Espectador espectador);
	public void atualizarDados(Espectador espectador);
	public Espectador consultarEspectador(String id);
	public void removerEspectador(String id);
	public List<Espectador> listar();

}
