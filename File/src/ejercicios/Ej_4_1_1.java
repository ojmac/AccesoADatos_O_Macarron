package ejercicios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ej_4_1_1 {

	/*Ejercicio 4.1.1 Sobre la clase del ejercicio 3.2.1 implementa un método que permita mostrar
	 *en pantalla la información de un coche a partir de una matrícula. 
	 *El método tendrá como parámetro la matrícula del coche a buscar.
	 *Emplea un método de Test para la ejecución del nuevo método.
	 */
	public void datosCoches2(String matricula) {

		
		try {
			String nomArch = "./" + matricula + ".dat"; 
			FileInputStream fis = new FileInputStream(nomArch);
			DataInputStream dis = new DataInputStream(fis);
			
			String marca = dis.readUTF();
	        String matriculaL = dis.readUTF();
	        int anyoMatriculacion = dis.readInt();
			dis.close();
	        
			System.out.printf("El coche del año : %d, marca: %s, con matricula %s \n", anyoMatriculacion, marca,matriculaL);
			

		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
           
	}																										
	
}
