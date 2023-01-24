package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;

//clase que controla la conexión a la bbdd
public class Conexion {

	// método para realizar la conexión
	public static Connection conectar() {
		Connection cnx = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3307/foro", "root", "");
			return cnx;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return null;
		}
	}

}
