package manejoDeFicheros;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ej_3_2_1Test {
	
	Ej_3_2_1 ej = new Ej_3_2_1();

	@Test
	void guardaCochesTest() {
		
		String[] marcas = {"Mercedes","Maserati","BMW"};
		String[] matriculas = {"A1111","B2222","C3333"};
		int[] anyosMatriculacion = {2020,2022,2023};
		
		ej.guardaCoches(marcas, matriculas, anyosMatriculacion);
	
		
	}
	@Test
	void datosCochesTest() {
		
		String nomArch = "./coches.obj";
		
		ej.datosCoches(nomArch);
		
	}
}
