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

	public void guardaCoches(String marca, String matricula, int anyoMatriculacion) {

		Coche c = new Coche(marca, matricula, anyoMatriculacion);

		try {
			String nomArch = "./" + matricula + ".obj";
			FileOutputStream fos = new FileOutputStream(nomArch, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
			oos.close();

			System.out.println("Coche guardado en " + nomArch);

		} catch (IOException e) {

		}
	}

	public void datosCoches(String[] coches) {

		String[] matriculas = coches;

		for (String matricula : matriculas) {
			try {
				FileInputStream fis = new FileInputStream(matricula);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Coche pOut = (Coche) ois.readObject();
				System.out.printf("El coche del año : %d, marca: %s, con matricula %s \n", pOut.anyoMatriculacion,
						pOut.marca, pOut.matricula);

			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
		}
	}
}
