package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;

public interface SentidoHorizontal extends Sentido {

	/*Metodo que devuelve el identificador de la proxima columna alcanzada por el movimiento*/
	public abstract char proximoPaso(Posicion posicionAConocerLaSiguiente);
	
	public abstract SentidoHorizontal proximoSentido();

	public abstract int numeroDeComponenteDelantera(Nave nave);

}
