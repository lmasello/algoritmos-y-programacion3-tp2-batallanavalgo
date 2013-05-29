package pruebasDeEstructurasDeColecciones;

import junit.framework.TestCase;
import colecciones.ColeccionDeNaves;
import nave.*;

public class ColeccionDeNavesTest extends TestCase {
	

	public void testInicializadorDeColeccion() {

		ColeccionDeNaves coleccionDeNave = new ColeccionDeNaves();

		assertNotNull(coleccionDeNave);
	}
	
	public void testAgregaUnaNave() {

		ColeccionDeNaves coleccionDeNave = new ColeccionDeNaves();

		assertEquals(0, coleccionDeNave.cantidadDeNaves());

		Lancha naveAAgregar = new Lancha();

		coleccionDeNave.agregarNave(naveAAgregar);

		assertEquals(1, coleccionDeNave.cantidadDeNaves() );

	}
	
	public void testObtenerUnaNave() {

		ColeccionDeNaves coleccionDeNave = new ColeccionDeNaves();

		Lancha naveAAgregar1 = new Lancha();
		Buque naveAAgregar2 = new Buque();
		
		coleccionDeNave.agregarNave(naveAAgregar1);
		coleccionDeNave.agregarNave(naveAAgregar2);

		assertEquals(naveAAgregar1,coleccionDeNave.obtenerNave(1) );
		assertEquals(naveAAgregar2,coleccionDeNave.obtenerNave(2) );

	}
	
	

}
