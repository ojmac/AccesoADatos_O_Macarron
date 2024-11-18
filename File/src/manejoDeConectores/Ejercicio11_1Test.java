package manejoDeConectores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio11_1Test {
	
	Ejercicio11_1 ej = new Ejercicio11_1();
	
	int [] ids = {1,3,5,7};
	int finalizada = 0; // es false

	@Test
	void listaTareasTest() {
		
		ej.listaTareas(ids, 0);
	}

}
