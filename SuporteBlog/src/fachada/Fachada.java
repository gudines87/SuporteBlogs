package fachada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import negocios.Administrador;
import negocios.Anexo;
import negocios.Blog;
import negocios.Comentario;
import negocios.Espectador;
import negocios.Post;

public class Fachada {
	
		private static Fachada instance = new Fachada();
		private Espectador espectador;
		private Administrador administrador;
		private Blog blog;
		private Anexo anexo;
		private Comentario comentario;
		private Post post;
		BufferedReader entradaDados = new BufferedReader(new InputStreamReader(System.in));
		

	public Fachada() {
		this.administrador = new Administrador();
		this.anexo = new Anexo();
		this.blog = new Blog();
		this.comentario = new Comentario();
		this.espectador = new Espectador();
		this.post = new Post();
	}

	public static Fachada getInstance() {
		return instance;
	}
	
	public void cadastrarEspectador(Espectador espectador){
		this.espectador = espectador;
		this.espectador.gravarLogin(espectador.getLogin(), espectador.getSenha());
		espectador = this.espectador;
		this.espectador.salvarDados(espectador);
	}
	
	public void cadastrarAdministrador(Administrador administrador){
		this.administrador = administrador;
		this.administrador.gravarLogin(administrador.getLogin(), administrador.getSenha());
		administrador = this.administrador;
		this.administrador.salvarDados(administrador);
	}
	
	public void deletarUsuario(String id) throws IOException{
		Administrador ad = new Administrador();
		Espectador ed = new Espectador();
		String opc = "";
		if(this.administrador.consultarAdministrador(id) != null){
			this.administrador = ad.consultarAdministrador(id);
			this.administrador.toString();
			System.out.println("Tem certeza que deseja remover? s/n");
			opc = entradaDados.readLine();
			if(opc.equals("s")){
				this.administrador.removerAdministrador(id);
			}
		}else if(this.espectador.consultarEspectador(id) != null){
			this.espectador = ed.consultarEspectador(id);
			this.espectador.toString();
			System.out.println("Tem certezq eu deseja remover? s/n");
			opc = entradaDados.readLine();
			if(opc.equals("s")){
				this.espectador.removerEspectador(id);
			}
		}else{
			System.out.println("Usuario inexistente.");
		}
	}
	
	public void atualizarEspectador(Espectador espectador){
		this.espectador.atualizarDados(espectador);
	}
	
	public void atualizarAdministrador(Administrador administrador){
		this.administrador.atualizarDados(administrador);
	}
	
	public String consultarDadosEspectador(String id){
		return this.espectador.consultarEspectador(id).toString();
	}
	
	public Espectador consultarEspectador(String id){
		return this.espectador.consultarEspectador(id);
	}
	
	public String consultarDadosAdministrador(String id){
		return this.espectador.consultarEspectador(id).toString();
	}
	
	public Administrador consultarAdministrador(String id){
		return this.administrador.consultarAdministrador(id);
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
