package negocios;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Classe respons�vel pelo controle de sess�o dos id de usuarios
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
	 * M�todo que retorna uma instancia da classe
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
	 * M�todo respons�vel por fazer o login dos perfils
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
	 * M�todo respons�vel por desfazer o login e remover o id de sess�o
	 * @param id
	 * @return um boolean afirmando se fez ou n�o o logoof
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
	 * M�todo respons�vel por recuperar o login do usuario logando atrav�s do seu id de sess�o
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
	 * M�todo respons�vel por verificar se o usuario est� logado atrav�s do login
	 * @param login
	 * @return o boolean confirmando se est� ou n�o logado
	 */
	public boolean isUserLogged(String login){
		if(sessoes.containsValue(login)){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * M�todo que reseta todos os ids, ou seja, reseta as sess�es.
	 */
	public void resetSessions(){
		sessoes.clear();
		logins.clear();
	}
	
	/**
	 * M�todo que retorna informa��es do perfil atrav�s do id de sess�o
	 * @param id
	 * @param atributo
	 * @return a informa��o requisitada.
	 */
	public String getProfileInformationBySessionId(String id, String atributo){
		if(sessoes.containsKey(id)){
			return profile.getProfileInformation(sessoes.get(id), atributo);
		}
		return null;
	}
	
	/**
	 * m�todo get do id de sess�o
	 * @return o sessionId
	 */
	public String getSessionId(){
		return sessionId;
	}
	
}
