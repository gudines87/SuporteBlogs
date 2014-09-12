package negocios;

import interfaces.PostDAO;

public class Post {
	
	private int cod;
	private Administrador administrador;
	private Blog blog;
	
	public Post(){
		
	}

	public Post(int cod, Administrador administrador, Blog blog) {
		super();
		this.cod = cod;
		this.administrador = administrador;
		this.blog = blog;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Post [cod=" + cod + ", administrador=" + administrador
				+ ", blog=" + blog + "]";
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
