package negocios;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import interfaces.UsuarioDAO;


public class Profile implements Observer {
	
   
	private String login;
	private String nome_exibicao;
	private String senha;
	private String sexo;
	private String email;
	private Date data_nasc;
	private String endereco;
	private String interesses;
	private String quem_sou_eu;
	private String filmes;
	private String musicas;
	private String livros;
	
	public Profile(){
		
	}
	
	public Profile(String login, String nome, String senha, String sexo,
			String email, Date dataNascimento, String endereco,
			String interesses, String quemSouEu, String filmes, String musicas,
			String livros) {
		super();
		this.login = login;
		this.nome_exibicao = nome;
		this.senha = senha;
		this.sexo = sexo;
		this.email = email;
		this.data_nasc = dataNascimento;
		this.endereco = endereco;
		this.interesses = interesses;
		this.quem_sou_eu = quemSouEu;
		this.filmes = filmes;
		this.musicas = musicas;
		this.livros = livros;
	}

	public String getNome() {
		return nome_exibicao;
	}
	public void setNome(String nome) {
		this.nome_exibicao = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return data_nasc;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.data_nasc = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public String getQuemSouEu() {
		return quem_sou_eu;
	}

	public void setQuemSouEu(String quemSouEu) {
		this.quem_sou_eu = quemSouEu;
	}

	public String getFilmes() {
		return filmes;
	}

	public void setFilmes(String filmes) {
		this.filmes = filmes;
	}

	public String getMusicas() {
		return musicas;
	}

	public void setMusicas(String musicas) {
		this.musicas = musicas;
	}

	public String getLivros() {
		return livros;
	}

	public void setLivros(String livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Profile [login=" + login + ", nome_exibicao=" + nome_exibicao
				+ ", senha=" + senha + ", sexo=" + sexo + ", email=" + email
				+ ", data_nasc=" + data_nasc + ", endereco=" + endereco
				+ ", interesses=" + interesses + ", quem_sou_eu=" + quem_sou_eu
				+ ", filmes=" + filmes + ", musicas=" + musicas + ", livros="
				+ livros + "]";
	}

	public void salvarUsuario(Profile usuario){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		ud.salvarUsuario(usuario);
	}
	
	public void atualizarUsuario(Profile usuario){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		ud.atualizarUsuario(usuario);
	}
	
	public Profile consultarUsuario(String id){	
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		return ud.consultarUsuario(id);
	}
	
	public void removerUsuario(String id){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		ud.removerUsuario(id);
	}
	
	public List<Profile> listarUsuarios(){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		return ud.listarUsuarios();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
