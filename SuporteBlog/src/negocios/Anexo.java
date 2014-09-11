package negocios;

public class Anexo {
	
	private int cod;
	private String nome;
	private String tipo;// ex.: imagem, video, arquivo.
	private String end; //endereço do anexo.
	private static int codProx; //variável auxiliar para gerar o próximo código;
	
	public Anexo(){
		cod = codProx;
		codProx++;
	}
	
	public Anexo(String nome, String tipo, String end){
		this();
		this.nome = nome;
		this.tipo = tipo;
		this.end = end;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	public static int getCodProx() {
		return codProx;
	}

	@Override
	public String toString() {
		return "Anexo [nome=" + nome + ", tipo=" + tipo + ", end=" + end + "]";
	}
	
	
}
