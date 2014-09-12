package interfaces;

import negocios.Anexo;

public interface AnexoDAO {
	
	public void salvarAnexo(Anexo anexo);
	public Anexo consultarAnexo(int cod);
	public void removerAnexo(int cod);

}
