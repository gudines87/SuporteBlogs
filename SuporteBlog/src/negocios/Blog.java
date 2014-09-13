package negocios;

import interfaces.BlogDAO;

public class Blog {
	
	private int codigo;
	private String titulo;
	private String descricao;
	private String imagemFundo;
	private boolean autz_comment;
	private boolean autz_comment_annon;
	private Profile usuario;
	private String sessionId;
	private String background;
	
	
	public Blog(){
		this.usuario = new Profile();
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
		this.usuario = usuario;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
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



	public boolean isAutorizaComentario() {
		return autz_comment;
	}



	public void setAutorizaComentario(boolean autorizaComentario) {
		this.autz_comment = autorizaComentario;
	}



	public boolean isAutorizaComentarioAnonimo() {
		return autz_comment_annon;
	}



	public void setAutorizaComentarioAnonimo(boolean autorizaComentarioAnonimo) {
		this.autz_comment_annon = autorizaComentarioAnonimo;
	}



	public Profile getUsuario() {
		return usuario;
	}



	public void setUsuario(Profile usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Blog [codigo=" + codigo + ", titulo=" + titulo + ", descricao="
				+ descricao + ", imagemFundo=" + imagemFundo
				+ ", autorizaComentario=" + autz_comment
				+ ", autorizaComentarioAnonimo=" + autz_comment_annon
				+ ", usuario=" + usuario + "]";
	}

	public int criarBlog(Blog blog){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		return bd.criarBlog(blog);		
	}
	
	public void removerBlog(int cod){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		bd.removerBlog(cod);
	}
	
	public Blog consultarBlog(int cod){
		BlogDAO bd = FactoryDAO.createBlogDAO();
		return bd.consultarBlog(cod);
	}	

}
