package nave;

public class PortaAviones extends Nave {
	
	public PortaAviones() {

		cantidadDeComponentes = 5;
		for (int indiceDeComponentes = 0; indiceDeComponentes < cantidadDeComponentes; indiceDeComponentes++) {

			this.agregarComponenteConResistencia(1);
		}
	}


}
