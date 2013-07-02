package testDePruebaGrafica;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import nave.Buque;
import nave.Destructor;
import nave.Lancha;
import nave.PortaAviones;
import nave.RompeHielos;

import org.junit.Test;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;

import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

import pruebaGrafica.GraficadorDeTableroEnConsola;

public class GraficadorDeTableroEnConsolaTest extends TestCase{

	public void testDeGraficadorDeTableroDelJuego() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		System.out.println("\nGrafica una ubicacion aleatoria de los barcos en el tablero, donde los numeros indican la cantidad de partes de nave que se encuentran en dicha posicion\n");
		
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		tableroAGraficar.colocarNavesEnElTablero();
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		
		Tablero.deleteInstance();
	}
	
	public void testDeGraficadorDeTableroDelJuegoConMovimiento() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		System.out.println("\nGrafica una serie de movimientos de los barcos en el tablero\n");
		
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		tableroAGraficar.colocarNavesEnElTablero();
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		for(int i=0 ; i<10 ; i++){
			System.out.println();
			tableroAGraficar.moverNaves();
			unGraficador.graficarEnConsola();
		}
		Tablero.deleteInstance();
	}

	public void testDeGraficadorDeDosLanchas() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
		System.out.println("\nGrafica la ubicacion de dos lanchas en el tablero\n");
		
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		Posicion posicionDeProaDeUnaLanchaAColocar = tableroAGraficar.obtenerPosicion('D', 5);
		Posicion posicionDeProaDeOtraLanchaAColocar = tableroAGraficar.obtenerPosicion('H', 9);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new Lancha(), posicionDeProaDeUnaLanchaAColocar);

		tableroAGraficar.agregarNaveVerticalManualmenteConPosicionDeProa(new Lancha(), posicionDeProaDeOtraLanchaAColocar);
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		
		Tablero.deleteInstance();
	}
	
	public void testDeGraficadorDeDosDestructores() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
		System.out.println("\nGrafica la ubicacion de dos destructores en el tablero\n");
		
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		Posicion posicionDeProaDeUnaLanchaAColocar = tableroAGraficar.obtenerPosicion('D', 5);
		Posicion posicionDeProaDeOtraLanchaAColocar = tableroAGraficar.obtenerPosicion('H', 7);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new Destructor(), posicionDeProaDeUnaLanchaAColocar);

		tableroAGraficar.agregarNaveVerticalManualmenteConPosicionDeProa(new Destructor(), posicionDeProaDeOtraLanchaAColocar);
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	
		Tablero.deleteInstance();
	}
	
	public void testDeGraficadorDeUnBuque() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
		System.out.println("\nGrafica la ubicacion de un buque en el tablero\n");
		
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		Posicion posicionDeProaDeUnaNaveAColocar = tableroAGraficar.obtenerPosicion('J', 5);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new Buque(), posicionDeProaDeUnaNaveAColocar);


		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		
		Tablero.deleteInstance();
	}
	
	public void testDeGraficadorDeUnPortaAviones() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/

		System.out.println("\nGrafica la ubicacion de un porta aviones en el tablero\n");

		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		Posicion posicionDeProaDeUnaNaveAColocar = tableroAGraficar.obtenerPosicion('J', 10);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new PortaAviones(), posicionDeProaDeUnaNaveAColocar);

		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		
		Tablero.deleteInstance();
	}

	public void testDeGraficadorDeUnRompeHielos() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		System.out.println("\nGrafica la ubicacion de un rompe hielos en el tablero \n");
		
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = Tablero.getInstance();
		
		Posicion posicionDeProaDeUnaNaveAColocar = tableroAGraficar.obtenerPosicion('A', 1);

		tableroAGraficar.agregarNaveVerticalManualmenteConPosicionDeProa(new RompeHielos(), posicionDeProaDeUnaNaveAColocar);

		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		
		Tablero.deleteInstance();
	}
}
