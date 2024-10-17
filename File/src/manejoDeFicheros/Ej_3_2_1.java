package manejoDeFicheros;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*Ejercicio 3.2.1 Implementa una clase para el ejercicio con un método que serialice y guarde
 *en fichero un objeto de la clase coche. La clase coche constará de los atributos matrícula, 
 *marca y año de matriculación. El método tendrá como parámetros estos mismos atributos.
 *Implementa otro método cuya finalidad sea la lectura de la información de todos los coches 
 *registrados en fichero.
 *Emplea métodos de Test para la ejecución de ambos métodos. 
 *Se añadirán al menos tres coches al fichero.
*/

public class Ej_3_2_1 {

	public void guardaCoches(String[] marcas, String[] matriculas, int[] anyosMatriculacion) {

		String nomArch = "./coches.obj";
		try {
			FileOutputStream fos = new FileOutputStream(nomArch, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < marcas.length; i++) {
				Coche c = new Coche(marcas[i], matriculas[i], anyosMatriculacion[i]);
				oos.writeObject(c);
				System.out.println("Coche guardado en " + nomArch);
			}

			oos.close();

		} catch (IOException e) {

		}
	}

	public void datosCoches(String nomFich) {
		ObjectInputStream ois=null; 
		try {
			FileInputStream fis = new FileInputStream(nomFich);
			ois = new ObjectInputStream(fis);
			while (true) {

				try {
					Coche pOut = (Coche) ois.readObject();
					System.out.printf("El coche del año : %d, marca: %s, con matricula %s \n", pOut.anyoMatriculacion,
							pOut.marca, pOut.matricula);
				
				}catch (EOFException e) {
	               
	                break; 
	            }catch (ClassNotFoundException e) {

					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}
}
