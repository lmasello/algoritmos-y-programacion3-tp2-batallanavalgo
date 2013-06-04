package movimientos;

import componentesDeTablero.Posicion;

public class Abajo extends Sentido implements SentidoVertical{

	@Override
	public int proximoPaso(Posicion posicionAConocerLaSiguiente) {
		/*
		 * Devuelve el identificador de la fila de arriba de la posicion pasada por parametro
		 */
		int filaActual = posicionAConocerLaSiguiente.filaDeLaPosicion();
		
		int nuevaFila = filaActual-1;
		
		return nuevaFila;
	}

	@Override
	public SentidoVertical proximoSentido() {

		return new Arriba();
		
	}
	
}
