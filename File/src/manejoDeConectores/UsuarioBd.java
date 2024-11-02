package manejoDeConectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioBd {

	public UsuarioBd() {

	}
	public static void crearTabla(String url, String usuario, String pswd, String sentenciaSQL) {

		Connection conn = null;
		Statement st = null;

		try {
			conn = DriverManager.getConnection(url, usuario, pswd);
			st = conn.createStatement();
			st.executeUpdate(sentenciaSQL);

		} catch (SQLException ex) {
			System.out.println("Error" + ex.getMessage());

		} finally {
			try {
				if (st != null && !st.isClosed()) {
					st.close();
					System.out.println("Sentencia cerrada");
				}
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la sentencia:\n" + ex.getStackTrace());
			}
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
					System.out.println("Conexión cerrada");
				}
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexión:\n" + ex.getStackTrace());
			}
		}
	}
}
