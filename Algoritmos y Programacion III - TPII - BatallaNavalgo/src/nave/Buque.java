package nave;

import excepciones.LargoDeNaveIncorrecto;

public class Buque extends Nave{
	
	public Buque() throws LargoDeNaveIncorrecto{
		
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(4);
		
		this.agregarComponentes();
		
	}


}
