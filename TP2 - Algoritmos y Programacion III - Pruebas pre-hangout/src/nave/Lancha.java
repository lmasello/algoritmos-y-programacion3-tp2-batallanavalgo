package nave;

public class Lancha extends Nave {

	public Lancha() {

		cantidadDeComponentes = 2;
		for (int indiceDeComponentes = 0; indiceDeComponentes < cantidadDeComponentes; indiceDeComponentes++) {

			this.agregarComponenteConResistencia(1);
		}
	}

}
