package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;

import nave.ComponenteDeNave;
import nave.Lancha;
import nave.Nave;
import nave.Resistencia;

;

public class ComponenteDeNaveTest extends TestCase {

	public void testNoEstaDestruidaComponenteDeNaveAlCrearse() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		
		Nave nave1 = new Lancha();
		Resistencia resistenciaDeLaNave = new Resistencia(1);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave,nave1);

		assertEquals(false, componente.estaDestruida());

	}

	public void testDispararComponenteConResistencia1() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		
		Nave nave1 = new Lancha();
		Resistencia resistenciaDeLaNave = new Resistencia(1);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave,nave1);
		componente.disparoAComponente();

		assertEquals(true, componente.estaDestruida());

	}

	public void testDispararComponenteConResistencia2() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		Nave nave1 = new Lancha();
		Resistencia resistenciaDeLaNave = new Resistencia(2);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave, nave1);
		componente.disparoAComponente();

		assertEquals(false, componente.estaDestruida());

		componente.disparoAComponente();

		assertEquals(true, componente.estaDestruida());
	}

	public void testDestruirComponente() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		
		Nave nave1 = new Lancha();
		Resistencia resistenciaDeLaNave = new Resistencia(2);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave, nave1);
		componente.destruirComponente();

		assertEquals(true, componente.estaDestruida());
	}

}
