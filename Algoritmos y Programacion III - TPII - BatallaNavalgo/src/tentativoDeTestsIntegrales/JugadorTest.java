package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import jugador.Jugador;
import junit.framework.TestCase;

import org.junit.Test;

import colecciones.ColeccionDePosiciones;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;


import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaPuntual;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class JugadorTest extends TestCase {

	public void testJugadorInicializaCon10000Puntos() {

		Jugador jugadorHumano = new Jugador("Leandro Masello");

		assertEquals(10000, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

	}

	public void testElPuntajeDelJugadorDisminuye10PuntosAlPasarUnTurno() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {

		Tablero tableroDePrueba = Tablero.getInstance();
		Jugador jugadorHumano = new Jugador("Leandro Masello");

		tableroDePrueba.pasarTurno(jugadorHumano);

		assertEquals(9990, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

		Tablero.deleteInstance();
	}

	public void testElPuntajeDelJugadorDisminuyeDeAcuerdoAlDisparoQueElige() throws ValorDeParametroFueraDeRango {

		Jugador jugadorHumano = new Jugador("Leandro Masello");
		Disparo disparo1 = new DisparoConvencional();
		Disparo disparo2 = new MinaSubmarinaPuntual();
		ColeccionDePosiciones posiciones = new ColeccionDePosiciones();
		Posicion posicion = new Posicion();
		posiciones.agregarPosicion(posicion);

		jugadorHumano.realizarDisparoALasPosiciones(disparo1, posiciones);

		assertEquals(9800, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

		jugadorHumano.realizarDisparoALasPosiciones(disparo2, posiciones);

		assertEquals(9750, jugadorHumano.obtenerPuntaje().obtenerPuntaje());
	}

}
