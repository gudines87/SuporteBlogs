package negocios;

import interfaces.BlogDAO;

public class Blog {
	
	private int cod;
	private String nome;
	private String url;
	private String imagemDeFundo;
	private String palavrasChave;
	private Administrador administrador;	
	
	public Blog(){

	}
	
	public Blog(String nome, String end, Administrador ad){
		this.nome = nome;
		this.url = end;
		this.administrador = ad;
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

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	@Override
	public String toString() {
		return "Blog [cod=" + cod + ", nome=" + nome + ", end=" + url
				+ ", imagemDeFundo=" + imagemDeFundo + ", palavrasChave="
				+ palavrasChave + ", administrador=" + administrador + "]";
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
