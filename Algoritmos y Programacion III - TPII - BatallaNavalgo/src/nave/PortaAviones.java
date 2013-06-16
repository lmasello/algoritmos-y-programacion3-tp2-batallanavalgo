package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValoresDeParametroFueraDeRango;

public class PortaAviones extends Nave {
	/* Nave compuesta por 5 componentes */
	
	public PortaAviones() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(5);
		
		this.agregarComponentes();
		
	}


}
