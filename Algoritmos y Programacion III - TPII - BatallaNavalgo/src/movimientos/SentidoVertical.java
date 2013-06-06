package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;

public interface SentidoVertical extends Sentido{

	/*Metodo que devuelve el identificador de la proxima fila alcanzada por el movimiento*/
	public abstract int proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoVertical proximoSentido();

	public abstract int numeroDeComponenteDelantera(Nave nave);

}
