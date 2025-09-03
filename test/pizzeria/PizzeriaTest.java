package pizzeria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import pizzeria.cliente.Cliente;
import pizzeria.empleado.Empleado;
import pizzeria.pedido.EstadoPedido;
import pizzeria.pedido.Pedido;
import pizzeria.producto.Pizza;
import pizzeria.producto.Producto;

class PizzeriaTest {

	Pizzeria pizzeria;
	Empleado pizzero;
	Empleado encargado;
	Cliente cliente;
	Pedido pedido;
	Producto muzzarella;
	Producto napolitana;
	
	@BeforeEach
	void setUp() {
		pizzeria = new Pizzeria("La Isla", "O'higgins 999", 1130165712);
		pizzero = new Empleado();
		cliente = new Cliente();
		pedido = new Pedido(1, cliente,  LocalDate.now(), LocalTime.now(), "MercadoPago");
		muzzarella = new Pizza(12500);
		napolitana = new Pizza(14000);
	}
	
	@Test
	void testModificarEmpleados() {
		pizzeria.agregarEmpleado(pizzero);
		assertEquals(pizzeria.cantidadDeEmpleados(), 1);
		pizzeria.quitarEmpleado(encargado);
		assertEquals(pizzeria.cantidadDeEmpleados(), 1);
		pizzeria.quitarEmpleado(pizzero);
		assertEquals(pizzeria.cantidadDeEmpleados(), 0);
	}
	
	@Test
	void testPedidosYCaja() {
		
		//Tomar pedidos
		assertEquals(pizzeria.getDineroEnCaja(), 0);
		pizzeria.tomarPedido(pedido);
		assertEquals(pizzeria.cantidadDePedidosTotal(), 1);
		assertEquals(pizzeria.cantidadDePedidosElDia(LocalDate.now()), 1);
		assertEquals(pizzeria.getDineroEnCaja(), 0);
		assertEquals(pizzeria.pedidosEnEstado(EstadoPedido.EN_PROCESO), Set.of(pedido));
		
		//Entregar pedidos
		pizzeria.entregarPedido(pedido);
		assertEquals(pizzeria.pedidosEnEstado(EstadoPedido.ENTREGADO), Set.of(pedido));
		assertEquals(pizzeria.pedidosDelCliente(cliente), Set.of(pedido));
		assertEquals(pizzeria.getDineroEnCaja(), 100);
		
		//Cancelar pedidos
		pizzeria.cancelarPedido(pedido);
		assertEquals(pizzeria.pedidosEnEstado(EstadoPedido.CANCELADO), Set.of(pedido));
		assertEquals(pizzeria.pedidosDelCliente(cliente), Set.of(pedido));
		assertEquals(pizzeria.getDineroEnCaja(), 0);
	}
	
	@Test
	void testMenuYProductos() {
		
		//Modificar el menú
		pizzeria.agregarProductoMenu(muzzarella);
		pizzeria.agregarProductoMenu(napolitana);
		assertEquals(pizzeria.getMenu(), Set.of(muzzarella, napolitana));
		pizzeria.quitarProductoMenu(muzzarella);
		assertEquals(pizzeria.getMenu(), Set.of(napolitana));
		
		//Productos Más vendidos
		assertTrue(pizzeria.productosMasVendidos().isEmpty());
		// TODO: implementar test de productos luego de implementar la clase pedido y producto.
	}

}
