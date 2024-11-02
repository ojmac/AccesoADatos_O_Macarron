package manejoDeFicheros;

import java.io.File;
import java.io.FilenameFilter;

public class Ej_2_2_1 implements FilenameFilter{
	
	/*Ejercicio 2.2.1 Desarrolla una clase que contenga un método que muestre 
	 * por pantalla todos los directorios ubicados en la ruta raíz del proyecto 
	 * que en su nombre contengan una cadena. Esta cadena se pasará por parámetro al método. 
	 * Emplea un método de Test para ejecutar el método de la clase al que nos estamos refiriendo, 
	 * pasando por parámetro la cadena "in".*/

	String texto;

	public Ej_2_2_1(String texto) {
		super();
		this.texto = texto;
	}

	
	public boolean accept(File dir, String name){
		
		return (name.contains(texto) && dir.isDirectory());
	}
	
	public void filtro(String texto) {
		try {
		File f = new File(".");
		String[] directorios = f.list(new Ej_2_2_1("in"));
		
		if(directorios == null || directorios.length==0) {
			System.out.println("No hay archivos que mostrar con ese criterios");
		}else {
			for(String dir: directorios)
            	System.out.println(dir);
		}
		
	}catch(Exception e){
		System.out.println("error");
	}

	
	}
	
}
