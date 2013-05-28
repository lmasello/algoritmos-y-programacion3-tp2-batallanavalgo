package nave;

import java.util.ArrayList;

public abstract class Nave {
	
	ArrayList<ComponenteDeNave> componentes;
	/*Direccion direccion;  tenemos que discutir como lo implementamos*/
	boolean estaDestruida;
	int cantidadDeComponentes;
	
	
	public Nave (){
		
		componentes = new ArrayList<ComponenteDeNave> ();
		estaDestruida = false;
		
	}
	
	public void agregarComponenteConResistencia(int resistencia){

		ComponenteDeNave componente = new ComponenteDeNave(resistencia);
		componentes.add(componente);
		
	}
	
	public int cantidadDeComponentes(){
		
		return this.componentes.size();
		
	}
	
	public boolean estaDestruida(){
		
		return estaDestruida;
	}
	
	public void destruirNave(){
	/* Destruye cada componente de la nave */
		for (int indiceDeComponentes=0 ; indiceDeComponentes<componentes.size(); indiceDeComponentes++){
			
			ComponenteDeNave componente = componentes.get(indiceDeComponentes);
			componente.destruirComponente();
			
		}
		
		estaDestruida = true;
	}
	
	
	
	
		

}
