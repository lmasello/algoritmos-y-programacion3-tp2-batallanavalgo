package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.Destructor;

public class DestructorTest extends TestCase {

	public void testDestructorCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		Destructor destructor = new Destructor();

		assertEquals(false, destructor.estaDestruida());

	}

	public void testDestructorDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		Destructor destructor = new Destructor();
		destructor.destruirNave();

		assertEquals(true, destructor.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeDestructor() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango{
		
		Destructor destructor = new Destructor();
		
		assertEquals(3, destructor.cantidadDeComponentes() );
	}

}
