package negocios;

import java.util.HashMap;
import java.util.Map;

public class ControleSessao {

	private static ControleSessao instance = null;
	private Map<Integer, String> sessoes = null;
	
	private ControleSessao(){
		sessoes = new HashMap<Integer, String>();
	}
	
	public static ControleSessao getInstance(){
		if(instance == null){
			instance = new ControleSessao();
			return instance;
		}
		return instance;
	}
	
	public Integer login(String login){
		return null;
	}
}
