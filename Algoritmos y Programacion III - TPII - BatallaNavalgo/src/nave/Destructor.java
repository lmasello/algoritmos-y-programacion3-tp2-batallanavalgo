package nave;

import excepciones.LargoDeNaveIncorrecto;

public class Destructor extends Nave{
	
	public Destructor() throws LargoDeNaveIncorrecto {

		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(3);
		
		this.agregarComponentes();
		
	}

}
