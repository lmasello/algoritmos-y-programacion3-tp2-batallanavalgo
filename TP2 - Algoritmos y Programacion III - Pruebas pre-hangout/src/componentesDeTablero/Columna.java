package componentesDeTablero;

import colecciones.ColeccionDePosiciones;

public class Columna {

	ColeccionDePosiciones posicionesDeLaColumna;
	char identificador;

	public Columna() {
		posicionesDeLaColumna = new ColeccionDePosiciones();
	}

	public void numeroDePosicionesDeLaColumna(int cantidadDePosiciones) {

		for (int numeroDePosicionActual = 1; numeroDePosicionActual <= cantidadDePosiciones; numeroDePosicionActual++) {

			Posicion posicionAAgregar = new Posicion();
			
			posicionAAgregar.setColumna(this.idColumna());
			posicionAAgregar.setFila(numeroDePosicionActual);
			
			posicionesDeLaColumna.agregarPosicion(posicionAAgregar);
		}

	}

	private char idColumna() {
		return identificador;
	}

	public int cantidadDePosiciones() {

		return posicionesDeLaColumna.cantidadDePosiciones();
	}

	public Posicion obtenerPosicionDeFila(int filaBuscada) {

		return posicionesDeLaColumna.obtenerPosicionDeLaFila(filaBuscada);

	}

	public void setIdentificadorDeColumna(char identificadorDeColumna) {
		identificador = identificadorDeColumna;
	}

}
