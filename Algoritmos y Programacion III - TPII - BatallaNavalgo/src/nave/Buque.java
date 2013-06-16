package nave;

import componentesDeTablero.Tablero;

import movimientos.Direccion;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class Buque extends Nave{
	/* Nave compuesta por 4 componentes */
	public Buque() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango{
		
		super();
		
		Resistencia resistenciaAAgregar = new Resistencia(1);
		this.establecerResistenciaDeLaNave(resistenciaAAgregar);
		this.establecerLargoDeLaNave(4);
		
		this.agregarComponentes();
		
	}

	public boolean estaDestruida() throws ValorDeParametroFueraDeRango{
		
	/* Caso especial de nave en el cual si al menos una componente de la nave esta destruida
	 * entonces toda la nave esta destruida
	 *  */
		
		for( int numeroDeComponente = 1; numeroDeComponente <= componentes.cantidadDeComponentes();
			 	numeroDeComponente++){
			if(componentes.obtenerComponente(numeroDeComponente).estaDestruida()){
				return true;
			}
		}
		
		return false;
	}

}
