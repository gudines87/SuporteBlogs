package negocios;

import interfaces.ComentarioDAO;

public class Comentario {
	
	private int codigo;
	private String tipo;
	private String conteudo;
	private Post post;	
	private Profile usuario;

	
	public Comentario(){
		this.usuario = new Profile();
	}
	
	public Comentario(String tipo, String conteudo, Post post, Profile usuario) {
		super();
		this.tipo = tipo;
		this.conteudo = conteudo;
		this.post = post;
		this.usuario = usuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Profile getUsuario() {
		return usuario;
	}

	public void setUsuario(Profile usuario) {
		this.usuario = usuario;
	}

	public int salvarComentario(Comentario comentario){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.salvarComentario(comentario);
	}
	
	public Comentario consultarComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		return cd.consultarComentario(cod);
	}
	
	public void removerComentario(int cod){
		ComentarioDAO cd = FactoryDAO.createComentarioDAO();
		cd.removerComentario(cod);
	}
	

}
