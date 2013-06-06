package pruebasUnitarias;

import recolectorDePosiciones.RecolectorDePosicionesDeDisparo;
import colecciones.ColeccionDePosiciones;
import junit.framework.TestCase;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import disparos.MinaSubmarinaTriple;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class RecolectorDePosicionesDeDisparoTest extends TestCase {
	
	
	public void testRecolectarPosicionConDisparoDeRadioCeroEnEsquinaSuperiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('A', 1);
			DisparoConvencional disparo = new DisparoConvencional();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, disparo);
			
			assertEquals( 1 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals( posicionADisparar , coleccionDePosicionesADisparar.obtenerPosicionDeLaFila(1));		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioUnoEnEsquinaSuperiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('A', 1);
		MinaSubmarinaDoble minaDoble = new MinaSubmarinaDoble();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaDoble);
		
		assertEquals( 4 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 1)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 2)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 1)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 2)));
		

	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaSuperiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('A', 1);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 1)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 2)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 1)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 2)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 1)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 2)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 3)));
			
			
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioCeroEnEsquinaInferiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('A', 10);
		DisparoConvencional disparo = new DisparoConvencional();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, disparo);
		
		assertEquals( 1 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals( posicionADisparar , coleccionDePosicionesADisparar.obtenerPosicionDeLaFila(1));		

	}

	public void testRecolectarPosicionConDisparoDeRadioUnoEnEsquinaInferiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('A', 10);
		MinaSubmarinaDoble minaDoble = new MinaSubmarinaDoble();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaDoble);
		
		assertEquals( 4 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 10)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 9)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 10)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 9)));
		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaInferiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('A', 10);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 10)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 9)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('A', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 10)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 9)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('B', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 10)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 9)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 8)));
			
	
	}
	
	
	public void testRecolectarPosicionConDisparoDeRadioCeroEnEsquinaSuperiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('J', 1);
			DisparoConvencional disparo = new DisparoConvencional();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, disparo);
			
			assertEquals( 1 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals( posicionADisparar , coleccionDePosicionesADisparar.obtenerPosicionDeLaFila(1));		
	
	}

	public void testRecolectarPosicionConDisparoDeRadioUnoEnEsquinaSuperiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('J', 1);
		MinaSubmarinaDoble minaDoble = new MinaSubmarinaDoble();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaDoble);
		
		assertEquals( 4 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 1)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 2)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 1)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 2)));
		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaSuperiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('J', 1);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 1)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 2)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 1)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 2)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 1)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 2)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 3)));
			
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioCeroEnEsquinaInferiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('J', 10);
		DisparoConvencional disparo = new DisparoConvencional();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, disparo);
		
		assertEquals( 1 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals( posicionADisparar , coleccionDePosicionesADisparar.obtenerPosicionDeLaFila(1));		

	}

	public void testRecolectarPosicionConDisparoDeRadioUnoEnEsquinaInferiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('J', 10);
		MinaSubmarinaDoble minaDoble = new MinaSubmarinaDoble();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaDoble);
		
		assertEquals( 4 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 10)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 9)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 10)));
		assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 9)));
		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaInferiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('J', 10);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 10)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 9)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('J', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 10)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 9)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 10)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 9)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 8)));
			
	
	}
	
	
	public void testRecolectarPosicionConDisparoDeRadioCero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tablero = new Tablero(10,10);
		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
		Posicion posicionADisparar = tablero.obtenerPosicion('C', 3);
		DisparoConvencional disparo = new DisparoConvencional();
		ColeccionDePosiciones coleccionDePosicionesADisparar;
		
		coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, disparo);
		
		assertEquals( 1 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
		assertEquals( posicionADisparar , coleccionDePosicionesADisparar.obtenerPosicionDeLaFila(1));		

	}
	
	public void testRecolectarPosicionConDisparoDeRadioUno() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('H', 7);
			MinaSubmarinaDoble minaDoble = new MinaSubmarinaDoble();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaDoble);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('H', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('I', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 8)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 6)));
			
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDos() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('E', 5);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 25 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('E', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('E', 4)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('E', 5)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('E', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('E', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('D', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('D', 4)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('D', 5)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('D', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('D', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 4)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 5)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('C', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('F', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('F', 4)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('F', 5)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('F', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('F', 7)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 3)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 4)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 5)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 6)));
			assertEquals(true, coleccionDePosicionesADisparar.seEncuentraLaPosicion(tablero.obtenerPosicion('G', 7)));
		
			
			
	}

	
}
