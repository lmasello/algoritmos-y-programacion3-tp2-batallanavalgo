package pruebasUnitarias;

import colecciones.ColeccionDePosiciones;
import junit.framework.TestCase;
import componentesDeTablero.Posicion;
import componentesDeTablero.RecolectorDePosicionesDeDisparo;
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
		

	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaSuperiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('A', 1);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			
	
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
		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaInferiorIzquierda() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('A', 10);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			
	
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
		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaSuperiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('J', 1);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			
	
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
		
	
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDosEnEsquinaInferiorDerecha() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('J', 10);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 9 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			
	
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
			
	}
	
	public void testRecolectarPosicionConDisparoDeRadioDos() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
			Tablero tablero = new Tablero(10,10);
			RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tablero);
			Posicion posicionADisparar = tablero.obtenerPosicion('E', 5);
			MinaSubmarinaTriple minaTriple = new MinaSubmarinaTriple();
			ColeccionDePosiciones coleccionDePosicionesADisparar;
			
			coleccionDePosicionesADisparar = recolector.obtenerPosicionesDeDisparo(posicionADisparar, minaTriple);
			
			assertEquals( 25 , coleccionDePosicionesADisparar.cantidadDePosiciones() );
			
	}

	
}
