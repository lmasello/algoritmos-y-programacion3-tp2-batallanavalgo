package juego;

import colecciones.ColeccionDeNaves;
import jugador.Jugador;
import componentesDeTablero.Modelo;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import disparos.Disparo;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.NoHayDisparoParaColocarEnLaPosicion;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class Juego implements Modelo {
	
	Tablero tableroDelJuego;
	Jugador jugador;
	
	public Juego(String nombre) throws ValoresDeParametroFueraDeRango{
		
		tableroDelJuego = Tablero.getInstance();
		jugador = new Jugador(nombre); // Se podria pedir por teclado el ingreso del nombre
										  // del jugador
	}
	
	@Override
	public void colocarNavesEnElTablero() throws ValorDeParametroFueraDeRango,
			LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		tableroDelJuego.colocarNavesEnElTablero();
		
	}

	@Override
	public Posicion obtenerPosicion(char columnaBuscada, int filaBuscada)
			throws ValorDeParametroFueraDeRango {
		return tableroDelJuego.obtenerPosicion(columnaBuscada, filaBuscada);
	}

	@Override
	public int cantidadDeBarcosEnTablero() {
		return tableroDelJuego.cantidadDeBarcosEnTablero();
	}

	@Override
	public void realizarDisparoALaPosicion(Disparo disparo,
			Posicion posicionElegida) throws ValorDeParametroFueraDeRango,
			ValoresDeParametroFueraDeRango, NoHayDisparoParaColocarEnLaPosicion {
		tableroDelJuego.realizarDisparoALaPosicion(disparo, posicionElegida);
		jugador.obtenerPuntaje().disminuirPuntajePorDisparo(disparo);
	}

	@Override
	public void impactarDisparos() throws ValorDeParametroFueraDeRango {
		tableroDelJuego.impactarDisparos();
	}

	@Override
	public void moverNaves() throws ValorDeParametroFueraDeRango,
			ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
		tableroDelJuego.moverNaves();
	}

	@Override
	public ColeccionDeNaves obtenerNavesDelTablero() {
		return tableroDelJuego.obtenerNavesDelTablero();
	}

	@Override
	public Jugador obtenerJugador() {
		return jugador;
	}

	@Override
	public void disminuirPuntajeDeJugadorPorPasajeDeTurno() {
		jugador.obtenerPuntaje().disminuirPuntajePorPasoDeTurno();
	}

	public Tablero obtenerTablero() {
		return tableroDelJuego;
	}

}
