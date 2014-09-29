package fachada;

import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import negocios.Anexo;
import negocios.Blog;
import negocios.Comentario;
import negocios.ControleSessao;
import negocios.Profile;
import negocios.Post;

public class Fachada {
	
		private static Fachada instance = null;
		
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
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		return instance;
	}
	
	public void createProfile(String login, String nome, String senha, String sexo,
			String email, String dataNascimento, String endereco,
			String interesses, String quemSouEu, String filmes, String musicas,
			String livros){
		
		int idade = 0;
		try {
			idade = usuario.calculaIdade(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		
		if(isUserLogged(login) == true){
		return ControleSessao.getInstance().doLogin(login, senha);
		}else{
			return null;
		}

	}
	
	public void changeProfileInformation(String id, String atributo, String conteudo){
		usuario.changeProfileInformation(id, atributo, conteudo);
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
	
	public void removerUsuario(String login){
		this.usuario.removerUsuario(login);
	}
	
	public Profile consultarUsuario(String login){
		return this.usuario.consultarUsuario(login);
	}
	
	public Profile consultaPorLogin(String login){
		return this.usuario.consultarPorLogin(login);
	}
	public List<Profile> consultarUsuarios(){
		return this.usuario.listarUsuarios();
	}
	
	@SuppressWarnings("null")
	public int createBlog(String titulo, String descricao, String imagemFundo,
			boolean autz_comment, boolean autz_comment_annon, String background,
			String dono){
		
		if(isUserLogged(dono) == true){
			this.blog.setAutz_comment(autz_comment);
			this.blog.setAutz_comment_annon(autz_comment_annon);
			this.blog.setBackground(background);
			this.blog.setDescricao(descricao);
			this.blog.setImagemFundo(imagemFundo);
			this.blog.setProfile(usuario.consultarPorLogin(dono));
			this.blog.setTitulo(titulo);
			this.blog.setId(this.blog.createBlog(blog));
			
			return this.blog.getId();
			}else{
				return (Integer) null;
			}
	}
	
	public String getBlogInformation(int id, String atributo){
		return this.blog.getBlogInformation(id, atributo);
	}
	
	public void  changeBlogInformation(int id, String atributo, String conteudo){
		this.blog.changeBlogInformation(id, atributo, conteudo);
	}
	
	public void deletarBlog(int cod){
		this.blog.removerBlog(cod);
	}
	
	public Blog consultarBlog(int cod){
		return this.blog.consultarBlog(cod);
	}
	
	public int criarPostar(String titulo, String texto, String usuarioLogin, int idBlog){
		this.post.setUsuario(this.usuario.consultarPorLogin(usuarioLogin));
		this.post.setBlog(this.blog.consultarBlog(idBlog));
		this.post.setTexto(texto);
		this.post.setTitulo(titulo);
		return this.post.criarPost(post);
	}
	
	public void removerPost(int cod){
		this.post.removerPost(cod);
	}
	
	public Post consultarPost(int cod){
		return this.post.consultarPost(cod);
	}
	
	public int criarComentario(String tipo, String conteudo, int codPost, String usuarioLogin){
		this.comentario.setConteudo(conteudo);
		this.comentario.setPost(this.post.consultarPost(codPost));
		this.comentario.setTipo(tipo);
		this.comentario.setUsuario(this.usuario.consultarPorLogin(usuarioLogin));
		return this.comentario.salvarComentario(comentario);
	}
	
	public void removerComentario(int codido){
		this.comentario.removerComentario(codido);
	}
	
	public Comentario consultarComentario(int codido){
		return this.comentario.consultarComentario(codido);
	}
	
	public int salvarAnexo(String nome, int tipo, String end, int codComentario, int codPost){
		this.anexo.setNome(nome);
		this.anexo.setComentario(this.comentario.consultarComentario(codComentario));
		this.anexo.setEnd(end);
		this.anexo.setPost(this.post.consultarPost(codPost));
		this.anexo.setTipo(tipo);
		return this.anexo.salvarAnexo(anexo);
	}
	
	public void removerAnexo(int cod){
		this.anexo.removerAnexo(cod);
	}
	
	public Anexo consultarAnexo(int cod){
		return this.anexo.consultarAnexo(cod);
	}

}
