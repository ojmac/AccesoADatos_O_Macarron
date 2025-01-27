package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity

@Table(name = "Coches")
public class Coche {

	@Id
	@Column(name = "matricula")
    private String matricula;
	
	@Column(name = "marca")
    private String marca;
		
	@Column (name = "modelo")
    private String modelo;
	
	@Column (name = "color")
    private String color;
	
	@Column (name = "año")
    private int anio;
	
	@Column (name = "velocidadMax")
	private double velocidadMax;

	@OneToOne()
	@JoinColumn(name ="Permiso_Circulacion",
			referencedColumnName = "numReg",
			foreignKey = @ForeignKey(name = "fk_permiso_id"))
	private PermisoCirc permiso;
	
	@OneToMany(mappedBy = "coche", cascade = CascadeType.ALL)
	private List<Reparacion> reparaciones= new ArrayList<>(); 
	
	@ManyToMany(mappedBy = "coches", cascade = CascadeType.DETACH)
	private List<Conductor> conductores = new ArrayList<>();  

	
    
    public Coche() {
       
    }

    public Coche(String matricula, String marca, String modelo, int anio, String color, double velocidadMax, PermisoCirc permiso ) {
        this.matricula = matricula;
    	this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.velocidadMax = velocidadMax;
        this.permiso = permiso;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getVelocidad() {
        return velocidadMax;
    }

    public void setVelocidad(double velocidad) {
        this.velocidadMax = velocidad;
    }

    
    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(double velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	public PermisoCirc getPermiso() {
		return permiso;
	}

	public void setPermiso(PermisoCirc permiso) {
		this.permiso = permiso;
	}

	public List<Reparacion> getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(List<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}
	public void setReparaciones1(Reparacion rep) {
		
		this.reparaciones.add(rep);
	}

	public List<Conductor> getConductores() {
		return conductores;
	}
	public void setConductor(Conductor cond) {
		
		this.conductores.add(cond);
	}

	public void setConductores(List<Conductor> conductores) {
		this.conductores = conductores;
	}

	public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Color: " + color);
        System.out.println("Velocidad: " + velocidadMax + " km/h");
        System.out.println("Permiso de ciculacion num :" + permiso);
        System.out.println("número de reparaciones:" + reparaciones.size());
    }
}

