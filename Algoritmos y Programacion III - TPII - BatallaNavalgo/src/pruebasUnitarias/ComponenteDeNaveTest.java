package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;

import nave.ComponenteDeNave;
import nave.Lancha;
import nave.Nave;
import nave.Resistencia;

;

public class ComponenteDeNaveTest extends TestCase {

	public void testNoEstaDestruidaComponenteDeNaveAlCrearse() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {
		
		Nave nave1 = new Lancha();
		ComponenteDeNave componente = nave1.obtenerComponenteDeNumero(1);

		assertEquals(false, componente.estaDestruida());

	}

	public void testDispararComponenteConResistencia1() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {
		
		Nave nave1 = new Lancha();
		ComponenteDeNave componente = nave1.obtenerComponenteDeNumero(1);
		componente.disparoAComponente();

		assertEquals(true, componente.estaDestruida());

	}

	public void testDispararComponenteConResistencia2() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {

		Nave nave1 = new Lancha();
		ComponenteDeNave componente = nave1.obtenerComponenteDeNumero(1);
		componente.disparoAComponente();

		assertEquals(false, componente.estaDestruida());

		componente.disparoAComponente();

		assertEquals(true, componente.estaDestruida());
	}

	public void testDestruirComponente() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {
		
		Nave nave1 = new Lancha();
		ComponenteDeNave componente = nave1.obtenerComponenteDeNumero(1);
		componente.destruirComponente();

		assertEquals(true, componente.estaDestruida());
	}

}
