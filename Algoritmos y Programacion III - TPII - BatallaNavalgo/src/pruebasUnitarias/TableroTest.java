package pruebasUnitarias;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;


public class TableroTest extends TestCase {

	public void testInicializaElTableroCon10ColumnasY10Filas() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		Tablero tableroDelJuego = new Tablero(10, 10);

		assertEquals(10, tableroDelJuego.cantidadDeColumnas());
		assertEquals(10, tableroDelJuego.cantidadDeFilas());
	}

	public void testObtenerUnaPosicionDelTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion unaPosicionDelTablero = tableroDelJuego.obtenerPosicion('C', 2);

		assertNotNull(unaPosicionDelTablero);

	}

}
