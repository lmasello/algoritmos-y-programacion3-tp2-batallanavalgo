package disparos;

public class MinaSubmarinaPorContacto extends Disparo {
	
	int costoDeDisparo = 150;
	
	public MinaSubmarinaPorContacto(){
		
		tiempoPredefinidoDeImpacto = 0; // Indefinido, solo impacta cuando haya una nave.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 0;
		fueEjecutado = false;
	
	}
	
	public int obtenerCosto(){
		
		return costoDeDisparo;
	}

	public boolean noEsMinaPorContacto() {
		
		return false;
	}
}
