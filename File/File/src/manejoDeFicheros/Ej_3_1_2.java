package manejoDeFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej_3_1_2 {

	/*
	 * Ejercicio 3.1.2 Implementa una clase con un método que evidencie la
	 * diferencia de rendimiento entre el uso de las clases FileReader y FileWriter
	 * y las clases BufferedReader y BufferedWriter. Para los cálculos de tiempo
	 * puede hacerse uso del método System.currentTimeMillis().
	 */

	public void comparador() {

		long tiempo1 = 0;
		long tiempo2 = 0;
		System.out.println("1parte");

		try {
			long inicial = System.currentTimeMillis();
			File fichero = new File("fichero1.txt");
			FileWriter fw = new FileWriter(fichero, true);
			fw.write("	/*Ejercicio 3.1.2 Implementa una clase con un método que evidencie la diferencia de \r\n"
					+ "	 *rendimiento entre el uso de las clases FileReader y FileWriter y las clases BufferedReader\r\n"
					+ "	 *y BufferedWriter. \r\n"
					+ "	 *Para los cálculos de tiempo puede hacerse uso del método System.currentTimeMillis().*/");
			fw.close();

			FileReader fr = new FileReader(fichero);
			int c = 0;
			while (c != -1) {

				c = fr.read();
				if (c != -1)
					System.out.print((char) c);

				long fin = System.currentTimeMillis();
				tiempo1 = fin - inicial;
			}

			fr.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("\n2parte");
		try {
			long inicial = System.currentTimeMillis();
			File fichero = new File("fichero2.txt");
			

			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("	/*Ejercicio 3.1.2 Implementa una clase con un método que evidencie la diferencia de \r\n");
			bw.newLine();
			bw.write("	 *rendimiento entre el uso de las clases FileReader y FileWriter y las clases BufferedReader\r\n");
			bw.newLine();
			bw.write("	 *y BufferedWriter. \r\n");
			bw.newLine();
			bw.write("	 *Para los cálculos de tiempo puede hacerse uso del método System.currentTimeMillis().*/");
			bw.close();

			FileReader fr = new FileReader(fichero);
			BufferedReader bf = new BufferedReader(fr);

			String linea = "";
			while (linea != null) {
				linea = bf.readLine();
				if (linea != null) {

					System.out.println(linea);
				}

			}
			long fin = System.currentTimeMillis();
			tiempo2 = fin - inicial;

			bf.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		long difTotal = tiempo1 - tiempo2;
		System.out.println(
				"El proceso usando buferedreader y bufferedwriter es " + difTotal + " milisegundos más rapido");
	}

}
