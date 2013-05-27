package tablero;

import tiposDeDatosAbstractos.ColeccionDeColumnas;

public class Tablero {

	ColeccionDeColumnas columnasDelTablero;
	
	public Tablero(int cantidadDeColumnas , int cantidadDeFilas){
	/*
	 * Constructor de la clase. Inicializa la clase Tablero con una cantidad determinada de columnas y filas.
	 * A su vez, inicializa el tablero colocando arbitrariamente a las naves del juego.
	 * Precondiciones:
	 * 		cantidadDeColumnas y cantidadDeFilas deben ser mayores a 0.
	 */
		
		columnasDelTablero = this.inicializarColumnasConFilas(cantidadDeColumnas , cantidadDeFilas);
		this.colocarNavesEnElTablero();		
	}
	
	private void colocarNavesEnElTablero() {
		
	}

	private ColeccionDeColumnas inicializarColumnasConFilas(int cantidadDeColumnas, int cantidadDePosiciones) {
		
		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();
		
		for(int numeroDeColumnaActual=1 ; numeroDeColumnaActual<=cantidadDeColumnas ; numeroDeColumnaActual++){
			
			Columna columnaAAgregar = new Columna();
			columnaAAgregar.numeroDePosicionesDeLaColumna(cantidadDePosiciones);
			
			unaColeccion.agregarColumna(columnaAAgregar);		
		}
		
		return unaColeccion;
		
	}

	public Posicion obtenerPosicion(char columnaBuscada , int filaBuscada){
		
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
