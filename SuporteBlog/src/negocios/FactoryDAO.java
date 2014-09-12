package negocios;

import interfaces.AdministradorDAO;
import interfaces.AnexoDAO;
import interfaces.BlogDAO;
import interfaces.ComentarioDAO;
import interfaces.EspectadorDAO;
import interfaces.PostDAO;
import persistencia.JDBCAdministradorDAO;
import persistencia.JDBCAnexoDAO;
import persistencia.JDBCBlogDAO;
import persistencia.JDBCComentarioDAO;
import persistencia.JDBCEspectadorDAO;
import persistencia.JDBCPostDAO;

public class FactoryDAO {
	
	public static EspectadorDAO createEspectadorDAO(){
		return new JDBCEspectadorDAO();
	}
	
	public static BlogDAO createBlogDAO(){
		return new JDBCBlogDAO();
	}
	
	public static AnexoDAO createAnexoDAO(){
		return new JDBCAnexoDAO();
	}
	
	public static ComentarioDAO createComentarioDAO(){
		return new JDBCComentarioDAO();
	}
	
	public static PostDAO createPostDAO(){
		return new JDBCPostDAO();
	}

	public static AdministradorDAO createAdministradorDAO(){
		return new JDBCAdministradorDAO();
	}
}