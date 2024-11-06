package manejoDeFicheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej_3_2_2 {

	/*
	 * Ejercicio 3.2.2 Se modifica la solución del Ejercicio 3.2.1 para que, en
	 * lugar de guardar la información mediante un clase de tipo ObjectOutputStream,
	 * se emplee una clase de tipo DataOutputStream. Respecto a la lectura de
	 * información del fichero, en lugar de emplear la clase ObjectInputStream, se
	 * empleará la clase DataInputStream. Emplea métodos de Test para la ejecución
	 * de los dos métodos implicados. Se añadirá al menos la información de tres
	 * coches al fichero.
	 */

	public void guardaCoches2(String[] marcas, String[] matriculas, int[] anyosMatriculacion) {
		String nomArch = "./coches.dat";
		DataOutputStream dos = null;
		for (int i = 0; i < matriculas.length; i++) {
			try {
				
				FileOutputStream fos = new FileOutputStream(nomArch, true);
				dos = new DataOutputStream(fos);

				dos.writeUTF(marcas[i]);
				dos.writeUTF(matriculas[i]);
				dos.writeInt(anyosMatriculacion[i]);
				

				System.out.println("Coche guardado en " + nomArch);

			} catch (IOException e) {

			}finally {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void datosCoches2(String nomArch) {
		DataInputStream dis =null;
		
		try {
			FileInputStream fis = new FileInputStream(nomArch);
			dis = new DataInputStream(fis);
			while(true) {
				
			String marca = dis.readUTF();
			String matriculaL = dis.readUTF();
			int anyoMatriculacion = dis.readInt();
			

			System.out.printf("El coche del año : %d, marca: %s, con matricula %s \n", anyoMatriculacion, marca,
					matriculaL);
		}
		} catch (IOException e) {
			System.out.println("Fin de archivo");
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
		
	}
}
