package colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import disparos.Disparo;

public class ColeccionDeDisparos {

	ArrayList<Disparo> coleccionDeDisparos;

	public ColeccionDeDisparos() {

		coleccionDeDisparos = new ArrayList<Disparo>();
	}

	public void agregarDisparo(Disparo disparo) {
		/* Agrega el disparo recibido por parametro al 
		 * final de la coleccion	 */

		coleccionDeDisparos.add(disparo);

	}
	
	public Disparo obtenerDisparoDeIndice(int indice){
		/* Devuelve el disparo de la coleccion respecto del indice
		 * recibido  */
		
		return coleccionDeDisparos.get(indice);
	}
	
	public int cantidadDeDisparos(){
		
		return coleccionDeDisparos.size();
	}

	public void quitarDisparo(Disparo disparo) {
		/* Elimina el disparo recibido en la coleccion,
		 * si no se encuentra no hace nada	 */
		
		coleccionDeDisparos.remove(disparo);
	}
	
	public boolean noEstaVacia(){
		
		return (!coleccionDeDisparos.isEmpty());
	}

	public Iterator<Disparo> iterator() {
		
		return coleccionDeDisparos.iterator();
	}

}
