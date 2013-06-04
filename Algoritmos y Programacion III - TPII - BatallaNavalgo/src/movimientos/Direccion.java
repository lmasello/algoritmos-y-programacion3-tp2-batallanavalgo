package movimientos;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;

public abstract class Direccion {

	Tablero tableroDeLaDireccion;
	Sentido sentidoDeLaNave;
	
	public void sentido(Sentido unSentido) {
		sentidoDeLaNave = unSentido;
	}

	public Sentido sentido(){
		return sentidoDeLaNave;
	}
	public abstract Posicion desplazarPosicion(Posicion posicionAConocerLaSiguiente) throws ValorDeParametroFueraDeRango;
	/*Obtiene la posicion siguiente a una posicion determinada de un tablero*/	

	public void cambiarSentido() {
		sentidoDeLaNave = (sentidoDeLaNave).proximoSentido();
	}

	public void tableroDeLasPosiciones(Tablero tableroParaConocerDireccion) {
		
		tableroDeLaDireccion = tableroParaConocerDireccion;
	}

	public Sentido sentidoDeLaDireccion() {
		
		return sentidoDeLaNave;
	}

}
