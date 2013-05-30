package testDePruebaGrafica;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import componentesDeTablero.Tablero;

import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

import pruebaGrafica.GraficadorDeTableroEnConsola;

public class GraficadorDeTableroEnConsolaTest extends TestCase{

	public void testDeGraficadorEnConsola() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
	/*
	* Unicamente la prueba se realiza en consola
	*/
	
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		Tablero tableroAGraficar = new Tablero(10,10);
		
		unGraficador.establecerTableroAGraficar(tableroAGraficar);
		unGraficador.graficarEnConsola();
	}

}
