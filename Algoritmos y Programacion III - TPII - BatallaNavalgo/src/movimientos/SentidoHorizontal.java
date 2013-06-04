package movimientos;

import componentesDeTablero.Posicion;

public interface SentidoHorizontal extends Sentido {

	public abstract char proximoPaso(Posicion posicionAConocerLaSiguiente);

	public abstract SentidoHorizontal proximoSentido();


}
