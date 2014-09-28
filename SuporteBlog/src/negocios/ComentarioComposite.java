package negocios;

import java.util.ArrayList;
import java.util.List;

public abstract class ComentarioComposite {
	
	
	private int codigo;
	private String tipo;
	private String conteudo;
	private Post post;	
	private Profile usuario;
	private ComentarioComposite comentarioC;
	private List<ComentarioComposite> comentarios = new ArrayList<>();
	
	public ComentarioComposite() {

	}

	public List<ComentarioComposite> getListaComentarios() {
		return comentarios;
	}


	public void setListaComentarios(List<ComentarioComposite> listaComentarios) {
		this.comentarios = listaComentarios;
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


	public ComentarioComposite getComentarioC() {
		return comentarioC;
	}


	public void setComentarioC(ComentarioComposite comentarioC) {
		this.comentarioC = comentarioC;
	}



	public void addComentario(ComentarioComposite comentario) {
			this.comentarios.add(comentario);
	}

	public void removeComentario(ComentarioComposite comentario) {
			this.comentarios.remove(comentario);
	}

}

