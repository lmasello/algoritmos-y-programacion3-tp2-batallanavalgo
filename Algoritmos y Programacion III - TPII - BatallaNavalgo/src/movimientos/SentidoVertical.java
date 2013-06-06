package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;

public interface SentidoVertical extends Sentido{

	public abstract int proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoVertical proximoSentido();

	public abstract int numeroDeComponenteDelantera(Nave nave);

}
