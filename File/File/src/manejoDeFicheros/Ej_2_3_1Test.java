package manejoDeFicheros;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Ej_2_3_1Test {
	
	Ej_2_3_1 ej = new Ej_2_3_1();

	@Test
	void newDirTest() {
		File nn =ej.newDir("recursos111");
		System.out.println(nn.getName());
	}
	@Test
	void newFichTest()throws IOException  {
		
		Ej_2_3_1NoEsArchivoException nn = new Ej_2_3_1NoEsArchivoException("Error");
		try {
			throw new IOException();
		} catch (IOException e) {
			 e.getMessage();
		}
		
		ej.newFich("recursos111", "Pl");
		
	}
	@Test
	void newFich2Test() {
		
		File rec = ej.newDir("recursos111/fichero.txt");

		try {
			
			ej.newFich2(rec, "pp.txt");
			
		}catch (Ej_2_3_1NoEsDirectorioException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	void modificarFichTest() {
		
		try {
			File rec = ej.newDir("recursos111/fichero.txt");
			rec.createNewFile(); 
			
			File pp = ej.newFich2(rec, "pp.txt");
			
			ej.modificarFich(rec, "nDir", "pk.txt");;
		} catch (Ej_2_3_1NoEsDirectorioException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (Ej_2_3_1NoEsArchivoException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
	@Test
	void renomFicheroTest()throws IOException {
		
		File rec = ej.newDir("recursos111");
		String pp = "pp";
		String pk = "pk";
		
		ej.renomFichero(rec, pp, pk);
		
	}

}
