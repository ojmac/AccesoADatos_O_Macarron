package manejoDeConectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ej_8_1 {

	public boolean Error1042() {

		Connection con = null;

		int errorCode = 0;

		try {
			con = DriverManager.getConnection("jdbc:mysql://errorHost:3306/dannys_dinner", "root", "");
			System.out.println("Conexión establecida correctamente.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			errorCode = e.getErrorCode();

			System.out.println(errorCode);
			System.out.println("Ocurrió un error: " + e.getMessage());

			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {

			}
		}
		if (errorCode == 1042)
			return true;
		else
			return false;
	}

	public boolean Error1045() {

		String url = "jdbc:mysql://localhost:3306/tareas_pendientes";
		int errorCode = 0;
		System.out.println("Funciona");
		String usuario = "root";
		String contraseña = "contraseña_incorrecta";
		boolean ok = false;

		try {
			Connection con = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexión establecida correctamente.");
			con.close();

		} catch (SQLException e) {
			errorCode = e.getErrorCode();
			System.out.println(errorCode);
			System.out.println("Ocurrió un error: " + e.getMessage());
			e.printStackTrace();

		}
		if (errorCode == 1045)
			ok = true;
		return ok;
	}

	public boolean Error1046() {

		String url = "jdbc:mysql://localhost:3306";
		boolean ok =false;
		int errorCode =0;
		System.out.println("Funciona");
		String usuario = "root";
		String contraseña = "";

		try {
			Connection con = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexión establecida correctamente.");
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM tareas_pendientes";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			con.close();
		} catch (SQLException e) {
			errorCode = e.getErrorCode();
			System.out.println(errorCode);
			System.out.println("Ocurrió un error: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("terminado");
		if (errorCode == 1046)ok =true;
		return ok;
		

	}

	public boolean Error1109() {
		String url = "jdbc:mysql://localhost:3306/tareas_pendientes";
		boolean ok =false;
		int errorCode =0;
		System.out.println("Funciona");
		String usuario = "root";
		String contraseña = "";

		try {
			Connection con = DriverManager.getConnection(url, usuario, contraseña);
			System.out.println("Conexión establecida correctamente.");
			Statement stmt = con.createStatement();
			String query = "SELECT t.id FROM tareas_pendientes AS t JOIN (SELECT id FROM tareas_pendientes WHERE id = 1) AS non_existent_table WHERE t.id = non_existent_table.id;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			con.close();
		} catch (SQLException e) {
			errorCode = e.getErrorCode();
			System.out.println(errorCode);
			System.out.println("Ocurrió un error: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("terminado");
		if (errorCode == 1109)ok =true;
		return ok;
	}

}
