package manejoDeConectores;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class LogicaBdTest {
	
	String fechaInicial = "2024-10-16";
	String fechaFinal = "2025-03-01";
	boolean finalizada = true;
	int[] ids = {6,7,8};
	File file = new File("bd.config");
	
	LogicaBd lbd =new LogicaBd();
	

	@Test
	void creaTablaTest() {
		lbd.creaTabla();
	}
	@Test
	void insertaDatosTest() {
		lbd.insertaDatos();
	}
	@Test
	void modificaCamposTest() {
		lbd.modificaCampo(ids, finalizada);
	}
	@Test
	void muestraDatosTest() {
		lbd.muestraDatos(fechaInicial, fechaFinal);
	}

}
