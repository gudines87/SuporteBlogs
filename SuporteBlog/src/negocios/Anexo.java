package negocios;

import interfaces.AnexoDAO;

public class Anexo {
	
	private int cod;
	private String nome;
	private TipoAnexo tipo;
	private String end;
	private Comentario comentario;
	private Post post;
	
	public Anexo(){
	
	}

	public Anexo(String nome, TipoAnexo tipo, String end,
			Comentario comentario, Post post) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.end = end;
		this.comentario = comentario;
		this.post = post;
	}



	public Object getTipo(){
		return tipo;
	}
	
	public void setTipo(int tipo){
		this.tipo.setId(tipo);
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
	
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Anexo [cod=" + cod + ", nome=" + nome + ", tipo=" + tipo
				+ ", end=" + end + ", comentario=" + comentario + ", post="
				+ post + "]";
	}

	public int salvarAnexo(Anexo anexo){
		AnexoDAO ad = FactoryDAO.createAnexoDAO();
		return ad.salvarAnexo(anexo);
	}
	
	public Anexo consultarAnexo(int cod){
		AnexoDAO ad = FactoryDAO.createAnexoDAO();
		return ad.consultarAnexo(cod);
	}
	
	public void removerAnexo(int cod){
		AnexoDAO ad = FactoryDAO.createAnexoDAO();
		ad.removerAnexo(cod);
	}
	
}
