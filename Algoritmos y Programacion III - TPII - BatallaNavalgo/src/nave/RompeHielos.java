package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValoresDeParametroFueraDeRango;

public class RompeHielos extends Nave {
	/* Nave compuesta por 3 componentes */
	
	public RompeHielos() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
			
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(2);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(3);
		
		this.agregarComponentes();
		
	}


}
