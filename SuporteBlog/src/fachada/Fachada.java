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

/**
 * Classe fachada da aplicação.
 * @author Lucas Barbosa
 *
 */
public class Fachada {
	
		private static Fachada instance = null;
		
		private Blog blog;
		private Anexo anexo;
		private Comentario comentario;
		private Post post;
		private Profile usuario;	
		
/**
 * Construtor instanciando os atributos
 */
	public Fachada() {
		this.blog = new Blog();
		this.anexo = new Anexo();
		this.comentario = new Comentario();
		this.post = new Post();
		this.usuario = new Profile();
	}

	/**
	 * Recuperando uma instancia da fachada
	 * @return a instancia
	 */
	public static Fachada getInstance() {
		if(instance == null){
			instance = new Fachada();
			return instance;
		}
		return instance;
	}
	
	/**
	 * Método responsável por criar um perfil
	 * @param login
	 * @param nome
	 * @param senha
	 * @param sexo
	 * @param email
	 * @param dataNascimento
	 * @param endereco
	 * @param interesses
	 * @param quemSouEu
	 * @param filmes
	 * @param musicas
	 * @param livros
	 */
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
			JOptionPane.showMessageDialog(null, "A idade ï¿½ incorreta","aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		usuario.createProfile(usuario);
		
	}
	
	/**
	 * Método responsável por recuperar informações de perfil
	 * @param login
	 * @param atributo
	 * @return a informação
	 */
	public String getProfileInformation(String login, String atributo){
		return usuario.getProfileInformation(login, atributo);
	}
	
	/**
	 *Método responsável por recuperar informações de perfil pelo id de sessão
	 * @param id
	 * @param atributo
	 * @return a informação
	 */
	public String getProfileInformationBySessionId(String id, String atributo){
		return ControleSessao.getInstance().getProfileInformationBySessionId(id, atributo);
	}
	
	/**
	 * Método responsável por fazer o login
	 * @param login
	 * @param senha
	 * @return um boolean afirmando se foi feito ou não o login
	 */
	public String doLogin(String login, String senha){
		
		if(isUserLogged(login) == true){
		return ControleSessao.getInstance().doLogin(login, senha);
		}else{
			return null;
		}

	}
	
	/**
	 * Método responsável por mudar informações do perfil
	 * @param id
	 * @param atributo
	 * @param conteudo
	 */
	public void changeProfileInformation(String id, String atributo, String conteudo){
		usuario.changeProfileInformation(id, atributo, conteudo);
	}
	
	/**
	 * Método responsável por resetar os ids de sessão
	 */
	public void resetSessions(){
		ControleSessao.getInstance().resetSessions();
	}
	
	/**
	 * Método responsável por fazer o logoff do perfil
	 * @param id
	 */
	public void logoff(String id){
		ControleSessao.getInstance().logoof(id);
	}
	
	/**
	 * Método responsável por verificar se o usuario está realmente online
	 * @param login
	 * @return
	 */
	public boolean isUserLogged(String login){
		return ControleSessao.getInstance().isUserLogged(login);
	}
	
	/**
	 * Método responsável por recuperar o login através do id de sessão
	 * @param id
	 * @return
	 */
	public String getLoginById(String id){
		return ControleSessao.getInstance().getLoginById(id);
	}
	
	/**
	 * Método responsável por remover o usuario
	 * @param login
	 */
	public void removerUsuario(String login){
		this.usuario.removerUsuario(login);
	}
	
	/**
	 * Método responsável por consultar o usuario
	 * @param login
	 * @return o perfil do usuario
	 */
	public Profile consultarUsuario(String login){
		return this.usuario.consultarUsuario(login);
	}
	
	/**
	 *  Método responsável por consultar o usuario pelo login
	 * @param login
	 * @return o perfil do usuario
	 */
	public Profile consultaPorLogin(String login){
		return this.usuario.consultarPorLogin(login);
	}
	/**
	 * Método responsável por retornar um lista dos perfils cadastrador no sistema
	 * @return
	 */
	public List<Profile> consultarUsuarios(){
		return this.usuario.listarUsuarios();
	}
	/**
	 * Método responsável por criar um blog
	 * @param titulo
	 * @param descricao
	 * @param imagemFundo
	 * @param autz_comment
	 * @param autz_comment_annon
	 * @param background
	 * @param dono
	 * @return o id do blog
	 */
	
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
	
	/**
	 * Método responsável por recuperar informações do blog
	 * @param id
	 * @param atributo
	 * @return a informação
	 */
	public String getBlogInformation(int id, String atributo){
		return this.blog.getBlogInformation(id, atributo);
	}
	
	/**
	 * Método responsável por mudar as informações do blog
	 * @param id
	 * @param atributo
	 * @param conteudo
	 */
	public void  changeBlogInformation(int id, String atributo, String conteudo){
		this.blog.changeBlogInformation(id, atributo, conteudo);
	}
	/**
	 * Método responsável por remover um blog
	 * @param cod
	 */
	public void deletarBlog(int cod){
		this.blog.removerBlog(cod);
	}
	
	/**
	 * Método responsável por consultar um blog
	 * @param cod
	 * @return o blog
	 */
	public Blog consultarBlog(int cod){
		return this.blog.consultarBlog(cod);
	}
	
	/**
	 * Método responsável por criar um port
	 * @param titulo
	 * @param texto
	 * @param usuarioLogin
	 * @param idBlog
	 * @return o código do post
	 */
	public int criarPostar(String titulo, String texto, String usuarioLogin, int idBlog){
		this.post.setUsuario(this.usuario.consultarPorLogin(usuarioLogin));
		this.post.setBlog(this.blog.consultarBlog(idBlog));
		this.post.setTexto(texto);
		this.post.setTitulo(titulo);
		return this.post.criarPost(post);
	}
	
	/**
	 * método responsável por remover um post
	 * @param cod
	 */
	public void removerPost(int cod){
		this.post.removerPost(cod);
	}
	
	/**
	 * Método responsável por consultar um post
	 * @param cod
	 * @return o pospt
	 */
	public Post consultarPost(int cod){
		return this.post.consultarPost(cod);
	}
	
	/**
	 * Método responsável por criar um comentario
	 * @param tipo
	 * @param conteudo
	 * @param codPost
	 * @param usuarioLogin
	 * @return o codigo do comentario
	 */
	public int criarComentario(String tipo, String conteudo, int codPost, String usuarioLogin){
		this.comentario.setConteudo(conteudo);
		this.comentario.setPost(this.post.consultarPost(codPost));
		this.comentario.setTipo(tipo);
		this.comentario.setUsuario(this.usuario.consultarPorLogin(usuarioLogin));
		return this.comentario.salvarComentario(comentario);
	}
	
	/**
	 * Método responsável por remover um comentario
	 * @param codido
	 */
	public void removerComentario(int codido){
		this.comentario.removerComentario(codido);
	}
	
	/**
	 * Método responsável por consultar um comentário
	 * @param codido
	 * @return o comentário
	 */
	public Comentario consultarComentario(int codido){
		return this.comentario.consultarComentario(codido);
	}
	
	/**
	 * Método responsável por salvar um anexo
	 * @param nome
	 * @param tipo
	 * @param end
	 * @param codComentario
	 * @param codPost
	 * @return o código do anexo
	 */
	public int salvarAnexo(String nome, int tipo, String end, int codComentario, int codPost){
		this.anexo.setNome(nome);
		this.anexo.setComentario(this.comentario.consultarComentario(codComentario));
		this.anexo.setEnd(end);
		this.anexo.setPost(this.post.consultarPost(codPost));
		this.anexo.setTipo(tipo);
		return this.anexo.salvarAnexo(anexo);
	}
	
	/**
	 * Método responsável por remover um anexo do sistema
	 * @param cod
	 */
	public void removerAnexo(int cod){
		this.anexo.removerAnexo(cod);
	}
	
	/**
	 * Método responsável por contular um anexo
	 * @param cod
	 * @return um anexo.
	 */
	public Anexo consultarAnexo(int cod){
		return this.anexo.consultarAnexo(cod);
	}

}
