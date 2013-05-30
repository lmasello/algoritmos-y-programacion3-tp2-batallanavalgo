package componentesDeTablero;

import nave.ComponenteDeNave;
import colecciones.ColeccionDeComponentes;
import colecciones.ColeccionDeDisparos;
import disparos.Disparo;

public class Posicion {
	
	char columnaDePosicion;
	int filaDePosicion;
	ColeccionDeComponentes componentesDeNaveEnPosicion;
	ColeccionDeDisparos disparosEnPosicion;
	
	public ColeccionDeComponentes obtenerComponentesEnPosicion(){
	/* Devuelve la lista de componentes de naves en la posicion */
		
		return componentesDeNaveEnPosicion;
	}
	
	public ColeccionDeDisparos obtenerDisparosEnPosicion(){
	/* Devuelve la lista de disparos en la posicion */
		
		return disparosEnPosicion;	
	}
	
	public void agregarComponenteAPosicion(ComponenteDeNave componente){
		
		componentesDeNaveEnPosicion.agregarComponente(componente);	
	}
	
	public void agregarDisparoAPosicion(Disparo disparoAAgregar){
		
		disparosEnPosicion.agregarDisparo(disparoAAgregar);
	}
	
	public void setFila(int fila){
		
		filaDePosicion = fila;
	}
	
	public void setColumna(char columna){
		
		columnaDePosicion = columna;
	}
	
	public int filaDeLaPosicion(){
		
		return filaDePosicion;
	}
	
	public char columnaDeLaPosicion(){
		
		return columnaDePosicion;
	}
	
}
