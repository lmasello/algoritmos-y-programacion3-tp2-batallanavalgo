package nave;

public class ComponenteDeNave {
	
	Resistencia resistencia;
	boolean destruida;
	
	
	public ComponenteDeNave (int resistenciaDeNave){
		
		resistencia = new Resistencia(resistenciaDeNave);
		destruida = false;
		
		
	}
	
	public void disparoAComponente (){
		
		resistencia.disminuir();
				
		if (resistencia.obtenerResistencia() == 0){
			destruida = true;
		}
	}
	
	public void destruirComponente(){
		
		resistencia.debilitar();
		destruida = true;
	}
		
	
	
	public boolean estaDestruida(){
			
		return this.destruida;
	}

}
