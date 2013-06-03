package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.Destructor;

public class DestructorTest extends TestCase {

	public void testDestructorCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango {

		Destructor destructor = new Destructor();

		assertEquals(false, destructor.estaDestruida());

	}

	public void testDestructorDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto {

		Destructor destructor = new Destructor();
		destructor.destruirNave();

		assertEquals(true, destructor.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeDestructor() throws LargoDeNaveIncorrecto{
		
		Destructor destructor = new Destructor();
		
		assertEquals(3, destructor.cantidadDeComponentes() );
	}

}
