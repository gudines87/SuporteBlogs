package fachada;

import negocios.Usuario;

public class Fachada {
	
	// criando singleton
		private static Fachada instance = new Fachada();
		

	public Fachada() {

	}

	public static Fachada getInstance() {
		return instance;
	}
	
	public void cadastrarUsuario(Usuario usuario, String blog){
		//salvarDados(UsuarioFactory.criarUsuario(blog));
		//gravarLogin();
		//atualizarDados();
	}
	
	public void deletarUsuario(String id){
		//consultarUsuario(id).toString();
		//tem certeza?
		//deletarUsuario(id);
	}
	
	public void cadastrarBlog(){
		//verificarUsuario();
		//criarBlog();
	}
	
	public void deletarBlog(int cod){
		//consultarBlog(cod).toString();
		//tem certeza?
		//deletarBlog(id);
	}
	
	public void postar(){
		//consultarBlog();
		//gerarPost();
	}
	
	public void comentar(){
		//consultarBlog();
		//consultarPost();
		//gerarComentario();
	}

}
