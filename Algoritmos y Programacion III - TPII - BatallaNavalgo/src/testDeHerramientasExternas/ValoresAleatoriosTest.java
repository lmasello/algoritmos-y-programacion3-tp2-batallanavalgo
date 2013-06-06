package testDeHerramientasExternas;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class ValoresAleatoriosTest extends TestCase{

	public void testGenerarValorAleatorioEntreDosValores() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroAProbar = new Tablero(10,10);
		
		for(int contador=0;contador<10;contador++){
			
			int numeroAleatorio = tableroAProbar.generarNumeroAleatorioEntreDosValores(1, tableroAProbar.cantidadDeColumnas());

			assertTrue(numeroAleatorio>0);
			assertTrue(numeroAleatorio<=tableroAProbar.cantidadDeColumnas());
		}
	}
	public void testGenerarValorAleatorioEntre0Y1() throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
		
		Tablero tableroAProbar = new Tablero(10,10);
		
		for(int contador=0;contador<10;contador++){
			
			int numeroAleatorio = tableroAProbar.generarNumeroAleatorioEntreDosValores(0, 1);

			assertTrue(numeroAleatorio>=0);
			assertTrue(numeroAleatorio<=1);
		}
	}
}
