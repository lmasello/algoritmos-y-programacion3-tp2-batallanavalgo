package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import juego.Juego;
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
import excepciones.NoHayDisparoParaColocarEnLaPosicion;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class JugadorTest extends TestCase {

	public void testJugadorInicializaCon10000Puntos() {

		Jugador jugadorHumano = new Jugador("Leandro Masello");

		assertEquals(10000, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

	}

	public void testElPuntajeDelJugadorDisminuye10PuntosAlPasarUnTurno() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {

		Juego juego = new Juego("Robert");

		juego.disminuirPuntajeDeJugadorPorPasajeDeTurno();

		assertEquals(9990, juego.obtenerJugador().obtenerPuntaje().obtenerPuntaje());

		Tablero.deleteInstance();
	}

	public void testElPuntajeDelJugadorDisminuyeDeAcuerdoAlDisparoQueElige() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, NoHayDisparoParaColocarEnLaPosicion {
	
		Juego juego = new Juego("Robert");
		Disparo disparo1 = new DisparoConvencional();
		Disparo disparo2 = new MinaSubmarinaPuntual();
		
		Posicion posicion = juego.obtenerPosicion('C', 5);
		
		juego.realizarDisparoALaPosicion(disparo1, posicion);

		assertEquals(9800, juego.obtenerJugador().obtenerPuntaje().obtenerPuntaje());

		juego.realizarDisparoALaPosicion(disparo2, posicion);

		assertEquals(9750, juego.obtenerJugador().obtenerPuntaje().obtenerPuntaje());
		
		Tablero.deleteInstance();
	
		
	}
}
