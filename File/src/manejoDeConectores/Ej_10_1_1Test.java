package manejoDeConectores;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class Ej_10_1_1Test {

	Ej_10_1_1 ej = new Ej_10_1_1();
	
	@Test
	void leerCsvTest() {
	ej.leerCsv("tareas.csv");
	}
	@Test
	void insertarDatosvTest () throws SQLException {
	ej.insertarDatos();
	}

}
