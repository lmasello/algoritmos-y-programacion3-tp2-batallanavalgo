package nave;

import java.awt.Color;

import movimientos.Direccion;
import componentesDeTablero.Tablero;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValoresDeParametroFueraDeRango;

public class Lancha extends Nave {
	/* Nave compuesta por 2 componentes */
	public Lancha() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(2);
		
		this.agregarComponentes();
			
	}
	
	public Color getColor(){
		
		return Color.white;
	}
}
