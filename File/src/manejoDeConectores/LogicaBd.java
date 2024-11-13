package manejoDeConectores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogicaBd {

	String rutaScriptCreacion="";
	String rutaScriptInsercion="";
	BD bd = null;

    public BD crearBD(File file) {
    	
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] values = new String[5];  
            String line;
            int index = 0;

            while ((line = br.readLine()) != null && index < values.length) {
                String[] partes = line.split("=", 2); 
                if (partes.length == 2) { 
                    values[index] = partes[1].trim(); 
                    index++;
                }
            }

            bd = new BD(values[0], values[1], values[2], "tareas_pendientes");
            rutaScriptCreacion=values[3];
        	rutaScriptInsercion=values[4];

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bd;
    }

	public void creaTabla(File file) {
		
		crearBD(file);
		
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
			ok = bd.crearTablaInsertarDatos(setenciaSQL);
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

	public void insertaDatos(File file) {
		crearBD(file);
		
		BufferedReader br = null;
		boolean ok = false;

		try  {
			
			br = new BufferedReader(new FileReader(rutaScriptInsercion));
			String linea;
			
			while ((linea = br.readLine()) != null) {
				 if (!linea.trim().isEmpty()) {
				System.out.println(linea);
				ok = bd.crearTablaInsertarDatos(linea);
				 }
			}

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

	public void modificaCampo(int[] ids, boolean finalizada, File file) {
		crearBD(file);

		bd.modifcarCampo(ids, finalizada);
	}

	public void muestraDatos(String fechaInicio, String fechaFinal, File file) {
		crearBD(file);
		
		bd.mostrarDatos(fechaInicio, fechaFinal);
	}

}
