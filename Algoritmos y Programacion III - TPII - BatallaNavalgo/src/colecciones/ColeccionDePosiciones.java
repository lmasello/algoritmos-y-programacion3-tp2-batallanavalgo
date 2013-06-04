package colecciones;

import java.util.ArrayList;

import componentesDeTablero.Posicion;


public class ColeccionDePosiciones {

	ArrayList<Posicion> posicionesDeLaColumna;

	public ColeccionDePosiciones() {

		posicionesDeLaColumna = new ArrayList<Posicion>();
	}

	public void agregarPosicion(Posicion posicionAAgregar) {

		posicionesDeLaColumna.add(posicionAAgregar);
	}

	public Posicion obtenerPosicionDeLaFila(int filaDeLaPosicion) {

		int indiceDeLaPosicion = filaDeLaPosicion - 1;

		if (this.tieneLaPosicion(indiceDeLaPosicion)) {
			Posicion posicionBuscada = posicionesDeLaColumna.get(indiceDeLaPosicion);
			return posicionBuscada;
		}

		return null; // Aqui deberia lanzar excepcion
	}
	

	public boolean seEncuentraLaPosicion(Posicion posicion){
		
		for (int indice=1; indice <= this.cantidadDePosiciones(); indice++){
			if( posicion == this.obtenerPosicionDeLaFila(indice)){
				return true;			
			}
		}
		
		return false;
	}
	
	
	public boolean tieneLaPosicion(int indiceDeLaPosicion) {

		boolean tieneLaPosicion = (indiceDeLaPosicion <= this.cantidadDePosiciones());

		return tieneLaPosicion;
	}

	public int cantidadDePosiciones() {
		return posicionesDeLaColumna.size();
	}

}
