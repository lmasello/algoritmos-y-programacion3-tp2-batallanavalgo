package componentesDeTablero;

import colecciones.ColeccionDeComponentes;
import colecciones.ColeccionDeDisparos;

public class Posicion {
	
	ColeccionDeComponentes componentesDeNaveEnPosicion;
	ColeccionDeDisparos disparosEnPosicion;
	
	public ColeccionDeComponentes obtenerComoponentesEnPosicion(){
	/* Devuelve la lista de componentes de naves en la posicion */
		
		return componentesDeNaveEnPosicion;
		
	}
	
	public ColeccionDeDisparos obtenerDisparosEnPosicion(){
	/* Devuelve la lista de disparos en la posicion */
		
		return disparosEnPosicion;
		
	}
	
}
