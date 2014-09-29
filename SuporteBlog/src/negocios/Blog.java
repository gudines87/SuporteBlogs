package negocios;

import interfaces.BlogDAO;

/**
 * 
 * @author Clarice Maria
 *
 */
public class Blog {
	
	private int id;
	private String titulo;
	private String descricao;
	private String imagemFundo;
	private boolean autz_comment;
	private boolean autz_comment_annon;
	private String background;
	private Profile profile;
	
	
	/**
	 * Construtor
	 */
	public Blog(){
		this.profile = new Profile();
	}

	/**
	 * Construtor iniciando os atributos
	 * @param titulo
	 * @param descricao
	 * @param imagemFundo
	 * @param autorizaComentario
	 * @param autorizaComentarioAnonimo
	 * @param usuario
	 * @param palavrasChave
	 */
	public Blog(String titulo, String descricao,
			String imagemFundo, boolean autorizaComentario,
			boolean autorizaComentarioAnonimo, Profile usuario,
			String palavrasChave) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.imagemFundo = imagemFundo;
		this.autz_comment = autorizaComentario;
		this.autz_comment_annon = autorizaComentarioAnonimo;
		this.profile = usuario;
	}


	/**
	 * M�todo get do id
	 * @return o id
	 */
	public int getId() {
		return id;
	}


	/**
	 * M�todo set do id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * M�todo get do titulo
	 * @return o titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * M�todo set do titulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * m�todo get da descricao
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * M�todo set da descricao
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


/**
 * M�todo get da imagem de fundo
 * @return a imagem de fundo
 */
	public String getImagemFundo() {
		return imagemFundo;
	}


/**
 * M�todo set da imagem de fundo
 * @param imagemFundo
 */
	public void setImagemFundo(String imagemFundo) {
		this.imagemFundo = imagemFundo;
	}
	
	/**
	 * M�todo get do perfil
	 * @return
	 */
	public Profile getProfile() {
		return profile;
	}
	
	/**
	 * m�todo set do perfil
	 * @param usuario
	 */
	public void setProfile(Profile usuario) {
		this.profile = usuario;
	}
	
	/**
	 * M�todo toString repons�vel por mostrar os atributos do blog
	 */
	@Override
	public String toString() {
		return "Blog [codigo=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", imagemFundo=" + imagemFundo
				+ ", autorizaComentario=" + autz_comment
				+ ", autorizaComentarioAnonimo=" + autz_comment_annon
				+ ", usuario=" + profile + "]";
	}

	/**
	 * M�todo respons�vel por criar o blog
	 * @param blog
	 * @return
	 */
	public int createBlog(Blog blog){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		return bd.createBlog(blog);		
	}
	
	/**
	 * M�todo respons�vel por recurperar insofrma��es do blog
	 * @param id
	 * @param atributo
	 * @return uma string com as informa��es
	 */
	public String getBlogInformation(int id, String atributo){
		
			if(atributo.equals("background")){
				return consultarBlog(id).getBackground();
			}else if(atributo.equals("descricao")){
				return consultarBlog(id).getDescricao();
			}else if(atributo.equals("imgagemFundo")){
				return consultarBlog(id).getImagemFundo();
			}else if(atributo.equals("titulo")){
				return consultarBlog(id).getTitulo();
			}else if(atributo.equals("imgagemFundo")){
				return "consultarBlog(id).getAutz_comment()";
			}else if(atributo.equals("imgagemFundo")){
				return "consultarBlog(id).getAutz_comment_annon()";
			}else if(atributo.equals("dono")){
				return consultarBlog(id).getProfile().getLogin();
			}
			return  "Erro";
	}
	
	/**
	 * M�todo repons�veis por mudar informa��es do blog
	 * @param id
	 * @param atributo
	 * @param conteudo
	 */
	public void changeBlogInformation(int id, String atributo, String conteudo){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		bd.changeBlogInformation(id, atributo,conteudo);
	}
	
	/**
	 * M�todo repons�vel por remover o blog
	 * @param cod
	 */
	public void removerBlog(int cod){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		bd.removerBlog(cod);
	}
	
	/**
	 * M�todo respons�vel por consultar o blog
	 * @param id
	 * @return o blog
	 */
	public Blog consultarBlog(int id){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		return bd.consultarBlog(id);
	}

	/**
	 * M�todo get do backgroun
	 * @return o background
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * M�todo set do background
	 * @param background
	 */
	public void setBackground(String background) {
		this.background = background;
	}

	/**
	 * m�todo get do autz_comment
	 * @return o autz_comment
	 */
	public boolean getAutz_comment() {
		return autz_comment;
	}

	/**
	 * m�todo set do autz_comment
	 * @param autz_comment
	 */
	public void setAutz_comment(boolean autz_comment) {
		this.autz_comment = autz_comment;
	}

	/**
	 * M�todo get do autz_comment_annon
	 * @return a autoriza��o do coment�rio anonimo
	 */
	public boolean getAutz_comment_annon() {
		return autz_comment_annon;
	}

	/**
	 * m�todo set da autoriza��o do coment�rio anonimo
	 * @param autz_comment_annon
	 */
	public void setAutz_comment_annon(boolean autz_comment_annon) {
		this.autz_comment_annon = autz_comment_annon;
	}

}
