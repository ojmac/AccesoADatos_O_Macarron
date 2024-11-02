package manejoDeConectores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LogicaBd {

	String rutaScriptCreacion="";
	String rutaScriptInsercion="";

	public BD crearBD(File file) {
		Properties pr = new Properties();
		BD bd= null;
		try (FileInputStream fis = new FileInputStream(file)) {
			pr.load(fis);

			String cadConexion = pr.getProperty("cadena_conexion");
			String usuarioBD = pr.getProperty("usuarioBD");
			String pswdBD = pr.getProperty("contrasenaBD");
			rutaScriptCreacion = pr.getProperty("rutaScriptCreacion");
			rutaScriptInsercion = pr.getProperty("rutaScriptInsercion");

			fis.close();
			bd = new BD(cadConexion, usuarioBD, pswdBD, "tareas_pendientes");
			System.out.println("Conexión a la base de datos establecida con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bd;
	}

	public void creaTabla() {
		
		BD bd = crearBD(new File("bd.config"));

		BufferedReader br = null;
		boolean ok = false;

		try  {
		
			br = new BufferedReader(new FileReader(rutaScriptCreacion));
			String linea;
			StringBuilder sentencia = new StringBuilder();

			while ((linea = br.readLine()) != null) {
				if (linea.isEmpty() || linea.startsWith("#")) {
					continue;
				}
				sentencia.append(linea);
			}
			String setenciaSQL = sentencia.toString();
			ok = bd.crearTabla(setenciaSQL);
			if (ok)
				System.out.println("Tabla creada!!");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void insertaDatos() {
		
		BD bd = crearBD(new File("bd.config"));

		BufferedReader br = null;
		boolean ok = false;

		try  {
			
			br = new BufferedReader(new FileReader(rutaScriptInsercion));
			String linea;
			StringBuilder sentencia = new StringBuilder();
			while ((linea = br.readLine()) != null) {

				sentencia.append(linea).append("\n");
			}
			String setenciaSQL = sentencia.toString();
			ok = bd.insertarDatos(setenciaSQL);

		} catch (FileNotFoundException e) {

			System.err.println("El archivo no se encontró: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		} finally {

			try {
				if (br != null)
					br.close();

			} catch (IOException e) {
				System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
			}
			if (ok)
				System.out.println("Datos insertados");
		}
	}

	public void modificaCampo(int[] ids, boolean finalizada) {

		BD bd = crearBD(new File("bd.config"));
		bd.modifcarCampo(ids, finalizada);
	}

	public void muestraDatos(String fechaInicio, String fechaFinal) {

		BD bd = crearBD(new File("bd.config"));
		bd.mostrarDatos(fechaInicio, fechaFinal);
	}

}
