package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.LargoDeNaveIncorrecto;

public class RompeHielos extends Nave {
	/* Nave compuesta por 3 componentes */
	
	public RompeHielos() throws LargoDeNaveIncorrecto {
			
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(2);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(3);
		
		this.agregarComponentes();
		
	}


}
