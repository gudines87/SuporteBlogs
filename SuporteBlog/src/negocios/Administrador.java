package negocios;

public class Administrador extends Usuario {
	
	private Blog blog;
	
	public Administrador(){
		
	}

	public Administrador(String login, String senha, String nome, Blog blog) {
		super(login, senha, nome);
		this.blog = blog;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Administrador [blog=" + blog + ", nome=" + nome
				+ ", login=" + login + ", senha=" + senha + ", end=" + end
				+ ", tel=" + tel + ", mail=" + mail + "]";
	}
	
	public void deletarBlog(int cod){
		
	}

	
	public void gerarPost(Post post){
		
	}
	
	public void deletarPost(){
		
	}
	
}
