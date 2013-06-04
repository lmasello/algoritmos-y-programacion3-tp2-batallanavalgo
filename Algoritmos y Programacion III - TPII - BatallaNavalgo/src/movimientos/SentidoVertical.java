package movimientos;

import componentesDeTablero.Posicion;

public interface SentidoVertical extends Sentido{

	public abstract int proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoVertical proximoSentido();

}
