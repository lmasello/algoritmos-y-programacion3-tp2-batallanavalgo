package pruebasDeEstructurasDeColecciones;

import nave.ComponenteDeNave;
import nave.Lancha;
import nave.Nave;
import nave.Resistencia;
import junit.framework.TestCase;
import colecciones.ColeccionDeComponentes;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;

public class ColeccionDeComponentesTest extends TestCase {
	

	public void testCrearColeccionDeComponentes	(){
		
		ColeccionDeComponentes coleccionDeComponentes = new ColeccionDeComponentes(); 
		
		assertNotNull(coleccionDeComponentes);
		assertEquals(false, coleccionDeComponentes.tieneComponente());
	}
	
	public void testAgregarComponentes() throws LargoDeNaveIncorrecto{
		
		ColeccionDeComponentes coleccionDeComponentes = new ColeccionDeComponentes(); 
		Resistencia resistenciaUno = new Resistencia(3);
		Resistencia resistenciaDos = new Resistencia(2);
		Nave naveDePrueba = new Lancha();
		ComponenteDeNave componenteUno = new ComponenteDeNave(resistenciaUno, naveDePrueba);
		ComponenteDeNave componenteDos = new ComponenteDeNave(resistenciaDos, naveDePrueba);
		
		coleccionDeComponentes.agregarComponente(componenteUno);
		
		assertEquals( 1 , coleccionDeComponentes.cantidadDeComponentes());
		
		coleccionDeComponentes.agregarComponente(componenteDos);
		
		assertEquals( true, coleccionDeComponentes.tieneComponente());
		assertEquals( 2 , coleccionDeComponentes.cantidadDeComponentes());
	
	}
	
	public void testObtenerComponentes() throws LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango{
		
		ColeccionDeComponentes coleccionDeComponentes = new ColeccionDeComponentes(); 
		Resistencia resistenciaUno = new Resistencia(3);
		Resistencia resistenciaDos = new Resistencia(2);
		Nave naveDePrueba = new Lancha();
		ComponenteDeNave componenteUno = new ComponenteDeNave(resistenciaUno, naveDePrueba);
		ComponenteDeNave componenteDos = new ComponenteDeNave(resistenciaDos, naveDePrueba);
		
		coleccionDeComponentes.agregarComponente(componenteUno);
		coleccionDeComponentes.agregarComponente(componenteDos);
		
		assertEquals( componenteUno, coleccionDeComponentes.obtenerComponente(1));
		assertEquals( componenteDos, coleccionDeComponentes.obtenerComponente(2));
		
		
	}
	
	public void testQuitarComponentes() throws LargoDeNaveIncorrecto{
		
		ColeccionDeComponentes coleccionDeComponentes = new ColeccionDeComponentes(); 
		Resistencia resistenciaUno = new Resistencia(3);
		Resistencia resistenciaDos = new Resistencia(2);
		Nave naveDePrueba = new Lancha();
		ComponenteDeNave componenteUno = new ComponenteDeNave(resistenciaUno, naveDePrueba);
		ComponenteDeNave componenteDos = new ComponenteDeNave(resistenciaDos, naveDePrueba);
		
		coleccionDeComponentes.agregarComponente(componenteUno);
		coleccionDeComponentes.agregarComponente(componenteDos);
		
		coleccionDeComponentes.quitarComponente(componenteUno);
		
		assertEquals( 1, coleccionDeComponentes.cantidadDeComponentes());
		
		coleccionDeComponentes.quitarComponente(componenteDos);
		
		assertEquals( 0, coleccionDeComponentes.cantidadDeComponentes());
		assertEquals( false, coleccionDeComponentes.tieneComponente());
		
	}
}


