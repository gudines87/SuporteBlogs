package negocios;

import interfaces.UsuarioDAO;

public class Usuario {

	protected String id;
	protected String nome;
	protected String login;
	protected String senha;
	protected String end;
	protected String tel;
	protected String mail;
	
	public Usuario(){
		
	}
	
	public Usuario(String login, String senha, String nome){
		this.login = login;
		this.senha = senha;
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login
				+ ", senha=" + senha + ", end=" + end + ", tel=" + tel
				+ ", mail=" + mail + "]";
	}
	
	public void gravarLogin(String login, String senha){
		this.id = login.concat(senha);
	}
	
	public void salvarDados(Usuario usuario){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		ud.salvarDados(usuario);		
	}
	
	public void atualizarDados(Usuario usuario){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		ud.atualizarDados(usuario);
	}
	
	public Usuario consultarUsuario(String id){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		return ud.consultarUsuario(id);
	}
	
	public void removerUsuario(String id){
		UsuarioDAO ud = FactoryDAO.createUsuarioDAO();
		ud.removerUsuario(id);
	}
	
	public void gerarComentario(Comentario comentario){
		
	}
	
	public void deletarComentario(int cod){
		
	}
	
	public Post consultarPost(int cod){
		return null;
	}
	
}