package nave;

public class Buque extends Nave{
	
	public Buque() {

		cantidadDeComponentes = 4;
		for (int indiceDeComponentes = 0; indiceDeComponentes < cantidadDeComponentes; indiceDeComponentes++) {

			this.agregarComponenteConResistencia(1);
		}
	}

}
