package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;

import java.io.IOException;

import jugador.Jugador;
import junit.framework.TestCase;

import nave.Lancha;
import nave.Nave;

import org.junit.Test;

import recolectorDePosiciones.RecolectorDePosicionesDeDisparo;

import colecciones.ColeccionDePosiciones;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;

import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class DisparosTest extends TestCase{

	public void testAlDispararConMinaDobleSeColocanDisparonEnPosicionesDeAlrededor() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, IOException{
		
		/*Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Jugador jugador1 = new Jugador("Juan");
		
		jugador1.asignarTablero(tableroDelJuego);
		
		jugador1.disparar();
		jugador1.disparar();
		
		assertEquals(2 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(1 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());

		tableroDelJuego.impactarDisparos();// Se impactan los disparos. Convencional desaparece,
                                           // MinaDoble queda en momento = 1	
		assertEquals(1 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(1 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());
		
		tableroDelJuego.impactarDisparos();// MinaDoble queda en momento = 0
		tableroDelJuego.impactarDisparos();// Desaparece MinaDoble.
		
		assertEquals(0 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(0 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());
	
		Tablero.deleteInstance();
		*/
	}
}
