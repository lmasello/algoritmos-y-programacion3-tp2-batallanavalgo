package disparos;

public class MinaSubmarinaPorContacto extends Disparo {
	
	int costoDeDisparo = 150;
	
	public MinaSubmarinaPorContacto(){
		
		tiempoPredefinidoDeImpacto = 88; // Indefinido, solo impacta cuando haya una nave.
		momentoDeImpacto = new MomentoDeImpacto(tiempoPredefinidoDeImpacto);
		radioDeDisparo = 0;
	}
	
	public int obtenerCosto(){
		
		return costoDeDisparo;
	}

	public boolean noEsMinaPorContacto() {
		
		return false;
	}
}
