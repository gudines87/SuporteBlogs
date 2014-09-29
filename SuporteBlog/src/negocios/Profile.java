package negocios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import interfaces.ProfileDAO;

/**
* Esta classe refere-se ao perfil de um usuário cadastrado.
*
* @author Lucas Barbosa
*/
public class Profile implements Observer {
	
   
	private String login;
	private String nome_exibicao;
	private String senha;
	private String sexo;
	private String email;
	private String data_nasc;
	private String endereco;
	private String interesses;
	private String quem_sou_eu;
	private String filmes;
	private String musicas;
	private String livros;
	
	
	/**
	* Construtor da classe vazio.
	*/
	public Profile(){
		
	}
	
	
	/**
	 * Construtor da classe inicializando os atributos.
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
	public Profile(String login, String nome, String senha, String sexo,
			String email, String dataNascimento, String endereco,
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

	/**
	* Retorna o nome do perfil.
	*
	* @return nome do perfil
	*/
	public String getNome() {
		return nome_exibicao;
	}
	
	/**
	* Seta nome do perfil.
	*
	* @param nome
	*/
	public void setNome(String nome) {
		this.nome_exibicao = nome;
	}
	
	/**
	* Retorna o login do perfil.
	*
	* @return login do perfil
	*/
	public String getLogin() {
		return login;
	}
	
	/**
	* Seta login do perfil.
	*
	* @param login
	*/
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	* Retorna a senha do perfil.
	*
	* @return senha do perfil
	*/
	public String getSenha() {
		return senha;
	}
	
	/**
	* Seta senha do perfil.
	*
	* @param senha
	*/
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	* Retorna o sexo do perfil.
	*
	* @return nsexo do perfil
	*/
	public String getSexo() {
		return sexo;
	}

	/**
	* Seta sexo do perfil.
	*
	* @param sexo
	*/
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	* Retorna o email do perfil.
	*
	* @return email do perfil
	*/
	public String getEmail() {
		return email;
	}

	/**
	* Seta email do perfil.
	*
	* @param email
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	* Retorna a data de nascimento do perfil.
	*
	* @return data de nascimento do perfil
	*/
	public String getDataNascimento() {
		return data_nasc;
	}

	/**
	* Seta a data de nascimento do perfil.
	*
	* @param data nascimento
	*/
	public void setDataNascimento(String dataNascimento) {
		this.data_nasc = dataNascimento;
	}

	/**
	* Retorna o endereco do perfil.
	*
	* @return endereco do perfil
	*/
	public String getEndereco() {
		return endereco;
	}

	/**
	* Seta endereco do perfil.
	*
	* @param endereco
	*/
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	* Retorna os interesses do perfil.
	*
	* @return interesses do perfil
	*/
	public String getInteresses() {
		return interesses;
	}

	/**
	* Seta interesses do perfil.
	*
	* @param interesses
	*/
	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	/**
	* Retorna uma descricao do perfil.
	*
	* @return quem sou eu do perfil
	*/
	public String getQuemSouEu() {
		return quem_sou_eu;
	}

	/**
	* Seta quem_sou_eu do perfil.
	*
	* @param quem_sou_eu
	*/
	public void setQuemSouEu(String quemSouEu) {
		this.quem_sou_eu = quemSouEu;
	}

	/**
	* Retorna os filmes favoritos do perfil.
	*
	* @return filmes do perfil
	*/
	public String getFilmes() {
		return filmes;
	}

	/**
	* Seta os filmes do perfil.
	*
	* @param filmes
	*/
	public void setFilmes(String filmes) {
		this.filmes = filmes;
	}

	/**
	* Retorna as musicas favoritas do perfil.
	*
	* @return musicas do perfil
	*/
	public String getMusicas() {
		return musicas;
	}

	/**
	* Seta musicas do perfil.
	*
	* @param muscias
	*/
	public void setMusicas(String musicas) {
		this.musicas = musicas;
	}

	/**
	* Retorna os livros favoritos do perfil.
	*
	* @return livros do perfil
	*/
	public String getLivros() {
		return livros;
	}

	/**
	* Seta livros do perfil.
	*
	* @param livros
	*/
	public void setLivros(String livros) {
		this.livros = livros;
	}

	
	/**
	* Mostra os atributos do perfil numa String
	*
	* @return uma string mostrando os atributos do perfil
	*/
	@Override
	public String toString() {
		return "Profile [login=" + login + ", nome_exibicao=" + nome_exibicao
				+ ", senha=" + senha + ", sexo=" + sexo + ", email=" + email
				+ ", data_nasc=" + data_nasc + ", endereco=" + endereco
				+ ", interesses=" + interesses + ", quem_sou_eu=" + quem_sou_eu
				+ ", filmes=" + filmes + ", musicas=" + musicas + ", livros="
				+ livros + "]";
	}

	
	/**
	* Cria um perfil de usuario
	*
	* @param usuario
	*/
	public void createProfile(Profile usuario){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		ud.createProfile(usuario);
	}
	
	/**
	* Modifica informações desse perfil
	*
	* @param id, atributo, conteudo
	*/
	public void changeProfileInformation(String id, String atributo, String conteudo){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		ud.changeProfileInformation(id, atributo, conteudo);
	}
	
	/**
	* consulta usuario pelo id
	*
	* @param id
	* @return Profile, um perfil.
	*/
	public Profile consultarUsuario(String id){	
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		return ud.consultarUsuario(id);
	}
	
	/**
	 * método que remove os usuários do sistema
	 * 
	 * @param login
	 */
	public void removerUsuario(String login){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		ud.removerUsuario(login);
	}
	
	/**
	 * Método que lista os usuarios cadastrados no sistema
	 * @return uma lista de usuario
	 */
	public List<Profile> listarUsuarios(){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		return ud.listarUsuarios();
	}
	
	/**
	 * método que consulta um perfil de acordo com seu login
	 * 
	 * @param login
	 * @return um Perfil.
	 */
	public Profile consultarPorLogin(String login){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		return ud.consultaPorLogin(login);
	}
	
	
	/**
	 *Método que retorna informações especificas de um atributo do perfil pesquisado 
	 * @param login
	 * @param atributo
	 * @return uma String com as informações do atributo.
	 */
	public String getProfileInformation(String login, String atributo){
		if(atributo.equals("nome_exibicao")){
			return consultarPorLogin(login).getNome();
		}else if(atributo.equals("email")){
			return consultarPorLogin(login).getSexo();
		}else if(atributo.equals("endereco")){
			return consultarPorLogin(login).getEndereco();
		}else if(atributo.equals("interesses")){
			return consultarPorLogin(login).getInteresses();
		}else if(atributo.equals("quem_sou_eu")){
			return consultarPorLogin(login).getQuemSouEu();
		}else if(atributo.equals("filmes")){
			return consultarPorLogin(login).getFilmes();
		}else if(atributo.equals("musicas")){
			return consultarPorLogin(login).getMusicas();
		}else if(atributo.equals("livros")){
			return consultarPorLogin(login).getLivros();
		}
		
		return  "Erro";
	}

	
	public boolean validarLogin(){
		Pattern pattern = Pattern.compile("^\\w{5,15}-");
        Matcher matcher = pattern.matcher("ETE-1234 ZXC-4567 cdr-0987");
 
        boolean b = false;
        while( b = matcher.find() ){
            if( b ){
                System.out.println( matcher.group()+" - Posicao: "+matcher.start() );
            }else{
                System.out.println("Nao encontrado");
            }
        }
		return true;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Método que válida o email.
	 * 
	 * @param email
	 * @return retorna um boolean para validar o email.
	 */
	 public boolean validarEmail(String email) {
		    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		    Matcher m = p.matcher(email); 
		    if (m.find()){
		      System.out.println("O email "+email+" e valido");
		      return true;
		    }
		    else{
		      System.out.println("O E-mail "+email+" e invalido");
		      return false;
		    }  
	}
	 
	 /**
	  * método que válida o login
	  * 
	  * @param usuario
	  * @return retorn um boolean para validar o login
	  */
	 public boolean validarLogin(Profile usuario){
		 	ProfileDAO pd = FactoryDAO.createProfileDAO();
		 
		 	if(usuario.getLogin().length() < 5 || usuario.getLogin().length() > 15){
				JOptionPane.showMessageDialog(null, "Minimo de 5 e maximo de 15 caracteres para login","aviso", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			if(usuario.getSenha().length() < 6 || usuario.getLogin().length() > 16){
				JOptionPane.showMessageDialog(null, "Minimo de 6 e maximo de 16 caracteres para senha","aviso", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			if(pd.validarProfile(usuario.getLogin()) == true){
				return false;
			}
			
	 return true;
	 }
	 
	
	 /**
	  * Método para validar campos de um perfil.
	  * 
	  * 
	  * @param usuario
	  * @return retorn um boolean que válida campos do perfil
	  */
	public boolean validarCampos(Profile usuario){
		
		if(usuario.getLogin().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo login ï¿½ obrigatï¿½rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(usuario.getSenha().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo senha ï¿½ obrigatï¿½rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(usuario.getEmail().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo email ï¿½ obrigatï¿½rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(usuario.getDataNascimento().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo Data de nascimento ï¿½ obrigatï¿½rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		
		return true;		
	}
	
	
	/**
	 * Método que calcula a idade do usuario de um perfil
	 * @param dataNasc
	 * @return a idade do perfil.
	 * @throws ParseException
	 */
	public int calculaIdade(String dataNasc) throws ParseException{

	    DateFormat formatter = new SimpleDateFormat("MM/dd/yy");  
	    Date date = (Date)formatter.parse(dataNasc);  
		
		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(date);

		Calendar today = Calendar.getInstance();

		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {

		age--;

		}

		return age;

		}
}
