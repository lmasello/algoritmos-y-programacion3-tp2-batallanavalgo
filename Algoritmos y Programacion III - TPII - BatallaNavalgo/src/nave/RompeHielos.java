package nave;

import excepciones.LargoDeNaveIncorrecto;

public class RompeHielos extends Nave {
	
	public RompeHielos() throws LargoDeNaveIncorrecto {
			
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(2);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(3);
		
		this.agregarComponentes();
		
	}


}
