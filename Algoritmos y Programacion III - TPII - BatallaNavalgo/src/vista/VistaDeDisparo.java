package vista;

import java.awt.Color;

import disparos.Disparo;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeDisparo extends Circulo {

	private static int RADIO = 25;
	private Disparo disparo;
	
	public VistaDeDisparo(Disparo disparo) {
		super(RADIO, (ObjetoPosicionable)disparo);
		this.disparo = disparo;
	}
	
	public Color getColor(){
		
		return this.disparo.getColor();
	}

}
