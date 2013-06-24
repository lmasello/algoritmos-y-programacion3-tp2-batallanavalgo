package nave;

public class Resistencia {

	private int resistencia;

	public Resistencia(int nivelDeResistencia) {
		/*
		 * Constructor de la clase, el cual inicializa la clase con un nivel determinado de Resistencia. Mientras
		 * mayor sea dicho numero, mayor sera la resistencia 
		 */
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

	public void reducirACero() {

		resistencia = 0;

	}

	public Resistencia nuevaResistencia() {
		return new Resistencia(this.obtenerResistencia());
	}

}
