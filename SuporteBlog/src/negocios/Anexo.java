package negocios;

import interfaces.AnexoDAO;

/**
 * 
 * @author Everson Douglas
 *
 */
public class Anexo {
	
	private int cod;
	private String nome;
	private TipoAnexo tipo;
	private String end;
	private Comentario comentario;
	private Post post;
	
	/**
	 * Construtor vazio
	 */
	public Anexo(){
	
	}

	/**
	 * Construtor iniciando os atributos
	 * @param nome
	 * @param tipo
	 * @param end
	 * @param comentario
	 * @param post
	 */
	public Anexo(String nome, TipoAnexo tipo, String end,
			Comentario comentario, Post post) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.end = end;
		this.comentario = comentario;
		this.post = post;
	}


	/**
	 * A seguir os gets e sets dos atributos
	 */
	
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

	/**
	 * To String, responsável por mostrar os atributos do anexo
	 */
	@Override
	public String toString() {
		return "Anexo [cod=" + cod + ", nome=" + nome + ", tipo=" + tipo
				+ ", end=" + end + ", comentario=" + comentario + ", post="
				+ post + "]";
	}

	/**
	 * Método responsável por salvar o anexo
	 * @param anexo
	 * @return o codigo do anexo
	 */
	public int salvarAnexo(Anexo anexo){
		AnexoDAO ad = FactoryDAO.createAnexoDAO();
		return ad.salvarAnexo(anexo);
	}
	
	/**
	 * Método responsável por consultar o anexo
	 * @param cod
	 * @return o anexo
	 */
	public Anexo consultarAnexo(int cod){
		AnexoDAO ad = FactoryDAO.createAnexoDAO();
		return ad.consultarAnexo(cod);
	}
	
	/**
	 * Método responsável por remover o anexo
	 * @param cod
	 */
	public void removerAnexo(int cod){
		AnexoDAO ad = FactoryDAO.createAnexoDAO();
		ad.removerAnexo(cod);
	}
	
}
