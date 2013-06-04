package nave;

import movimientos.Direccion;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;

public interface ComponenteMovible {

	public abstract void establecerTableroEnDondeSeEncuentraLaComponente(Tablero tableroDeLaNave);
	
	public abstract Posicion posicionActualDeLaComponente();
	
	public abstract Direccion direccionDelMovimiento();
	
	public abstract Posicion posicionSiguiente();

}
