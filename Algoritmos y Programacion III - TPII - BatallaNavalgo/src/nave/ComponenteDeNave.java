package nave;

public class ComponenteDeNave {

	Resistencia resistencia;
	boolean destruida;
	Nave naveALaQuePertenece;

	public ComponenteDeNave(Resistencia resistenciaDeNave, Nave nave) {

		resistencia = resistenciaDeNave;
		destruida = false;
		naveALaQuePertenece = nave;

	}

	public void disparoAComponente() {

		resistencia.disminuir();

		if (resistencia.obtenerResistencia() == 0) {
			destruida = true;
		}
	}

	public void destruirComponente() {

		resistencia.debilitar();
		destruida = true;
	}

	public boolean estaDestruida() {

		return this.destruida;
	}

	public Nave obtenerNaveALaQuePertenece(){
		
		return naveALaQuePertenece;
	}
}
