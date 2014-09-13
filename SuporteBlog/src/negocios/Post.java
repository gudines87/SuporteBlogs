package negocios;

import interfaces.PostDAO;

public class Post {
	
	private int cod;
	private Usuario usuario;
	private Blog blog;
	
	public Post(){
		this.usuario = new Usuario();
	}

	public Post(int cod, Usuario usuario, Blog blog) {
		this.usuario = new Usuario();
		this.cod = cod;
		this.usuario = usuario;
		this.blog = blog;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
	@Override
	public String toString() {
		return "Post [cod=" + cod + ", usuario=" + usuario + ", blog=" + blog
				+ "]";
	}

	public int criarPost(Post post){
		PostDAO pd = FactoryDAO.createPostDAO();
		return pd.criarPost(post);
	}
	
	public Post consultarPost(int cod){
		PostDAO pd = FactoryDAO.createPostDAO();
		return pd.consultarPost(cod);
	}
	
	public void removerPost(int cod){
		PostDAO pd = FactoryDAO.createPostDAO();
		pd.removerPost(cod);
	}

}
