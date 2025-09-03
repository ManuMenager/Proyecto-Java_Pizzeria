package pizzeria.pedido;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import pizzeria.cliente.Cliente;
import pizzeria.producto.Producto;

public class Pedido {
	
	@SuppressWarnings("unused")
	private int id;
	private Cliente cliente;
	private LocalDate fecha;
	@SuppressWarnings("unused")
	private LocalTime horario;
	private String estado;
	@SuppressWarnings("unused")
	private String medioDePago;
	private List<Producto> productos = new ArrayList<>();
	
	public Pedido(int id, Cliente cliente, LocalDate fecha, LocalTime horario, String medioDePago) {
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
		this.horario = horario;
		this.estado = "En Proceso";
		this.medioDePago = medioDePago;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public boolean estaEntregado() {
		return getEstado() == "Entregado";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public int precio() {
		return productos.stream().mapToInt(Producto::precio).sum();
	}
}
