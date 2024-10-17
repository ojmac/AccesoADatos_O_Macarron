package manejoDeFicheros;

import java.io.File;

public class Ej_2_1_4 {

	/*
	 * Ejercicio 2.1.4 Sobre la clase anterior crea un método que permita, partiendo
	 * de un directorio que tengas en tu sistema de archivos con 5 o más niveles,
	 * mostrar por pantalla el tamaño de cada directorio padre. Emplea un método de
	 * Test para ejecutar el método de la clase.
	 */

	public void tamanyo(File file) {
		
		if (file == null) {
			System.out.println("El archivo es nulo");
			return;
		}
		
		if(!file.exists()) {
			System.out.println("El archivo no existe");
			return;
		}
	    if (file.isFile()) {
            long tamanyo = file.length();  
            System.out.println("El tamaño del archivo '" + file.getName() + "' es " + tamanyo + " bytes");
            
        }else if (file.isDirectory()){ 
        	long tamanyoDir = 0;
        
        	File[] archHijos = file.listFiles();
        	if(archHijos != null) {
        		for (File f : archHijos) {
        			if(f.isFile()) {
        				long tamanyoArch =f.length();
        				tamanyoDir+=tamanyoArch;
        				System.out.println("El tamaño de archivo " + f.getName() + " es " + tamanyoArch);
        			}
        		}
        	}
        	System.out.println("El tamaño del directorio '" + file.getName() + "' es " + tamanyoDir + " bytes");
        }

	    File parent = file.getParentFile();
	    if(parent != null) {
	    	tamanyo(parent);
	    }
	}

	

}
