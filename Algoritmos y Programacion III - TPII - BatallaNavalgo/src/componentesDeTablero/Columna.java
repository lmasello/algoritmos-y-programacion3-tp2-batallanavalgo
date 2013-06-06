package componentesDeTablero;

import colecciones.ColeccionDePosiciones;

public class Columna {

	ColeccionDePosiciones posicionesDeLaColumna;
	char identificador;

	public Columna() {
		posicionesDeLaColumna = new ColeccionDePosiciones();
	}

	public void numeroDePosicionesDeLaColumna(int cantidadDePosiciones) {
		/* Agrega tantas posiciones como cantidadDePosiciones haya recibido
		 * como parametro en la coleccion posicionesDelaColumna	 */

		for (int numeroDePosicionActual = 1; numeroDePosicionActual <= cantidadDePosiciones; numeroDePosicionActual++) {

			Posicion posicionAAgregar = new Posicion();
			
			posicionAAgregar.setColumna(this.idColumna());
			posicionAAgregar.setFila(numeroDePosicionActual);
			
			posicionesDeLaColumna.agregarPosicion(posicionAAgregar);
		}

	}

	private char idColumna() {
		/* Devuelve la letra correspondiente a la columna misma */
		return identificador;
	}

	public int cantidadDePosiciones() {

		return posicionesDeLaColumna.cantidadDePosiciones();
	}

	public Posicion obtenerPosicionDeFila(int filaBuscada) {
		/* Devuelve la posicion de la fila recibida como parametro*/

		return posicionesDeLaColumna.obtenerPosicionDeLaFila(filaBuscada);

	}

	public void setIdentificadorDeColumna(char identificadorDeColumna) {
		/* Identifica la letra de la columna con el char recibido como parametro*/
		identificador = identificadorDeColumna;
	}

}
