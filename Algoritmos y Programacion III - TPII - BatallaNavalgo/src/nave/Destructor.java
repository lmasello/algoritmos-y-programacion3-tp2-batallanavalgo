package nave;

import movimientos.Direccion;
import componentesDeTablero.Tablero;
import disparos.Disparo;

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
	public boolean puedeRecibirDisparoDe(Disparo disparo){
		/* La nave destructor solo puede ser afectada por un disparo convencional,
		 * por lo tanto devuelve verdadero para cuando lo es, y falso cuando no lo es
		 */
			return(disparo.esDisparoConvencional());
		}
}
