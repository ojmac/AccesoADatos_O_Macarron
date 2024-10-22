package manejoDeFicheros;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ej_5_3_1Test {
	
	Ej_5_3_1 ej = new Ej_5_3_1();

	@Test
	void datosCoches2Test() {
		ej.datosCoches2("./coches.dat");
	}

	@Test
	void modificarXMLTest() {
		ej.modificarXML();
	}
}
