package pruebasUnitarias;

import disparos.DisparoConvencional;
import puntaje.Puntaje;
import junit.framework.TestCase;


public class PuntajeTest extends TestCase {
	
	public void testPuntajeInicial(){
		
		Puntaje puntajeDeJugador = new Puntaje();
		puntajeDeJugador.setearPuntaje(10000);
		
		assertEquals(10000, puntajeDeJugador.obtenerPuntaje());
		
	}
	
	public void testPuntajeDisminuidoPorTurno(){
		
		Puntaje puntajeDeJugador = new Puntaje();
		puntajeDeJugador.setearPuntaje(10000);
		
		puntajeDeJugador.disminuirPuntajePorPasoDeTurno();
		
		assertEquals(9990, puntajeDeJugador.obtenerPuntaje());
		
	}
	
	public void testPuntajeDisminuidoPorDisparoConvencional(){
		
		Puntaje puntajeDeJugador = new Puntaje();
		DisparoConvencional disparo = new DisparoConvencional();
		
		puntajeDeJugador.setearPuntaje(10000);
		puntajeDeJugador.disminuirPuntajePorDisparo(disparo);
		
		assertEquals(9800, puntajeDeJugador.obtenerPuntaje());
		
	}
}
