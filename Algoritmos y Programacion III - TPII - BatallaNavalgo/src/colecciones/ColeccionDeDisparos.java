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

}
