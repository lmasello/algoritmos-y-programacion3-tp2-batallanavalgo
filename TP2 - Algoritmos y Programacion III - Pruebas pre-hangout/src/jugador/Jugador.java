package jugador;

import disparo.Disparo;
import puntaje.Puntaje;
import tablero.Posicion;
import tablero.Tablero;

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
	
	public void asignarTablero(Tablero tablero){
		
		tableroDelJugador = tablero;
	}
	
	public Puntaje obtenerPuntaje() {
		
		return puntajeDelJugador;
     
	}


	public void realizarDisparoEnPosicion(Disparo disparo, char columna, int fila) {
		
	/* Obtiene la posicion en la que se desea realizar el disparo
	 * luego agrega el disparo en esa posicion(metodo todavia no implementado)
	 * y finalmente disminuye el puntaje del jugador dependiendo del disparo
	 *	
	 *	Posicion posicion = tableroDelJugador.obtenerPosicion(columna,fila);
	 *	Metodo a desarrollar: posicion.agregarDisparo(disparo);  
	 * */
		
		this.obtenerPuntaje().disminuirPuntajePorDisparo(disparo);
		
	}

}
