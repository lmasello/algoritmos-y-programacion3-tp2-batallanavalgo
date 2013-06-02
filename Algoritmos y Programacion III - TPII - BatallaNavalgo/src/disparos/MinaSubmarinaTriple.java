package disparos;

public class MinaSubmarinaTriple extends Disparo {

	int costoDeDisparo = 125;
	
	public MinaSubmarinaTriple(){
		
		tiempoPredefinidoDeImpacto = 3; // A los 3 turnos de que se produce el disparo.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 2;
	}
	
	public int obtenerCosto(){
		
		return costoDeDisparo;
	}
}
