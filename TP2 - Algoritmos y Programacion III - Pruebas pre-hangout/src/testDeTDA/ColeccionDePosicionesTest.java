package testDeTDA;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import tablero.Columna;
import tablero.Posicion;
import tiposDeDatosAbstractos.ColeccionDeColumnas;
import tiposDeDatosAbstractos.ColeccionDePosiciones;

public class ColeccionDePosicionesTest extends TestCase{

	public void testInicializadorDeColeccion(){
		
		ColeccionDePosiciones unaColeccion = new ColeccionDePosiciones();
		
		assertNotNull(unaColeccion);		
	}
	
	public void testAgregaUnaPosicion(){
		
		ColeccionDePosiciones unaColeccion = new ColeccionDePosiciones();
		
		assertEquals(0 , unaColeccion.cantidadDePosiciones());
		
		Posicion posicionAAgregar = new Posicion();
		
		unaColeccion.agregarPosicion(posicionAAgregar);
		
		assertEquals(1 , unaColeccion.cantidadDePosiciones());
		
	}

	public void testEvaluaSiTieneUnaPosicion(){
		
		ColeccionDePosiciones unaColeccion = new ColeccionDePosiciones();
		Posicion posicionAAgregar = new Posicion();
		
		unaColeccion.agregarPosicion(posicionAAgregar);
		
		assertEquals(true , unaColeccion.tieneLaPosicion(1));
		
	}
	
	public void testEvaluaSiTieneUnaPosicionCasoNegativo(){
		
		ColeccionDePosiciones unaColeccion = new ColeccionDePosiciones();
		Posicion posicionAAgregar = new Posicion();
		
		unaColeccion.agregarPosicion(posicionAAgregar);
		
		assertEquals(false , unaColeccion.tieneLaPosicion(2));
		
	}	

	public void testObtenerUnaPosicion(){
		
		ColeccionDePosiciones unaColeccion = new ColeccionDePosiciones();
		Posicion posicion1 = new Posicion();
		Posicion posicion2 = new Posicion();
		
		unaColeccion.agregarPosicion(posicion1);
		unaColeccion.agregarPosicion(posicion2);
		
		assertEquals(posicion1 , unaColeccion.obtenerPosicionDeLaFila(1));
		assertEquals(posicion2 , unaColeccion.obtenerPosicionDeLaFila(2));
		
		
	}

}
