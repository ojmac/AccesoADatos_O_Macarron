package manejoDeConectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ej_10_1_1 {
	
	public ArrayList<String[]> leerCsv(String archivoCSV) {
		
		  ArrayList<String[]> registros = new ArrayList<>();
		 
		  try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
			  String linea = br.readLine(); 
			  if (linea == null || linea.isEmpty()) {
				    System.out.println("El archivo está vacío o no se pudo leer.");
				    return registros;
				}
			  
			  String[] registrosArray = linea.split(";");
			   for (String registro : registrosArray) {
	              
	                String[] valores = registro.split(",");
	 
	                registros.add(valores);
	            }
			  br.close();
		  } catch (IOException e) {
	            e.printStackTrace();
	      }
			  return registros;
		  }
		
	public void insertarDatos() throws SQLException {
		ArrayList<String[]> registros=this.leerCsv("tareas.csv");
		
		Connection con = null;
	  	PreparedStatement statement = null;
	  	String sentenciaSQL = null;
	  	String url = "jdbc:mysql://localhost:3306/tareas_pendientes";
	  	sentenciaSQL = "INSERT INTO tareas_pendientes VALUES (?, ?, ?, ?, ?)";
	  	try {
			
			 con = DriverManager.getConnection(url, "root", "");
			 statement = con.prepareStatement(sentenciaSQL);
			for (String[]registro:registros) {
				   if (registro.length != 5) {
	                    System.out.println("Registro incompleto: " + String.join(",", registro));
	                    continue;
	                }
		    	
				
					 
						statement.setInt (1, Integer.parseInt(registro[0]));
						 statement.setString (2, registro[1]);
						 statement.setString(3, registro[2]);
						 statement.setString(4, registro[3]);
						 statement.setBoolean(5,  Boolean.parseBoolean(registro[4]));
						
						 statement.executeUpdate();
			
			
			}
			
		} catch (SQLException ex) {
			
		  	  System.out.println("peta aqui");;
			
		}finally {
		  	  try {
		    	    if (statement != null && !statement.isClosed()) {
		             statement.close();
		    	    }
		  	  } catch (SQLException ex) {
		  	
		  	  }
		  	  System.out.println("Operación Terminada");
			}

		
		
	}
	
	}


	
	


