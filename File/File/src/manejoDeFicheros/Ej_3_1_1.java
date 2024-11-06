package manejoDeFicheros;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej_3_1_1 {
	
	/*Ejercicio 3.1.1 Se implementa una clase con un método que escriba en un fichero una cadena. 
	 * Tanto el nombre del fichero como la cadena se pasarán como parámetros al método anterior. 
	 * Después de registrar en el fichero la cadena, el método a implementar permitirá añadir 
	 * al final del fichero un asterisco.*/
	
	
	public static void escribirCadena(String fichero, String cadena) {
		Scanner sct = new Scanner(System.in);
		
		try {
			File fichero1 = new File(fichero);
			FileWriter fw = new FileWriter(fichero1, true);
			fw.write(cadena);
			
			System.out.println("Quiere añadir un asterísco? (s/n)");
			String resp = sct.nextLine();
			if(resp.equalsIgnoreCase("s"))fw.write("*");
			
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
