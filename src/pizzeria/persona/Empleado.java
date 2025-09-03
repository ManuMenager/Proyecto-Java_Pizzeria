package pizzeria.persona;

public class Empleado extends Persona {
	private int salarioPorHora;
	private int horasTrabajadas;
	
	public Empleado(int id, String nombre, int telefono, int salarioPorHora) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.salarioPorHora = salarioPorHora;
	}
	
	
}
