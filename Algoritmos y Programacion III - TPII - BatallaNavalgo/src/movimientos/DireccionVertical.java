package movimientos;

import componentesDeTablero.Posicion;

import excepciones.ValorDeParametroFueraDeRango;


public class DireccionVertical extends Direccion {

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
				
			if(tableroDeLaDireccion.noTieneLaFila(sentidoDeLaNave.proximoPaso(posicionAConocerLaSiguiente))){
				this.cambiarSentido();
			}
			
			int filaSiguiente = sentidoDeLaNave.proximoPaso(posicionAConocerLaSiguiente);
			
			Posicion posicionADevolver = tableroDeLaDireccion.obtenerPosicion(posicionAConocerLaSiguiente.columnaDeLaPosicion(),filaSiguiente);

			return posicionADevolver;
		}
}
