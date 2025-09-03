package pizzeria.persona;

public class Persona {
	protected int id;
	protected String nombre;
	protected int telefono;
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
