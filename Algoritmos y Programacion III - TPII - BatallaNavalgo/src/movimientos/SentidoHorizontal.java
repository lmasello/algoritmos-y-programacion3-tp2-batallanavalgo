package movimientos;

import componentesDeTablero.Posicion;

public interface SentidoHorizontal {

	public abstract char proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoHorizontal proximoSentido();


}
