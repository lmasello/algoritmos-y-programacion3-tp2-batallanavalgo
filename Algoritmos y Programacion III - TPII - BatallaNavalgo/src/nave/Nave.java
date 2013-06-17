package nave;

import java.util.Iterator;

import componentesDeTablero.Tablero;

import movimientos.Derecha;
import movimientos.Direccion;
import movimientos.Sentido;
import colecciones.ColeccionDeComponentes;
import disparos.Disparo;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

public abstract class Nave implements NaveMovible {

	private static int NUMERO_DE_PROA=1;
	
	ColeccionDeComponentes componentes;
	boolean estaDestruida;
	int largoDeLaNave;
	Resistencia resistenciaDeLaNave;
	
	/*Los siguientes atributos corresponden a la implementacion de lo citado en la interfaz naveMovible*/
	
	Direccion direccionDeLaNave;
	Tablero tableroEnDondeSeDesplaza;

	public Nave() throws ValoresDeParametroFueraDeRango {
		
		componentes = new ColeccionDeComponentes();
		estaDestruida = false;
		tableroEnDondeSeDesplaza = Tablero.getInstance();

	}
	
	public void agregarComponentes() throws ValoresDeParametroFueraDeRango{
	/*
	 * Agrega la cantidad de componentes correspondientes a cada nave,
	 * Cada nave tiene una cantidad determinada de componentes	
	 */
		for (int indiceDeComponentes = 0; indiceDeComponentes < largoDeLaNave; indiceDeComponentes++) {

			ComponenteDeNave componenteAAgregar = new ComponenteDeNave(resistenciaDeLaNave,this);
			
			this.agregarComponenteALaNave(componenteAAgregar);
		}
	}

	public boolean estaDestruida() throws ValorDeParametroFueraDeRango {
		
	/* Recorre las componentes de la nave y se fija si alguna esta destruida.
	 * Si todas estan destruidas entonces la nave esta destruida 
	 * */
		
		boolean estaDestruida=true;
		
		Iterator<ComponenteDeNave> iterator = componentes.iterator();
		
		while(iterator.hasNext()){
			ComponenteDeNave componente = iterator.next();
			if(!componente.estaDestruida()){
				estaDestruida = false;
			}
		}				
		return estaDestruida;
	}
	
	public int cantidadDeComponentes(){
		
		return componentes.cantidadDeComponentes();
		
	}
	
	protected void establecerLargoDeLaNave(int largo) throws LargoDeNaveIncorrecto{
	/*
	 * Establece el largo medido en casillas predefinido por la consigna del trabajo.
	 * Los largos posibles son: 
	 * Lancha: 2 ; Destructores: 3 ; Buque: 4 ; Portaaviones: 5 ; RompeHielos: 3   
	 */
		
		if((largo!=2) & (largo!=3) & (largo!=4) &(largo!=5)){
			throw new LargoDeNaveIncorrecto();
		}
		
		largoDeLaNave = largo;
		
	}
	
	protected void establecerResistenciaDeLaNave(Resistencia resistenciaAAgregar){
		resistenciaDeLaNave = resistenciaAAgregar;
	}
		
	protected void agregarComponenteALaNave(ComponenteDeNave componenteAAgregar){
		
		componentes.agregarComponente(componenteAAgregar);
		
	}

	public void destruirNave() throws ValorDeParametroFueraDeRango {
		/* Destruye cada componente de la nave */
			
		Iterator<ComponenteDeNave> iterator = componentes.iterator();
		while(iterator.hasNext()){
			ComponenteDeNave componente = iterator.next();
			componente.destruirComponente();
		}
		estaDestruida = true;
	}

	public int numeroDeComponenteDeLaProa(){
	/*
	 * Se toma como supuesto que la proa es la primer componente de la nave	
	 */
		return NUMERO_DE_PROA;
	}
	
	public int numeroDeComponenteDeLaPopa() {
	/*
	 * Se establece la ultima componente de la nave como Popa del barco
	 */
		return this.cantidadDeComponentes();
	}

	protected Resistencia resistenciaDeLaNave(){
		
		return resistenciaDeLaNave;
		
	}
	
	public ComponenteDeNave obtenerComponenteDeNumero(int numeroDeComponenteDeseada) throws ValorDeParametroFueraDeRango {
	/*
	 * Devuelve la componente de la nave de acuerdo al indice pasado por parametro.
	 * 
	 * Precondiciones: 
	 * 		numeroDeComponenteDeseada debe ser mayor a 0 y menor o igual a la cantidad de componentes de la nave	
	 */
		
		if((numeroDeComponenteDeseada<=0)&(numeroDeComponenteDeseada>this.cantidadDeComponentes())){
			throw new ValorDeParametroFueraDeRango();
		}
			
		return componentes.obtenerComponente(numeroDeComponenteDeseada);
		
	}
	
	public boolean esDestructor(){ 
		
		return false;
	}
	
	@Override
	public void moverComponentes() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene{
	/*
	 * Mueve cada una de las componentes de la Nave, teniendo en cuenta las componentes de los extremos en los rebotes
	 * con los limites del tablero en donde se mueve. Para ello, toma en cuenta si tiene que comenzar a moverse
	 * a partir de la componente de proa o de popa, continuando luego por todo el barco
	 */
		int numeroDeComponenteQueComienzaAMoverse = this.determinarIndiceDeLaNaveQueSeComienzaAMover();
		
		if (numeroDeComponenteQueComienzaAMoverse == this.numeroDeComponenteDeLaProa()){
			this.moverEnSentidoPositivo();
		}
		else if(numeroDeComponenteQueComienzaAMoverse == this.cantidadDeComponentes()){
			this.moverEnSentidoNegativo();
		}

	}
	
	private void establecerSentidoDelProximoMovimiento(ComponenteMovible componenteQueComienzaAMoverse) {
		/*
		 * Determina si es necesario cambiar el sentido de la nave para realizar el movimiento en conjunto de todas sus componentes
		 * En caso de considerarlo necesario, cambia al sentido opuesto. Este caso se da si la componenteAMoverse chocaria con el borde del
		 * tablero y tenga que cambiar su sentido. En caso que no tenga que hacer un cambio de direccion, no hace nada
		 */
		if(!componenteQueComienzaAMoverse.puedeAvanzar()){//Si no puede avanzar, quiere decir que la primer componente va a chocar contra el final del tablero y cambiar el sentido de su movimiento

			direccionDeLaNave.cambiarSentido();
			}
	}

	private int determinarIndiceDeLaNaveQueSeComienzaAMover() throws ValorDeParametroFueraDeRango {
		/*
		 * Determina que componente de la nave comienza a desplazarse, si la proa o la popa.
		 * Esto se realiza para que todas las componentes se muevan 
		 * como un solo bloque (la nave) y se eviten situaciones en las que una componente se mueva en un sentido y las otras componentes
		 * en otro sentido.
		 * Por ejemplo: El sentido inicial de la nave es hacia la derecha, la nave contiene 3 componentes y aquella componente que se encuentra
		 * mas hacia la derecha esta en el borde derecho del tablero. Si no se aplica una logica, dicha componente se va a mover hacia
		 * la izquierda y las demas componentes hacia la derecha. Lo que hace este metodo es, una vez que la componente que cambia de sentido
		 * , actualizar dicho sentido en la nave, y asi las demas componentes se van a desplazar en el mismo sentido 
		 */
		int numeroDeComponenteQueComienzaAMoverse = direccionDeLaNave.numeroDeComponenteDelantera(this);
		
		this.establecerSentidoDelProximoMovimiento(this.obtenerComponenteDeNumero(numeroDeComponenteQueComienzaAMoverse));

		numeroDeComponenteQueComienzaAMoverse = direccionDeLaNave.numeroDeComponenteDelantera(this);

		return numeroDeComponenteQueComienzaAMoverse;
		
	}

	private void moverEnSentidoNegativo() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
	/*
	 * Realiza el movimiento de las componentes comenzando por la componente que se encuentre en la posicion más negativa (ala izquierda o bien ala inferior)
	 */
	
		int indiceDeLaPopa;
		
		for(indiceDeLaPopa=this.cantidadDeComponentes() ; indiceDeLaPopa>=1  ; indiceDeLaPopa--){
			
			ComponenteMovible componenteAMover = this.obtenerComponenteDeNumero(indiceDeLaPopa);
			
			componenteAMover.mover();
		}
	}

	private void moverEnSentidoPositivo() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
	/*
	 * Realiza el movimiento de las componentes comenzando por la componente que se encuentre en la posicion más positiva (ala derecha o bien ala superior)
	 */
	
		int indiceDeLaProa;
		
		for(indiceDeLaProa=1 ; indiceDeLaProa<= this.cantidadDeComponentes() ; indiceDeLaProa++){
			
			ComponenteMovible componenteAMover = this.obtenerComponenteDeNumero(indiceDeLaProa);
			
			componenteAMover.mover();
		}
		
	}
	
	public void establecerDireccionDelMovimiento(Direccion unaDireccion) throws ValorDeParametroFueraDeRango{
		/*
		 * Establece la direccion de movimiento a la nave. Tambien, establece dicha dirección a cada una de las
		 * componentes de la nave
		 */
		direccionDeLaNave = unaDireccion;
		this.establecerMismaDireccionALasComponentes();
	}

	private void establecerMismaDireccionALasComponentes() throws ValorDeParametroFueraDeRango {
		
		Iterator<ComponenteDeNave> iterator = componentes.iterator();
		while(iterator.hasNext()){
			ComponenteMovible componenteDeLaNave = iterator.next();
			componenteDeLaNave.establecerDireccion();
		}
	}


	public Direccion direccionDeLaNave() {
		return direccionDeLaNave;
	}

	public boolean puedeRecibirDisparoDe(Disparo disparo){
		/* Las naves pueden recibir cualquiera disparo, excepto la nave Destructor
		 * que solo puede ser impactada por un disparo convencional (Ver Destructor).
		 */
		return true;
	}
}
