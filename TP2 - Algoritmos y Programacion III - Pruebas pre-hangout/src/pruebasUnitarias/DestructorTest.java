package pruebasUnitarias;

import junit.framework.TestCase;
import nave.Destructor;

public class DestructorTest extends TestCase {

	public void testDestructorCrearYVerQueNoEstaDestruida() {

		Destructor destructor = new Destructor();

		assertEquals(false, destructor.estaDestruida());

	}

	public void testDestructorDestruir() {

		Destructor destructor = new Destructor();
		destructor.destruirNave();

		assertEquals(true, destructor.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeDestructor(){
		
		Destructor destructor = new Destructor();
		
		assertEquals(3, destructor.cantidadDeComponentes() );
	}

}
