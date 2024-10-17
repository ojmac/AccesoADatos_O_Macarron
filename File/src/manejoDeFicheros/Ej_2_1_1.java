package manejoDeFicheros;

import java.io.File;

public class Ej_2_1_1 {

	/*
	 * Ejercicio 2.1.1 Desarrolla una clase que indique por pantalla los elementos
	 * que forman parte de la ruta raíz de un proyecto java. En el caso de que sea
	 * un fichero mostrará la frase: Nombre del fichero: <nombre_fichero>. En el
	 * caso de que sea un directorio mostrará la frase: Nombre del directorio:
	 * <nombre_fichero>
	 */

	public void listarFichero() {

		File fichero = new File(".");

		if (fichero.exists() && fichero.isDirectory()) {

			File[] ficheros = fichero.listFiles();

			for (File f : ficheros) {

				if (f.isDirectory()) {
					System.out.println("Nombre del directorio: " + f.getName());
				} else {
					System.out.println("Nombre del fichero: " + f.getName());
				}
			}
		}
	}
}
