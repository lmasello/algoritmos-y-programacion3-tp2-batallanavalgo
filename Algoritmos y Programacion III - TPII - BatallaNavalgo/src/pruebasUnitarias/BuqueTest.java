package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.Buque;


public class BuqueTest extends TestCase {

	public void testLanchaCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto {

		Buque buque = new Buque();

		assertEquals(false, buque.estaDestruida());

	}

	public void testBuqueDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Buque buque = new Buque();
		buque.destruirNave();

		assertEquals(true, buque.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeBuque() throws LargoDeNaveIncorrecto{
		
		Buque buque = new Buque();
		
		assertEquals(4, buque.cantidadDeComponentes() );
	}

}

