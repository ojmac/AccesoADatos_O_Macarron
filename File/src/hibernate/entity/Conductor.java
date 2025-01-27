package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity

@Table(name = "Conductores")
public class Conductor {
	
	@Id
	@Column(name = "id")
	private int numCarnet;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "Años_de_Carnet")
	private int AnyosCarnet;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	@JoinTable(name="nm_coche_conductor", 
		joinColumns={@JoinColumn(name="id", foreignKey = @ForeignKey(name = "fk_conducotr_id"))}, 
		inverseJoinColumns={@JoinColumn(name="matricula", foreignKey = @ForeignKey(name = "fk_matricula_id"))})
	private List<Coche> coches = new ArrayList<>();

	public Conductor(int numCarnet, String nombre, int anyosCarnet) {
		super();
		this.numCarnet = numCarnet;
		this.nombre = nombre;
		AnyosCarnet = anyosCarnet;
	}

	public int getNumCarnet() {
		return numCarnet;
	}

	public void setNumCarnet(int numCarnet) {
		this.numCarnet = numCarnet;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnyosCarnet() {
		return AnyosCarnet;
	}

	public void setAnyosCarnet(int anyosCarnet) {
		AnyosCarnet = anyosCarnet;
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}
	public void setCoche(Coche coche) {
		
		this.coches.add(coche);
	}
	
	
}
