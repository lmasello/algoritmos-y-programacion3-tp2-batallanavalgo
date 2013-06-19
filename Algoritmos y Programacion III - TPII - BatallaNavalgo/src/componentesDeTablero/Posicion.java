package componentesDeTablero;

import java.util.Iterator;

import nave.ComponenteDeNave;
import nave.Disparable;
import colecciones.ColeccionDeComponentes;
import colecciones.ColeccionDeDisparos;
import disparos.Disparo;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;

public class Posicion {
	
	char columnaDePosicion;
	int filaDePosicion;
	ColeccionDeComponentes componentesDeNaveEnPosicion;
	ColeccionDeDisparos disparosEnPosicion;
	
	public Posicion(){
		
		componentesDeNaveEnPosicion = new ColeccionDeComponentes();
		disparosEnPosicion = new ColeccionDeDisparos();
	}
	
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

	public boolean tieneComponenteDeNave() {
	/*
	* Devuelve true si en dicha posicion se encuentra una o más componente de nave
	*/
		return componentesDeNaveEnPosicion.tieneComponente();
	}
	
	public void impactoDeLosDisparos() throws ValorDeParametroFueraDeRango{
	/* Recorre los disparos en la posicion, para cada uno chequea el momento de impacto
	 * si el mismo es igual a 0(cero), realiza el impacto del disparo.
	 * Si no, disminuye el momento de impacto del disparo
	 * Al finalizar, quita los disparos que fueron ejectuados.
	 * */
		Iterator<Disparo> iterator = disparosEnPosicion.iterator();
		while(iterator.hasNext()){
			Disparo disparoActual = iterator.next();
			if( disparoActual.obtenerMomentoDeImpacto().obtenerMomentoDeImpacto() == 0){
				this.realizarImpactoDe(disparoActual);
				iterator.remove();
			}else{
				disparoActual.obtenerMomentoDeImpacto().DisminuirMomentoDeImpacto();
			}
		}
				
	}


	private void realizarImpactoDe(Disparo disparo) throws ValorDeParametroFueraDeRango {
	/* Chequea si la posicion tiene componentes,
	 * 	  si tiene: 	Recorre las componentes que se encuentren en la posicion y realiza el
	 * 					disparo para cada una de ellas. Luego quita el disparo de la posicion
	 * 	  si no tiene:  Y no es una mina por contacto quita el disparo de la posicion
	 * */
		
		if(componentesDeNaveEnPosicion.tieneComponente()){
			Iterator<ComponenteDeNave> iterator = componentesDeNaveEnPosicion.iterator();
			while(iterator.hasNext()){
				Disparable componenteADisparar = iterator.next();
				componenteADisparar.recibirDisparo(disparo);
				disparo.marcarComoEjecutado();
			}
		}else{
			if(disparo.noEsMinaPorContacto()){
				disparo.marcarComoEjecutado();
			}
		}
	}

	public boolean tieneDisparo() {
		
		return (disparosEnPosicion.noEstaVacia());
	}

	public void removerComponentesEliminadas() throws ValorDeParametroFueraDeRango {
		
	/* Recorre los componentes en la posicion para chequear si hay alguna destruida en cuyo
	 * caso la elimina de la coleccion
	 * */
		
		Iterator<ComponenteDeNave> iterator = componentesDeNaveEnPosicion.iterator();
		while(iterator.hasNext()){
			Disparable componenteActual = iterator.next();
			if(componenteActual.estaDestruida()){
				iterator.remove();
			}
		}
	}

	public void removerComponente(ComponenteDeNave componenteDeNave) throws ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
		
		if (componentesDeNaveEnPosicion.tieneLaComponente(componenteDeNave)){
			componentesDeNaveEnPosicion.borrarComponente(componenteDeNave);
		}
		else{
			
			throw new ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene();
		}
	}

	public int cantidadDeComponentesEnPosicion() {
		
		return componentesDeNaveEnPosicion.cantidadDeComponentes();
	}
	
}
