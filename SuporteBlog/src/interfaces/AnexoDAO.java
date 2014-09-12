package interfaces;

import negocios.Anexo;

public interface AnexoDAO {
	
	public int salvarAnexo(Anexo anexo);
	public Anexo consultarAnexo(int cod);
	public void removerAnexo(int cod);

}
