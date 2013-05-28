package pruebasUnitarias;

import junit.framework.TestCase;


import nave.ComponenteDeNave;;

public class ComponenteDeNaveTest extends TestCase {
	
	public void testNoEstaDestruidaComponenteDeNaveAlCrearse(){
		
		ComponenteDeNave componente = new ComponenteDeNave(1);
		
		assertEquals ( false , componente.estaDestruida() );
		
	}
	
	public void testDispararComponenteConResistencia1(){
		
		ComponenteDeNave componente = new ComponenteDeNave(1);
		componente.disparoAComponente();
		
		assertEquals ( true , componente.estaDestruida() );
		
	}
	
	public void testDispararComponenteConResistencia2(){
		
		ComponenteDeNave componente = new ComponenteDeNave(2);
		componente.disparoAComponente();
		
		assertEquals (false , componente.estaDestruida() );
		
		componente.disparoAComponente();
		
		assertEquals (true , componente.estaDestruida() );
	}
	
	public void testDestruirComponente(){
		
		ComponenteDeNave componente = new ComponenteDeNave(2);
		componente.destruirComponente();
		
		assertEquals (true , componente.estaDestruida() );
	}
	

}
