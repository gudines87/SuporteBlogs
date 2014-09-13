package negocios;

public enum TipoAnexo {
	AUDIO(1), VIDEO(2), IMAGEM(3);
	
	private int id;

	
	private TipoAnexo(int id) {
	this.id = id;
	}
	
	public int getId() {
	return id;
	}
	
	public static TipoAnexo retornaIdTipo(int id) {
	
	for (TipoAnexo ta : values()) {
		if (ta.getId() == id)
			return ta;
		}
	return null;
	}
}
