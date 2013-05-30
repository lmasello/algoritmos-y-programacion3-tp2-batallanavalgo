package pruebasUnitarias;

import nave.ComponenteDeNave;
import componentesDeTablero.Posicion;
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
	
	public void testAgregarComponentes () throws ValorDeParametroFueraDeRango{
		
		Posicion posicion = new Posicion();
		int resistencia1 = 2;
		int resistencia2 = 5;
		
		ComponenteDeNave componente1 = new ComponenteDeNave(resistencia1);
		ComponenteDeNave componente2 = new ComponenteDeNave(resistencia2);
		
		posicion.agregarComponenteAPosicion(componente1);
		posicion.agregarComponenteAPosicion(componente2);
		
		assertEquals ( componente1 , (posicion.obtenerComponentesEnPosicion()).obtenerComponente(1));
		assertEquals ( componente2 , (posicion.obtenerComponentesEnPosicion()).obtenerComponente(2));
		
		
		
	}
	
	

}
