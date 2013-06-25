package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeComponenteDeNave extends Cuadrado{
	//Cuando se setean en 50 los valores de ancho y largo los cuadrados no se distinguen individualmente
	private static int ANCHO =48;
	private static int ALTO =48;
	Color color;
	
	public VistaDeComponenteDeNave(ObjetoPosicionable objetoPosicionable, Color color) {
		super(ANCHO, ALTO, objetoPosicionable);
		this.color = color;
	}

	@Override
	public Color getColor(){
		return color;
	}

}
