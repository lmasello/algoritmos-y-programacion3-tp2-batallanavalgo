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
	
		Tablero tableroDondeSeMueve = new Tablero(10,10);
		Resistencia resistenciaDeNave = new Resistencia(1);
		Nave naveDeLaComponente = new Lancha();
		DireccionHorizontal direccionDeLaComponente = new DireccionHorizontal();
		
		ComponenteMovible componenteAMover = new ComponenteDeNave(resistenciaDeNave, naveDeLaComponente);
		componenteAMover.establecerTableroEnDondeSeEncuentraLaComponente(tableroDondeSeMueve);
		componenteAMover.establecerDireccion(direccionDeLaComponente);

		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('D', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		Posicion posicionDondeDeberiaEstar = tableroDondeSeMueve.obtenerPosicion('E', 4);
		
		assertEquals(posicionDondeDeberiaEstar , componenteAMover.posicionActualDeLaComponente());
	}
	
	public void testDeMovimientoVerticalDeUnaComponente() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDondeSeMueve = new Tablero(10,10);
		Resistencia resistenciaDeNave = new Resistencia(1);
		Nave naveDeLaComponente = new Lancha();
		DireccionVertical direccionDeLaComponente = new DireccionVertical();
		
		ComponenteMovible componenteAMover = new ComponenteDeNave(resistenciaDeNave, naveDeLaComponente);
		componenteAMover.establecerTableroEnDondeSeEncuentraLaComponente(tableroDondeSeMueve);
		componenteAMover.establecerDireccion(direccionDeLaComponente);
		
		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('D', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		Posicion posicionDondeDeberiaEstar = tableroDondeSeMueve.obtenerPosicion('D', 3);
		
		assertEquals(posicionDondeDeberiaEstar , componenteAMover.posicionActualDeLaComponente());
	}
	
	public void testDeMovimientoHorizontalDeUnaComponenteAlAlcanzarFinDeTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDondeSeMueve = new Tablero(10,10);
		Resistencia resistenciaDeNave = new Resistencia(1);
		Nave naveDeLaComponente = new Lancha();
		DireccionHorizontal direccionDeLaComponente = new DireccionHorizontal();

		ComponenteMovible componenteAMover = new ComponenteDeNave(resistenciaDeNave, naveDeLaComponente);
		componenteAMover.establecerTableroEnDondeSeEncuentraLaComponente(tableroDondeSeMueve);
		componenteAMover.establecerDireccion(direccionDeLaComponente);
	
		Posicion posicionDeLaComponente = tableroDondeSeMueve.obtenerPosicion('J', 4);
		componenteAMover.establecerPosicionActual(posicionDeLaComponente);
		
		componenteAMover.mover();
		
		Posicion posicionDondeDeberiaEstar = tableroDondeSeMueve.obtenerPosicion('I', 4);
		
		assertEquals(posicionDondeDeberiaEstar , componenteAMover.posicionActualDeLaComponente());
	}
}
