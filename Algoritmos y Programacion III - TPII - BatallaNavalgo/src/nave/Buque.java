package nave;

import java.awt.Color;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Buque extends Nave{
	/* Nave compuesta por 4 componentes */
	public Buque() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango{
		
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(4);
		
		this.agregarComponentes();
		
	}
	
	public boolean esBuque(){
		return true;
	}
	
	public Color getColor(){
		
		return Color.orange;
	}

}
