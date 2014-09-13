package negocios;


import interfaces.AnexoDAO;
import interfaces.BlogDAO;
import interfaces.ComentarioDAO;
import interfaces.PostDAO;
import interfaces.UsuarioDAO;

import persistencia.JDBCAnexoDAO;
import persistencia.JDBCBlogDAO;
import persistencia.JDBCComentarioDAO;
import persistencia.JDBCPostDAO;
import persistencia.JDBCUsuarioDAO;;

public class FactoryDAO {
	
	public static UsuarioDAO createUsuarioDAO(){
		return new JDBCUsuarioDAO();
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