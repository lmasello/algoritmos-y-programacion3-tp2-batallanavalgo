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

}
