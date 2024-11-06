package manejoDeFicheros;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ej_4_1_1Test {
	
	Ej_4_1_1 ej = new Ej_4_1_1();
	

	@Test
	void guardaCoches2Test() {
		
		String[] marcas = {"Mercedes","Maserati","BMW"};
		String[] matriculas = {"A1111","B2222","C3333"};
		int[] anyosMatriculacion = {2020,2022,2023};
		
		ej.guardaCoches2(marcas, matriculas, anyosMatriculacion);
		
	}

	@Test
	void datosCoches2Test() {
		
		String nomArch = "./coches.obj";
		String matricula= "B2222";
		
		ej.datosCoches2(nomArch, matricula);
		
	}
	

}
