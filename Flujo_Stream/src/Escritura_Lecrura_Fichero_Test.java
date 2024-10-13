import org.junit.jupiter.api.Test;

class Escritura_Lecrura_Fichero_Test {

	@Test
	void leerFicheroTest() {
		EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
		elf.leerFichero();
	}



	@Test
	void escribirFicheroTest() {
		EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
		elf.escribirFichero();
	
	}
		
	@Test
	void lecturaEscrituraFicheroAByteTest() {
		EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
		elf.lecturaEscrituraFicheroAByte();
		
		
	}
		
	@Test
	void ficheroAByteTest() {
			EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
			elf.ficheroAByte();
			
		}
	
	@Test
	void lecturaEscrituraObjetoEnFicheroTest() {
		EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
		elf.lecturaEscrituraObjetoEnFichero();
		
	}
	@Test
	public void escrituraDatoAFicheroTest(){
		EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
		elf. escrituraDatoAFichero();
	}
	public void lecturaDatoDeFicheroTest(){
		EscrituraLecturaFichero  elf = new EscrituraLecturaFichero() ;
		elf. lecturaDatoDeFichero();
	}
}
