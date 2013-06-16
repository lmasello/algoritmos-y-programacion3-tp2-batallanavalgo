package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;


public class DireccionHorizontal implements Direccion {

	Tablero tableroDeLaDireccion;
	SentidoHorizontal sentidoDeLaNave;
	
	public DireccionHorizontal(){
		sentidoDeLaNave = new Derecha();
	}
	
	public Posicion desplazarPosicion(Posicion posicionAConocerLaSiguiente) throws ValorDeParametroFueraDeRango{
	/*
	 * Obtiene la posicion siguiente a una posicion determinada de un tablero. 
	 * Como la direccion es horizontal, si el sentido es Derecha, devolvera la siguiente posicion que se encuentre
	 * a la derecha de posicion a conocer la siguiente. En caso que a la derecha de la misma, 
	 * no haya mas tablero, el sentido cambia a Izquierda y se devuelve la posicion de la izquierda.
	 * 
	 */
		char columnaSiguiente = sentidoDeLaNave.proximoPaso(posicionAConocerLaSiguiente);

		if(tableroDeLaDireccion.noTieneLaColumna(columnaSiguiente)){
			
			this.cambiarSentido();
			columnaSiguiente = sentidoDeLaNave.proximoPaso(posicionAConocerLaSiguiente);
		}		
		Posicion posicionADevolver = tableroDeLaDireccion.obtenerPosicion(columnaSiguiente, posicionAConocerLaSiguiente.filaDeLaPosicion());

		return posicionADevolver;
	}

	public boolean equals(Object otro){
		return this.getClass().equals(otro.getClass());
	}


	@Override
	public void cambiarSentido() {
		sentidoDeLaNave = (sentidoDeLaNave).proximoSentido();
	}

	@Override
	public void tableroDeLasPosiciones(Tablero tableroParaConocerDireccion) {
		
		tableroDeLaDireccion = tableroParaConocerDireccion;
	}

	@Override
	public Sentido sentidoDeLaDireccion() {
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
		char columnaSiguiente = sentidoDeLaNave.proximoPaso(posicionActual);
		
		return tableroDeLaDireccion.tieneLaColumna(columnaSiguiente);
		
	}

}
