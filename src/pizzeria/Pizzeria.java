package pizzeria;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pizzeria.cliente.Cliente;
import pizzeria.empleado.Empleado;
import pizzeria.pedido.EstadoPedido;
import pizzeria.pedido.Pedido;
import pizzeria.producto.Producto;

public class Pizzeria {
	
	@SuppressWarnings("unused")
	private String nombre;
	@SuppressWarnings("unused")
	private String direccion;
	@SuppressWarnings("unused")
	private int telefono;
	private int dineroEnCaja;
	private Set<Empleado> empleados;
	private Set<Pedido> pedidos;
	private Set<Producto> menu;
	
	public Pizzeria(String nombre, String direccion, int telefono) { 
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dineroEnCaja = 0;
		this.empleados = new HashSet<>();
		this.pedidos = new HashSet<>();
		this.menu = new HashSet<>();
	}
	
	public int getDineroEnCaja() {
		return dineroEnCaja;
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void quitarEmpleado(Empleado empleado) {
		empleados.remove(empleado);
	}
	
	int cantidadDeEmpleados() {
		return empleados.size();
	}
	
	public void tomarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void entregarPedido(Pedido pedido) {
		pedido.setEstado(EstadoPedido.ENTREGADO);
		dineroEnCaja += pedido.precio();
	}
	
	public void cancelarPedido(Pedido pedido) {
		pedido.setEstado(EstadoPedido.CANCELADO);
		dineroEnCaja -= pedido.precio();
	}
	
	public Set<Pedido> pedidosEnEstado(EstadoPedido estado) {
	    return pedidos.stream()
	    				.filter(pedido -> pedido.getEstado() == estado)
	    				.collect(Collectors.toCollection(HashSet::new));
	}
	
	public int cantidadDePedidosElDia(LocalDate dia) {
		return pedidosElDia(dia).size();
	}
	
	private Set<Pedido> pedidosElDia(LocalDate dia) {
		return pedidos.stream()
						.filter(pedido -> pedido.getFecha().equals(dia))
						.collect(Collectors.toCollection(HashSet::new));
	}
	
	public int cantidadDePedidosTotal() {
		return pedidos.size();
	}
	
	public Set<Producto> getMenu() {
		return menu;
	}
	
	public void agregarProductoMenu(Producto producto) {
		menu.add(producto);
	}
	
	public void quitarProductoMenu(Producto producto) {
		menu.remove(producto);
	}
	
	public Set<Pedido> pedidosDelCliente(Cliente cliente) {
		return pedidos.stream()
						.filter(pedido -> pedido.getCliente().equals(cliente))
						.collect(Collectors.toCollection(HashSet::new));
	}
	
	public Map<Integer, Long> productosMasVendidos() {
		return pedidos.stream()
						.filter(pedido -> pedido.estaEntregado())
						.flatMap(pedido -> pedido.getProductos().stream())
						.collect(Collectors.groupingBy(Producto::getId, Collectors.counting()));
	}
	
}