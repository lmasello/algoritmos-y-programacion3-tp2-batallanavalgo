package nave;

public class Destructor extends Nave{
	
	public Destructor() {

		cantidadDeComponentes = 3;
		for (int indiceDeComponentes = 0; indiceDeComponentes < cantidadDeComponentes; indiceDeComponentes++) {

			this.agregarComponenteConResistencia(1);
		}
	}

}
