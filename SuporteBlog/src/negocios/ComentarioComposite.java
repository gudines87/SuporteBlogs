package negocios;

import java.util.ArrayList;
import java.util.List;

public abstract class ComentarioComposite {
	
	
	private List<ComentarioComposite> listaComentarios = new ArrayList<ComentarioComposite>();
	private int codigo;
	private String tipo;
	private String conteudo;
	private Post post;	
	private Profile usuario;
	private ComentarioComposite comentarioC;
	
	public ComentarioComposite() {

	}

	public List<ComentarioComposite> getListaComentarios() {
		return listaComentarios;
	}


	public void setListaComentarios(List<ComentarioComposite> listaComentarios) {
		this.listaComentarios = listaComentarios;
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


/**
* Método que adiciona um comentário a uma lista de comentários
* @param comentario Comentario - adiciona um comentário a uma lista de comentários
* @author Douglas
*/
public void addComentario(ComentarioComposite comentario) {
this.listaComentarios.add(comentario);
}
/**
* Método que exclui um comentário de uma lista de comentários filhos
* @param comentario Comentario - exclui um comentário
* @author Douglas
*/
public void removeComentario(ComentarioComposite comentario) {
this.listaComentarios.remove(comentario);
}
/**
* O método verifica se este comentário (this) é igual ao comentário passado como parâmetro
* @param ComentarioComposite comentario - comentário a ser comparado.
* @return Boolean equals - se o comentário estiver com todos os campos preenchidos corretamente ele retorna um true, caso contrário ele retorna um false
* @author Douglas
*/
public boolean equals(ComentarioComposite comentario) {

	int iguais = 0;

	if (comentario.getCodigo() == this.getCodigo()
			&& comentario.getConteudo().equals(this.getConteudo())
			&& comentario.getPost().equals(this.getPost())
			&& comentario.getComentarioC().getCodigo() == this.getComentarioC().getCodigo()
			&& comentario.getUsuario().equals(this.getUsuario())) {
		for (ComentarioComposite comentarioP : comentario.getListaComentarios())
			for (ComentarioComposite comentarioT : this.getListaComentarios())
				if (comentarioP.equals(comentarioT))
					iguais++;
		if (iguais == this.getListaComentarios().size() && this.getListaComentarios().size() == comentario.getListaComentarios().size())
			return true;
		}
	return false;
	}
}
