package manejoDeFicheros;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej_3_2_2 {
	

	/*Ejercicio 3.2.2 Se modifica la solución del Ejercicio 3.2.1 para que, 
	 * en lugar de guardar la información mediante un clase de tipo ObjectOutputStream, 
	 * se emplee una clase de tipo DataOutputStream. Respecto a la lectura de información 
	 * del fichero, en lugar de emplear la clase ObjectInputStream, se empleará la clase 
	 * DataInputStream.
	 * Emplea métodos de Test para la ejecución de los dos métodos implicados. 
	 * Se añadirá al menos la información de tres coches al fichero.
	*/

		public void guardaCoches2(String marca, String matricula, int anyoMatriculacion) {

			
			try {
				String nomArch = "./" + matricula + ".dat";
				FileOutputStream fos = new FileOutputStream(nomArch, true);
				DataOutputStream dos = new DataOutputStream(fos);
				
				dos.writeUTF(marca);
				dos.writeUTF(matricula);
				dos.writeInt(anyoMatriculacion);
				dos.close();

				System.out.println("Coche guardado en " + nomArch);

			} catch (IOException e) {

			}
		}

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


