package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.RompeHielos;

public class RompeHielosTest extends TestCase {

	public void testRompeHielosCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		RompeHielos rompeHielos = 
				new RompeHielos();

		assertEquals(false, rompeHielos.estaDestruida());

	}

	public void testRompeHielosDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		RompeHielos rompeHielos = new RompeHielos();
		rompeHielos.destruirNave();

		assertEquals(true, rompeHielos.estaDestruida());
	}
	
	public void testCantidadDeComponentesDeRompeHielos() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango{
		
		RompeHielos rompeHielos = new RompeHielos();
		
		assertEquals(3, rompeHielos.cantidadDeComponentes() );
	}

}

