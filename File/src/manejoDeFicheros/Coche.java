package manejoDeFicheros;
import java.io.Serializable;

public class Coche implements Serializable{
	
	String marca;
	String matricula;
	int anyoMatriculacion;
	
	public Coche(String marca, String matricula, int anyoMatriculacion) {
		super();
		this.marca = marca;
		this.matricula = matricula;
		this.anyoMatriculacion = anyoMatriculacion;
	}
	public Coche() {
		
	};

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAnyoMatriculacion() {
		return anyoMatriculacion;
	}

	public void setAnyoMatriculacion(int añoMatriculacion) {
		this.anyoMatriculacion = añoMatriculacion;
	}
	

	
}
