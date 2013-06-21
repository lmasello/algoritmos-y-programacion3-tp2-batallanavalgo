package colecciones;

import java.util.ArrayList;

import componentesDeTablero.Columna;
import excepciones.ValorDeParametroFueraDeRango;


public class ColeccionDeColumnas {

	ArrayList<Columna> coleccionDeColumnas;

	public ColeccionDeColumnas() {

		coleccionDeColumnas = new ArrayList<Columna>();

	}

	public void agregarColumna(Columna columnaAAgregar) {
	/*
	 * Agrega una Columna al final de la coleccion
	 */
		coleccionDeColumnas.add(columnaAAgregar);

	}

	public boolean tieneLaColumnaDeIdentificador(char identificadorDeColumnaABuscar) {
	/*
	 * Evalua si la coleccion posee una columna referenciada con un identificador, el cual es pasado por parametro
	 */
		int valorAsciiDeLaPrimeraColumna = this.convertirAAscii('A');
		int valorAsciiDeLaColumnaBuscada = this.convertirAAscii(identificadorDeColumnaABuscar);

		int indiceDeLaColumnaBuscada = valorAsciiDeLaColumnaBuscada	- valorAsciiDeLaPrimeraColumna;

		// Si el tablero tiene la columna buscada, el indice de la columna buscada debera ser mayor o igual
		// a indice de la primera columna

		boolean tieneLaColumna = (indiceDeLaColumnaBuscada < this.cantidadDeColumnas())&(indiceDeLaColumnaBuscada>=0);

		return tieneLaColumna;

	}

	public Columna obtenerLaColumnaDeIndice(char identificadorDeColumnaBuscada) throws ValorDeParametroFueraDeRango {
	/*
	 * Devuelve una instancia de Columna, de acuerdo al identificador pasado por parametro
	 * Precondiciones:
	 * 		identificadorDeColumnaBuscada debe ser mayor o igual al identificador de la primera columna y menor o igual al identificador de la ultima columna
	 */
	
		int valorAsciiDeLaPrimeraColumna = this.convertirAAscii('A');
		int valorAsciiDeLaUltimaColumna = valorAsciiDeLaPrimeraColumna + this.cantidadDeColumnas()-1;
		
		int valorAsciiDeLaColumnaBuscada = this.convertirAAscii(identificadorDeColumnaBuscada);
		
		if((valorAsciiDeLaColumnaBuscada<valorAsciiDeLaPrimeraColumna)|(valorAsciiDeLaColumnaBuscada>valorAsciiDeLaUltimaColumna)){
			throw new ValorDeParametroFueraDeRango();
		}
		
		int indiceDeLaColumnaBuscada = valorAsciiDeLaColumnaBuscada	- valorAsciiDeLaPrimeraColumna;

		Columna columnaBuscada = coleccionDeColumnas.get(indiceDeLaColumnaBuscada);

		return columnaBuscada;

	}

	private int convertirAAscii(char valorAConvertir) {
		return (int) valorAConvertir;
	}

	public int cantidadDeColumnas() {
		return coleccionDeColumnas.size();
	}

	public boolean tieneFila(int unaFila) {
		
		Columna unaColumna = coleccionDeColumnas.get(1);
		return((unaFila>=1) & (unaFila<unaColumna.cantidadDePosiciones()));
		
	}

}
