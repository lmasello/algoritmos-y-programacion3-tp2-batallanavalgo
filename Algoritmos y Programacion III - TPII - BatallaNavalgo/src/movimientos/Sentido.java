package movimientos;

public abstract class Sentido {

	public boolean equals(Object otro){
		return this.getClass().equals(otro.getClass());
	}

	public abstract Sentido proximoSentido();

}
