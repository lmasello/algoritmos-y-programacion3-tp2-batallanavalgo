package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import nave.Buque;
import nave.Destructor;
import nave.Lancha;
import nave.Nave;
import nave.RompeHielos;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import disparos.MinaSubmarinaPorContacto;
import disparos.MinaSubmarinaPuntual;
import disparos.MinaSubmarinaTriple;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;


public class TableroTest extends TestCase {
	
	public void testRealizarDisparoAUnaNaveDeResistenciaDeUnTiro() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Nave naveAProbar = new Lancha();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		Disparo disparoARealizar = new DisparoConvencional();

		posicionDeProaDeNaveAProbar.agregarDisparoAPosicion(disparoARealizar);
		posicionDeCuerpoDeNave.agregarDisparoAPosicion(disparoARealizar);
		
		tableroDelJuego.impactarDisparos();
		assertEquals(true, naveAProbar.estaDestruida());
		
	}

	public void testRealizarDisparoAUnaNaveDeResistenciaDeDosTiros() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Posicion posicionDePopaDeNave = tableroDelJuego.obtenerPosicion('B', 4);
		Nave naveAProbar = new RompeHielos();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		Disparo disparoARealizar = new DisparoConvencional();

		posicionDeProaDeNaveAProbar.agregarDisparoAPosicion(disparoARealizar);
		posicionDeCuerpoDeNave.agregarDisparoAPosicion(disparoARealizar);
		posicionDePopaDeNave.agregarDisparoAPosicion(disparoARealizar);
		
		tableroDelJuego.impactarDisparos();
		assertEquals(true, naveAProbar.estaDestruida());
		
	}

	public void testRealizarDisparoAUnaNaveQueAlRecibirUnImpactoSeDestruye() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Nave naveAProbar = new Buque();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		Disparo disparoARealizar = new DisparoConvencional();

		posicionDeCuerpoDeNave.agregarDisparoAPosicion(disparoARealizar);

		tableroDelJuego.impactarDisparos();
		assertEquals(true, naveAProbar.estaDestruida());
		
	}
	
	public void testRealizarDisparoAUnaNaveQueSoloRecibeDanioDeUnDisparoConvencional() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Posicion posicionDePopaDeNave = tableroDelJuego.obtenerPosicion('B', 4);
		
		Nave naveAProbar = new Destructor();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());

 		Disparo disparoARealizar1 = new DisparoConvencional();

 		posicionDeProaDeNaveAProbar.agregarDisparoAPosicion(disparoARealizar1);
		posicionDeCuerpoDeNave.agregarDisparoAPosicion(disparoARealizar1);
		posicionDePopaDeNave.agregarDisparoAPosicion(disparoARealizar1);

		tableroDelJuego.impactarDisparos();
		assertEquals(true, naveAProbar.estaDestruida());
		
	}

	public void testNoSeDaniaUnaNaveQueSoloRecibeDanioDeUnDisparoConvencionalYSeDisparaConOtroDisparo() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = new Tablero(10, 10);
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Posicion posicionDePopaDeNave = tableroDelJuego.obtenerPosicion('B', 4);
		
		Nave naveAProbar = new Destructor();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		Disparo disparoARealizar1 = new MinaSubmarinaPuntual();
		Disparo disparoARealizar2 = new MinaSubmarinaDoble();
		Disparo disparoARealizar3 = new MinaSubmarinaTriple();
		Disparo disparoARealizar4 = new MinaSubmarinaPorContacto();
		
 		posicionDeProaDeNaveAProbar.agregarDisparoAPosicion(disparoARealizar1);
		posicionDeCuerpoDeNave.agregarDisparoAPosicion(disparoARealizar2);
		posicionDePopaDeNave.agregarDisparoAPosicion(disparoARealizar3);
		posicionDePopaDeNave.agregarDisparoAPosicion(disparoARealizar4);
		
		tableroDelJuego.impactarDisparos();
		assertEquals(false, naveAProbar.estaDestruida());
		
	}
}