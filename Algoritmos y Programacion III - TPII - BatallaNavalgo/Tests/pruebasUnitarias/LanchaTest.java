package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.Lancha;

public class LanchaTest extends TestCase {

	public void testLanchaCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		Lancha lancha = new Lancha();

		assertEquals(false, lancha.estaDestruida());

	}

	public void testLanchaDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		Lancha lancha = new Lancha();
		lancha.destruirNave();

		assertEquals(true, lancha.estaDestruida());
	}

}
