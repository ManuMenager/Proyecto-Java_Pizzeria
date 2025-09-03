package pizzeria.producto;

public class Pizza extends Producto{

	private int precio;
	
	public Pizza(int precio) {
		this.precio = precio;
	}
	
	@Override
	public int precio() {
		return precio;
	}

}
