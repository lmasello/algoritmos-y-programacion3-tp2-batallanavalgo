package tablero;

import tiposDeDatosAbstractos.ColeccionDeColumnas;

public class Tablero {

	ColeccionDeColumnas columnasDelTablero;
	
	public Tablero(int cantidadDeColumnas , int cantidadDeFilas){
	/*
	 * Constructor de la clase. Inicializa la clase Tablero con una cantidad determinada de columnas y filas.
	 * A su vez, inicializa el tablero colocando arbitrariamente a las naves del juego.
	 * 
	 * Precondiciones:
	 * 		cantidadDeColumnas y cantidadDeFilas deben ser mayores a 0.
	 */
		
	/*	if((cantidadDeColumnas<=0) & (cantidadDeFilas<=0)){
			levantarExcepcion
		}
	*/	
		columnasDelTablero = this.inicializarColumnasConFilas(cantidadDeColumnas , cantidadDeFilas);
		this.colocarNavesEnElTablero();		
	}
	
	private void colocarNavesEnElTablero() {
		
	}

	private ColeccionDeColumnas inicializarColumnasConFilas(int cantidadDeColumnas, int cantidadDePosiciones) {
	/*
	 * Metodo que crea una instancia de ColeccionDeColumnas, con una cantidad de Columnas de acuerdo a lo estipulado por parametro
	 * En donde cada columna va a contener una cantidad de posiciones estipulada por parametro.
	 * 
	 * Precondiciones:	cantidadDeColumnas y cantidadDePosiciones deben ser mayores a 0.
	 * Postcondiciones: devuelve una instancia de ColeccionDeColumnas
	 */
		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();
		
		for(int numeroDeColumnaActual=1 ; numeroDeColumnaActual<=cantidadDeColumnas ; numeroDeColumnaActual++){
			
			Columna columnaAAgregar = new Columna();
			columnaAAgregar.numeroDePosicionesDeLaColumna(cantidadDePosiciones);
			
			unaColeccion.agregarColumna(columnaAAgregar);		
		}
		
		return unaColeccion;
		
	}

	public Posicion obtenerPosicion(char columnaBuscada , int filaBuscada){
	/*
	 * Metodo que tiene como objetivo obtener una posicion deseada del tablero.
	 * 
	 *  Precondiciones: 
	 *  	columnaBuscada debe corresponder a una columna valida del tablero.
	 *  	filaBuscada debe corresponder a una fila valida del tablero.
	 *  Postcondiciones: devuelve la una instancia de Posicion, de acuerdo a los parametros estipulados por parametro.
	 */
		Columna columnaDeLaPosicionRequerida = columnasDelTablero.obtenerLaColumnaDeIndice(columnaBuscada);
		
		Posicion posicionRequerida = columnaDeLaPosicionRequerida.obtenerPosicionDeFila(filaBuscada);
		
		return posicionRequerida;
	}
		
	public int cantidadDeColumnas() {

		return columnasDelTablero.cantidadDeColumnas();
		
	}

	public int cantidadDeFilas() {
		
		char unIdentificadorDeColumna = 'A';
		Columna unaColumna = columnasDelTablero.obtenerLaColumnaDeIndice(unIdentificadorDeColumna);
		
		return unaColumna.cantidadDePosiciones();	
	}
	
}
