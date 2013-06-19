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

	public void testElPuntajeDelJugadorDisminuyeDeAcuerdoAlDisparoQueElige() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {
	/*	
	 * Se deja comentado ya que este test se debera realizar una vez realizada la interfaz, ya que es aqui en donde 
	 * de acuerdo al disparo, se resta puntos
	 * 
		Tablero tableroDePrueba = Tablero.getInstance();
		Jugador jugadorHumano = new Jugador("Leandro Masello");
		Disparo disparo1 = new DisparoConvencional();
		Disparo disparo2 = new MinaSubmarinaPuntual();
		
		Posicion posicion = tableroDePrueba.obtenerPosicion('C', 5);
		jugadorHumano.asignarTablero(tableroDePrueba);
		
		tableroDePrueba.realizarDisparoALaPosicion(disparo1, posicion);

		assertEquals(9800, jugadorHumano.obtenerPuntaje().obtenerPuntaje());

		tableroDePrueba.realizarDisparoALaPosicion(disparo2, posicion);

		assertEquals(9750, jugadorHumano.obtenerPuntaje().obtenerPuntaje());
		
		Tablero.deleteInstance();
	}
		*/
	}
}
