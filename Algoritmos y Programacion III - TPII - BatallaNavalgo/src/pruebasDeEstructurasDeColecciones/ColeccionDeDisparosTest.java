package pruebasDeEstructurasDeColecciones;

import colecciones.ColeccionDeDisparos;
import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import disparos.MinaSubmarinaTriple;
import junit.framework.TestCase;

public class ColeccionDeDisparosTest extends TestCase{
	
	public void testCrearDeColeccion() {

		ColeccionDeDisparos coleccionDeDisparos = new ColeccionDeDisparos();

		assertNotNull(coleccionDeDisparos);
	}
	
	public void testAgregarDisparos(){
		
		ColeccionDeDisparos coleccionDeDisparos = new ColeccionDeDisparos();
		Disparo disparoUno = new DisparoConvencional();
		Disparo disparoDos = new MinaSubmarinaDoble();
		
		assertEquals( false, coleccionDeDisparos.noEstaVacia());
		
		coleccionDeDisparos.agregarDisparo(disparoUno);
		coleccionDeDisparos.agregarDisparo(disparoDos);
		
		assertEquals( true, coleccionDeDisparos.noEstaVacia());
		assertEquals( 2, coleccionDeDisparos.cantidadDeDisparos());
		
	}
	
	public void testObtenerDisparos(){
		
		ColeccionDeDisparos coleccionDeDisparos = new ColeccionDeDisparos();
		Disparo disparoUno = new DisparoConvencional();
		Disparo disparoDos = new MinaSubmarinaTriple();
		
		coleccionDeDisparos.agregarDisparo(disparoUno);
		coleccionDeDisparos.agregarDisparo(disparoDos);
		
		assertEquals( disparoUno, coleccionDeDisparos.obtenerDisparoDeIndice(0));
		assertEquals( disparoDos, coleccionDeDisparos.obtenerDisparoDeIndice(1));
		
	}
	
	public void testQuitarDisparo(){
		
		ColeccionDeDisparos coleccionDeDisparos = new ColeccionDeDisparos();
		Disparo disparoUno = new DisparoConvencional();
		Disparo disparoDos = new MinaSubmarinaTriple();
		
		coleccionDeDisparos.agregarDisparo(disparoUno);
		coleccionDeDisparos.agregarDisparo(disparoDos);
		
		coleccionDeDisparos.quitarDisparo(disparoUno);
		
		assertEquals( true, coleccionDeDisparos.noEstaVacia());
		assertEquals( 1, coleccionDeDisparos.cantidadDeDisparos());
		
		coleccionDeDisparos.quitarDisparo(disparoDos);
		
		assertEquals( false, coleccionDeDisparos.noEstaVacia());
		
		
	}
	
	

}
