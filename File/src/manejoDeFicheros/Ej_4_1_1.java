package manejoDeFicheros;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ej_4_1_1 {

	/*Ejercicio 4.1.1 Sobre la clase del ejercicio 3.2.1 implementa un método que permita mostrar
	 *en pantalla la información de un coche a partir de una matrícula. 
	 *El método tendrá como parámetro la matrícula del coche a buscar.
	 *Emplea un método de Test para la ejecución del nuevo método.
	 */
	
	public void guardaCoches2(String[] marcas, String[] matriculas, int[] anyosMatriculacion) {

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
	
	public void datosCoches2(String nomFich, String matricula) {
		ObjectInputStream ois=null; 
		try {
			FileInputStream fis = new FileInputStream(nomFich);
			ois = new ObjectInputStream(fis);
			while (true) {

				try {
					Coche pOut = (Coche) ois.readObject();
					
					if(matricula.equals(pOut.matricula)) {
					System.out.printf("El coche del año : %d, marca: %s, con matricula %s \n", pOut.anyoMatriculacion,
							pOut.marca, pOut.matricula);
					break;
					}else continue;
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
