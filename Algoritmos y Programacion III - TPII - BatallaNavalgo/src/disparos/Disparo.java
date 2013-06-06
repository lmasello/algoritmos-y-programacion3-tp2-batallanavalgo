package disparos;

import nave.ComponenteDeNave;

public class Disparo {
	
	MomentoDeImpacto momentoDeImpacto;
	int tiempoPredefinidoDeImpacto;
	int radioDeDisparo;
	boolean fueEjecutado;

	public int obtenerCosto() {
		
		return 0;
	}
	
	public void dispararA(ComponenteDeNave componente){
		/* Caso especial en el cual la nave Destructor solo es afectada por 
		 * un disparo convencional
		 *  */
		
		if(componente.obtenerNaveALaQuePertenece().esDestructor()
				&& this.noEsDisparoConvencional()){
			//No dispara
		}else{
			componente.disparoAComponente();
		}
	}
	
	public boolean noEsDisparoConvencional() {

		return true;
	}

	public MomentoDeImpacto obtenerMomentoDeImpacto(){
		
		return momentoDeImpacto;
	}

	public boolean noEsMinaPorContacto() {
		
		return true;
	}
	
	public int obtenerRadioDeDisparo(){
		
		return radioDeDisparo;
	}

	public boolean fueEjecutado() {
		
		return fueEjecutado;
		
	}

	public void marcarComoEjecutado() {
		
		fueEjecutado = true;
		
	}

	public Disparo crearDisparo() {
		
		return null;
	}
}
