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
import excepciones.ValoresDeParametroFueraDeRango;
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

	public void realizarDisparoALaPosicion( Disparo disparo, Posicion posicionElegida) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		/* Metodo que a partir de un disparo y una posicion elegida, obtiene todas las posiciones afectadas por ese disparo,
		 * y lo ubica en las mismas.
		 */
		ColeccionDePosiciones posicionesAfectadas = tableroDelJugador.obtenerPosicionesDondeDisparar(posicionElegida, disparo);
		this.colocarDisparoEnPosicionesAfectadas(disparo, posicionesAfectadas);
	}

	private void colocarDisparoEnPosicionesAfectadas(Disparo disparo,ColeccionDePosiciones
			 posicionesAfectadas) throws ValorDeParametroFueraDeRango {
		
	/* Recorre la coleccion de posiciones. Crea el disparo correspondiente y lo
	 * agrega a la posicion. Al finalizar disminuye el puntaje debido al disparo seleccionado 
	 */
		
		for(int posicionEnColeccion = 1; posicionEnColeccion <= posicionesAfectadas.cantidadDePosiciones()
				; posicionEnColeccion++){
				Posicion posicionActual = posicionesAfectadas.obtenerPosicionDeLaFila(posicionEnColeccion);
				Disparo disparoAAgregar = disparo.crearDisparo();
				posicionActual.agregarDisparoAPosicion(disparoAAgregar);
		}
		
		this.obtenerPuntaje().disminuirPuntajePorDisparo(disparo);
	
	}
	


	public void disparar() throws IOException, ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
			
		/*	El Jugador elige un tipo de disparo, junto con una posicion (metodos a desarrollar)
		 *  sobre la cual quiera disparar. Luego de acuerdo al tipo de disparo, se recolectan las 
		 *  posiciones necesarias para tal disparo y se devuelve la coleccion. Por ultimo
		 *  se realiza el disparo a las posiciones recolectadas.
		 */  
		Disparo disparo = this.elegirDisparo();
		Posicion posicionElegida = this.elegirPosicion();
		
		this.realizarDisparoALaPosicion(disparo, posicionElegida);
		
	}

	public Posicion elegirPosicion() throws IOException, ValorDeParametroFueraDeRango {
		
		/* Metodo de interaccion con el usuario en el cual se elige una posicion
		 * Se pregunta primero a que fila se quiere disparar y luego a la columna.
		 * Finalmente se obtiene la posicion deseada del tablero y se devuelve la misma.
		 * 
		 * Precondiciones: + La fila debe ser mayor que 1 y menor que la cantidad de filas
		 * que tenga el tablero
		 * 				   + La columna debe ser mayor que 1 y menor que la cantidad de
		 * columnas que tenga el tablero.	
		 * */
		
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
		
	/* 	Metodo de interaccion con el usuario en el cual se elige un disparo
	 *  Se pregunta que disparo se deseea utilizar, luego se devuelve una instancia
	 *  del disparo elegido
	 *  Precondiciones: + El disparo debe tomar un valor de 1 a 5 
	 *  */
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
