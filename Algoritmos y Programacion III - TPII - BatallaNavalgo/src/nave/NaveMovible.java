package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;

public interface NaveMovible {

	/*Mueve cada una de las componentes de la Nave, teniendo en cuenta las componentes de los extremos en los rebotes
	 * con los limites del tablero en donde se mueve
	 */
	public void moverComponentes() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
	
	public abstract void establecerTableroEnDondeMoverse(Tablero tableroBase) throws ValorDeParametroFueraDeRango;
	
	public abstract void establecerDireccionDelMovimiento(Direccion unaDireccion) throws ValorDeParametroFueraDeRango;
}
