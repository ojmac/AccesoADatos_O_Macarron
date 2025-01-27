package hibernate.entity;

import javax.persistence.*;

@Entity

@Table(name = "Usuarios")
public class Usuario {
	
	@Id
	@Column(name = "DNI")
	private String DNI;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "edad")
	private int edad;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direccion_id",
		referencedColumnName = "id",
		foreignKey = @ForeignKey(name = "fk_direccion_id"))
	private Direccion direcion;
	
	@OneToMany (mappedBy = "usario", cascade = CascadeType.ALL)
	private Coche coche;
	
	
	public Usuario(String dNI, String nombre, int edad, Direccion direcion, Coche coche) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.edad = edad;
		this.direcion = direcion;
		this.coche = coche;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public Direccion getDirecion() {
		return direcion;
	}


	public void setDirecion(Direccion direcion) {
		this.direcion = direcion;
	}


	public Coche getCoche() {
		return coche;
	}


	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	
	
	
	
	
	
	

}
