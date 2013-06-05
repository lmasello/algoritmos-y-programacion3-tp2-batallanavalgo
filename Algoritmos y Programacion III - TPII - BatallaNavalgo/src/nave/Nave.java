package nave;

import componentesDeTablero.Tablero;

import movimientos.Derecha;
import movimientos.Direccion;
import movimientos.Sentido;
import colecciones.ColeccionDeComponentes;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;

public abstract class Nave implements NaveMovible {

	ColeccionDeComponentes componentes;
	boolean estaDestruida;
	int largoDeLaNave;
	Resistencia resistenciaDeLaNave;
	
	/*Los siguientes atributos corresponden a la implementacion de lo citado en la interfaz naveMovible*/
	
	Direccion direccionDeLaNave;
	Tablero tableroEnDondeSeDesplaza;

	public Nave() {
		componentes = new ColeccionDeComponentes();
		estaDestruida = false;
	}
	
	public void agregarComponentes(){
	/*
	 * Agrega la cantidad de componentes correspondientes a cada nave,
	 * Cada nave tiene una cantidad determinada de componentes	
	 */
		for (int indiceDeComponentes = 0; indiceDeComponentes < largoDeLaNave; indiceDeComponentes++) {

			ComponenteDeNave componenteAAgregar = new ComponenteDeNave(resistenciaDeLaNave,this);
			componenteAAgregar.establecerTableroEnDondeSeEncuentraLaComponente(tableroEnDondeSeDesplaza);
			componenteAAgregar.establecerDireccion(direccionDeLaNave);
			
			this.agregarComponenteALaNave(componenteAAgregar);
		}
	}

	public boolean estaDestruida() throws ValorDeParametroFueraDeRango {
		
	/* Recorre las componentes de la nave y se fija si alguna esta destruida.
	 * Si todas estan destruidas entonces la nave esta destruida 
	 * */
		
		for( int numeroDeComponente = 1; numeroDeComponente <= componentes.cantidadDeComponentes();
				 	numeroDeComponente++){
			estaDestruida = componentes.obtenerComponente(numeroDeComponente).estaDestruida();
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
			
		for (int indiceDeComponentes = 1; indiceDeComponentes <= componentes.cantidadDeComponentes(); indiceDeComponentes++) {

			ComponenteDeNave componente = componentes.obtenerComponente(indiceDeComponentes);
			componente.destruirComponente();

		}

		estaDestruida = true;
	}

	public int numeroDeComponenteDeLaProa(){
	/*
	 * Se toma como supuesto que la proa es la primer componente de la nave	
	 */
		return 1;
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
	public void moverComponentes(){
	
		Sentido sentidoActualDelMovimiento = direccionDeLaNave.sentidoDeLaDireccion();  
		/*El proximo indice hace referencia a que si por ejemplo el sentido es Derecha, la nave se tiene que comenzar a mover de la 
		 * posicion que se encuentre mas a la derecha, sucede lo contrario con el sentido Izquierda
		 */
		int indiceDeLaComponenteQueSeComienzaAMover = this.determinarIndiceDeLaNaveQueSeComienzaAMover();
		
		if (indiceDeLaComponenteQueSeComienzaAMover = 1){
			this.moverEnSentidoPositivo();
		}
		else if(indiceDeLaComponenteQueSeComienzaAMover = this.cantidadDeComponentes()){
			this.moverEnSentidoNegativo();
		}

	}
	
	@Override
	public void tableroEnDondeSeVaADesplazarLaNave(Tablero tableroEnDondeMoverse){
		tableroEnDondeSeDesplaza = tableroEnDondeMoverse;
	}
	
	@Override
	public void direccionDeLaNave(Direccion direccionQueVaATenerLaNave){
		direccionDeLaNave = direccionQueVaATenerLaNave;
		direccionDeLaNave.tableroDeLasPosiciones(tableroEnDondeSeDesplaza);
	}

	
}
