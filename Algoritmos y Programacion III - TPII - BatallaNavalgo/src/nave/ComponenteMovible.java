package nave;

import movimientos.Direccion;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;

public interface ComponenteMovible {

	public abstract void establecerTableroEnDondeSeEncuentraLaComponente(Tablero tableroDeLaNave);

	public abstract void establecerPosicionActual(Posicion posicionActual);

	public abstract Posicion posicionActualDeLaComponente();

	public abstract void mover() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
	
	public void establecerDireccion(Direccion direccionDelMovimiento);

	public abstract boolean puedeAvanzar();
	
}
