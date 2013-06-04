package pruebasDeMovimientos;

import static org.junit.Assert.*;

import movimientos.Abajo;
import movimientos.Arriba;
import movimientos.Direccion;
import movimientos.DireccionVertical;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class DireccionVerticalTest {

	public void testObtenerLaPosicionVerticalSiguienteAUnaPosicionDeUnTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroParaConocerDireccion = new Tablero(10,10);
		Posicion posicionAConocerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('D', 4);
		
		Direccion direccionDeUnaNave = new DireccionVertical();
		direccionDeUnaNave.sentido(new Arriba());
		
		Posicion posicionSiguiente = direccionDeUnaNave.desplazarPosicion(posicionAConocerLaSiguiente);
		
		Posicion posicionQueDeberiaSerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('D', 3);
		
		assertEquals(posicionQueDeberiaSerLaSiguiente , posicionSiguiente);
	}

	public void testCambiaLaDireccionVertical() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Direccion direccionDeUnaNave = new DireccionVertical();
		direccionDeUnaNave.sentido(new Arriba());
	
		direccionDeUnaNave.cambiarSentido();
		
		assertEquals(new Abajo() , direccionDeUnaNave.sentidoDeLaDireccion());
	}
	
	public void testProximaPosicionAlLlegarAlFinalDelTableroEnDireccionVertical(){
		
		Tablero tableroParaConocerDireccion = new Tablero(10,10);
		Posicion posicionAConocerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('J', 10);
		
		Direccion direccionDeUnaNave = new DireccionVertical();
		direccionDeUnaNave.sentido(new Arriba());
		
		Posicion posicionSiguiente = direccionDeUnaNave.desplazarPosicion(posicionAConocerLaSiguiente);
		
		Posicion posicionQueDeberiaSerLaSiguiente = tableroParaConocerDireccion.obtenerPosicion('J', 9);
		
		assertEquals(posicionQueDeberiaSerLaSiguiente , posicionSiguiente);
	}
	
}