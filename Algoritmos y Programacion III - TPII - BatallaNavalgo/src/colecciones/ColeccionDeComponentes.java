package colecciones;

import java.util.ArrayList;

import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;

import nave.ComponenteDeNave;

public class ColeccionDeComponentes {
	
	ArrayList<ComponenteDeNave> componentes;
	
	public ColeccionDeComponentes() {
		
		componentes = new ArrayList<ComponenteDeNave>();
		
	}
	
	public void agregarComponente(ComponenteDeNave componente) {
	/*
	 * Agrega una componente de nave al final de la propia coleccion.
	 */
		componentes.add(componente);

	}
	
	public int cantidadDeComponentes() {
	/*
	 * Devuelve la cantidad de componentes que posee la coleccion
	 */
		return this.componentes.size();

	}
	
	public ComponenteDeNave obtenerComponente(int indiceDeComponente) throws ValorDeParametroFueraDeRango{
	/*
	 * Devuelve una componente de nave, de acuerdo al valor de indice enviado por parametro.
	 * El indiceDeComponente debe ser mayor a 0 y menor o igual a la cantidad de posiciones	
	 */
		if((indiceDeComponente<=0)|(indiceDeComponente>this.cantidadDeComponentes())){
			throw new ValorDeParametroFueraDeRango();
		}
		
		return componentes.get(indiceDeComponente-1);
	}

	public boolean tieneComponente() {
		return (!componentes.isEmpty());
	}

	public void quitarComponente(ComponenteDeNave componenteAQuitar) {
		
		componentes.remove(componenteAQuitar);
	}

	public boolean tieneLaComponente(ComponenteDeNave componenteDeNave) {
		
		for(int indiceActual = 0 ; indiceActual<this.cantidadDeComponentes() ; indiceActual++){
				
			if(componenteDeNave.equals(componentes.get(indiceActual))){
				return true;
			}
		}
		
		return false;
	}

	public void borrarComponente(ComponenteDeNave componenteDeNave) throws ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
		
		if(this.tieneLaComponente(componenteDeNave)){
			
			componentes.remove(componenteDeNave);
		}
		else{
			throw new ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene();
		}
		
	}


}
