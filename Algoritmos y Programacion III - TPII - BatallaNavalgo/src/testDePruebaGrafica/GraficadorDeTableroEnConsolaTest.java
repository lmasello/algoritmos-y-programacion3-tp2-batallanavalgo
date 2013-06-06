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
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		tableroAGraficar.colocarNavesEnElTablero();
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}
	
	public void testDeGraficadorDeTableroDelJuegoConMovimiento() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		tableroAGraficar.colocarNavesEnElTablero();
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
		for(int i=0 ; i<5 ; i++){
			System.out.println();
			tableroAGraficar.moverNaves();
			unGraficador.graficarEnConsola();
		}
	}

	public void testDeGraficadorDeDosLanchas() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		Posicion posicionDeProaDeUnaLanchaAColocar = tableroAGraficar.obtenerPosicion('D', 5);
		Posicion posicionDeProaDeOtraLanchaAColocar = tableroAGraficar.obtenerPosicion('H', 7);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new Lancha(), posicionDeProaDeUnaLanchaAColocar);

		tableroAGraficar.agregarNaveVerticalManualmenteConPosicionDeProa(new Lancha(), posicionDeProaDeOtraLanchaAColocar);
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}
	
	public void testDeGraficadorDeDosDestructores() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		Posicion posicionDeProaDeUnaLanchaAColocar = tableroAGraficar.obtenerPosicion('D', 5);
		Posicion posicionDeProaDeOtraLanchaAColocar = tableroAGraficar.obtenerPosicion('H', 7);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new Destructor(), posicionDeProaDeUnaLanchaAColocar);

		tableroAGraficar.agregarNaveVerticalManualmenteConPosicionDeProa(new Destructor(), posicionDeProaDeOtraLanchaAColocar);
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}
	
	public void testDeGraficadorDeUnBuque() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		Posicion posicionDeProaDeUnaNaveAColocar = tableroAGraficar.obtenerPosicion('J', 5);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new Buque(), posicionDeProaDeUnaNaveAColocar);


		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}
	
	public void testDeGraficadorDeUnPortaAviones() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		Posicion posicionDeProaDeUnaNaveAColocar = tableroAGraficar.obtenerPosicion('J', 10);

		tableroAGraficar.agregarNaveHorizontalManualmenteConPosicionDeProa(new PortaAviones(), posicionDeProaDeUnaNaveAColocar);

		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}

	public void testDeGraficadorDeUnRompeHielos() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		Posicion posicionDeProaDeUnaNaveAColocar = tableroAGraficar.obtenerPosicion('A', 1);

		tableroAGraficar.agregarNaveVerticalManualmenteConPosicionDeProa(new RompeHielos(), posicionDeProaDeUnaNaveAColocar);

		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}
}
