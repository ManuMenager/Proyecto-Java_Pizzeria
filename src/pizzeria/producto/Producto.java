package pizzeria.producto;

public abstract class Producto {

	private int id;
	
	public int getId() {
		return id;
	}
	
	public abstract int precio();

}
