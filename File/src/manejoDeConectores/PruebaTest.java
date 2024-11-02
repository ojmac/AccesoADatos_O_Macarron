package manejoDeConectores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebaTest {
	
	Prueba p = new Prueba();
	
	String url = "jdbc:mysql://localhost:3306/burger";
	String user = "root";
	String pswd = "";

	@Test
	void abrirConexionTest() {
		p.abrirConexion(url,user,pswd);
	}

}
