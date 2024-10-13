import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ej_3_2_1Test {
	
	Ej_3_2_1 ej = new Ej_3_2_1();

	@Test
	void guardaCochesTest() {
		
		ej.guardaCoches("Mercedes", "A1111", 2020);
		ej.guardaCoches("Maserati", "B2222", 2022);
		ej.guardaCoches("BMW", "C3333", 2023);
		
	}
	@Test
	void datosCochesTest() {
		
		String[] coches = {"./A1111.obj","./B2222.obj","./C3333.obj"};
		
		ej.datosCoches(coches);
		
	}
}
