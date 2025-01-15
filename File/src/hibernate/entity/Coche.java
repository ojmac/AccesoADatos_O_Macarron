package hibernate.entity;

import javax.persistence.*;


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
	@Column (name = "año")
    private int anio;
	@Column (name = "color")
    private String color;
	@Column (name = "velocidad_max")
    private double velocidadMax;

    
    public Coche() {
       
    }

    public Coche(String matricula, String marca, String modelo, int anio, String color, double velocidadMax) {
        this.matricula = matricula;
    	this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.velocidadMax = velocidadMax;
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

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Color: " + color);
        System.out.println("Velocidad: " + velocidadMax + " km/h");
    }
}

