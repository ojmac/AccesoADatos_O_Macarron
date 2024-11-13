package manejoDeConectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class Ej_9_1_BD {

	private String url;
	private String usuario;
	private String pswd;
	private String tabla;
	private Connection con;

	public Ej_9_1_BD() {

	}

	public Ej_9_1_BD(String url, String usuario, String pswd, String tabla) {
		super();
		this.url = url;
		this.usuario = usuario;
		this.pswd = pswd;
		this.tabla = tabla;
		conectar();
	}

	private void conectar() {
		try {
			this.con = DriverManager.getConnection(this.url, this.usuario, this.pswd);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean crearTablaInsertarDatos(String sentenciaSQL) {

		Statement st = null;
		boolean ok = false;
		boolean autocommit = true;
		try {
			// conectar();
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
				System.err.println("Error al cerrar la sentencia:\n" + ex.getStackTrace());
			}
		}
		cerrarConexion();

		return ok;
	}

	public boolean modifcarCampo(int[] ids, boolean finalizada) {

		// conectar();
		Statement st = null;
		boolean ok = false;

		try {

			st = this.con.createStatement();
			for (int i = 0; i < ids.length; i++) {

				String setenciaSQL = "UPDATE " + this.tabla + " SET finalizada = " + finalizada + " WHERE id = "
						+ ids[i] + ";";
				st.executeUpdate(setenciaSQL);
			}
			System.out.println("Cambios realizados con éxito");
			ok = true;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (st != null && !st.isClosed()) {
					st.close();
				}
			} catch (SQLException e) {
				System.err.println("No se pudo cerrar el Statement");
				e.printStackTrace();
			}
		}
		cerrarConexion();
		return ok;
	}

	public boolean insertarTransaccion(List<String> ordenes) {
		Statement st = null;
		boolean ok = false;
		boolean autocommit = true;
		try {

			st = this.con.createStatement();
			autocommit = con.getAutoCommit();
			con.setAutoCommit(false);
			st = con.createStatement();
			for (String orden : ordenes) {
				st.executeUpdate(orden);
			}

			con.commit();
			con.setAutoCommit(autocommit);
			ok = true;
		} catch (SQLException e) {

			System.err.println("Error al ejecutar la transacción: " + e.getMessage());
			
		} finally {
			 try {
		            if (con != null) {
		                con.rollback();
		                System.out.println("Rollback realizado.");
		            }
			 } catch (SQLException e) {
		            System.err.println("Error al restaurar auto-commit: " + e.getMessage());
		        }
			try {
				if (st != null && !st.isClosed()) {
					st.close();
					System.out.println("Sentencia cerrada");
				}
			} catch (SQLException ex) {
				System.err.println("Error al cerrar la sentencia:\n" + ex.getStackTrace());
			}
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
					+ "FROM tareas_pendientes\r\n" + "WHERE fecha_inicio >= '" + fechaInicio + "'\r\n"
					+ "  AND fecha_final <= '" + fechaFinal + "';";
//				String sentenciaSQL = "select * from tareas_pendientes;"	;	
			rs = st.executeQuery(sentenciaSQL);

			System.out.println("----------------------------");
			System.out.print("ID ");
			System.out.print(" Descripción ");
			System.out.print(" Fecha de inicio ");
			System.out.print(" Fecha final ");
			System.out.println(" Finalizada ");
			System.out.println("----------------------------");

			while (rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");
				String fechaInicioResult = rs.getString("fecha_inicio");
				String fechaFinalResult = rs.getString("fecha_final");
				boolean finalizada = rs.getBoolean("finalizada");

				System.out.print(" " + id);
				System.out.print(" " + descripcion);
				System.out.print(" " + fechaInicioResult);
				System.out.print(" " + fechaFinalResult);
				System.out.println(" " + finalizada);
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
			if (this.con != null && !this.con.isClosed()) {
				this.con.close();
				System.out.println("Conexión cerrada.");
			}
		} catch (SQLException e) {

			System.out.println("No se pudo cerrar la conexión:");
			e.printStackTrace();
		}
	}
}
