package BBDDOO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ej_3_1_1Test {
	
	Ej_3_1_1 ej = new Ej_3_1_1();

	@Test
	void insertarObjTest() {
		ej.insertarObj();
		
	}
	@Test
	void insertarListadoTest() {
		ej.insertarListado();
		
	}
	@Test
	void obtenerObjXIdTest() {
		ej.obtenerObjXId(3);
		
	}
	
	@Test
	void  mostrarTipoTareasTest() {
		ej.mostrarTipoTareas();
		
	}
	@Test
	void  mostrarTareasTest() {
		ej.mostrarTareas();
		
	}
	@Test
	void  mostrarTareas2Test() {
		ej.mostrarTareas2();
		
	}
	

}
