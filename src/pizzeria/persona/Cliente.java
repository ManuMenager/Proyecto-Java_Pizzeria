package pizzeria.persona;

public class Cliente extends Persona {
	private String direccion;
	
	public Cliente(int id, String nombre, String direccion, int telefono) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}