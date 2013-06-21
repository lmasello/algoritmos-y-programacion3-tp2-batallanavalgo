package vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDeComponenteDeNave extends Cuadrado{

	private static int ANCHO =1;
	private static int ALTO =1;
	
	public VistaDeComponenteDeNave(ObjetoPosicionable objetoPosicionable) {
		super(ANCHO, ALTO, objetoPosicionable);
	}

	@Override
	public Color getColor(){
		return Color.WHITE;
	}
}
