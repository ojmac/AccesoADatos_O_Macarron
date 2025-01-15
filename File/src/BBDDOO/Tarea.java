package BBDDOO;

public class Tarea {

	private int id;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private boolean finalizada;
	private TipoTarea tipoTarea;

	public Tarea(int id, String descripcion, String fechaInicio, String fechaFin, boolean finalizada,
			TipoTarea tipoTarea) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.finalizada = finalizada;
		this.tipoTarea = tipoTarea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

	public TipoTarea getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(TipoTarea tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", finalizada=" + finalizada + ", tipoTarea=" + tipoTarea + "]";
	}
	
	public int obtenerIdTipoTarea() {
		
		int id = this.tipoTarea.getId();
		
		return id;
		
	}

}
