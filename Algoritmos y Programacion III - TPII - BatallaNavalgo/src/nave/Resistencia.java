package nave;

public class Resistencia {

	private int resistencia;

	public Resistencia(int nivelDeResistencia) {

		resistencia = nivelDeResistencia;

	}

	public int obtenerResistencia() {

		return this.resistencia;
	}

	public void disminuir() {

		if (resistencia > 0) {
			resistencia = resistencia - 1;
		}

	}

	public void debilitar() {

		resistencia = 0;

	}

}
