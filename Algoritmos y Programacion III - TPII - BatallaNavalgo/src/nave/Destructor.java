package nave;

import movimientos.Direccion;
import componentesDeTablero.Tablero;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValoresDeParametroFueraDeRango;

public class Destructor extends Nave{
	/* Nave compuesta por 3 componentes */
	
	public Destructor() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {

		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(3);
		
		this.agregarComponentes();
		
	}

	public boolean esDestructor(){
		
		return true;
	}
}
