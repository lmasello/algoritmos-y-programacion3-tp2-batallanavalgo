package pruebasDeMovimientos;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import movimientos.DireccionHorizontal;
import movimientos.DireccionVertical;
import nave.ComponenteDeNave;
import nave.ComponenteMovible;
import nave.Lancha;
import nave.Nave;
import nave.NaveMovible;
import nave.Resistencia;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class ComponenteMovibleTest extends TestCase{

	public void testDeMovimientoHorizontalDeUnaComponente() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
	
		Tablero tableroDondeSeMueve = Tablero.getInstance();
		DireccionHorizontal direccionDeLaComponente = new DireccionHorizontal();
		
		Nave naveDeLaComponente = new Lancha();
		ComponenteMovible componenteAMover = naveDeLaComponente.obtenerComponenteDeNumero(1);

		naveDeLaComponente.establecerDireccionDelMovimiento(direccionDeLaComponente);
		
		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('D', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		Posicion posicionDondeDeberiaEstar = tableroDondeSeMueve.obtenerPosicion('E', 4);
		
		assertEquals(posicionDondeDeberiaEstar , componenteAMover.posicionActualDeLaComponente());
		
		Tablero.deleteInstance();
	}
	
	public void testDeMovimientoVerticalDeUnaComponente() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDondeSeMueve = Tablero.getInstance();
		DireccionVertical direccionDeLaComponente = new DireccionVertical();
		
		Nave naveDeLaComponente = new Lancha();
		ComponenteMovible componenteAMover = naveDeLaComponente.obtenerComponenteDeNumero(1);
		
		naveDeLaComponente.establecerDireccionDelMovimiento(direccionDeLaComponente);
		
		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('D', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		Posicion posicionDondeDeberiaEstar = tableroDondeSeMueve.obtenerPosicion('D', 3);
		
		assertEquals(posicionDondeDeberiaEstar , componenteAMover.posicionActualDeLaComponente());
		
		Tablero.deleteInstance();
	}
	
	public void testDeMovimientoHorizontalDeUnaComponenteAlAlcanzarFinDeTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDondeSeMueve = Tablero.getInstance();
		DireccionHorizontal direccionDeLaComponente = new DireccionHorizontal();

		Nave naveDeLaComponente = new Lancha();
		ComponenteMovible componenteAMover = naveDeLaComponente.obtenerComponenteDeNumero(1);

		naveDeLaComponente.establecerDireccionDelMovimiento(direccionDeLaComponente);
		
		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('J', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		Posicion posicionDondeDeberiaEstar = tableroDondeSeMueve.obtenerPosicion('I', 4);
		
		assertEquals(posicionDondeDeberiaEstar , componenteAMover.posicionActualDeLaComponente());
		
		Tablero.deleteInstance();
	}
	
	public void testAlMoverseLaPosicionAnteriorDebeBorrarLaComponente() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDondeSeMueve = Tablero.getInstance();
		DireccionHorizontal direccionDeLaComponente = new DireccionHorizontal();

		Nave naveDeLaComponente = new Lancha();
		ComponenteMovible componenteAMover = naveDeLaComponente.obtenerComponenteDeNumero(1);

		naveDeLaComponente.establecerDireccionDelMovimiento(direccionDeLaComponente);
				
		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('J', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		assertEquals(false , posicionDeLaComponente.tieneComponenteDeNave());
		
		Tablero.deleteInstance();
	}

}
