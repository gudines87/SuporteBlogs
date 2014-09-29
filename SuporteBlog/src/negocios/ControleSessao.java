package negocios;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ControleSessao {

	private static ControleSessao instance = null;
	private Profile profile;
	private String sessionId;
	private Map<String, String> sessoes = null;
	private Map<String, String> logins = null;
	
	private ControleSessao(){
		sessoes = new HashMap<String, String>();
		logins = new HashMap<String, String>();
		profile = new Profile();
	}
	
	public static ControleSessao getInstance(){
		if(instance == null){
			instance = new ControleSessao();
			return instance;
		}
		return instance;
	}
	
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
	
	public boolean logoof(String id){
		if(sessoes.containsKey(id)){
			sessoes.remove(id);
			return true;
		}else{
			return false;
		}
	}
	
	public String getLoginById(String id){
		if(sessoes.containsKey(id)){
			return sessoes.get(id);
		}
		
		return null;
	}
	
	public boolean isUserLogged(String login){
		if(sessoes.containsValue(login)){
			return false;
		}else{
			return true;
		}
		
	}
	
	public void resetSessions(){
		sessoes.clear();
		logins.clear();
	}
	
	public String getProfileInformationBySessionId(String id, String atributo){
		if(sessoes.containsKey(id)){
			return profile.getProfileInformation(sessoes.get(id), atributo);
		}
		return null;
	}
	
	public String getSessionId(){
		return sessionId;
	}
	
}
