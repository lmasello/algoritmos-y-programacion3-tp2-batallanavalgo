package nave;

import movimientos.Direccion;

import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import disparos.Disparo;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public class ComponenteDeNave implements ComponenteMovible, Disparable {

	Resistencia resistencia;
	boolean destruida;
	Nave naveALaQuePertenece;
	
	/*Los siguientes son atributos requeridos por la interfaz ComponenteMovible*/
	Tablero tableroEnDondeSeMueve;
	Posicion posicionActual;
	Direccion direccionDelMovimiento;

	public ComponenteDeNave(Resistencia resistenciaDeNave, Nave nave) throws ValoresDeParametroFueraDeRango {

		resistencia = resistenciaDeNave;
		destruida = false;
		naveALaQuePertenece = nave;

		tableroEnDondeSeMueve = Tablero.getInstance();
	}

	public void recibirDisparo(Disparo disparo) {
	/*
	 * Un disparo impacta a la componente. Provoca una disminucion de la resistencia, si puede recibir 
	 * tal disparo,  la cual en caso que alcance el valor 0, significa que la componente ha sido destruida.
	 */
		if(this.naveALaQuePertenece.puedeRecibirDisparoDe(disparo)){
			resistencia.disminuir();
		}
		
		if (resistencia.obtenerResistencia() == 0) {
			destruida = true;
		}
	}

	public void destruirComponente() {
	/*
	 * Destruye por completo la componente, luego del impacto de un disparo. En el caso que la componente
	 * tenga una resistencia mayor a 1, tambien la destruye
	 */
		resistencia.reducirACero();
		destruida = true;
	}

	public boolean estaDestruida() {

		return this.destruida;
	}

	public Nave obtenerNaveALaQuePertenece(){
		
		return naveALaQuePertenece;
	}


	@Override
	public Posicion posicionActualDeLaComponente() {
		return posicionActual;
	}

	private Posicion posicionSiguiente() throws ValorDeParametroFueraDeRango {
		/*
		 * Devuelve la proxima posicion que le corresponde de acuerdo al tipo de direccion y sentido de la componente.
		 * En caso de encontrarse en el limite del tablero, se cambia el sentido de la direccion y movimiento, para obtener
		 * el objetivo.
		 */
		
		return direccionDelMovimiento.desplazarPosicion(posicionActual);
	}

	@Override
	public void establecerPosicionActual(Posicion posicionASerActual) {
		/*
		 * Almacena una referencia a la posicion donde esta contenida la componente.
		 * 
		 * Precondiciones: posicionASerActual debe encontrarse en el tablero donde se mueve la componente
		 */
		posicionActual = posicionASerActual;
		posicionActual.agregarComponenteAPosicion(this);
	}

	@Override
	public void mover() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
	/*
	 * Realiza el movimiento de una componente, modificando su posicion actual, por la posicion siguiente de acuerdo a
	 * la direccion de movimiento que posea la componente.
	 */
		Posicion posicionASerLaSiguiente = this.posicionSiguiente();
		
		posicionActual.removerComponente(this);
		
		this.establecerPosicionActual(posicionASerLaSiguiente);
	}

	@Override
	public boolean puedeAvanzar() {
	/*
	 * Determina si es posible avanzar una posicion en el tablero, sin cambiar el sentido del movimiento y sin 
	 * alcanzar el final del Tablero
	 */
		return direccionDelMovimiento.hayPosicionSiguienteDisponible(posicionActual);
	}

	@Override
	public void establecerDireccion() {
		
		direccionDelMovimiento = naveALaQuePertenece.direccionDeLaNave();
	}

}
