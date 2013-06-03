package pruebasUnitarias;

import junit.framework.TestCase;

import nave.ComponenteDeNave;
import nave.Resistencia;

;

public class ComponenteDeNaveTest extends TestCase {

	public void testNoEstaDestruidaComponenteDeNaveAlCrearse() {

		Resistencia resistenciaDeLaNave = new Resistencia(1);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave);

		assertEquals(false, componente.estaDestruida());

	}

	public void testDispararComponenteConResistencia1() {

		Resistencia resistenciaDeLaNave = new Resistencia(1);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave);
		componente.disparoAComponente();

		assertEquals(true, componente.estaDestruida());

	}

	public void testDispararComponenteConResistencia2() {

		Resistencia resistenciaDeLaNave = new Resistencia(2);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave);
		componente.disparoAComponente();

		assertEquals(false, componente.estaDestruida());

		componente.disparoAComponente();

		assertEquals(true, componente.estaDestruida());
	}

	public void testDestruirComponente() {

		Resistencia resistenciaDeLaNave = new Resistencia(2);
		ComponenteDeNave componente = new ComponenteDeNave(resistenciaDeLaNave);
		componente.destruirComponente();

		assertEquals(true, componente.estaDestruida());
	}

}
