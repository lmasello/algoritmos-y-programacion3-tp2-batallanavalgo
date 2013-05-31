package colecciones;

import java.util.ArrayList;

import disparos.Disparo;

public class ColeccionDeDisparos {

	ArrayList<Disparo> coleccionDeDisparos;

	public ColeccionDeDisparos() {

		coleccionDeDisparos = new ArrayList<Disparo>();
	}

	public void agregarDisparo(Disparo disparo) {

		coleccionDeDisparos.add(disparo);

	}
	
	public Disparo obtenerDisparoDeIndice(int indice){
		
		return coleccionDeDisparos.get(indice);
	}
	
	public int cantidadDeDisparos(){
		
		return coleccionDeDisparos.size();
	}

	public void quitarDisparo(Disparo disparo) {
		
		coleccionDeDisparos.remove(disparo);
	}

}
