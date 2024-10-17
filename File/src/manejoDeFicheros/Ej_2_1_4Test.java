package manejoDeFicheros;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class Ej_2_1_4Test {

	@Test
	void tamanyoTest() {
		Ej_2_1_4 ej = new Ej_2_1_4();
		ej.tamanyo(new File("C:/Program Files/Odoo/sessions/sessions/7f/7f24c214d3d981ef0ae4cd13ce55ba4f057eef68"));
	}

}
