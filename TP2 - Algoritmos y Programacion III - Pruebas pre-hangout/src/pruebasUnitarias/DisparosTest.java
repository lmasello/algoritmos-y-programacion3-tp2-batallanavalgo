package pruebasUnitarias;

import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import disparos.MinaSubmarinaPorContacto;
import disparos.MinaSubmarinaPuntual;
import disparos.MinaSubmarinaTriple;
import junit.framework.TestCase;


public class DisparosTest extends TestCase {
	
	public void testDisparoConvencional(){
		
		Disparo disparo1 = new DisparoConvencional();
		
		assertEquals(200, disparo1.obtenerCosto());
	}
	
	public void testDisparoMinaSubmarinaPuntual(){
		
		Disparo disparo2 = new MinaSubmarinaPuntual();
		
		assertEquals(50, disparo2.obtenerCosto());
		
		
	}
	
	public void testDisparoMinaSubmarinaDoble(){
		
		Disparo disparo3 = new MinaSubmarinaDoble();
		
		assertEquals(100, disparo3.obtenerCosto());
		
	}
	
	public void testDisparoMinaSubmarinaTriple(){
		
		Disparo disparo4 = new MinaSubmarinaTriple();
		
		assertEquals(125, disparo4.obtenerCosto());
			
	}
	
	public void testDisparoMinaSubmarinaPorContacto(){
		
		Disparo disparo5 = new MinaSubmarinaPorContacto();
		
		assertEquals(150, disparo5.obtenerCosto());
		
	}

}
