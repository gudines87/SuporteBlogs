package negocios;

public class Blog {
	
	private int cod;
	private static int codProx;
	private String nome;
	private String end;
	private String imagemDeFundo;
	private String palavrasChave;
	private Administrador administrador;
	private Espectador espectador;
	
	
	public Blog(){
		cod = codProx;
		codProx++;
	}
	
	public Blog(String nome, String end, Administrador ad){
		this();
		this.nome = nome;
		this.end = end;
		this.administrador = ad;
		cod = codProx;
		codProx++;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getCodProx() {
		return codProx;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	public String getImagemDeFundo() {
		return imagemDeFundo;
	}

	public void setImagemDeFundo(String imagemDeFundo) {
		this.imagemDeFundo = imagemDeFundo;
	}

	public String getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Espectador getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectador espectador) {
		this.espectador = espectador;
	}

	@Override
	public String toString() {
		return "Blog [nome=" + nome + ", end=" + end + ", imagemDeFundo=" + imagemDeFundo + ", palavrasChave="
				+ palavrasChave + ", administrador=" + administrador
				+ ", espectador=" + espectador + "]";
	}

	
	public void criarBlog(Blog blog){
		
	}
	
	public void removerBlog(int cod){
		
	}
	
	public Blog consultarBlog(int cod){
		return null;
	}
	
	

}
