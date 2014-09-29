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
 * Classe FactoryDAO responsável por retornar a inicialização dos JDBCs.
 * Essa classe pode substituir o Singleton
 * 
 * @author Everson Douglas
 *
 */
public class FactoryDAO {
	
	/**
	 * Método do JDBCProfileDAO
	 * @return a inicialização do JDBCProfileDAO
	 */
	public static ProfileDAO createProfileDAO(){
		return new JDBCProfileDAO();
	}
	
	/**
	 * Método do JDBCBlogDAO
	 * @return a inicialização do JDBCBlogDAO
	 */
	public static BlogDAO createBlogDAO(){
		return new JDBCBlogDAO();
	}
	
	/**
	 * Método do JDBCAnexoDAO
	 * @return a inicialização do JDBCAnexoDAO
	 */
	public static AnexoDAO createAnexoDAO(){
		return new JDBCAnexoDAO();
	}
	
	/**
	 * Método do JDBCComentarioDAO
	 * @return a inicialização do JDBCComentarioDAO
	 */
	public static ComentarioDAO createComentarioDAO(){
		return new JDBCComentarioDAO();
	}
	
	/**
	 * Método do JDBCPostDAO
	 * @return a inicialização do JDBCPostDAO
	 */
	public static PostDAO createPostDAO(){
		return new JDBCPostDAO();
	}

}