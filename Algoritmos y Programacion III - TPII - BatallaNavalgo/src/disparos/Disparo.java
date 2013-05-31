package disparos;

import nave.ComponenteDeNave;

public class Disparo {
	
	MomentoDeImpacto momentoDeImpacto;
	int tiempoPredefinidoDeImpacto;

	public int obtenerCosto() {
		
		return 0;
	}
	
	public void dispararA(ComponenteDeNave componente){
		
		componente.disparoAComponente();
	}
	
	public MomentoDeImpacto obtenerMomentoDeImpacto(){
		
		return momentoDeImpacto;
	}

	public boolean noEsMinaPorContacto() {
		
		return true;
	}
}
