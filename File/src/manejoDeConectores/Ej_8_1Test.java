package manejoDeConectores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Ej_8_1Test {
	
	Ej_8_1 ej = new Ej_8_1();

	@Test
	void Error1042Test() {
		boolean ok =ej.Error1042();
		Assertions.assertTrue(ok, "La conexión debería haberse establecido correctamente");
	}
	@Test
	void Error1045Test() {
		boolean ok =ej.Error1045();
		Assertions.assertTrue(ok, "Salta el error esperado");
	}
	@Test
	void Error1046Test() {
		boolean ok =ej.Error1046();
		Assertions.assertTrue(ok, "Salta el error esperado");
	}
	@Test
	void Error1109Test() {
		boolean ok =ej.Error1109();
		Assertions.assertTrue(ok, "Salta el error esperado");
	}
}
