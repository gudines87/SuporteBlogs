package negocios;

import interfaces.ComentarioDAO;

/**
 * 
 * @author Jo�o Victor
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
	 * M�todo get do codigo
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * M�todo set do codigo
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo get do tipo de comentario
	 * @return o tipo de comentario
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * M�todo set do tipo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * M�todo get do conteudo
	 * @return o conteudo
	 */
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * M�todo set do conteudo
	 * @param conteudo
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * M�todo get do post
	 * @return o post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * M�todo set do post
	 * @param post
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * mm�todo get do usuario
	 * @return
	 */
	public Profile getUsuario() {
		return usuario;
	}

	/**
	 * m�todo set do usuario
	 * @param usuario
	 */
	public void setUsuario(Profile usuario) {
		this.usuario = usuario;
	}

	/**
	 * m�todo respons�vel por salvar os comentarios
	 * @param comentario
	 * @return o codigo do comentario.
	 */
	public int salvarComentario(Comentario comentario){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.salvarComentario(comentario);
	}
	
	/**
	 * m�todo respons�vel por consultar os coment�rios
	 * @param cod
	 * @return o comentario
	 */
	public Comentario consultarComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.consultarComentario(cod);
	}
	
	/**
	 * m�todo repons�vel por remover os comentairo
	 * @param cod
	 */
	public void removerComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		cd.removerComentario(cod);
	}
	

}
