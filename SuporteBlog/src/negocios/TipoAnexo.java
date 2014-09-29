package negocios;

/**
 * Enum com os tipos poss�veis de anexo
 * 
 * @author Lucas Barbosa
 *
 */
public enum TipoAnexo {
	/**
	 * os tipos.
	 */
	AUDIO(1), VIDEO(2), IMAGEM(3);
	
	
	private int cod;

	/**
	 * O construtor da classe
	 * @param id
	 */
	private TipoAnexo(int id) {
	this.cod = id;
	}
	
	/**
	 * M�todo get para o id
	 * 
	 * @return o codigo referente ao tipo do anexo
	 */
	public int getId() {
	return cod;
	}
	
	/**
	 * M�todo set referente ao id
	 * @param cod
	 */
	public void setId(int cod){
		this.cod = cod;
	}
	
	/**
	 * M�todo que retorna o tipo do enum
	 * @param cod
	 * @return retorna o tipo do anexo.
	 */
	public static TipoAnexo retornaIdTipo(int cod) {
	
	for (TipoAnexo anexo : values()) {
		if (anexo.getId() == cod){
			return anexo;
		}	
		}
	return null;
	}
}
