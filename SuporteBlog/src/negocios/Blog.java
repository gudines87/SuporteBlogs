package negocios;

import interfaces.BlogDAO;

public class Blog {
	
	private int id;
	private String titulo;
	private String descricao;
	private String imagemFundo;
	private boolean autz_comment;
	private boolean autz_comment_annon;
	private String background;
	private Profile profile;
	
	
	public Blog(){
		this.profile = new Profile();
	}

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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getImagemFundo() {
		return imagemFundo;
	}



	public void setImagemFundo(String imagemFundo) {
		this.imagemFundo = imagemFundo;
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile usuario) {
		this.profile = usuario;
	}
	
	@Override
	public String toString() {
		return "Blog [codigo=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", imagemFundo=" + imagemFundo
				+ ", autorizaComentario=" + autz_comment
				+ ", autorizaComentarioAnonimo=" + autz_comment_annon
				+ ", usuario=" + profile + "]";
	}

	public int createBlog(Blog blog){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		return bd.createBlog(blog);		
	}
	
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
	
	public void changeBlogInformation(int id, String atributo, String conteudo){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		bd.changeBlogInformation(id, atributo,conteudo);
	}
	
	public void removerBlog(int cod){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		bd.removerBlog(cod);
	}
	
	public Blog consultarBlog(int id){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		return bd.consultarBlog(id);
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public boolean getAutz_comment() {
		return autz_comment;
	}

	public void setAutz_comment(boolean autz_comment) {
		this.autz_comment = autz_comment;
	}

	public boolean getAutz_comment_annon() {
		return autz_comment_annon;
	}

	public void setAutz_comment_annon(boolean autz_comment_annon) {
		this.autz_comment_annon = autz_comment_annon;
	}

}
