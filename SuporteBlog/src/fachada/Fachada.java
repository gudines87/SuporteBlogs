package fachada;

import java.util.List;

import negocios.Anexo;
import negocios.Blog;
import negocios.Comentario;
import negocios.Usuario;

import negocios.Post;

public class Fachada {
	
		private static Fachada instance = new Fachada();
		
		private Blog blog;
		private Anexo anexo;
		private Comentario comentario;
		private Post post;
		private Usuario usuario;	
		

	public Fachada() {
		this.blog = new Blog();
		this.anexo = new Anexo();
		this.comentario = new Comentario();
		this.post = new Post();
		this.usuario = new Usuario();
	}

	public static Fachada getInstance() {
		return instance;
	}
	
	public void salvarUsuario(String login, String senha, String nome, String end, String tel, String mail){
		this.usuario = new Usuario(login, senha, nome, end, tel, mail);
		this.usuario.gravarId(login, senha);
		this.usuario.salvarUsuario(usuario);
	}
	
	public void atualizarUsuario(String login, String senha, String nome, String end, String tel, String mail){
		this.usuario = new Usuario(login, senha, nome, end, tel, mail);
		this.usuario.gravarId(login, senha);
		this.usuario.atualizarUsuario(usuario);
	}
	
	public Usuario consultarUsuario(String id){
		return this.usuario.consultarUsuario(id);
	}
	public List<Usuario> consultarUsuarios(){
		return this.usuario.listarUsuarios();
	}
	
	
	public int cadastrarBlog(String id, String nomeBlog, String imagemDeFundo, String url, String palavrasChave){
		this.usuario = consultarUsuario(id);
		this.blog = new Blog(nomeBlog, url, imagemDeFundo, palavrasChave, usuario);
		return this.blog.criarBlog(blog);
	}
	
	public void deletarBlog(int cod){
		this.blog.removerBlog(cod);
	}
	
	public Blog consultarBlog(int cod){
		return this.blog.consultarBlog(cod);
	}
	
	public int criarPostar(String id, int codBlog){
		this.usuario = consultarUsuario(id);
		this.blog = consultarBlog(codBlog);
		this.post = new Post(usuario, blog);
		return this.post.criarPost(post);
	}
	
	public void removerPost(int cod){
		this.post.removerPost(cod);
	}
	
	public Post consultarPost(int cod){
		return this.post.consultarPost(cod);
	}
	
	public int criarComentario(String coment, String id){
		this.usuario = consultarUsuario(id);
		this.comentario = new Comentario(coment, usuario);
		return this.comentario.salvarComentario(comentario);
	}
	
	public void removerComentario(int cod){
		this.comentario.removerComentario(cod);
	}
	
	public Comentario consultarComentario(int cod){
		return this.comentario.consultarComentario(cod);
	}
	
	public int salvarAnexo(int codPost, String nome, String tipo, String end, int codComentario){
		this.comentario = consultarComentario(codComentario);
		this.post = consultarPost(codPost);
		this.anexo = new Anexo(nome, tipo, end, comentario, post);
		return this.anexo.salvarAnexo(anexo);
	}
	
	public void removerAnexo(int cod){
		this.anexo.removerAnexo(cod);
	}
	
	public Anexo consultarAnexo(int cod){
		return this.anexo.consultarAnexo(cod);
	}

}
