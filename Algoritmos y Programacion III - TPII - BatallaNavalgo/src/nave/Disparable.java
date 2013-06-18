package nave;

import disparos.Disparo;

public interface Disparable {

	public void recibirDisparo(Disparo disparo);
	/*
	 * Su un disparo puede impactar a la componente, provoca una disminucion de la resistencia 
	 * la cual en caso que alcance el valor 0, la componente ha sido destruida.
	 */

	public void destruirComponente();
	/*
	 * Destruye por completo la componente, independientemente de la resistencia de la misma.
	 * Dicha destruccion se da luego del impacto de un disparo.
	 */
	
	public boolean estaDestruida();
	
	
	
}
