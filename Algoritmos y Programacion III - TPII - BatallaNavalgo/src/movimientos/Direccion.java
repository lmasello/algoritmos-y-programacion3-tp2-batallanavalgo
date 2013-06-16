package movimientos;

import nave.Nave;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import excepciones.ValorDeParametroFueraDeRango;

public interface Direccion {

	/*Obtiene la posicion siguiente a una posicion determinada de un tablero*/	
	public abstract Posicion desplazarPosicion(Posicion posicionAConocerLaSiguiente) throws ValorDeParametroFueraDeRango;

	public void cambiarSentido();
	
	public Sentido sentidoDeLaDireccion();

	/* Devuelve el numero de la Componente que lidera el movimiento de toda la nave. Esta corresponde a proa o popa*/
	public abstract int numeroDeComponenteDelantera(Nave nave);

	/*Evalua si puede existir un movimiento manteniendo el sentido y sin llegar al final del tablero*/
	public abstract boolean hayPosicionSiguienteDisponible(Posicion posicionActual);

	public boolean equals(Object otro);
	
}
