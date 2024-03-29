package colecciones;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValoresDeParametroFueraDeRango;

import nave.Buque;
import nave.Destructor;
import nave.Lancha;
import nave.Nave;
import nave.PortaAviones;
import nave.RompeHielos;

public class ColeccionDeNaves {

	ArrayList<Nave> coleccion;
	
	public ColeccionDeNaves(){
		
		coleccion = new ArrayList<Nave>();

	}
	
	public void agregarNave(Nave naveAAgregar){
		coleccion.add(naveAAgregar);
	}

	public void establecerNavesDelJuego() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
	/*
	 * Agrega las naves establecidas por la consigna del trabajo a la coleccion.	
	 */
		this.agregarUnaCantidadDeVecesNaveLancha(2);
		this.agregarUnaCantidadDeVecesNaveDestructor(2);
		
		this.agregarBuque();
		this.agregarPortaAviones();
		this.agregarRompeHielos();
		
	}

	private void agregarRompeHielos() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		Nave naveAAgregar = new RompeHielos(); 
		this.agregarNave(naveAAgregar);	
	}

	private void agregarPortaAviones() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		Nave naveAAgregar = new PortaAviones(); 
		this.agregarNave(naveAAgregar);	
	}

	private void agregarBuque() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		Nave naveAAgregar = new Buque(); 
		this.agregarNave(naveAAgregar);	
	}

	private void agregarUnaCantidadDeVecesNaveDestructor(int cantidadDeNaves) throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		for(int numeroDeNaveActual = 0 ; numeroDeNaveActual < cantidadDeNaves ; numeroDeNaveActual++){
			
			Nave naveAAgregar = new Destructor(); 
			this.agregarNave(naveAAgregar);
		}
	}

	private void agregarUnaCantidadDeVecesNaveLancha(int cantidadDeNaves) throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		
		for(int numeroDeNaveActual = 0 ; numeroDeNaveActual < cantidadDeNaves ; numeroDeNaveActual++){
			
			Nave naveAAgregar = new Lancha(); 
			this.agregarNave(naveAAgregar);
		}
	}

	public int cantidadDeNaves() {
		return coleccion.size();
	}

	public Nave naveDeLaPosicion(int numeroDeNaveActual) {
		/*
		 * Precondiciones: numeroDeNaveActual debe ser mayor o igual a 1
		 */
		return coleccion.get(numeroDeNaveActual-1);
		
	}

	public Iterator iterator() {
		
		return coleccion.iterator();
	}

	public void quitarNave(Nave naveAEliminar) {
		
		coleccion.remove(naveAEliminar);
	}
	
}
