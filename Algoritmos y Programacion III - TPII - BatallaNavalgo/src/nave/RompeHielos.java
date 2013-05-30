package nave;

public class RompeHielos extends Nave {
	
	public RompeHielos() {

		cantidadDeComponentes = 3;
		for (int indiceDeComponentes = 0; indiceDeComponentes < cantidadDeComponentes; indiceDeComponentes++) {

			this.agregarComponenteConResistencia(2);
		}
	}


}
