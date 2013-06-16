package nave;

import movimientos.Direccion;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;

public interface ComponenteMovible {

	/*Almacena una referencia a la posicion donde esta contenida la componente*/
	public abstract void establecerPosicionActual(Posicion posicionActual);

	public abstract Posicion posicionActualDeLaComponente();

	/*Realiza el movimiento de una componente, modificando su posicion actual, por la posicion siguiente de acuerdo a
	 * la direccion de movimiento que posea la componente.
	 */
	public abstract void mover() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
	
	/*Determina si es posible avanzar una posicion en el tablero, sin cambiar el sentido del movimiento y sin 
	 * alcanzar el final del Tablero
	 */
	public abstract boolean puedeAvanzar();

	public abstract void establecerDireccion();
		
}
