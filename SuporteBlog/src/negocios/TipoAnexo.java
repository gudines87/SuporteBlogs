package negocios;

public enum TipoAnexo {
	AUDIO(1), VIDEO(2), IMAGEM(3);
	
	private int cod;

	
	private TipoAnexo(int id) {
	this.cod = id;
	}
	
	public int getId() {
	return cod;
	}
	
	public static TipoAnexo retornaIdTipo(int cod) {
	
	for (TipoAnexo anexo : values()) {
		if (anexo.getId() == cod){
			return anexo;
		}	
		}
	return null;
	}
}
