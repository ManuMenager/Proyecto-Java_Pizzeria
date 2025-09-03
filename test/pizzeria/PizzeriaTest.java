package pizzeria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pizzeria.empleado.Empleado;

class PizzeriaTest {

	Pizzeria laIsla;
	Empleado porty;
	Empleado jorge;
	
	@BeforeEach
	void setUp() {
		laIsla = new Pizzeria("La Isla", "O'higgins 999", 1130165712);
		porty = new Empleado();
	}
	
	@Test
	void testModificarEmpleados() {
		laIsla.agregarEmpleado(porty);
		assertEquals(laIsla.cantidadDeEmpleados(), 1);
		laIsla.quitarEmpleado(jorge);
		assertEquals(laIsla.cantidadDeEmpleados(), 1);
		laIsla.quitarEmpleado(porty);
		assertEquals(laIsla.cantidadDeEmpleados(), 0);
	}

}
