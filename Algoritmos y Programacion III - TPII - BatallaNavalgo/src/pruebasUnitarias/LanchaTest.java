package pruebasUnitarias;

import excepciones.ValorDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.Lancha;

public class LanchaTest extends TestCase {

	public void testLanchaCrearYVerQueNoEstaDestruida() {

		Lancha lancha = new Lancha();

		assertEquals(false, lancha.estaDestruida());

	}

	public void testLanchaDestruir() throws ValorDeParametroFueraDeRango {

		Lancha lancha = new Lancha();
		lancha.destruirNave();

		assertEquals(true, lancha.estaDestruida());
	}

}