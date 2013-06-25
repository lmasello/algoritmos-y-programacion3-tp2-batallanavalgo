package nave;

import java.awt.Color;

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
	
	public Color getColor(){
		
		return Color.green;
	}
	
	@Override
	public int getX() {
		return 1*15;
	}

	@Override
	public int getY() {
		return 10*11;
	}

}
