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
	
	public Profile(){
		
	}
	
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

	public String getDataNascimento() {
		return data_nasc;
	}

	public void setDataNascimento(String dataNascimento) {
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

	public void createProfile(Profile usuario){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		ud.createProfile(usuario);
	}
	
	public void changeProfileInformation(String id, String atributo, String conteudo){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		ud.changeProfileInformation(id, atributo, conteudo);
	}
	
	public Profile consultarUsuario(String id){	
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		return ud.consultarUsuario(id);
	}
	
	public void removerUsuario(String login){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		ud.removerUsuario(login);
	}
	
	public List<Profile> listarUsuarios(){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		return ud.listarUsuarios();
	}
	
	public Profile consultarPorLogin(String login){
		ProfileDAO ud = FactoryDAO.createProfileDAO();
		return ud.consultaPorLogin(login);
	}
	
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
	 
	
	public boolean validarCampos(Profile usuario){
		
		if(usuario.getLogin().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo login � obrigat�rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(usuario.getSenha().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo senha � obrigat�rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(usuario.getEmail().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo email � obrigat�rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(usuario.getDataNascimento().equals(null)){
			JOptionPane.showMessageDialog(null, "O campo Data de nascimento � obrigat�rio","aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		
		return true;		
	}
	
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
