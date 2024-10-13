import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EscrituraLecturaFichero {

	public void leerFichero() {
		
		try {
			
			FileReader fr = new FileReader("c:/directorios_y_ficheros/prueba/fichero.txt");
			
			int c =0;
		while(c !=-1) {
			
			c =fr.read();
			if(c!=-1)
			System.out.println((char)c);
			
		}
		fr.close();
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
	public void escribirFichero() {
		
		try {
			FileWriter fw = new FileWriter("c:/directorios_y_ficheros/prueba/fichero.txt",true);
			String cadena = System.lineSeparator()+ "Voy a escribir en mi fichero";
			fw.write(cadena);
			
			fw.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
	}
	//buferedreader y bufferedwriter
	
	public void lecturaFicheroABuffer () {
		
		try {
			FileReader fr = new FileReader ("./fichero.txt");
			BufferedReader bf = new BufferedReader(fr);
			String linea = "";
			
			while (linea != null) {
				
				linea = bf.readLine();
				if(linea!=null)
				System.out.println(linea);
			}
			fr.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void LeeryEscribirAFicheroConBuffer() {
		
		try {
			FileReader fr = new FileReader ("./fichero.txt");
			BufferedReader bf = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("./ficheroSalida.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			String linea = "";
			
			while(linea!=null) {
				linea = bf.readLine();
				if(linea!=null) {
					bw.write(linea); //bw.write(linea + System.lineSeparator()); tb retorno de carro
					bw.newLine(); //mete un retorno de carro
					System.out.println(linea);
					
					
				}
				
			}
			bf.close();
			bw.close();
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		
		
	}
	
// FileInputStream FileOutStream
	
	public void ficheroAByte() {
		
		try {
			byte[] buffer = new byte[2048];
			FileInputStream fio = new FileInputStream("./flecha.png");
			long cantBytes = 0;
			while(cantBytes != -1) {
				
				cantBytes = fio.read(buffer);
				System.out.println(cantBytes);
				
			}
			
		}catch(IOException e){
			
			e.printStackTrace();
		}
	}
	public void lecturaEscrituraFicheroAByte() {
		
		try {
			byte[] buffer = new byte[2048];
			
			FileInputStream fis = new FileInputStream("./flecha.png");
			FileOutputStream fos = new FileOutputStream ("./flechabis.png");
			long cantBytes = 0;
			while(cantBytes != -1) {
				
				cantBytes = fis.read(buffer);
				
				if(cantBytes != -1) {
					fos.write(buffer);
				}
				System.out.println(cantBytes);
				
			}
			fis.close();
			fos.close();
		}catch(IOException e){
			
			e.printStackTrace();
		}
	}
	
	//object inputStream
	
	public void lecturaEscrituraObjetoEnFichero() {
		
		try{
			Persona p = new Persona(36, "María");
			FileOutputStream fos = new FileOutputStream("./persona.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			oos.close();
			fos.close();
		}catch(IOException e){
				
		}	
	}
	
	public void recuperarObjetoDeFichero() {
		
		try{
			Persona p = new Persona(36, "María");
			FileOutputStream fos = new FileOutputStream("./persona.obj");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			FileInputStream fis = new FileInputStream("./persona.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			oos.writeObject(p);
			Persona p2 = (Persona) ois.readObject();
			oos.close();
			ois.close();
			
		}catch(IOException e){
				
		}catch(ClassNotFoundException nfe) {
			
		}
	}
	
	public void escrituraDatoAFichero(){
		
		try {
			FileOutputStream fos = new FileOutputStream("./informacion.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("Esta es la cadena del fichero");
			int valInt = Integer.MAX_VALUE;
			dos.writeInt(valInt);
			long valoLong = Long.MAX_VALUE;
			dos.writeLong(valoLong);
			
		}catch(IOException e){
			
		}
	}
	public void lecturaDatoDeFichero(){
		
		try {
			FileInputStream fis = new FileInputStream("./informacion.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			
			System.out.println(dis.readUTF());
			System.out.println(dis.readInt());
			System.out.println(dis.readLong());
		
			
		}catch(IOException e){
			
		}
	}
}
