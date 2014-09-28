package fachada;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import negocios.Anexo;
import negocios.Blog;
import negocios.Comentario;
import negocios.ControleSessao;
import negocios.Profile;
import negocios.Post;

public class Fachada {
	
		private static Fachada instance = new Fachada();
		
		private Blog blog;
		private Anexo anexo;
		private Comentario comentario;
		private Post post;
		private Profile usuario;	
		

	public Fachada() {
		this.blog = new Blog();
		this.anexo = new Anexo();
		this.comentario = new Comentario();
		this.post = new Post();
		this.usuario = new Profile();
	}

	public static Fachada getInstance() {
		return instance;
	}
	
	public void createProfile(String login, String nome, String senha, String sexo,
			String email, Date dataNascimento, String endereco,
			String interesses, String quemSouEu, String filmes, String musicas,
			String livros){
		
		int idade;
		idade = usuario.calculaIdade(dataNascimento);
		
		this.usuario.setDataNascimento(dataNascimento);
		this.usuario.setEmail(email);
		this.usuario.setEndereco(endereco);
		this.usuario.setFilmes(filmes);
		this.usuario.setInteresses(interesses);
		this.usuario.setLivros(livros);
		this.usuario.setLogin(login);
		this.usuario.setMusicas(musicas);
		this.usuario.setNome(nome);
		this.usuario.setQuemSouEu(quemSouEu);
		this.usuario.setSenha(senha);
		this.usuario.setSexo(sexo);
		
		
		if(usuario.validarCampos(usuario) == false){
			return;
		}
		
		if(usuario.validarLogin() == false){
			return;
		}
		
		if(usuario.validarEmail(email) == false){
			return;
		}
		
		if(idade < 18 || idade > 100){
			JOptionPane.showMessageDialog(null, "A idade � incorreta","aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		usuario.createProfile(usuario);
		
	}
	
	public String getProfileInformation(String login, String atributo){
		return usuario.getProfileInformation(login, atributo);
	}
	
	public String getProfileInformationBySessionId(String id, String atributo){
		return ControleSessao.getInstance().getProfileInformationBySessionId(id, atributo);
	}
	
	public String doLogin(String login, String senha){
		return ControleSessao.getInstance().doLogin(login, senha);
	}
	
	public void changeProfileInformation(String id, String atributo){
		usuario.changeProfileInformation(id, atributo);
	}
	
	public void resetSessions(){
		ControleSessao.getInstance().resetSessions();
	}
	
	public void logoff(String id){
		ControleSessao.getInstance().logoof(id);
	}
	
	public boolean isUserLogged(String login){
		return ControleSessao.getInstance().isUserLogged(login);
	}
	
	public String getLoginById(String id){
		return ControleSessao.getInstance().getLoginById(id);
	}
	
	public Profile consultarUsuario(String id){
		return this.usuario.consultarUsuario(id);
	}
	public List<Profile> consultarUsuarios(){
		return this.usuario.listarUsuarios();
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
	
	public void removerAnexo(int cod){
		this.anexo.removerAnexo(cod);
	}
	
	public Anexo consultarAnexo(int cod){
		return this.anexo.consultarAnexo(cod);
	}

}
