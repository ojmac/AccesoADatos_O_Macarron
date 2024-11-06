package manejoDeFicheros;

import java.io.File;

import org.junit.jupiter.api.Test;

class Ej_2_1_2Test {

	@Test
	void creaFichYDirTest() {
		Ej_2_1_2 ej = new Ej_2_1_2();
		ej.creaFichYDir("C:/directorios_y_ficheros/prueba","fichero_prueba.txt");
	}
	
	@Test
	void borraFichYDirTest() {
		Ej_2_1_2 ej = new Ej_2_1_2();
		ej.borraFichYDir( new File("C:/directorios_y_ficheros/prueba","fichero_prueba.txt"));
	}
	
	@Test
	void datosFTest() {
		Ej_2_1_2 ej = new Ej_2_1_2();
		ej.datosF(new File("C:/directorios_y_ficheros/prueba","fichero_prueba.txt"));
	}
	
}
