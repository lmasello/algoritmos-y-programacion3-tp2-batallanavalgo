package componentesDeTablero;

import disparos.Disparo;
import jugador.Jugador;
import nave.Nave;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public interface Modelo {

	public void colocarNavesEnElTablero() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango;
	//Agrega aleatoriamente las naves en el tablero
	
	public Posicion obtenerPosicion(char columnaBuscada, int filaBuscada) throws ValorDeParametroFueraDeRango;
	
	public int cantidadDeBarcosEnTablero();

	public void pasarTurno(Jugador jugador) throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
	
	public void realizarDisparoALaPosicion( Disparo disparo, Posicion posicionElegida) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango;
	//Coloca disparos en las posiciones afectadas por un disparo en particular
	
	public void impactarDisparos() throws ValorDeParametroFueraDeRango;
	//Impacta los disparos de todas las posiciones del tablero
	
	public void moverNaves() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
	
}
