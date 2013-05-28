package pruebasUnitarias;

import junit.framework.TestCase;
import nave.Resistencia;

public class ResistenciaTest extends TestCase {
	
	public void testCrearResistenciaNivel2YDisminuir(){
		
		Resistencia resistencia = new Resistencia(2);
		assertEquals (2 , resistencia.obtenerResistencia() );
		
		resistencia.disminuir();
		
		assertEquals (1 , resistencia.obtenerResistencia() );
		
		resistencia.disminuir();
		
		assertEquals (0 , resistencia.obtenerResistencia() );
		
		resistencia.disminuir();
		
		assertEquals (0 , resistencia.obtenerResistencia() );
	}
	
	public void testDestruirResistencia() {
		
		Resistencia resistencia = new Resistencia(2);
		resistencia.debilitar();
		
		assertEquals (0, resistencia.obtenerResistencia() );
		
	}

}
