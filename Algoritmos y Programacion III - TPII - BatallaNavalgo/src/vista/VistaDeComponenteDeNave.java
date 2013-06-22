package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeComponenteDeNave extends Cuadrado{
	//Cuando se setean en 50 los valores de ancho y largo los cuadrados no se distinguen individualmente
	private static int ANCHO =47;
	private static int ALTO =47;
	
	public VistaDeComponenteDeNave(ObjetoPosicionable objetoPosicionable) {
		super(ANCHO, ALTO, objetoPosicionable);
	}

	@Override
	public Color getColor(){
		return Color.WHITE;
	}
}
