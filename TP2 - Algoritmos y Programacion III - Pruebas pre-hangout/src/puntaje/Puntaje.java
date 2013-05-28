package puntaje;

import disparos.Disparo;

public class Puntaje {

	int puntajeDeJugador;

	public int obtenerPuntaje() {

		return puntajeDeJugador;
	}

	public void setearPuntaje(int puntaje) {

		puntajeDeJugador = puntaje;

	}

	public void disminuirPuntajePorPasoDeTurno() {
		/*
		 * Disminuye el puntaje del jugador por 10, que es el equivalente a un
		 * turno
		 */

		puntajeDeJugador = (puntajeDeJugador - 10);
	}

	public void disminuirPuntajePorDisparo(Disparo disparo) {
		/*
		 * Disminuye el puntaje del jugador dependiendo del costo del disparo
		 * realizado
		 */
		puntajeDeJugador = (puntajeDeJugador - disparo.obtenerCosto());

	}

}
