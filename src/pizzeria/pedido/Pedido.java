package pizzeria.pedido;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import pizzeria.persona.Cliente;
import pizzeria.producto.Producto;

public class Pedido {
	
	@SuppressWarnings("unused")
	private int id;
	private Cliente cliente;
	private LocalDate fecha;
	@SuppressWarnings("unused")
	private LocalTime horario;
	private EstadoPedido estado;
	@SuppressWarnings("unused")
	private String medioDePago;
	private List<Producto> productos = new ArrayList<>();
	
	public Pedido(int id, Cliente cliente, LocalDate fecha, LocalTime horario, String medioDePago) {
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
		this.horario = horario;
		this.estado = EstadoPedido.EN_PROCESO;
		this.medioDePago = medioDePago;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public EstadoPedido getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	public boolean estaEntregado() {
		return estado == EstadoPedido.ENTREGADO;
	}
	
	public boolean estaCancelado() {
		return estado == EstadoPedido.CANCELADO;
	}
	
	public boolean estaEnProceso() {
		return estado == EstadoPedido.EN_PROCESO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public int precio() {
		return 100;
		//return productos.stream().mapToInt(Producto::precio).sum();
	}
}
