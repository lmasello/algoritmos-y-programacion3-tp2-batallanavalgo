package nave;

import excepciones.LargoDeNaveIncorrecto;

public class PortaAviones extends Nave {
	
	public PortaAviones() throws LargoDeNaveIncorrecto {
		
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(5);
		
		this.agregarComponentes();
		
	}


}
