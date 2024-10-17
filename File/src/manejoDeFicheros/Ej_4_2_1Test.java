package manejoDeFicheros;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class Ej_4_2_1Test {
	
	Ej_4_2_1 ej = new Ej_4_2_1();

	
	@Test
	@Order(1)
	void escrbAleaTest() {
		
		String[] nombres= {"María", "Alberto", "Pepa"};
		String[] ids= {"11111111A", "22222222B", "33333333C"};
		int[] edades= {37, 40, 44};
		
		ej.escrbAlea(nombres, ids, edades);
		
		
	}

	@Test
	@Order(2)
	void leerAleaTest() {
		
		String file = "./miBase.dat";
		
		ej.leerAlea(file);
		
}
}