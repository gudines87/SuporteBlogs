package negocios;

import interfaces.BlogDAO;

public class Blog {
	
	private int cod;
	private String nome;
	private String url;
	private String imagemDeFundo;
	private String palavrasChave;
	private Usuario usuario;	
	
	public Blog(){
		this.usuario = new Usuario();
	}
	
	public Blog(String nome, String end, Usuario usuario){
		this.usuario = new Usuario();
		this.nome = nome;
		this.url = end;
		this.usuario = usuario;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getImagemDeFundo() {
		return imagemDeFundo;
	}

	public void setImagemDeFundo(String imagemDeFundo) {
		this.imagemDeFundo = imagemDeFundo;
	}

	public String getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Blog [cod=" + cod + ", nome=" + nome + ", url=" + url
				+ ", imagemDeFundo=" + imagemDeFundo + ", palavrasChave="
				+ palavrasChave + ", usuario=" + usuario + "]";
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
