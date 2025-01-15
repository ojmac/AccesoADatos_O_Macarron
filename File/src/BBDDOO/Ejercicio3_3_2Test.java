package BBDDOO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ejercicio3_3_2Test {
	
	Ejercicio3_3_2 ej = new Ejercicio3_3_2();
	
	TipoTarea tt2 = new TipoTarea(2, "comp", "hacer compras");
	
	Tarea t1 = new Tarea(1, "Comprar manzanas", "2024-02-15", "2024-02-16", true, tt2);
	
	Tarea t13 = new Tarea(13, "Comprar manzanas", "2024-02-15", "2024-02-16", true, new TipoTarea(2, "comp", "hacer compras"));

	Tarea t14 = new Tarea(14, "Vuelo lunar", "2024-02-15", "2024-02-16", true, new TipoTarea(6, "volar", "volar a la luna"));

	@Test
	void  insertarVerificandoClasesTest() {
		
		ej.insertarVerificandoClases(t1);
		
	}
	@Test
	void  insertarVerificandoClasesTest1() {
		
		ej.insertarVerificandoClases(t13);
		
	}
	@Test
	void  insertarVerificandoClasesTest2() {
		
		ej.insertarVerificandoClases(t14);
		
	}

}
