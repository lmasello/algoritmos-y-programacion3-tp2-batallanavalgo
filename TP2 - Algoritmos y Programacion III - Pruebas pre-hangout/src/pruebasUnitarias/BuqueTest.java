package pruebasUnitarias;

import junit.framework.TestCase;
import nave.Buque;


public class BuqueTest extends TestCase {

	public void testLanchaCrearYVerQueNoEstaDestruida() {

		Buque buque = new Buque();

		assertEquals(false, buque.estaDestruida());

	}

	public void testBuqueDestruir() {

		Buque buque = new Buque();
		buque.destruirNave();

		assertEquals(true, buque.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeBuque(){
		
		Buque buque = new Buque();
		
		assertEquals(4, buque.cantidadDeComponentes() );
	}

}

