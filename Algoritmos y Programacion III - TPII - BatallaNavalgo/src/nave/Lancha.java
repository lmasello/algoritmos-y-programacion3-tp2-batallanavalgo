package nave;

import excepciones.LargoDeNaveIncorrecto;

public class Lancha extends Nave {

	public Lancha() throws LargoDeNaveIncorrecto {

		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(2);
		
		this.agregarComponentes();
			
	}

}
