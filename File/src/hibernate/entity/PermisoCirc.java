package hibernate.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity

@Table(name = "Permiso_circulacion")
public class PermisoCirc {
	
	@Id
	@Column(name = "numReg")
	private int numRegistro;
	
	
	@Column (name = "Fecha_Expedición")
	private String f_expedicion; 
	
	@Column (name = "Fecha_expiracion")
	private String f_expiracion;
	
	@OneToOne(mappedBy = "permiso")
	private Coche coche;
	
	public PermisoCirc() {
		
	}
			

	public PermisoCirc(int numRegistro, String f_expedicion, String f_expiracion, Coche coche) {
		super();
		this.numRegistro = numRegistro;
		this.f_expedicion = f_expedicion;
		this.f_expiracion = f_expiracion;
		this.coche = coche;
	}

	public int getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(int numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getF_expedicion() {
		return f_expedicion;
	}

	public void setF_expedicion(String f_expedicion) {
		this.f_expedicion = f_expedicion;
	}

	public String getF_expiracion() {
		return f_expiracion;
	}

	public void setF_expiracion(String f_expiracion) {
		this.f_expiracion = f_expiracion;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	
	
}
