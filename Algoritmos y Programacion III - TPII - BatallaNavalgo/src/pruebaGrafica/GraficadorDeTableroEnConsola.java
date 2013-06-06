package pruebaGrafica;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;

public class GraficadorDeTableroEnConsola {

	Tablero tableroAGraficar;
	
	public void establecerTableroAGraficar(Tablero tableroGraficable){
		tableroAGraficar = tableroGraficable;
	}
	
	public void graficarEnConsola() throws ValorDeParametroFueraDeRango{
		
		int cantidadDeColumnas = tableroAGraficar.cantidadDeColumnas();
		int cantidadDeFilas = tableroAGraficar.cantidadDeFilas();
		
		for(int numeroDeFilaActual = 1 ; numeroDeFilaActual<=cantidadDeFilas ; numeroDeFilaActual++){
			
			for(int numeroDeColumnaActual=0; numeroDeColumnaActual<cantidadDeColumnas ; numeroDeColumnaActual++){				
	
				int numeroDeIdentificadorDeColumnaInicial = (int)'A';			
				char identificadorDeColumnaActual = (char) (numeroDeIdentificadorDeColumnaInicial + numeroDeColumnaActual);
				
				Posicion posicionActual = tableroAGraficar.obtenerPosicion(identificadorDeColumnaActual, numeroDeFilaActual);
				
				if(posicionActual.tieneComponenteDeNave()){
					int cantidadDeComponentes = posicionActual.cantidadDeComponentesEnPosicion();
					System.out.print(cantidadDeComponentes);
				}
				else{
					System.out.print(".");
				}
			}
			
			System.out.println();
		}
				
	}
}
