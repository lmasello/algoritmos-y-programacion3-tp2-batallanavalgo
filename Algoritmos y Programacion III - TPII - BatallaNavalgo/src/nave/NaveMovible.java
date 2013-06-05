package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.ValorDeParametroFueraDeRango;

public interface NaveMovible {

	public void moverComponentes();
	
	public void direccionDeLaNave(Direccion direccionQueVaATenerLaNave);
	
	public void tableroEnDondeSeVaADesplazarLaNave(Tablero tableroEnDondeMoverse);
}
