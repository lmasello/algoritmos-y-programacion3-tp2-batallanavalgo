package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.Buque;


public class BuqueTest extends TestCase {

	public void testLanchaCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		Buque buque = new Buque();

		assertEquals(false, buque.estaDestruida());

	}

	public void testBuqueDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		Buque buque = new Buque();
		buque.destruirNave();

		assertEquals(true, buque.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeBuque() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango{
		
		Buque buque = new Buque();
		
		assertEquals(4, buque.cantidadDeComponentes() );
	}

}

