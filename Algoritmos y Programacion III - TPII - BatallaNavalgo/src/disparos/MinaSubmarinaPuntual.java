package disparos;

public class MinaSubmarinaPuntual extends Disparo {

	int costoDeDisparo = 50;
	
	public MinaSubmarinaPuntual(){
		
		tiempoPredefinidoDeImpacto = 2; // A los 3 turnos de que se produce el disparo.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 0;
		fueEjecutado = false;
		
	}

	public int obtenerCosto() {

		return costoDeDisparo;
	}
	
	public Disparo crearDisparo() {
		
		return new MinaSubmarinaPuntual();
	}
}
