package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;

public interface Direccion {
	
	public abstract Posicion desplazarPosicion(Posicion posicionAConocerLaSiguiente) throws ValorDeParametroFueraDeRango;
	/*Obtiene la posicion siguiente a una posicion determinada de un tablero*/	

	public void cambiarSentido();

	public void tableroDeLasPosiciones(Tablero tableroParaConocerDireccion);
	
	public Sentido sentidoDeLaDireccion();

	public abstract int numeroDeComponenteDelantera(Nave nave);

	public abstract boolean hayPosicionSiguienteDisponible(
			Posicion posicionActual);

}
