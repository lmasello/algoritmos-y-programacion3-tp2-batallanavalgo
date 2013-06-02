package componentesDeTablero;

import colecciones.ColeccionDePosiciones;
import disparos.Disparo;
import excepciones.ValorDeParametroFueraDeRango;

public class RecolectorDePosicionesDeDisparo {
	
	int numeroDePrimeraColumna = (int)'A';
	int numeroDePrimeraFila = 1;
	int numeroDeUltimaColumna;
	int numeroDeUltimaFila;
	Tablero tablero;
	
	public RecolectorDePosicionesDeDisparo(Tablero tableroRecibido) throws ValorDeParametroFueraDeRango{
		/* Constructor del recolector que tiene al tablero como atributo y al numero
		 * ascii correspondiente a la ultima columna y fila 
		 */
		
		tablero = tableroRecibido;
		numeroDeUltimaColumna = (tablero.cantidadDeColumnas() + numeroDePrimeraColumna - 1);
		numeroDeUltimaFila = tablero.cantidadDeFilas();
		
	}	
	
	
	public ColeccionDePosiciones obtenerPosicionesDeDisparo(Posicion posicion,Disparo disparo) throws ValorDeParametroFueraDeRango{
		/*Devuelve una coleccion con las posiciones de las posicion afectadas por el disparo.
		 * Metodo de resolucion -> obtiene una posicion correspondiente a la esquina superior izquierda
		 * y una a la esquina inferior derecha respecto a la posicion recibida y al rango, con esos datos
		 * puede recorrer las posiciones que involucran el rango.
		 * ej.
		 * 		S= esquina superior izquierda
		 * 		I= esquina inferior derecha
		 * 		radio = 1
		 * 		P= posicion
		 * 
		 * 		. S . . .
		 * 		. . P . .
		 * 		. . . I .
		 */
		ColeccionDePosiciones coleccionDePosiciones;
		
		int radioDeDisparo = disparo.obtenerRadioDeDisparo();
		int filaDeLaPosicion = posicion.filaDeLaPosicion();
		int numeroDeColumnaDeLaPosicion = (int)posicion.columnaDeLaPosicion();
		
		Posicion esquinaSuperiorIzquierda = this.obtenerEsquinaSuperiorIzquierda(filaDeLaPosicion,numeroDeColumnaDeLaPosicion,radioDeDisparo);
		Posicion esquinaInferiorDerecha = this.obtenerEsquinaInferiorDerecha(filaDeLaPosicion,numeroDeColumnaDeLaPosicion,radioDeDisparo);
		
		coleccionDePosiciones = recolectarPosiciones(esquinaSuperiorIzquierda, esquinaInferiorDerecha);
		
		return coleccionDePosiciones;
		
	}
		
	private Posicion obtenerEsquinaSuperiorIzquierda(int numeroDeFila, int numeroDeColumna, int radio) throws ValorDeParametroFueraDeRango{
		
		int numeroDeColumnaValida = numeroDeColumna - radio;
		int numeroDeFilaValida = numeroDeFila - radio;
		
		while(numeroDeColumnaValida < numeroDePrimeraColumna){
			numeroDeColumnaValida ++;
		}
		
		while(numeroDeFilaValida < numeroDePrimeraFila){
			numeroDeFilaValida ++;
		}
		
		Posicion posicionEsquina = tablero.obtenerPosicion((char)numeroDeColumnaValida,numeroDeFilaValida);
		
		return posicionEsquina;
	}
	
	
	private Posicion obtenerEsquinaInferiorDerecha(int numeroDeFila, int numeroDeColumna, int radio) throws ValorDeParametroFueraDeRango{
		
		int numeroDeColumnaValida = numeroDeColumna + radio;
		int numeroDeFilaValida = numeroDeFila + radio;
		
		while(numeroDeColumnaValida > numeroDeUltimaColumna){
			numeroDeColumnaValida --;
		}
		
		while(numeroDeFilaValida > numeroDeUltimaFila){
			numeroDeFilaValida --;
		}
		
		
		Posicion posicionEsquina = tablero.obtenerPosicion((char)numeroDeColumnaValida,numeroDeFilaValida);
		
		return posicionEsquina;
	
	}
	
	private ColeccionDePosiciones recolectarPosiciones(Posicion esquinaSuperiorIzquierda,Posicion esquinaInferiorDerecha) throws ValorDeParametroFueraDeRango{
		
		int desdeColumna = (int)esquinaSuperiorIzquierda.columnaDeLaPosicion();
		int hastaColumna = (int)esquinaInferiorDerecha.columnaDeLaPosicion();
		int desdeFila = esquinaSuperiorIzquierda.filaDeLaPosicion();
		int hastaFila = esquinaInferiorDerecha.filaDeLaPosicion();
		
		ColeccionDePosiciones coleccionDePosiciones = new ColeccionDePosiciones();
		
		for (int indiceColumna=desdeColumna; indiceColumna<=hastaColumna; indiceColumna++){
			
			for (int indiceFila=desdeFila; indiceFila<=hastaFila; indiceFila++){
				
				coleccionDePosiciones.agregarPosicion(tablero.obtenerPosicion((char)indiceColumna, indiceFila));
			}
		}
		
		return coleccionDePosiciones;
	
	}
	
}
