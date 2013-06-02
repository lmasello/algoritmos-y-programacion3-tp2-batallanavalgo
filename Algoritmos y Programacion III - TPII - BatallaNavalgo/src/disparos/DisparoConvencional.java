package disparos;

public class DisparoConvencional extends Disparo {

	int costoDeDisparo = 200;
	
	public DisparoConvencional(){
		
		tiempoPredefinidoDeImpacto = 1; // Al instante de que se produce el disparo.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 0;
	}

	public int obtenerCosto() {

		return costoDeDisparo;
	}
	
	
}
