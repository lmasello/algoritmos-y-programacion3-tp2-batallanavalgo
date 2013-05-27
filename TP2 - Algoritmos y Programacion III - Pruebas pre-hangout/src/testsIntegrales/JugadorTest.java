package testsIntegrales;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {

	public void testJugadorInicializaCon10000Puntos(){
		
		Jugador jugadorHumano = new Jugador("Leandro Masello");
		
		assertEquals (10000 , jugadorHumano.puntaje());
		
	}
	
	public void testElPuntajeDelJugadorDisminuye10PuntosAlPasarUnTurno(){
	
		Jugador jugadorHumano = new Jugador("Leandro Masello");
		
		jugadorHumano.avanzaTurno();
		
		assertEquals (9990 , jugadorHumano.puntaje());
		
	}

	public void testElPuntajeDelJugadorDisminuyeDeAcuerdoAlDisparoQueElige(){
		
		Jugador jugadorHumano = new Jugador("Leandro Masello");
		Disparo disparo1 = new DisparoConvencional();
		Disparo disparo2 = new MinaSubmarinaPuntual();
		
		jugadorHumano.realizarDisparoEnPosicion(disparo1 , 1 , 2);
		
		assertEquals (9800 , jugadorHumano.puntaje());
		
		jugadorHumano.realizarDisparoEnPosicion(disparo2 , 1 , 3);
		
		assertEquals (9750 , jugadorHumano.puntaje());		
	}

}
