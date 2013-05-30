package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import jugador.Jugador;
import junit.framework.TestCase;

import org.junit.Test;

import componentesDeTablero.Tablero;


import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaPuntual;

public class JugadorTest extends TestCase {

	public void testJugadorInicializaCon10000Puntos() {

		Jugador jugadorHumano = new Jugador("Leandro Masello");

		assertEquals(10000, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

	}

	public void testElPuntajeDelJugadorDisminuye10PuntosAlPasarUnTurno() {

		Tablero tableroDePrueba = new Tablero(10, 10);
		Jugador jugadorHumano = new Jugador("Leandro Masello");

		tableroDePrueba.pasarTurno(jugadorHumano);

		assertEquals(9990, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

	}

	public void testElPuntajeDelJugadorDisminuyeDeAcuerdoAlDisparoQueElige() {

		Jugador jugadorHumano = new Jugador("Leandro Masello");
		Disparo disparo1 = new DisparoConvencional();
		Disparo disparo2 = new MinaSubmarinaPuntual();

		jugadorHumano.realizarDisparoEnPosicion(disparo1, 'A', 2);

		assertEquals(9800, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

		jugadorHumano.realizarDisparoEnPosicion(disparo2, 'A', 3);

		assertEquals(9750, jugadorHumano.obtenerPuntaje().obtenerPuntaje());
	}

}
