package negocios;

import interfaces.ComentarioDAO;

/**
 * 
 * @author João Victor
 *
 */
public class Comentario {
	
	private int codigo;
	private String tipo;
	private String conteudo;
	private Post post;	
	private Profile usuario;

	
	/**
	 * Primeiro construtor
	 */
	public Comentario(){
		this.usuario = new Profile();
	}
	
	/**
	 * Segundo construtor
	 * @param tipo
	 * @param conteudo
	 * @param post
	 * @param usuario
	 */
	public Comentario(String tipo, String conteudo, Post post, Profile usuario) {
		super();
		this.tipo = tipo;
		this.conteudo = conteudo;
		this.post = post;
		this.usuario = usuario;
	}

	/**
	 * Método get do codigo
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Método set do codigo
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método get do tipo de comentario
	 * @return o tipo de comentario
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Método set do tipo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método get do conteudo
	 * @return o conteudo
	 */
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * Método set do conteudo
	 * @param conteudo
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * Método get do post
	 * @return o post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * Método set do post
	 * @param post
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * mmétodo get do usuario
	 * @return
	 */
	public Profile getUsuario() {
		return usuario;
	}

	/**
	 * método set do usuario
	 * @param usuario
	 */
	public void setUsuario(Profile usuario) {
		this.usuario = usuario;
	}

	/**
	 * método responsável por salvar os comentarios
	 * @param comentario
	 * @return o codigo do comentario.
	 */
	public int salvarComentario(Comentario comentario){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.salvarComentario(comentario);
	}
	
	/**
	 * método responsável por consultar os comentários
	 * @param cod
	 * @return o comentario
	 */
	public Comentario consultarComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.consultarComentario(cod);
	}
	
	/**
	 * método reponsável por remover os comentairo
	 * @param cod
	 */
	public void removerComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		cd.removerComentario(cod);
	}
	

}
