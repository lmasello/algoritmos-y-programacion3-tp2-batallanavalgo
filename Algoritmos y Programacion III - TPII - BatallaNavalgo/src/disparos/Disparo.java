package disparos;

import nave.ComponenteDeNave;

public abstract class Disparo {
	
	MomentoDeImpacto momentoDeImpacto;
	int tiempoPredefinidoDeImpacto;
	int radioDeDisparo;
	boolean fueEjecutado;

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
	
}
