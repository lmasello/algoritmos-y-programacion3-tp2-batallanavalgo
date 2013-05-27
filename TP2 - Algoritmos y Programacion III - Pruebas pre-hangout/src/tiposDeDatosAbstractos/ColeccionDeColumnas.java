package tiposDeDatosAbstractos;

import java.util.ArrayList;

import tablero.Columna;

public class ColeccionDeColumnas {
	
	ArrayList<Columna> coleccionDeColumnas;
	
	public ColeccionDeColumnas(){
		
		coleccionDeColumnas = new ArrayList<Columna>();
		
	}

	public void agregarColumna(Columna columnaAAgregar){
		
		coleccionDeColumnas.add(columnaAAgregar);
		
	}

	public boolean tieneLaColumnaDeIdentificador(char identificadorDeColumnaABuscar){
		
		int valorAsciiDeLaPrimeraColumna = this.convertirAAscii('A');
		int valorAsciiDeLaColumnaBuscada = this.convertirAAscii(identificadorDeColumnaABuscar);
		
		int indiceDeLaColumnaBuscada = valorAsciiDeLaColumnaBuscada - valorAsciiDeLaPrimeraColumna;
		
		//Si el tablero tiene la columna buscada, el indice de la columna buscada deberá ser menor a la cantidad de columnas
		
		boolean tieneLaColumna = (indiceDeLaColumnaBuscada<this.cantidadDeColumnas()); 
				
		return tieneLaColumna;
		
	}
	
	public Columna obtenerLaColumnaDeIndice(char identificadorDeColumnaBuscada){
		
		int valorAsciiDeLaPrimeraColumna = this.convertirAAscii('A');
		int valorAsciiDeLaColumnaBuscada = this.convertirAAscii(identificadorDeColumnaBuscada);
		
		int indiceDeLaColumnaBuscada = valorAsciiDeLaColumnaBuscada - valorAsciiDeLaPrimeraColumna;
		
		Columna columnaBuscada = coleccionDeColumnas.get(indiceDeLaColumnaBuscada);
		
		return columnaBuscada;
		 
		}

	private int convertirAAscii(char valorAConvertir) {
		return (int)valorAConvertir;
	}
	
	public int cantidadDeColumnas(){
		return coleccionDeColumnas.size();
	}

}
