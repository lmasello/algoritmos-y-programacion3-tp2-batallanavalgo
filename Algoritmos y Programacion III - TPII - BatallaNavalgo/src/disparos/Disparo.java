package disparos;

import java.awt.Color;

import componentesDeTablero.Posicion;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import nave.ComponenteDeNave;

public abstract class Disparo implements ObjetoPosicionable{
	
	MomentoDeImpacto momentoDeImpacto;
	int tiempoPredefinidoDeImpacto;
	int radioDeDisparo;
	boolean fueEjecutado;
	int coordenadaX;
	int coordenadaY;

	public int obtenerCosto() {
		
		return 0;
	}
	
	public boolean esDisparoConvencional() {

		return false;
	}

	public MomentoDeImpacto obtenerMomentoDeImpacto(){
		
		return momentoDeImpacto;
	}

	public boolean noEsMinaPorContacto() {
		
		return true;
	}
	
	public int obtenerRadioDeDisparo(){
		
		return radioDeDisparo;
	}

	public boolean fueEjecutado() {
		
		return fueEjecutado;
		
	}

	public void marcarComoEjecutado() {
		
		fueEjecutado = true;
		
	}

	public abstract Disparo crearDisparo();
	
	public void setPosicion(Posicion posicion){
		coordenadaX = ((int)posicion.columnaDeLaPosicion() - (int)'A' + 1) ;
		coordenadaY = posicion.filaDeLaPosicion();
	}
	
	@Override
	public int getX() {
		return (coordenadaX*50)-40;
	}

	@Override
	public int getY() {
		return (coordenadaY*50)-40;
	}

	public Color getColor() {
		if(fueEjecutado){
			System.out.println("DISPARO EJECUTADO");
			return Color.LIGHT_GRAY;
		}

		System.out.println("DISPARO NO EJECUTADO");
		return Color.RED;
	}
}
