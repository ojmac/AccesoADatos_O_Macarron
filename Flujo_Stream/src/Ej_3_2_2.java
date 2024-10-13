import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej_3_2_2 {
	

	/*Ejercicio 3.2.1 Implementa una clase para el ejercicio con un método que serialice y guarde
	 *en fichero un objeto de la clase coche. La clase coche constará de los atributos matrícula, 
	 *marca y año de matriculación. El método tendrá como parámetros estos mismos atributos.
	 *Implementa otro método cuya finalidad sea la lectura de la información de todos los coches 
	 *registrados en fichero.
	 *Emplea métodos de Test para la ejecución de ambos métodos. 
	 *Se añadirán al menos tres coches al fichero.
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


