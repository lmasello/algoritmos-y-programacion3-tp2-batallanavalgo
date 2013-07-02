package pruebasDeMovimientos;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import movimientos.Abajo;
import movimientos.Arriba;
import movimientos.Direccion;
import movimientos.DireccionVertical;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class DireccionVerticalTest extends TestCase{

	public void testObtenerLaPosicionVerticalSiguienteAUnaPosicionDeUnTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroParaConocerDireccion = Tablero.getInstance();
		Posicion posicionAConocerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('D', 4);
		
		Direccion direccionDeUnaNave = new DireccionVertical();		
		Posicion posicionSiguiente = direccionDeUnaNave.desplazarPosicion(posicionAConocerLaSiguiente);
		
		Posicion posicionQueDeberiaSerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('D', 3);
		
		assertEquals(posicionQueDeberiaSerLaSiguiente , posicionSiguiente);
		
		Tablero.deleteInstance();
	}

	public void testCambiaLaDireccionVertical() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Direccion direccionDeUnaNave = new DireccionVertical();
	
		direccionDeUnaNave.cambiarSentido();
		
		assertEquals(new Abajo() , direccionDeUnaNave.sentidoDeLaDireccion());
	}
	
	public void testProximaPosicionAlLlegarAlFinalDelTableroEnDireccionVertical() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroParaConocerDireccion = Tablero.getInstance();
		Posicion posicionAConocerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('J', 10);
		
		Direccion direccionDeUnaNave = new DireccionVertical();
		
		Posicion posicionSiguiente = direccionDeUnaNave.desplazarPosicion(posicionAConocerLaSiguiente);
		
		Posicion posicionQueDeberiaSerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('J', 9);
		
		assertEquals(posicionQueDeberiaSerLaSiguiente , posicionSiguiente);
	
		Tablero.deleteInstance();
	}
	
}
