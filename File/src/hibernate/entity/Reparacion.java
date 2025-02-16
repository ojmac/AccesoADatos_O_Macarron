package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "Reparaciones")
public class Reparacion {
	
	@Id
	@Column(name = "id")
	private String reparacionId;
	
	@Column(name = "detalle")
	private String descripcion;
	
	@Column (name = "precio")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "coche_reparado",
		referencedColumnName = "matricula",
	  	foreignKey = @ForeignKey(name = "fk_matricula"))
	private Coche coche;
	
	public Reparacion() {
		
	}

	public Reparacion(String reparacionId, String descripcion, double precio, Coche coche) {
		super();
		this.reparacionId = reparacionId;
		this.descripcion = descripcion;
		this.precio = precio;
		this.coche = coche;
	}

	public String getReparacionId() {
		return reparacionId;
	}

	public void setReparacionId(String reparacionId) {
		this.reparacionId = reparacionId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	
	

}
