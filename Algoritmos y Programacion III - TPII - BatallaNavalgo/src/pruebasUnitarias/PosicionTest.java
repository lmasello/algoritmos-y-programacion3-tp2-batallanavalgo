package pruebasUnitarias;

import nave.ComponenteDeNave;
import nave.Lancha;
import nave.Nave;
import nave.Resistencia;
import componentesDeTablero.Posicion;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;

import junit.framework.TestCase;

public class PosicionTest extends TestCase {
	
	public void testSetearPosicionFilaYColumna(){
		
		Posicion posicion = new Posicion();
		int fila = 3;
		char columna = 'C';
		posicion.setFila(fila);
		posicion.setColumna(columna);
		
		assertEquals ( fila , posicion.filaDeLaPosicion() );
		assertEquals ( columna , posicion.columnaDeLaPosicion());
		
	}
	
	public void testAgregarComponentes () throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto{
		
		Posicion posicion = new Posicion();
		Resistencia resistencia1 = new Resistencia(2);
		Resistencia resistencia2 = new Resistencia(5);
		Nave nave1 = new Lancha();
		
		ComponenteDeNave componente1 = new ComponenteDeNave(resistencia1,nave1);
		ComponenteDeNave componente2 = new ComponenteDeNave(resistencia2,nave1);
		
		posicion.agregarComponenteAPosicion(componente1);
		posicion.agregarComponenteAPosicion(componente2);
		
		assertEquals ( componente1 , (posicion.obtenerComponentesEnPosicion()).obtenerComponente(1));
		assertEquals ( componente2 , (posicion.obtenerComponentesEnPosicion()).obtenerComponente(2));
		
	}
	
	public void testLuegoDeAgregarUnaComponenteDeberiaDarVerdaderoElMetodoDeSiTieneComponente() throws LargoDeNaveIncorrecto{
		Posicion posicion = new Posicion();
		Nave nave1 = new Lancha();
		
		Resistencia resistencia1 = new Resistencia(2);
		ComponenteDeNave componente1 = new ComponenteDeNave(resistencia1,nave1);

		posicion.agregarComponenteAPosicion(componente1);
		
		assertEquals(true , posicion.tieneComponenteDeNave());
	}
	
	public void testBorrarUnaComponente() throws LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
		
		Posicion posicion = new Posicion();
		Nave nave1 = new Lancha();
		Resistencia resistencia1 = new Resistencia(2);
		
		ComponenteDeNave componente1 = new ComponenteDeNave(resistencia1,nave1);

		posicion.agregarComponenteAPosicion(componente1);
		
		assertEquals(1 , posicion.cantidadDeComponentesEnPosicion());
		
		posicion.removerComponente(componente1);
		
		assertEquals(0 , posicion.cantidadDeComponentesEnPosicion());
	}


}
