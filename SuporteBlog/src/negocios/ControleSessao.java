package negocios;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe responsável pelo controle de sessão dos id de usuarios
 * @author Lucas Barbosa
 *
 */
public class ControleSessao {

	private static ControleSessao instance = null;
	private Profile profile;
	private String sessionId;
	private Map<String, String> sessoes = null;
	private Map<String, String> logins = null;
	
	/**
	 * Construtor instanciando os atributos
	 */
	private ControleSessao(){
		sessoes = new HashMap<String, String>();
		logins = new HashMap<String, String>();
		profile = new Profile();
	}
	
	/**
	 * Método que retorna uma instancia da classe
	 * @return a instancia da classe.
	 */
	public static ControleSessao getInstance(){
		if(instance == null){
			instance = new ControleSessao();
			return instance;
		}
		return instance;
	}
	
	/**
	 * Método responsável por fazer o login dos perfils
	 * @param login
	 * @param senha
	 * @return o id do Perfil logado.
	 */
	public String doLogin(String login, String senha){
		Random rand = null;
		rand = new Random();
		Integer id = rand.nextInt();
		while(sessoes.containsKey(id)){
			id= rand.nextInt();
			sessionId = "sessionId"+id;
		}
		sessoes.put(sessionId, login);
		logins.put(login, senha);
		return sessionId;
	}
	
	/**
	 * Método responsável por desfazer o login e remover o id de sessão
	 * @param id
	 * @return um boolean afirmando se fez ou não o logoof
	 */
	public boolean logoof(String id){
		if(sessoes.containsKey(id)){
			sessoes.remove(id);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Método responsável por recuperar o login do usuario logando através do seu id de sessão
	 * @param id
	 * @return o login do perfil
	 */
	public String getLoginById(String id){
		if(sessoes.containsKey(id)){
			return sessoes.get(id);
		}
		
		return null;
	}
	
	/**
	 * Método responsável por verificar se o usuario está logado através do login
	 * @param login
	 * @return o boolean confirmando se está ou não logado
	 */
	public boolean isUserLogged(String login){
		if(sessoes.containsValue(login)){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * Método que reseta todos os ids, ou seja, reseta as sessões.
	 */
	public void resetSessions(){
		sessoes.clear();
		logins.clear();
	}
	
	/**
	 * Método que retorna informações do perfil através do id de sessão
	 * @param id
	 * @param atributo
	 * @return a informação requisitada.
	 */
	public String getProfileInformationBySessionId(String id, String atributo){
		if(sessoes.containsKey(id)){
			return profile.getProfileInformation(sessoes.get(id), atributo);
		}
		return null;
	}
	
	/**
	 * método get do id de sessão
	 * @return o sessionId
	 */
	public String getSessionId(){
		return sessionId;
	}
	
}
