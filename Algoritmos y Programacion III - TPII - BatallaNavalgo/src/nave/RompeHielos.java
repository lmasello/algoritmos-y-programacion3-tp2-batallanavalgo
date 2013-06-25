package nave;

import java.awt.Color;

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

	public Color getColor(){
		
		return Color.DARK_GRAY;
	}
	
	@Override
	public int getX() {
		return 1*15;
	}

	@Override
	public int getY() {
		return 10*14;
	}

}
