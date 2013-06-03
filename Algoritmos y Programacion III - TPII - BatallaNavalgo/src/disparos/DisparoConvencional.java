package disparos;

public class DisparoConvencional extends Disparo {

	int costoDeDisparo = 200;
	
	public DisparoConvencional(){
		
		tiempoPredefinidoDeImpacto = 0; // Al instante de que se produce el disparo.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 0;
		fueEjecutado = false;
		
	}

	public int obtenerCosto() {

		return costoDeDisparo;
	}
	
	public boolean noEsDisparoConvencional() {
		
		return false;
	}
}
