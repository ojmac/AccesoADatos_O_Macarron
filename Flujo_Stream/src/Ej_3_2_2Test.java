import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ej_3_2_2Test {
	
	Ej_3_2_2 ej = new Ej_3_2_2();

	@Test
	void guardaCoches2Test() {
		
		ej.guardaCoches2("Mercedes", "A1111", 2020);
		ej.guardaCoches2("Maserati", "B2222", 2022);
		ej.guardaCoches2("BMW", "C3333", 2023);
		
	}
	@Test
	void datosCoches2Test() {
		
		ej.datosCoches2("A1111");
		ej.datosCoches2("B2222");
		ej.datosCoches2("C3333");
	}
}
