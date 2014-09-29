package negocios;

import interfaces.PostDAO;

/**
 * Classe Post do sistema
 * 
 * @author João Victor
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
	 * Método get do titulo
	 * @return o titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Método set do título
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Método get do texto
	 * @return o texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * método set do texto
	 * @param texto
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Método get do codigo
	 * @return o codigo
	 */
	public int getCod() {
		return cod;
	}

	/**
	 * método set do codigo
	 * @param cod
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}

	/**
	 * Método get do usuario
	 * @return o perfil do usuario
	 */
	public Profile getUsuario() {
		return usuario;
	}

	/**
	 * Método set do Usuario
	 * @param usuario
	 */
	public void setUsuario(Profile usuario) {
		this.usuario = usuario;
	}

	/**
	 * Método get do Bkog
	 * @return o blog
	 */
	public Blog getBlog() {
		return blog;
	}

	/**
	 * Método set do blog
	 * @param blog
	 */
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	/**
	 * Método toString para mostrar todos os atributos do post
	 */
	@Override
	public String toString() {
		return "Post [cod=" + cod + ", usuario=" + usuario + ", blog=" + blog
				+ "]";
	}

	/**
	 * Método de criação do Post
	 * @param post
	 * @return o codigo do post
	 */
	public int criarPost(Post post){
		PostDAO pd = FactoryDAO.createPostDAO();
		return pd.criarPost(post);
	}
	
	/**
	 * Método de consulta do post
	 * @param cod
	 * @return o post consultado
	 */
	public Post consultarPost(int cod){
		PostDAO pd = FactoryDAO.createPostDAO();
		return pd.consultarPost(cod);
	}
	
	/**
	 * Método de remoção do post
	 * @param cod
	 */
	public void removerPost(int cod){
		PostDAO pd = FactoryDAO.createPostDAO();
		pd.removerPost(cod);
	}

}
