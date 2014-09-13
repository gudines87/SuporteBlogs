package fachada;

import negocios.Anexo;
import negocios.Blog;
import negocios.Comentario;

import negocios.Post;

public class Fachada {
	
		private static Fachada instance = new Fachada();
		
		private Blog blog;
		private Anexo anexo;
		private Comentario comentario;
		private Post post;
		
		

	public Fachada() {
		
	}

	public static Fachada getInstance() {
		return instance;
	}
	
	
	public int cadastrarBlog(Blog blog){
		return this.blog.criarBlog(blog);
	}
	
	public void deletarBlog(int cod){
		this.blog.removerBlog(cod);
	}
	
	public Blog consultarBlog(int cod){
		return this.blog.consultarBlog(cod);
	}
	
	public int criarPostar(Post post){
		return this.post.criarPost(post);
	}
	
	public void removerPost(int cod){
		this.post.removerPost(cod);
	}
	
	public Post consultarPost(int cod){
		return this.post.consultarPost(cod);
	}
	
	public int criarComentario(Comentario comentario){
		return this.comentario.salvarComentario(comentario);
	}
	
	public void removerComentario(int cod){
		this.comentario.removerComentario(cod);
	}
	
	public Comentario consultarComentario(int cod){
		return this.comentario.consultarComentario(cod);
	}
	
	public int salvarAnexo(Anexo anexo){
		return this.anexo.salvarAnexo(anexo);
	}
	
	public void removerAnexo(int cod){
		this.anexo.removerAnexo(cod);
	}
	
	public Anexo consultarAnexo(int cod){
		return this.anexo.consultarAnexo(cod);
	}

}
