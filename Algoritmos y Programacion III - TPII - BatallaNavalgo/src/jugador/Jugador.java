package jugador;

import java.io.IOException;
import java.util.Scanner;

import colecciones.ColeccionDePosiciones;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;

import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import disparos.MinaSubmarinaPorContacto;
import disparos.MinaSubmarinaPuntual;
import disparos.MinaSubmarinaTriple;
import excepciones.ValorDeParametroFueraDeRango;
import puntaje.Puntaje;

public class Jugador {

	Puntaje puntajeDelJugador;
	String nombreDelJugador;
	Tablero tableroDelJugador;

	public Jugador(String nombre) {
		/* Crea a un jugador junto con su puntaje inicial */

		nombreDelJugador = nombre;
		puntajeDelJugador = new Puntaje();
		puntajeDelJugador.setearPuntaje(10000);

	}

	public void asignarTablero(Tablero tablero) {

		tableroDelJugador = tablero;
	}

	public Puntaje obtenerPuntaje() {

		return puntajeDelJugador;

	}

	public void realizarDisparoALasPosiciones(Disparo disparo,ColeccionDePosiciones
			 posicionesADisparar) throws ValorDeParametroFueraDeRango {
		
	/* Recorre la coleccion de posiciones para colocar el disparo correspondiente en cada
	 * 	posicion. Al finalizar disminuye el puntaje debido al disparo seleccionado 
	 */
		
		for(int posicionEnColeccion = 1; posicionEnColeccion <= posicionesADisparar.cantidadDePosiciones()
				; posicionEnColeccion++){
				Posicion posicionActual = posicionesADisparar.obtenerPosicionDeLaFila(posicionEnColeccion);
				Disparo disparoAAgregar = disparo.crearDisparo();
				posicionActual.agregarDisparoAPosicion(disparoAAgregar);
		}
		
		this.obtenerPuntaje().disminuirPuntajePorDisparo(disparo);
	

	}

	public void disparar() throws IOException, ValorDeParametroFueraDeRango{
			
		/*	El Jugador elige un tipo de disparo, junto con una posicion (metodos a desarrollar)
		 *  sobre la cual quiera disparar. Luego de acuerdo al tipo de disparo, se recolectan las 
		 *  posiciones necesarias para tal disparo y se devuelve la coleccion. Por ultimo
		 *  se realiza el disparo a las posiciones recolectadas.
		 */  
		Disparo disparo = this.elegirDisparo();
		Posicion posicionElegida = this.elegirPosicion();
		ColeccionDePosiciones posicionesADisparar = tableroDelJugador.obtenerPosicionesDondeDisparar(posicionElegida,disparo);
			  
		this.realizarDisparoALasPosiciones(disparo, posicionesADisparar);
		
	}

	public Posicion elegirPosicion() throws IOException, ValorDeParametroFueraDeRango {
		
		@SuppressWarnings("resource")
		Scanner en = new Scanner(System.in);
		int fila = 0;int columnaEnInt = 0;
		char columna;
		while ((fila > tableroDelJugador.cantidadDeFilas()) || (fila < 1)){
		System.out.print("Elegir la fila a la que desea disparar:");
		fila = en.nextInt();
		System.out.println();
		}
		while ((columnaEnInt > tableroDelJugador.cantidadDeColumnas()) || (columnaEnInt < 1)){
		System.out.print("Elegir la columna a la que desea disparar:");
		columnaEnInt = en.nextInt();
		System.out.println();
		}
		columna = (char)((int)'A' + columnaEnInt - 1);
		Posicion posicionElegida = tableroDelJugador.obtenerPosicion(columna, fila);
		
		return posicionElegida;
		
		
	}

	public Disparo elegirDisparo() throws IOException {
		
		int disparo = 0;
		@SuppressWarnings("resource")
		Scanner en = new Scanner(System.in);
		while((disparo < 1) || (disparo > 5)) {
			System.out.print("Por favor eliga el disparo que desea (1/5):");
			System.out.println();
			System.out.print("1: Disparo Convencional");System.out.println();
			System.out.print("2: Mina Submarina Puntual");System.out.println();
			System.out.print("3: Mina Submarina Doble");System.out.println();
			System.out.print("4: Mina Submarina Triple");System.out.println();
			System.out.print("5: Mina Submarina Por Contacto");System.out.println();
			System.out.println();
			
			disparo = en.nextInt();
		}
		
		if(disparo == 1){
			return new DisparoConvencional();
		}
		if(disparo == 2){
			return new MinaSubmarinaPuntual();
		}
		if(disparo == 3){
			return new MinaSubmarinaDoble();
		}
		if(disparo == 4){
		    return new MinaSubmarinaTriple();
		}
		if(disparo == 5){
			return new MinaSubmarinaPorContacto();
		}
		return null;
	}

}
