package disparos;

public class MinaSubmarinaTriple extends Disparo {

	int costoDeDisparo = 125;
	
	public MinaSubmarinaTriple(){
		
		tiempoPredefinidoDeImpacto = 2; // A los 3 turnos de que se produce el disparo.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 2;
		fueEjecutado = false;
		
	}
	
	public int obtenerCosto(){
		
		return costoDeDisparo;
	}
}
