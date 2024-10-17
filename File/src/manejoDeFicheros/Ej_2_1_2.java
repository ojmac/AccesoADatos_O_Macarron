package manejoDeFicheros;

import java.io.File;
import java.io.IOException;

public class Ej_2_1_2 {

	/*
	 * Ejercicio 2.1.2 Desarrolla una clase en la que se puedan ejecutar dos
	 * operaciones. La primera creará un directorio que tenga por ruta:
	 * C:/directorios_y_ficheros/prueba. A continuación, y sobre el directorio
	 * prueba, creará un fichero llamado fichero_prueba.txt. La segunda operación
	 * eliminará todo rastro de la primera operación. Emplea métodos de Test para
	 * ejecutar estos dos métodos.
	 */

	public void creaFichYDir(String ruta, String fichero) {

		File dir = new File(ruta);

		if (!dir.exists()) {

			dir.mkdirs();
			System.out.println("Directorios creados " + ruta);

		} else
			System.out.println("El directorio ya existe");

		File fich = new File(dir, fichero);

		if (!fich.exists()) {

			try {
				fich.createNewFile();

				System.out.println("Fichero creado " + fich.getPath());
			} catch (IOException e) {

				e.printStackTrace();
			}

		} else
			System.out.println("Fichero ya existe!");

	}

	public void borraFichYDir(File fichero) {

		if (fichero.exists() && fichero.isFile()) {

			if (fichero.delete()) {
				System.out.println("Archivo borrado : " + fichero.getPath());

			} else {
				System.out.println("No se pudo borrar el archivo  : " + fichero.getPath());
				return;
			}
		} else {
			System.out.println("Archivo inexistente : " + fichero.getPath());
			return;
		}

		File directorioPadre = fichero.getParentFile();

		while (directorioPadre.exists() && directorioPadre != null && directorioPadre.list().length == 0) {

			if (directorioPadre.delete()) {
				System.out.println("Directorio borrado: " + directorioPadre.getPath());
			} else {
				System.out.println("No se pudo borrar el directorio : " + directorioPadre.getPath());
				break;
			}
			directorioPadre = directorioPadre.getParentFile();
		}

	}
	// Ejercicio 2.1.3

	public static void datosF(File file) {

		String nombre = file.getName();

		System.out.println("El nombre del archivo es " + nombre);

		String escribir = (file.canWrite() ? "writeable" : "no writeable");

		System.out.println("El archivo es " + escribir);

		String leer = (file.canRead() ? "legible" : "no legible");

		System.out.println("El archivo es " + leer);

		long tamanio = file.length();

		System.out.println("El tamaño es " + tamanio);

		String ruta = file.getPath();
		String rutaAbs = file.getAbsolutePath();

		System.out.println("La ruta relativa es " + ruta + " y la absoluta " + rutaAbs);

		String padre = file.getParent();

		System.out.println("el nombre del directorio padre es : " + padre);
	}
}
