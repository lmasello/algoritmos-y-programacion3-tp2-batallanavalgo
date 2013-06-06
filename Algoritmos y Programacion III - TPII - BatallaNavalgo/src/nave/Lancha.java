package nave;

import movimientos.Direccion;
import componentesDeTablero.Tablero;

import excepciones.LargoDeNaveIncorrecto;

public class Lancha extends Nave {
	/* Nave compuesta por 2 componentes */
	public Lancha() throws LargoDeNaveIncorrecto {

		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(2);
		
		this.agregarComponentes();
			
	}

}
