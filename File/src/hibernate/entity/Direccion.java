package hibernate.entity;

public class Direccion {
	
	private int direccion_id;
	
	private String calle;
	
	private int num;
	
	private int cp;
	
	private String ciudad;
	
	private Usuario usuario;

	public Direccion(int direccion_id, String calle, int num, int cp, String ciudad, Usuario usuario) {
		super();
		this.direccion_id = direccion_id;
		this.calle = calle;
		this.num = num;
		this.cp = cp;
		this.ciudad = ciudad;
		this.usuario = usuario;
	}

	public int getDireccion_id() {
		return direccion_id;
	}

	public void setDireccion_id(int direccion_id) {
		this.direccion_id = direccion_id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
