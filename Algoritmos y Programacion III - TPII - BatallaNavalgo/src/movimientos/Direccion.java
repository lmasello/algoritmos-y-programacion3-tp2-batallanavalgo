package movimientos;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;

public interface Direccion {
	
	public void sentido(Sentido unSentido);

	public abstract Posicion desplazarPosicion(Posicion posicionAConocerLaSiguiente) throws ValorDeParametroFueraDeRango;
	/*Obtiene la posicion siguiente a una posicion determinada de un tablero*/	

	public void cambiarSentido();

	public void tableroDeLasPosiciones(Tablero tableroParaConocerDireccion);
	
	public Sentido sentidoDeLaDireccion();

}
