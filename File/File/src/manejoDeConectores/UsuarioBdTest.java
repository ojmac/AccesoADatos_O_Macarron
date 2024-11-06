package manejoDeConectores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioBdTest {
	
	UsuarioBd usuario1 = new UsuarioBd();
	String url = "jdbc:mysql://localhost:3306/ejercicios";
	String pswd = "";
	String usuario = "root";
	String sentenciaSQL = "CREATE TABLE arbol ( \n" + "id INTEGER NOT NULL, \n" + "nombre VARCHAR(100) NOT NULL, \n"
			+ "variedad VARCHAR(100) NOT NULL, \n" + "CONSTRAINT pk_usuario PRIMARY KEY (id));";

	@Test
	void crearTablaTest() {
		
		usuario1.crearTabla(url, usuario, pswd, sentenciaSQL);
	
	}


	
}
