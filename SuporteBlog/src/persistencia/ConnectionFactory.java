package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/SuporteBlog", "root", "velhasenha");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao abrir a conexão em ConnectionFactory", e);
		}
	}

}
