package disparos;

public class MinaSubmarinaDoble extends Disparo {

	int costoDeDisparo = 100;
	
	public MinaSubmarinaDoble(){
		
		tiempoPredefinidoDeImpacto = 2; // A los 3 turnos de que se produce el disparo.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 1;
		fueEjecutado = false;
		
	}
	
	public int obtenerCosto(){
		
		return costoDeDisparo;
	}
}
