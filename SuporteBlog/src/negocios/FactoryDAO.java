package negocios;


import interfaces.AnexoDAO;
import interfaces.BlogDAO;
import interfaces.ComentarioDAO;
import interfaces.PostDAO;
import interfaces.ProfileDAO;

import persistencia.JDBCAnexoDAO;
import persistencia.JDBCBlogDAO;
import persistencia.JDBCComentarioDAO;
import persistencia.JDBCPostDAO;
import persistencia.JDBCProfileDAO;;

/**
 * Classe FactoryDAO respons�vel por retornar a inicializa��o dos JDBCs.
 * Essa classe pode substituir o Singleton
 * 
 * @author Everson Douglas
 *
 */
public class FactoryDAO {
	
	/**
	 * M�todo do JDBCProfileDAO
	 * @return a inicializa��o do JDBCProfileDAO
	 */
	public static ProfileDAO createProfileDAO(){
		return new JDBCProfileDAO();
	}
	
	/**
	 * M�todo do JDBCBlogDAO
	 * @return a inicializa��o do JDBCBlogDAO
	 */
	public static BlogDAO createBlogDAO(){
		return new JDBCBlogDAO();
	}
	
	/**
	 * M�todo do JDBCAnexoDAO
	 * @return a inicializa��o do JDBCAnexoDAO
	 */
	public static AnexoDAO createAnexoDAO(){
		return new JDBCAnexoDAO();
	}
	
	/**
	 * M�todo do JDBCComentarioDAO
	 * @return a inicializa��o do JDBCComentarioDAO
	 */
	public static ComentarioDAO createComentarioDAO(){
		return new JDBCComentarioDAO();
	}
	
	/**
	 * M�todo do JDBCPostDAO
	 * @return a inicializa��o do JDBCPostDAO
	 */
	public static PostDAO createPostDAO(){
		return new JDBCPostDAO();
	}

}