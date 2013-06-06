package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;

public class Arriba implements SentidoVertical {

	@Override
	public int proximoPaso(Posicion posicionAConocerLaSiguiente) {
		/*
		 * Devuelve el identificador de la fila de arriba (la cual tiene un numero
		 * de identificador inferior) de la posicion pasada por parametro
		 */
		int filaActual = posicionAConocerLaSiguiente.filaDeLaPosicion();
		
		int nuevaFila = filaActual-1;
		
		return nuevaFila;
	}

	@Override
	public SentidoVertical proximoSentido() {

		return (SentidoVertical) new Abajo();
		
	}

	public boolean equals(Object otro){
		return this.getClass().equals(otro.getClass());
	}

	@Override
	public int numeroDeComponenteDelantera(Nave nave) {
		return nave.numeroDeComponenteDeLaProa();
	}

}
