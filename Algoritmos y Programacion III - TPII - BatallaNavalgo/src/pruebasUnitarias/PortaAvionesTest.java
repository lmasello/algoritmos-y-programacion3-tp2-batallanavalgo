package pruebasUnitarias;

import excepciones.ValorDeParametroFueraDeRango;
import junit.framework.TestCase;
import nave.PortaAviones;

public class PortaAvionesTest extends TestCase {

	public void testPortaAvionesCrearYVerQueNoEstaDestruida() {

		PortaAviones portaAviones = new PortaAviones();

		assertEquals(false, portaAviones.estaDestruida());

	}

	public void testPortaAvionesDestruir() throws ValorDeParametroFueraDeRango {

		PortaAviones portaAviones = new PortaAviones();
		portaAviones.destruirNave();

		assertEquals(true, portaAviones.estaDestruida());
	}
	
	public void testCantidadDeComponentesDePortaAviones(){
		
		PortaAviones portaAviones = new PortaAviones();
		
		assertEquals(5, portaAviones.cantidadDeComponentes() );
	}

}
