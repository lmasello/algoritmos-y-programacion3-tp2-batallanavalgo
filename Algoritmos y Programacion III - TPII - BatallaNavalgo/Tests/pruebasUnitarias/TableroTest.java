package pruebasUnitarias;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import nave.Buque;
import nave.Lancha;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;


public class TableroTest extends TestCase {

	public void testInicializaElTableroCon10ColumnasY10Filas() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {
		/*
		 * Metodo que prueba el inicializador del tablero, el cual se inicializa
		 * con 10 filas y 10 columnas. Primer parametro del constructor
		 * representa el numero de columnas y el segundo parametro representa el
		 * numero de filas.
		 */
		Tablero tableroDelJuego = Tablero.getInstance();

		assertEquals(10, tableroDelJuego.cantidadDeColumnas());
		assertEquals(10, tableroDelJuego.cantidadDeFilas());
		Tablero.deleteInstance();
	}

	public void testObtenerUnaPosicionDelTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion unaPosicionDelTablero = tableroDelJuego.obtenerPosicion('C', 2);

		assertNotNull(unaPosicionDelTablero);
		Tablero.deleteInstance();

	}
	
	public void testCantidadDeBarcosInicialesEnElTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
		
		Tablero tableroDelJuego = Tablero.getInstance();
		
		assertEquals(0 , tableroDelJuego.cantidadDeBarcosEnTablero());
		
		tableroDelJuego.colocarNavesEnElTablero();
		
		assertEquals(7 , tableroDelJuego.cantidadDeBarcosEnTablero());
		
		Tablero.deleteInstance();
	}
	
	public void testExaminarSiLasPosicionesDelTableroContienenComponentesAlAgregarUnaNaveHorizontalmente() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	
		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeLanchaAColocar = tableroDelJuego.obtenerPosicion('D', 5);
		
		assertEquals(false , tableroDelJuego.hayComponenteEnPosicion('D', 5));
		
		Lancha lanchaAColocar = new Lancha();
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(lanchaAColocar, posicionDeProaDeLanchaAColocar);
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('E', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('C', 5));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('B', 5));
		
		Tablero.deleteInstance();
	}


	public void testExaminarSiLasPosicionesDelTableroContienenComponentesAlAgregarUnaNaveVerticalmente() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	
		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeBuqueAColocar = tableroDelJuego.obtenerPosicion('D', 5);
		
		assertEquals(false , tableroDelJuego.hayComponenteEnPosicion('D', 5));
		
		Buque buqueAColocar = new Buque();
		tableroDelJuego.colocarComponentesEnDireccionVertical(buqueAColocar, posicionDeProaDeBuqueAColocar);
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('D', 4));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 6));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 7));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 8));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('D', 9));
		
		Tablero.deleteInstance();
	}

}
