package pruebasDeMovimientos;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import nave.Lancha;
import nave.Nave;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class NaveMovibleTest extends TestCase{

	public void testMoverNaveHorizontalmenteEnElTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Posicion posicionDeProaDeLanchaAColocar = tableroDelJuego.obtenerPosicion('D', 5);
			
		Nave naveAColocar = new Lancha();

		tableroDelJuego.agregarNaveHorizontalManualmenteConPosicionDeProa(naveAColocar, posicionDeProaDeLanchaAColocar);
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('E', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('C', 5));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('B', 5));
		
		tableroDelJuego.moverNaves();
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('F', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('E', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 5));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('C', 5));
	
	}
	
	public void testMoverNaveEnElTableroCuandoSeEstaEnLimiteDelTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Posicion posicionDeProaDeLanchaAColocar = tableroDelJuego.obtenerPosicion('J', 5);
		
		Nave naveAColocar = new Lancha();
		
		tableroDelJuego.agregarNaveHorizontalManualmenteConPosicionDeProa(naveAColocar, posicionDeProaDeLanchaAColocar);

		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('J', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('I', 5));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('B', 5));
		
		tableroDelJuego.moverNaves();
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('J', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('I', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('H', 5));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('C', 5));
	
	}

	public void testMoverNaveVerticalmenteEnElTablero() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Posicion posicionDeProaDeLanchaAColocar = tableroDelJuego.obtenerPosicion('D', 5);
			
		Nave naveAColocar = new Lancha();

		tableroDelJuego.agregarNaveVerticalManualmenteConPosicionDeProa(naveAColocar, posicionDeProaDeLanchaAColocar);
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('D', 4));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 5));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 6));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('D', 7));
		
		tableroDelJuego.moverNaves();
		
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('D', 3));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 4));
		assertEquals(true, tableroDelJuego.hayComponenteEnPosicion('D', 5));
		assertEquals(false, tableroDelJuego.hayComponenteEnPosicion('D', 6));
	
	}

}
