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

public class FactoryDAO {
	
	public static ProfileDAO createProfileDAO(){
		return new JDBCProfileDAO();
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

}