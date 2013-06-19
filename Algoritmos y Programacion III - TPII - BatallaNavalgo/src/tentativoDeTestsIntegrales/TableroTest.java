package tentativoDeTestsIntegrales;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import nave.Buque;
import nave.Destructor;
import nave.Lancha;
import nave.Nave;
import nave.PortaAviones;
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
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;


public class TableroTest extends TestCase {
	
	public void testRealizarDisparoAUnaNaveDeResistenciaDeUnTiro() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Nave naveAProbar = new Lancha();
	
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		Disparo disparoARealizar = new DisparoConvencional();

		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeProaDeNaveAProbar);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeCuerpoDeNave);
				
		tableroDelJuego.impactarDisparos();
		
		assertEquals(true, naveAProbar.estaDestruida());
		
		Tablero.deleteInstance();
	}

	public void testRealizarDisparoAUnaNaveDeResistenciaDeDosTiros() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Posicion posicionDePopaDeNave = tableroDelJuego.obtenerPosicion('B', 4);
		Nave naveAProbar = new RompeHielos();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
	
		Disparo disparoARealizar = new DisparoConvencional();
		
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDePopaDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeCuerpoDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeProaDeNaveAProbar);

		tableroDelJuego.impactarDisparos();
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDePopaDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeCuerpoDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeProaDeNaveAProbar);

		tableroDelJuego.impactarDisparos();
		
		assertEquals(true, naveAProbar.estaDestruida());
		
		Tablero.deleteInstance();
	}

	public void testRealizarDisparoAUnaNaveQueAlRecibirUnImpactoSeDestruye() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Nave naveAProbar = new Buque();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		
		assertEquals(false, naveAProbar.estaDestruida());
		
		Disparo disparoARealizar = new DisparoConvencional();

		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeProaDeNaveAProbar);

		tableroDelJuego.impactarDisparos();
		
		assertEquals(true, naveAProbar.estaDestruida());
		
		Tablero.deleteInstance();
	}
	
	public void testRealizarDisparoAUnaNaveQueSoloRecibeDanioDeUnDisparoConvencional() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Posicion posicionDePopaDeNave = tableroDelJuego.obtenerPosicion('B', 4);
		
		Nave naveAProbar = new Destructor();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);

		assertEquals(false, naveAProbar.estaDestruida());

 		Disparo disparoARealizar = new DisparoConvencional();

 		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeProaDeNaveAProbar);
 		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeCuerpoDeNave);
 		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDePopaDeNave);

		tableroDelJuego.impactarDisparos();
		
		assertEquals(true, naveAProbar.estaDestruida());
		
		Tablero.deleteInstance();
	}

	public void testNoSeDaniaUnaNaveQueSoloRecibeDanioDeUnDisparoConvencionalYSeDisparaConOtroDisparo() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Tablero tableroDelJuego = Tablero.getInstance();
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
		
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar1, posicionDeProaDeNaveAProbar);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar2, posicionDeCuerpoDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar3, posicionDePopaDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar4, posicionDePopaDeNave);
		
		/*Se impacta varias veces debido al momento de disparo que tiene cada disparo.*/
		tableroDelJuego.impactarDisparos();
		tableroDelJuego.impactarDisparos();
		tableroDelJuego.impactarDisparos();

		assertEquals(false, naveAProbar.estaDestruida());
	
		Tablero.deleteInstance();
	}
	
	public void testCantidadDeDisparosYComponentesEnPosicionesDelTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
		
		Tablero tableroDelJuego = Tablero.getInstance();
		Posicion posicionDeProaDeNaveAProbar = tableroDelJuego.obtenerPosicion('D', 4);
		Posicion posicionDeCuerpoDeNave = tableroDelJuego.obtenerPosicion('C', 4);
		Posicion posicionDePopaDeNave = tableroDelJuego.obtenerPosicion('B', 4);
		Nave naveAProbar = new RompeHielos();
		Nave otraNave = new PortaAviones();
		
		tableroDelJuego.colocarComponentesEnDireccionHorizontal(naveAProbar, posicionDeProaDeNaveAProbar);
		tableroDelJuego.colocarComponentesEnDireccionVertical(otraNave, posicionDeProaDeNaveAProbar);

		Disparo disparoARealizar = new DisparoConvencional();
		Disparo otroDisparo = new MinaSubmarinaPuntual();
		
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeProaDeNaveAProbar);
		tableroDelJuego.realizarDisparoALaPosicion(disparoARealizar, posicionDeCuerpoDeNave);
		tableroDelJuego.realizarDisparoALaPosicion(otroDisparo, posicionDeCuerpoDeNave);

		assertEquals(1 , posicionDeProaDeNaveAProbar.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(2 , posicionDeCuerpoDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());
		assertEquals(0 , posicionDePopaDeNave.obtenerDisparosEnPosicion().cantidadDeDisparos());
		
		assertEquals(2 , posicionDeProaDeNaveAProbar.cantidadDeComponentesEnPosicion());
		assertEquals(1 , posicionDeCuerpoDeNave.cantidadDeComponentesEnPosicion());

		Posicion posicionDeAgua = tableroDelJuego.obtenerPosicion('A', 1);

		assertEquals(0 , posicionDeAgua.cantidadDeComponentesEnPosicion());

		Tablero.deleteInstance();
	}

}