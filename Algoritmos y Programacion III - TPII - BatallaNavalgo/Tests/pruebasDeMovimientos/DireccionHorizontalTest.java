package pruebasDeMovimientos;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import movimientos.Derecha;
import movimientos.Direccion;
import movimientos.DireccionHorizontal;
import movimientos.Izquierda;
import movimientos.SentidoHorizontal;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class DireccionHorizontalTest extends TestCase{

	public void testObtenerLaPosicionHorizontalSiguienteAUnaPosicioDelMedionDeUnTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroParaConocerDireccion = Tablero.getInstance();
		Posicion posicionAConocerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('D', 4);
		Direccion direccionDeUnaNave = new DireccionHorizontal();
		
		Posicion posicionSiguiente = direccionDeUnaNave.desplazarPosicion(posicionAConocerLaSiguiente);
		
		Posicion posicionQueDeberiaSerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('E', 4);
		
		assertEquals(posicionQueDeberiaSerLaSiguiente , posicionSiguiente);
		
		Tablero.deleteInstance();
	}	
	
	public void testCambiaLaDireccionHorizontal() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Direccion direccionDeUnaNave = new DireccionHorizontal();

		direccionDeUnaNave.cambiarSentido();
		
		assertEquals(new Izquierda() , direccionDeUnaNave.sentidoDeLaDireccion());
	}
	
	public void testProximaPosicionAlLlegarAlFinalDelTableroEnDireccionHorizontal() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroParaConocerDireccion = Tablero.getInstance();
		Posicion posicionAConocerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('J', 4);
		
		Direccion direccionDeUnaNave = new DireccionHorizontal();
		
		Posicion posicionSiguiente = direccionDeUnaNave.desplazarPosicion(posicionAConocerLaSiguiente);
		
		Posicion posicionQueDeberiaSerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('I', 4);
		
		assertEquals(posicionQueDeberiaSerLaSiguiente , posicionSiguiente);
	
		Tablero.deleteInstance();
	}
	
}
