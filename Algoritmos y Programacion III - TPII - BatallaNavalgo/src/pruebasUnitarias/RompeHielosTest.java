package pruebasUnitarias;

import junit.framework.TestCase;
import nave.RompeHielos;

public class RompeHielosTest extends TestCase {

	public void testRompeHielosCrearYVerQueNoEstaDestruida() {

		RompeHielos rompeHielos = new RompeHielos();

		assertEquals(false, rompeHielos.estaDestruida());

	}

	public void testRompeHielosDestruir() {

		RompeHielos rompeHielos = new RompeHielos();
		rompeHielos.destruirNave();

		assertEquals(true, rompeHielos.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeRompeHielos(){
		
		RompeHielos rompeHielos = new RompeHielos();
		
		assertEquals(3, rompeHielos.cantidadDeComponentes() );
	}

}

