package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import jugador.Jugador;
import junit.framework.TestCase;

import nave.Lancha;
import nave.Nave;

import org.junit.Test;

import colecciones.ColeccionDePosiciones;

import componentesDeTablero.Posicion;
import componentesDeTablero.RecolectorDePosicionesDeDisparo;
import componentesDeTablero.Tablero;

import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class DisparosTest extends TestCase{

	public void testAlDispararConMinaDobleSeColocanDisparonEnPosicionesDeAlrededor() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
		
		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Nave naveAProbar = new Lancha();
		Jugador jugador1 = new Jugador("Juan");
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);

		RecolectorDePosicionesDeDisparo recolector = new RecolectorDePosicionesDeDisparo(tableroDelJuego);
		Disparo disparoARealizar = new DisparoConvencional();
		Disparo otroDisparo = new MinaSubmarinaDoble();

		ColeccionDePosiciones posicionesDelDisparoARealizar = recolector.obtenerPosicionesDeDisparo(posicionDeProaDeNaveAProbar, disparoARealizar); 
		ColeccionDePosiciones posicionesDelOtroDisparo = recolector.obtenerPosicionesDeDisparo(posicionDeCuerpoDeNave, otroDisparo);
		
		jugador1.asignarTablero(tableroDelJuego);
		
		jugador1.realizarDisparoALasPosiciones(disparoARealizar, posicionesDelDisparoARealizar);
		jugador1.realizarDisparoALasPosiciones(otroDisparo, posicionesDelOtroDisparo);
		
		assertEquals(2 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(1 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());

		tableroDelJuego.impactarDisparos();
	
		assertEquals(0 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(0 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());
		
	}

}
