package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;

public interface NaveMovible {

	public void moverComponentes() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
	
	public abstract void establecerTableroEnDondeMoverse(Tablero tableroBase) throws ValorDeParametroFueraDeRango;
	
	public abstract void establecerDireccionDelMovimiento(Direccion unaDireccion) throws ValorDeParametroFueraDeRango;
}
