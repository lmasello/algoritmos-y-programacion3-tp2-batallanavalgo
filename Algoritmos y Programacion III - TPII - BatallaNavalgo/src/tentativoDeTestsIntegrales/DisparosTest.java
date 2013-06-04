package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import nave.Lancha;
import nave.Nave;

import org.junit.Test;

import componentesDeTablero.Posicion;
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
	
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);

		Disparo disparoARealizar = new DisparoConvencional();
		Disparo otroDisparo = new MinaSubmarinaDoble();

		
		posicionDeProaDeNaveAProbar.agregarDisparoAPosicion(disparoARealizar);
		posicionDeCuerpoDeNave.agregarDisparoAPosicion(otroDisparo);
		
		assertEquals(2 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(1 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());

		tableroDelJuego.impactarDisparos();
	
		assertEquals(0 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(0 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());
		
	}

}
