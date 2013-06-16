package pruebasUnitarias;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.PortaAviones;

public class PortaAvionesTest extends TestCase {

	public void testPortaAvionesCrearYVerQueNoEstaDestruida() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {

		PortaAviones portaAviones = new PortaAviones();

		assertEquals(false, portaAviones.estaDestruida());

	}

	public void testPortaAvionesDestruir() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		PortaAviones portaAviones = new PortaAviones();
		portaAviones.destruirNave();

		assertEquals(true, portaAviones.estaDestruida());
	}
	
	public void testCantidadDeComponentesDePortaAviones() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango{
		
		PortaAviones portaAviones = new PortaAviones();
		
		assertEquals(5, portaAviones.cantidadDeComponentes() );
	}

}
