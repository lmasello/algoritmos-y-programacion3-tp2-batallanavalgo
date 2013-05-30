package nave;

import colecciones.ColeccionDeComponentes;

public abstract class Nave {

	ColeccionDeComponentes componentes;
	/* Direccion direccion; tenemos que discutir como lo implementamos */
	boolean estaDestruida;
	int cantidadDeComponentes;

	public Nave() {

		componentes = new ColeccionDeComponentes();
		estaDestruida = false;

	}

	public boolean estaDestruida() {

		return estaDestruida;
	}
	
	public int cantidadDeComponentes(){
		
		return componentes.cantidadDeComponentes();
		
	}
	
	public void agregarComponenteConResistencia(int resistencia){
		
		componentes.agregarComponente(resistencia);
		
	}

	public void destruirNave() {
		/* Destruye cada componente de la nave */
			
		for (int indiceDeComponentes = 0; indiceDeComponentes < componentes.cantidadDeComponentes(); indiceDeComponentes++) {

			ComponenteDeNave componente = componentes.obtenerComponente(indiceDeComponentes);
			componente.destruirComponente();

		}

		estaDestruida = true;
	}

	public int numeroDeComponenteDeLaProa(){
	/*
	 * Se toma como supuesto que la proa es la primer componente de la nave	
	 */
		return 1;
	}

	public ComponenteDeNave obtenerComponenteDeNumero(int numeroDeComponenteDeseada) {
	/*
	 * Devuelve la componente de la nave de acuerdo al indice pasado por parametro.
	 * 
	 * Precondiciones: 
	 * 		numeroDeComponenteDeseada debe ser mayor a 0 y menor o igual a la cantidad de componentes de la nave	
	 */
		
		/*if((numeroDeComponenteDeseada<=0)&(numeroDeComponenteDeseada>this.cantidadDeComponentes())){
			tirar error
		}*/
			
		return componentes.obtenerComponente(numeroDeComponenteDeseada-1);
		
	}
	
	
	
}
