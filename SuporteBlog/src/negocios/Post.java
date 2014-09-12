package negocios;

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
	
	public void criarPost(Post post){
		
	}
	
	public Post consultarPost(int cod){
		return null;
	}
	
	public void removerPost(int cod){
		
	}

}
