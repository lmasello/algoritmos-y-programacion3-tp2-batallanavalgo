package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;

import excepciones.ValorDeParametroFueraDeRango;


public class DireccionVertical implements Direccion {

	Tablero tableroDeLaDireccion;
	SentidoVertical sentidoDeLaNave;
	
	public DireccionVertical(){
		sentidoDeLaNave = new Arriba();
	}
	
	@Override
	public Posicion desplazarPosicion(Posicion posicionAConocerLaSiguiente)
			throws ValorDeParametroFueraDeRango {
		/*
		 * Obtiene la posicion siguiente a una posicion determinada de un tablero. 
		 * Como la direccion es vertical, si el sentido es Arriba, devolvera la siguiente posicion que se encuentre
		 * a la arriba de posicion a conocer la siguiente. En caso que arriba de la misma, 
		 * no haya mas tablero, el sentido cambia a Abajo y se devuelve la posicion de abajo.
		 * 
		 */
			int filaSiguiente = sentidoDeLaNave.proximoPaso(posicionAConocerLaSiguiente);
		
			if(tableroDeLaDireccion.noTieneLaFila(filaSiguiente)){
				this.cambiarSentido();
				filaSiguiente = sentidoDeLaNave.proximoPaso(posicionAConocerLaSiguiente);
			}
			
			Posicion posicionADevolver = tableroDeLaDireccion.obtenerPosicion(posicionAConocerLaSiguiente.columnaDeLaPosicion(),filaSiguiente);

			return posicionADevolver;
		}


	@Override
	public void cambiarSentido() {
		
		sentidoDeLaNave = (sentidoDeLaNave).proximoSentido();
	}

	@Override
	public void tableroDeLasPosiciones(Tablero tableroParaConocerDireccion) {
		
		tableroDeLaDireccion = tableroParaConocerDireccion;
	}
	
	public Sentido sentidoDeLaDireccion(){
		return sentidoDeLaNave;
	}

	@Override
	public int numeroDeComponenteDelantera(Nave nave) {
		return sentidoDeLaNave.numeroDeComponenteDelantera(nave);
	}

	@Override
	public boolean hayPosicionSiguienteDisponible(Posicion posicionActual) {
		/*
		 * Evalua si puede existir un movimiento manteniendo el sentido y sin llegar al final del tablero.
		 * Precondiciones: posicionActual debe pertenecer al tableroDeLaDireccion
		 */
		int filaSiguiente = sentidoDeLaNave.proximoPaso(posicionActual);
		
		return tableroDeLaDireccion.tieneLaFila(filaSiguiente);
		
	}
	public boolean equals(Object otro){
		return this.getClass().equals(otro.getClass());
	}

}
