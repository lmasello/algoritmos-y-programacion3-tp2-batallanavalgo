package testDeEstructurasDeColecciones;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import componentesDeTablero.Columna;

import colecciones.ColeccionDeColumnas;
import excepciones.ValorDeParametroFueraDeRango;


public class ColeccionDeColumnasTest extends TestCase {

	public void testInicializadorDeColeccion() {

		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();

		assertNotNull(unaColeccion);
	}

	public void testAgregaUnaColumna() {

		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();

		assertEquals(0, unaColeccion.cantidadDeColumnas());

		Columna columnaAAgregar = new Columna();

		unaColeccion.agregarColumna(columnaAAgregar);

		assertEquals(1, unaColeccion.cantidadDeColumnas());

	}

	public void testEvaluaSiTieneUnaColumna() {

		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();
		Columna columnaAAgregar = new Columna();

		unaColeccion.agregarColumna(columnaAAgregar);

		assertEquals(true, unaColeccion.tieneLaColumnaDeIdentificador('A'));

	}

	public void testEvaluaSiTieneUnaColumnaCasoNegativo() {

		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();
		Columna columnaAAgregar = new Columna();

		unaColeccion.agregarColumna(columnaAAgregar);

		assertEquals(false, unaColeccion.tieneLaColumnaDeIdentificador('B'));

	}

	public void testObtenerUnaColumna() throws ValorDeParametroFueraDeRango {

		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();
		Columna columna1 = new Columna();
		Columna columna2 = new Columna();

		unaColeccion.agregarColumna(columna1);
		unaColeccion.agregarColumna(columna2);

		assertEquals(columna1, unaColeccion.obtenerLaColumnaDeIndice('A'));
		assertEquals(columna2, unaColeccion.obtenerLaColumnaDeIndice('B'));

	}
}
