package colecciones;

import java.util.ArrayList;

import nave.Nave;


public class ColeccionDeNaves {
	
	ArrayList<Nave> naves;
	
	public ColeccionDeNaves(){
		
		naves = new ArrayList<Nave>();
		
	}
	
	public void agregarNave(Nave naveAAgregar){
		
		naves.add(naveAAgregar);
		
	}
	
	public Nave obtenerNave(int indiceNave){
		
		/* si no es valido el indice lanzar excepcion*/
		return naves.get(indiceNave - 1);
	}
	
	public int cantidadDeNaves(){
		
		return naves.size();
	
	}
}

