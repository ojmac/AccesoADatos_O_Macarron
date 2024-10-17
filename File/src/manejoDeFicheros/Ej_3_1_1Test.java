package manejoDeFicheros;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class Ej_3_1_1Test {

	@Test
	void escribirCadenaTest()  {
		
		Ej_3_1_1 ej = new Ej_3_1_1();
		ej.escribirCadena("fichero.txt", "texto a ingroducir");
	}

}
