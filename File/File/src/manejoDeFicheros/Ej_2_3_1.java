package manejoDeFicheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author OscarM
 * @version v1.0
 * @since 3/10/2024
 * @see java.io.File Clase que permite la creación de directorios y archivos de
 *      texto, además de modificar archivos.
 */

public class Ej_2_3_1 {

	/*
	 * Ejercicio 2.3.1 Desarrolla una clase que se componga de cuatro métodos: El
	 * primer método permitirá crear un nuevo directorio cuyo nombre se pasará por
	 * parámetro. El segundo método permitirá crear un fichero con extensión .txt y
	 * necesitará de dos parámetros. Un primer parámetro informará del nombre del
	 * directorio y un segundo parámetro informará del nombre del fichero. La
	 * función retornará un objeto de tipo File en caso de que el fichero se haya
	 * creado correctamente y un valor null en caso contrario. El tercer método
	 * permitirá crear un fichero con extensión .txt a partir del directorio padre y
	 * también necesitará de dos parámetros. Un primer parámetro informará de un
	 * objeto de tipo File para identificar el directorio padre, y un segundo
	 * parámetro informará del nombre del fichero. La función retornará un objeto de
	 * tipo File en caso de que el fichero se haya creado correctamente y un valor
	 * null en caso contrario. El cuarto método permitirá modificar el nombre de un
	 * fichero. Necesitará de tres parámetros. El primer parámetro informará de un
	 * objeto de tipo File para identificar el fichero cuyo nombre se quiere
	 * modificar. El segundo parámetro informará de la carpeta del nuevo fichero. El
	 * tercer parámetro informará del nombre del nuevo fichero.
	 */

	/**
	 * <b>Este metodo crea un directorio dandole un nombre por parametro</b> <br>
	 * 
	 * @param nomDir nombre del directorio
	 * @return un objeto File que representa el directorio creado
	 */
	public File newDir(String nomDir) {

		File directorio = new File(nomDir);

		if (!directorio.exists()) {

			boolean dirCreado = directorio.mkdir();

			if (dirCreado)
				System.out.println("Directorio " + nomDir + " creado");
			else
				System.out.println("No se pudo crear el directorio " + nomDir);
		} else
			System.out.println("El directorio ya existe!");

		return directorio;
	}

	/**
	 * Crea un nuevo archivo en el directorio especificado.
	 *
	 * Este método intenta crear un nuevo archivo dentro de un directorio dado. Si
	 * el archivo ya existe o el directorio no es válido, puede lanzar una
	 * excepción.
	 *
	 * @param nomDir  El nombre del directorio donde se creará el archivo.
	 * @param nomFich El nombre del archivo que se creará.
	 * @return Un objeto {@link File} que representa el archivo creado.
	 * @throws IOException Si ocurre un error al intentar crear el archivo, como si
	 *                     el directorio no existe o no se puede escribir en él.
	 */
	public File newFich(String nomDir, String nomFich) throws IOException {

		File directorio = new File(nomDir);
		File fichero = null;

		if (directorio.exists() && directorio.isDirectory()) {

			fichero = new File(directorio, nomFich);

			if (fichero.exists()) {

				System.out.println("El archivo " + nomFich + " ya existe en el directorio " + nomDir);

			} else {

				boolean creado = fichero.createNewFile();

				if (creado) {
					System.out.println("Archivo creado correctamente");
				} else {
					System.out.println("El archivo no pudo ser creado.");
				}
			}

		} else {
			System.out.println("El directorio " + nomDir + " no existe o no es un directorio.");
			fichero = null;
		}
		return fichero;
	}

	/**
	 * Crea un nuevo archivo dentro de un directorio dado por un objeto
	 * {@link File}.
	 *
	 * Este método toma un objeto {@link File} que representa un directorio y crea
	 * un nuevo archivo con el nombre especificado dentro de ese directorio. Si el
	 * archivo ya existe o hay algún problema al escribir en el directorio, puede
	 * lanzar una excepción.
	 * 
	 * @param file    Un objeto {@link File} que representa el directorio en el que
	 *                se creará el archivo.
	 * @param nomFich El nombre del archivo que se creará dentro del directorio.
	 * @return Un objeto {@link File} que representa el archivo creado.
	 * @throws IOException Si ocurre un error al crear el archivo, como si el
	 *                     directorio no es válido o no se puede escribir en él.
	 */
	public File newFich2(File file, String nomFich) throws Ej_2_3_1NoEsDirectorioException, IOException {

		

		if (file.exists() && file.isDirectory()) {

			File fichero = new File(file, nomFich);

			if (fichero.exists()) {

				System.out.println("El archivo " + nomFich + " ya existe en el directorio " + file.getName());
				return fichero;
				
			} else {

				boolean creado = fichero.createNewFile();
				if (creado) {

					System.out.println("Archivo creado correctamente");
			
				}
				return fichero;
			}

		} else {
			throw new Ej_2_3_1NoEsDirectorioException(
					"El directorio " + file.getName() + " no existe o no es un directorio.");
			
		}
		
	}

	/**
	 * Modifica un archivo existente moviéndolo a un nuevo directorio o cambiando su
	 * nombre.
	 *
	 * Este método toma un archivo existente representado por el objeto {@link File}
	 * y lo mueve a un nuevo directorio. También permite cambiar el nombre del
	 * archivo si es necesario. Si el archivo no puede ser movido o renombrado, se
	 * lanza una excepción.
	 *
	 * @param file        El archivo que se desea modificar.
	 * @param nomNuevoDir El nombre del nuevo directorio al que se moverá el
	 *                    archivo.
	 * @param nomFich     El nuevo nombre para el archivo. Si se mantiene el nombre
	 *                    actual, el archivo solo será movido.
	 * @throws IOException Si ocurre un error al mover o renombrar el archivo, como
	 *                     si el directorio destino no existe o no se puede escribir
	 *                     en él.
	 */
	public void modificarFich(File file, String nomNuevoDir, String nomFich) throws IOException, Ej_2_3_1NoEsArchivoException, Ej_2_3_1NoEsDirectorioException {

		Scanner sct = new Scanner(System.in);

		if (file.exists() && file.isFile()) {

			File dirDestino = new File("nomNuevoDIr");

			if (!dirDestino.exists() || !dirDestino.isDirectory()) {

				System.out.println("La carpeta de destino no existe o no es un directorio.");
				System.out.println("Quiere crear el directorio? (s/n)");
				String resp = sct.nextLine();
				boolean crearDir = (resp.equalsIgnoreCase("s"));

				if (crearDir) {

					dirDestino = this.newDir(nomNuevoDir);

					File obj = this.newFich2(dirDestino, nomFich);

					file.renameTo(obj);
					System.out.println("Directorio creado");

				} else {
					System.out.println("El directorio destino no existe ");
				}

			}

		}else {
			throw new Ej_2_3_1NoEsArchivoException("El objeto proporcionado no es un archivo.");
		}

	}

	/**
	 * Renombra un archivo existente al nombre original especificado.
	 *
	 * Este método toma un archivo existente y lo renombra con el nuevo nombre
	 * especificado. Si el archivo no se puede renombrar, se lanzará una excepción.
	 *
	 * @param file    El archivo que se desea renombrar.
	 * @param nomDest El nuevo nombre del archivo que se usará como destino.
	 * @param nomOrig El nombre original del archivo que se usará en la operación.
	 */
	public void renomFichero(File file, String nomDest, String nomOrig) {

		File pp = new File(file, nomOrig);

		File pk = new File(file, nomDest);

		boolean ok = pp.renameTo(pk);

		System.out.println(ok);

	}

}
