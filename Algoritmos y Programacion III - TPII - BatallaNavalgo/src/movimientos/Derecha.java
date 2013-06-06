package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;


public class Derecha implements SentidoHorizontal{

	@Override
	public char proximoPaso(Posicion posicionAConocerLaSiguiente) {
		/*
		 * Devuelve el identificador de la columna de la derecha de la pasada por parametro
		 */
		char columnaActual = posicionAConocerLaSiguiente.columnaDeLaPosicion();
		int columnaActualEnAscii = (int)columnaActual;
		
		char nuevaColumna = (char)(columnaActualEnAscii+1);
		
		return nuevaColumna;	
	}
	
	public SentidoHorizontal proximoSentido() {
		return new Izquierda();
	}

	public boolean equals(Object otro){
		return this.getClass().equals(otro.getClass());
	}

	@Override
	public int numeroDeComponenteDelantera(Nave nave) {
		return nave.numeroDeComponenteDeLaProa();
	}

}
