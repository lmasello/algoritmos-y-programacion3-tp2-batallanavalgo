package colecciones;

import java.util.ArrayList;

import nave.ComponenteDeNave;

public class ColeccionDeComponentes {
	
	ArrayList<ComponenteDeNave> componentes;
	
	public ColeccionDeComponentes() {
		
		componentes = new ArrayList<ComponenteDeNave>();
		
	}
	
	public void agregarComponente(int resistencia) {

		ComponenteDeNave componente = new ComponenteDeNave(resistencia);
		componentes.add(componente);

	}
	
	public int cantidadDeComponentes() {

		return this.componentes.size();

	}
	
	public ComponenteDeNave obtenerComponente(int indiceDeComponente){
		
		return componentes.get(indiceDeComponente);
	}

}
