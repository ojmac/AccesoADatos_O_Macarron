package manejoDeFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej_4_2_1 {

	/*
	 * Ejercicio 4.2.1 A partir de los ejemplos de escritura y lectura de fichero en
	 * modo aleatorio vistos anteriormente implementa una clase que permita insertar
	 * registros del mismo tipo mediante arrays pasados por parámetros con los IDs,
	 * nombres y edades de usuarios. Implementa otro método que permita la lectura
	 * de todos los registros del fichero.
	 * Implementa finalmente un método que modifique la edad de un registro para un id 
	 * determinado pasado por parámetro. La edad también se pasará por parámetro a este nuevo método.
	 * Emplea un método de Test para la ejecución de todos los métodos de la clase.

	 */

	public void escrbAlea(String[] nombres, String[] ids, int[] edades) {

		try {
			RandomAccessFile raf = new RandomAccessFile("./miBase.dat", "rw");

			for (int i = 0; i < nombres.length; i++) {

				this.wReg(raf, nombres[i], ids[i], edades[i]);
				System.out.println("Registro grabado");

			}

			raf.close();

		} catch (FileNotFoundException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

	private void wReg(RandomAccessFile raf, String nombre, String id, int edad) throws IOException {

		StringBuffer sBuffer = new StringBuffer(id);
		sBuffer.setLength(9);
		StringBuffer sBuffer2 = new StringBuffer(nombre);
		sBuffer2.setLength(15);
		raf.writeChars(sBuffer.toString());
		raf.writeChars(sBuffer2.toString());
		raf.writeInt(edad);

	}

	public void leerAlea(String file) {
		RandomAccessFile raf= null;
		try {
			long reg = 0L;
			raf = new RandomAccessFile(file, "r");

			while (true) {

				rReg(raf, reg);

				reg += 0L + 18 + 30 + 4;
			}
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			
			System.out.println(" *** Fin de registros ***");
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

	private void rReg(RandomAccessFile raf, long reg) throws IOException {

		raf.seek(reg);

		char[] idR = new char[9];
		for (int i = 0; i < idR.length; i++) {
			char ch = raf.readChar();
			idR[i] = ch;
		}
		String id = new String(idR).trim();

		char[] nombreR = new char[15];
		for (int i = 0; i < nombreR.length; i++) {
			char ch = raf.readChar();
			nombreR[i] = ch;
		}
		String nombre = new String(nombreR).trim();

		int edad = raf.readInt();

		System.out.printf("Para el registro  id = %s,  nombre = %s, edad = %d " + System.lineSeparator(), id,
				nombre, edad);
	}

}
