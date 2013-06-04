package movimientos;

import componentesDeTablero.Posicion;

public interface SentidoVertical {

	public abstract int proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoVertical proximoSentido();

}
