package negocios;

import interfaces.PostDAO;

/**
 * Classe Post do sistema
 * 
 * @author Jo�o Victor
 *
 */
public class Post {
	
	private int cod;
	private String titulo;
	private String texto;
	private Profile usuario;
	private Blog blog;
	
	/**
	 * Primeiro construtor
	 */
	public Post(){
		this.usuario = new Profile();
	}
	
	/**
	 * Segundo construtor iniciando os atributos
	 * @param titulo
	 * @param texto
	 * @param usuario
	 * @param blog
	 */
	public Post(String titulo, String texto, Profile usuario, Blog blog) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.usuario = usuario;
		this.blog = blog;
	}


	/**
	 * M�todo get do titulo
	 * @return o titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * M�todo set do t�tulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * M�todo get do texto
	 * @return o texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * m�todo set do texto
	 * @param texto
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * M�todo get do codigo
	 * @return o codigo
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * m�todo set do codigo
	 * @param cod
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * M�todo get do usuario
	 * @return o perfil do usuario
	 */
	public Profile getUsuario() {
		return usuario;
	}

	/**
	 * M�todo set do Usuario
	 * @param usuario
	 */
	public void setUsuario(Profile usuario) {
		this.usuario = usuario;
	}

	/**
	 * M�todo get do Bkog
	 * @return o blog
	 */
	public Blog getBlog() {
		return blog;
	}

	/**
	 * M�todo set do blog
	 * @param blog
	 */
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	/**
	 * M�todo toString para mostrar todos os atributos do post
	 */
	@Override
	public String toString() {
		return "Post [cod=" + cod + ", usuario=" + usuario + ", blog=" + blog
				+ "]";
	}

	/**
	 * M�todo de cria��o do Post
	 * @param post
	 * @return o codigo do post
	 */
	public int criarPost(Post post){
		PostDAO pd = FactoryDAO.createPostDAO();
		return pd.criarPost(post);
	}
	
	/**
	 * M�todo de consulta do post
	 * @param cod
	 * @return o post consultado
	 */
	public Post consultarPost(int cod){
		PostDAO pd = FactoryDAO.createPostDAO();
		return pd.consultarPost(cod);
	}
	
	/**
	 * M�todo de remo��o do post
	 * @param cod
	 */
	public void removerPost(int cod){
		PostDAO pd = FactoryDAO.createPostDAO();
		pd.removerPost(cod);
	}

}
