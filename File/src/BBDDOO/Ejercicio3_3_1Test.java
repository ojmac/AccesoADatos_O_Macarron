package BBDDOO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio3_3_1Test {
	
	Ejercicio3_3_1 ej = new Ejercicio3_3_1();
	private TipoTarea tt3 = new TipoTarea(3, "est", "estudios");

	@Test
	void mostrarTareasXTTTest() {
		ej.mostrarTareasXTT(tt3);
		
	}
	
	@Test
	void mostrarTareasXCadEnDescripTest() {
		ej.mostrarTareasXCadEnDescrip("co");
		
	}
	
	@Test
	void mostrarTareasEntreDosFechasIncTest() {
		ej.mostrarTareasEntreDosFechasInc("2024-05-02", "2024-10-30");;
		
	}
	@Test
	void mostrarTareasEntreDosFechasExcTest() {
		ej.mostrarTareasEntreDosFechasExc("2024-05-02", "2024-10-30");;
		
	}

}
