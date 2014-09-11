package negocios;

import interfaces.UsuarioDAO;
import persistencia.JDBCUsuarioDAO;

public class FactoryDAO {
	
	public static UsuarioDAO createUsuarioDAO(){
		return new JDBCUsuarioDAO();
	}

}