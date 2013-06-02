package jugador;

import colecciones.ColeccionDePosiciones;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;

import disparos.Disparo;
import excepciones.ValorDeParametroFueraDeRango;
import puntaje.Puntaje;

public class Jugador {

	Puntaje puntajeDelJugador;
	String nombreDelJugador;
	Tablero tableroDelJugador;

	public Jugador(String nombre) {
		/* Crea a un jugador junto con su puntaje inicial */

		nombreDelJugador = nombre;
		puntajeDelJugador = new Puntaje();
		puntajeDelJugador.setearPuntaje(10000);

	}

	public void asignarTablero(Tablero tablero) {

		tableroDelJugador = tablero;
	}

	public Puntaje obtenerPuntaje() {

		return puntajeDelJugador;

	}

	public void realizarDisparoALasPosiciones(Disparo disparo,ColeccionDePosiciones
			 posicionesADisparar) throws ValorDeParametroFueraDeRango {
		
	/* Recorre la coleccion de posiciones para colocar el disparo correspondiente en cada
	 * 	posicion. Al finalizar disminuye el puntaje debido al disparo seleccionado 
	 */
		
		for(int posicionEnColeccion = 1; posicionEnColeccion <= posicionesADisparar.cantidadDePosiciones()
				; posicionEnColeccion++){
				Posicion posicionActual = posicionesADisparar.obtenerPosicionDeLaFila(posicionEnColeccion);
				posicionActual.agregarDisparoAPosicion(disparo);
		}
		
		this.obtenerPuntaje().disminuirPuntajePorDisparo(disparo);
	

	}

	public void disparar(){
			
		/*	El Jugador elige un tipo de disparo, junto con una posicion (metodos a desarrollar)
		 *  sobre la cual quiera disparar. Luego de acuerdo al tipo de disparo, se recolectan las 
		 *  posiciones necesarias para tal disparo y se devuelve la coleccion. Por ultimo
		 *  se realiza el disparo a las posiciones recolectadas.
		 */  
		/*	  Disparo disparo = this.elegirDisparo();
			  Posicion posicionElegida = this.elegirPosicion();
			  ColeccionDePosiciones posicionesADisparar = tableroDelJugador.obtenerPosicionesDondeDisparar(posicionElegida,disparo);
			  
			  this.realizarDisparoALasPosiciones(disparo, posicionesADisparar);
		*/
	}

}
