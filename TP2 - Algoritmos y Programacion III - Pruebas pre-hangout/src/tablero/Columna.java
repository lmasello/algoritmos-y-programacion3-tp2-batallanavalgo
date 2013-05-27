package tablero;

import tiposDeDatosAbstractos.ColeccionDePosiciones;

public class Columna {

	ColeccionDePosiciones posicionesDeLaColumna;
	
	public Columna(){
		posicionesDeLaColumna = new ColeccionDePosiciones();
	}
	
	public void numeroDePosicionesDeLaColumna(int cantidadDePosiciones) {
		
		for(int numeroDePosicionActual=1 ; numeroDePosicionActual <= cantidadDePosiciones ; numeroDePosicionActual++){
			
			Posicion posicionAAgregar = new Posicion();
			posicionesDeLaColumna.agregarPosicion(posicionAAgregar);
		}
		
	}

	public int cantidadDePosiciones() {
		
		return posicionesDeLaColumna.cantidadDePosiciones();
	}

	public Posicion obtenerPosicionDeFila(int filaBuscada) {
		
		return posicionesDeLaColumna.obtenerPosicionDeLaFila(filaBuscada);
		
	}

}
