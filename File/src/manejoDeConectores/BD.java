package manejoDeConectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

	private String url;
	private String usuario;
	private String pswd;
	private String tabla;
	private Connection con;

	public BD() {

	}

	public BD(String url, String usuario, String pswd, String tabla) {
		super();
		this.url = url;
		this.usuario = usuario;
		this.pswd = pswd;
		this.tabla = tabla;
		conectar();
	}

	private void conectar() {
		try {
			con = DriverManager.getConnection(url, usuario, pswd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean crearTabla(String sentenciaSQL) {

		Statement st = null;
		boolean ok = false;

		try {
			conectar();
			st = this.con.createStatement();
			st.executeUpdate(sentenciaSQL);
			ok = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (st != null && !st.isClosed()) {
					st.close();
					System.out.println("Sentencia cerrada");
				}
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la sentencia:\n" + ex.getStackTrace());
			}
		}
		cerrarConexion();

		return ok;
	}

	public boolean insertarDatos(String sentenciaSQL) {

		conectar();
		Statement st = null;

		boolean ok = false;

		try {

			st = this.con.createStatement();
			st.executeUpdate(sentenciaSQL);

			ok = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (st != null && !st.isClosed()) {
					st.close();
				}
			} catch (SQLException e) {
			}

			cerrarConexion();
			return ok;
		}
	}

	public boolean modifcarCampo(int[] ids, boolean finalizada) {

		conectar();
		Statement st = null;
		boolean ok = false;

		try {

			st = this.con.createStatement();
			for (int i = 0; i < ids.length; i++) {

				String setenciaSQL = "UPDATE " + this.tabla + " SET finalizada = " + finalizada + " WHERE id = " + ids[i];
				st.executeUpdate(setenciaSQL);
			}
			System.out.println("Cambios realizados con éxito");
			ok = true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		cerrarConexion();
		return ok;
	}

	public void mostrarDatos(String fechaInicio, String fechaFinal) {

		conectar();
		Statement st = null;
		ResultSet rs = null;

		try {

			st = this.con.createStatement();
			String sentenciaSQL = "SELECT id, descripcion, fecha_inicio, fecha_final, finalizada\r\n"
					+ "FROM tareas_pendientes\r\n" + "WHERE fecha_inicio >= '" + fechaInicio + "'\r\n" + "  AND fecha_final <= '"
					+ fechaFinal + "';";
			rs = st.executeQuery(sentenciaSQL);

			while (rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				String fechaInicioResult = rs.getString("fecha_inicio");
				String fechaFinalResult = rs.getString("fecha_final");
				boolean finalizada = rs.getBoolean("finalizada");

				System.out.println("\nID: " + id);
				System.out.println("Descripción: " + descripcion);
				System.out.println("Fecha de inicio: " + fechaInicioResult);
				System.out.println("Fecha final: " + fechaFinalResult);
				System.out.println("Finalizada: " + finalizada);
				System.out.println("----------------------------");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (st != null && !st.isClosed())
					st.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		cerrarConexion();

	}

	public void cerrarConexion() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				System.out.println("Conexión cerrada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
