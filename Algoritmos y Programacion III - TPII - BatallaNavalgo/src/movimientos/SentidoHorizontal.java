package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;

public interface SentidoHorizontal extends Sentido {

	public abstract char proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoHorizontal proximoSentido();

	public abstract int numeroDeComponenteDelantera(Nave nave);

}
