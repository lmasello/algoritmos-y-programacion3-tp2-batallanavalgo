package movimientos;

import componentesDeTablero.Posicion;

public class Izquierda extends Sentido implements SentidoHorizontal{

	@Override
	public char proximoPaso(Posicion posicionAConocerLaSiguiente) {
		/*
		 * Devuelve el identificador de la columna de la izquierda a la pasada por parametro 
		 */
		char columnaActual = posicionAConocerLaSiguiente.columnaDeLaPosicion();
		int columnaActualEnAscii = (int)columnaActual;
		
		char nuevaColumna = (char)(columnaActualEnAscii-1);
		
		return nuevaColumna;
		
	}

	public SentidoHorizontal proximoSentido() {
		return new Derecha();
	}
	
}
