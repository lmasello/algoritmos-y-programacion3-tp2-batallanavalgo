package disparos;

public class MinaSubmarinaPorContacto extends Disparo {
	
	int costoDeDisparo = 150;
	
	public int obtenerCosto(){
		
		return costoDeDisparo;
	}

	public boolean noEsMinaPorContacto() {
		
		return false;
	}
}
