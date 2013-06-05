package componentesDeTablero;

import jugador.Jugador;
import movimientos.DireccionHorizontal;
import movimientos.DireccionVertical;
import nave.ComponenteDeNave;
import nave.Nave;
import nave.NaveMovible;
import colecciones.ColeccionDeColumnas;
import colecciones.ColeccionDeNaves;
import colecciones.ColeccionDePosiciones;
import disparos.Disparo;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;


public class Tablero {

	ColeccionDeColumnas columnasDelTablero;
	ColeccionDeNaves navesDelTablero;

	public Tablero(int cantidadDeColumnas, int cantidadDeFilas) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {
		/*
		 * Constructor de la clase. Inicializa la clase Tablero con una cantidad
		 * determinada de columnas y filas.
		 * 
		 * Precondiciones: cantidadDeColumnas y cantidadDeFilas deben ser
		 * mayores a 0.
		 */

		 if((cantidadDeColumnas<=0) | (cantidadDeFilas<=0)){
			 throw new ValoresDeParametroFueraDeRango();
		 }
		 
		columnasDelTablero = this.inicializarColumnasConFilas(cantidadDeColumnas, cantidadDeFilas);
		navesDelTablero = new ColeccionDeNaves();
	
	}
	

	public void colocarNavesEnElTablero() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto {
	/*
	 * Metodo que consiste en agregar naves en el tablero.
	 * Esta determinado por la consigna del trabajo la cantidad de naves a colocar.
	 * Dicha cantidad consiste en: 2 lanchas - 2 destructores - 1 buque - 1 portaaviones - 1 rompehielos.
	 * Las posiciones en donde se colocaran dichas naves es arbitraria.
	 * 
	 */
 
		navesDelTablero.establecerNavesDelJuego();
		
		ColeccionDeNaves navesAColocar = navesDelTablero;
		
		for (int numeroDeNaveActual=1 ; numeroDeNaveActual <= navesAColocar.cantidadDeNaves() ; numeroDeNaveActual++){
			
			/*Obtiene nave de la coleccion de naves del juego y coloca una por una en el tablero*/
			Nave naveActual = navesAColocar.naveDeLaPosicion(numeroDeNaveActual); 
			naveActual.tableroEnDondeSeVaADesplazarLaNave(this);
			
			this.colocarNave(naveActual);
		}
		
	}
	
	private void colocarNave(Nave naveActual) throws ValorDeParametroFueraDeRango {
	/*
	 * Metodo que coloca una nave en el tablero.
	 * Establece las posiciones aleatoriamente, pero teniendo en cuenta las dimensiones del barco a colocar.
	 * A su vez, setea la direccion del movimiento de la nave. 
	 * 
	 * Para establecer las posiciones, se selecciona aleatoriamente una posicion determinada,
	 * la cual representara la ubicacion de la proa de la nave. 
	 * Una vez establecida dicha posicion las demas componentes de la nave se ubicaran de acuerdo al largo
	 * determinado de la nave en cuestion y de acuerdo a la orientacion.	
	 */
		
		Posicion posicionDeProa;
		char orientacion = this.establecerOrientacion(); // 'V' vertical | 'H' horizontal
		
		if(orientacion == 'H'){ 
			
			naveActual.direccionDeLaNave(new DireccionHorizontal());
			
			posicionDeProa = this.determinarPosicionDeProaParaNaveHorizontal(naveActual);
			this.colocarComponentesEnDireccionHorizontal(naveActual , posicionDeProa);
		}
		else if(orientacion == 'V'){ 
			
			naveActual.direccionDeLaNave(new DireccionVertical());
			
			posicionDeProa = this.determinarPosicionDeProaParaNaveVertical(naveActual);
			this.colocarComponentesEnDireccionVertical(naveActual , posicionDeProa);
		}
	}
		

	private Posicion determinarPosicionDeProaParaNaveVertical(Nave naveActual) throws ValorDeParametroFueraDeRango {
	/*
	 * Determina aleatoriamente una posicion determinada para la proa de la nave, la cual se ubicara verticalmente. 
	 * Para establecer una posicion de proa valida de la nave, se tiene en cuenta la cantidad de filas que posee el
	 * tablero, como asi tambien la cantidad de componentes que posee la nave. De esta manera, la posicion de la
	 * proa se la calcula, teniendo en cuenta las demas posiciones a colocar. 	
	 */
		
		int cantidadDePosicionesEnFilaNecesariasParaNave = naveActual.cantidadDeComponentes();
		
		char columnaValidaDeProa = this.seleccionarColumnaParaProa();
		int filaValidaDeProa = this.seleccionarFilaParaProa(cantidadDePosicionesEnFilaNecesariasParaNave);
		
		Posicion posicionDeLaProa = this.obtenerPosicion(columnaValidaDeProa, filaValidaDeProa);
		return posicionDeLaProa;
	}

	private int seleccionarFilaParaProa(int cantidadDePosicionesNecesariasParaNave) throws ValorDeParametroFueraDeRango {
	/*
	 * Determina una numero de fila del tablero para ubicar la proa de una nave, teniendo en cuenta que se deben dejar 
	 * disponibles una determinada cantidad de filas hacia abajo (correspondientes a la cantidad de componentes de la nave)
	 * antes de que se acabe el largo del tablero.
	 * 
	 * Precondiciones: cantidadDePosicionesNecesariasParaNave debe ser mayor a 0.
	 */
		int cantidadDeFilasDelTablero = this.cantidadDeFilas();
		int numeroAleatorio;
		
		do{
			numeroAleatorio = this.generarNumeroAleatorioEntreDosValores(1, cantidadDeFilasDelTablero);
		}
		while(numeroAleatorio+cantidadDePosicionesNecesariasParaNave>cantidadDeFilasDelTablero);
	
		int filaInicial = 1;
		int filaSeleccionada = filaInicial + numeroAleatorio-1;
		
		return filaSeleccionada;
	}
	

	private char seleccionarColumnaParaProa() {
	/*
	 * Devuelve un char, haciendo referencia al identificador de una columna del tablero destinada a ubicar
	 * la proa
	 */
		int cantidadDeColumnas = this.cantidadDeColumnas();
		int numeroDeColumnaSeleccionada = this.generarNumeroAleatorioEntreDosValores(1, cantidadDeColumnas);

		int numeroDeColumnaInicial = (int)'A';
		char columnaSeleccionada =(char) (numeroDeColumnaInicial + numeroDeColumnaSeleccionada-1);
		
		return columnaSeleccionada;
	}

	private Posicion determinarPosicionDeProaParaNaveHorizontal(Nave naveActual) throws ValorDeParametroFueraDeRango {
	/*
	 * Determina aleatoriamente una posicion determinada para la proa de la nave, la cual se ubicara horizontalmente. 
	 * Para establecer una posicion de proa valida de la nave, se tiene en cuenta la cantidad de columnas que posee el
	 * tablero, como asi tambien la cantidad de componentes que posee la nave. De esta manera, la posicion de la
	 * proa se la calcula, teniendo en cuenta las demas posiciones a colocar. 	
	*/
		int cantidadDePosicionesEnColumnaNecesariasParaNave = naveActual.cantidadDeComponentes();
		
		char columnaValidaDeProa = this.seleccionarColumnaParaProa(cantidadDePosicionesEnColumnaNecesariasParaNave);
		int filaValidaDeProa = this.seleccionarFilaParaProa();
		
		Posicion posicionDeLaProa = this.obtenerPosicion(columnaValidaDeProa, filaValidaDeProa);
		return posicionDeLaProa;
		
	}

	private int seleccionarFilaParaProa() throws ValorDeParametroFueraDeRango {
	/*
	 * Determina una numero de fila del tablero para ubicar la proa de una nave. 
	*/	
		int cantidadDeFilas = this.cantidadDeFilas();
		int numeroDeFilaSeleccionada = this.generarNumeroAleatorioEntreDosValores(1, cantidadDeFilas);
		
		int filaInicial = 1;
		int filaSeleccionada = filaInicial + numeroDeFilaSeleccionada-1;
		
		return filaSeleccionada;
	}

	private char seleccionarColumnaParaProa(int cantidadDePosicionesNecesariasParaNave) {
	/*
	 * Determina una columna del tablero para ubicar la proa de una nave, teniendo en cuenta que se deben dejar 
	 * disponibles una determinada cantidad de columnas a la izquierda (correspondientes a la cantidad de componentes de la nave) 
	 * antes de que se acabe el ancho del tablero.
	 * 
	 * Precondiciones: cantidadDePosicionesNecesariasParaNave debe ser mayor a 0.
	*/		
		int cantidadDeColumnasDelTablero = this.cantidadDeColumnas();
		int numeroAleatorio;
		
		do{
			numeroAleatorio = this.generarNumeroAleatorioEntreDosValores(1, cantidadDeColumnasDelTablero);
		}
		while((numeroAleatorio-cantidadDePosicionesNecesariasParaNave)<0);
		
		char numeroDePrimeraColumna = (int)'A';

		char columnaSeleccionada =(char)(numeroDePrimeraColumna + numeroAleatorio-1);
		
		return columnaSeleccionada;
		
	}

	private char establecerOrientacion() {
	/*
	 * Establece una orientacion aleatoria, o bien 'H' haciendo referencia a horizontal o bien 'V' haciendo referencia
	 * a vertical.
	 * 
	 * Postcondiciones: devuelve un char indicado la orientacion resultante	
	 */
		
		int numeroAleatorio = this.generarNumeroAleatorioEntreDosValores(0,1); //El numeroAleatorio sera 1 o 0
		char valorADevolver='H'; //Se inicializa con dicho valor, para evitar error de compilador, ya que si se devuelve directo de la estructura condicional, no detecta el tipo y lanza error
		
		if(numeroAleatorio == 0){valorADevolver='H';}
		else if(numeroAleatorio ==1){valorADevolver='V';}
		
		return valorADevolver;
	}

	public int generarNumeroAleatorioEntreDosValores(int desde, int hasta) {
		
		return (int)(Math.random()*(hasta-desde+1)+desde);
		
	}


	public void colocarComponentesEnDireccionHorizontal(Nave naveActual,Posicion posicionDeProa) throws ValorDeParametroFueraDeRango {
		/*
		 * Metodo que coloca de manera horizontal las componentes de una nave en las posiciones del tablero, tomando como referencia la posicion de proa.
		 * En base a estos datos, el metodo procede a poblar las posiciones ubicadas a la izquierda de la posicionDeProa de acuerdo al largo de la nave.	
		 * 
		 * Precondiciones: 
		 * 		naveActual debe contener una cantidad de componentes mayor a 0.
		 * 		posicionDeProa debe ser una posicionValida del tablero y la misma debe tener en cuenta el largo de la nave para que entre toda la nave en el tablero
		 * Postcondiciones:
		 * 		Agrega a cada posicion correspondiente del tablero una componente de la nave 
		 */		
		
		int columnaActual = (int) posicionDeProa.columnaDeLaPosicion();
		int filaActual = posicionDeProa.filaDeLaPosicion();

		int numeroDeComponenteActualDelBarco;
		int cantidadDeComponentes = naveActual.cantidadDeComponentes();
		
		for(numeroDeComponenteActualDelBarco = naveActual.numeroDeComponenteDeLaProa() ; numeroDeComponenteActualDelBarco <= cantidadDeComponentes ; numeroDeComponenteActualDelBarco++){
			
			Posicion posicionAAgregarElComponente = this.obtenerPosicion((char)columnaActual, filaActual);
			ComponenteDeNave componenteAAgregar = naveActual.obtenerComponenteDeNumero(numeroDeComponenteActualDelBarco);

			posicionAAgregarElComponente.agregarComponenteAPosicion(componenteAAgregar);
			
			columnaActual = columnaActual-1; 
		}
	}

	public void colocarComponentesEnDireccionVertical(Nave naveActual,Posicion posicionDeProa) throws ValorDeParametroFueraDeRango {
		/*
		 * Metodo que coloca de manera vertical las componentes de una nave en las posiciones del tablero, tomando como referencia la posicion de proa.
		 * En base a estos datos, el metodo procede a poblar las posiciones ubicadas a abajo de la posicionDeProa de acuerdo al largo de la nave.	
		 * 
		 * Precondiciones: 
		 * 		naveActual debe contener una cantidad de componentes mayor a 0.
		 * 		posicionDeProa debe ser una posicionValida del tablero y la misma debe tener en cuenta el largo de la nave para que entre toda la nave en el tablero
		 * Postcondiciones:
		 * 		Agrega a cada posicion correspondiente del tablero una componente de la nave 
		 */		
		
		char columnaActual = posicionDeProa.columnaDeLaPosicion();
		int filaActual = posicionDeProa.filaDeLaPosicion();

		int numeroDeComponenteActualDelBarco;
		int cantidadDeComponentes = naveActual.cantidadDeComponentes();
		
		for(numeroDeComponenteActualDelBarco = naveActual.numeroDeComponenteDeLaProa() ; numeroDeComponenteActualDelBarco <= cantidadDeComponentes ; numeroDeComponenteActualDelBarco++){
			
			Posicion posicionAAgregarElComponente = this.obtenerPosicion(columnaActual, filaActual);
			ComponenteDeNave componenteAAgregar = naveActual.obtenerComponenteDeNumero(numeroDeComponenteActualDelBarco);
		
			posicionAAgregarElComponente.agregarComponenteAPosicion(componenteAAgregar);
			
			filaActual=filaActual+1; 
		}
	}


	private ColeccionDeColumnas inicializarColumnasConFilas(int cantidadDeColumnas, int cantidadDePosiciones) {
		/*
		 * Metodo que crea una instancia de ColeccionDeColumnas, con una
		 * cantidad de Columnas de acuerdo a lo estipulado por parametro En
		 * donde cada columna va a contener una cantidad de posiciones
		 * estipulada por parametro.
		 * 
		 * Precondiciones: cantidadDeColumnas y cantidadDePosiciones deben ser
		 * mayores a 0. Postcondiciones: devuelve una instancia de
		 * ColeccionDeColumnas
		 */
		ColeccionDeColumnas unaColeccion = new ColeccionDeColumnas();

		for (int numeroDeColumnaActual = 0; numeroDeColumnaActual < cantidadDeColumnas; numeroDeColumnaActual++) {

			Columna columnaAAgregar = new Columna();
			char identificadorDeColumna = (char)((int)'A'+numeroDeColumnaActual);
			
			columnaAAgregar.setIdentificadorDeColumna(identificadorDeColumna);
			columnaAAgregar.numeroDePosicionesDeLaColumna(cantidadDePosiciones);

			unaColeccion.agregarColumna(columnaAAgregar);
		}

		return unaColeccion;

	}

	public Posicion obtenerPosicion(char columnaBuscada, int filaBuscada) throws ValorDeParametroFueraDeRango {
		/*
		 * Metodo que tiene como objetivo obtener una posicion deseada del
		 * tablero.
		 * 
		 * Precondiciones: columnaBuscada debe corresponder a una columna valida
		 * del tablero. filaBuscada debe corresponder a una fila valida del
		 * tablero. Postcondiciones: devuelve la una instancia de Posicion, de
		 * acuerdo a los parametros estipulados por parametro.
		 */
		Columna columnaDeLaPosicionRequerida = columnasDelTablero.obtenerLaColumnaDeIndice(columnaBuscada);

		Posicion posicionRequerida = columnaDeLaPosicionRequerida.obtenerPosicionDeFila(filaBuscada);

		return posicionRequerida;
	}

	public int cantidadDeColumnas() {

		return columnasDelTablero.cantidadDeColumnas();

	}

	public int cantidadDeFilas() throws ValorDeParametroFueraDeRango {

		char unIdentificadorDeColumna = 'A';
		Columna unaColumna = columnasDelTablero.obtenerLaColumnaDeIndice(unIdentificadorDeColumna);

		return unaColumna.cantidadDePosiciones();
	}

	public void pasarTurno(Jugador jugador) {
		/*
		 * Este es un metodo provisorio para disminuir el puntaje del jugador al
		 * avanzar un turno, todas las demas funciones que deba cumplir éste
		 * metodo se irán actualizando
		 */
		/* this.realizarDisparos(); a implementar, recorre la coleccion de disparos
		 * 											actualizando las componentes segun daño 
		 * this.actualizarNaves();  a implementar, recorre todas las naves verificando si estan
		 * 											destruidas     */
		
		jugador.obtenerPuntaje().disminuirPuntajePorPasoDeTurno();

	}
	
	public ColeccionDeNaves obtenerNavesDelTablero(){
		
		return navesDelTablero;
	}


	public int cantidadDeBarcosEnTablero() {
		
		return navesDelTablero.cantidadDeNaves();
	}


	public boolean hayComponenteEnPosicion(char columnaDeLaPosicion, int filaDeLaPosicion) throws ValorDeParametroFueraDeRango {
		
		Posicion posicionAEvaluar = this.obtenerPosicion(columnaDeLaPosicion, filaDeLaPosicion);
		
		return posicionAEvaluar.tieneComponenteDeNave();
	}


	public ColeccionDePosiciones obtenerPosicionesDondeDisparar(Posicion posicionElegida, Disparo disparo) throws ValorDeParametroFueraDeRango{
		/* Devuelve una coleccion de posiciones con todas aquellas posiciones afectadas por el disparo.
		 * Por convension del trabajo, las posiciones afectadas de acuerdo a cada disparo seran:
		 * Disparo Convensional: 1 posicion
		 * Mina Puntual: 1 posicion
		 * Mina por Contacto: 1 posicion
		 * Mina doble: 9 posiciones (la posicion en donde se la deja y todas aquellas posiciones adyacentes de radio 1)
		 * Mina triple: 25 posiciones (la posicion en donde se la deja y todas aquellas posiciones adyacentes de radio 2)
		 * 
		 *  Precondiciones:
		 *      posicionElegida debe ser una posicion del tablero
		 *      disparo debe ser un disparo valido (convencional, mina puntual, mina por contacto, mina doble o mina triple)
		*/

		RecolectorDePosicionesDeDisparo unRecolectorDePosiciones = new RecolectorDePosicionesDeDisparo(this);
		ColeccionDePosiciones posicionesADisparar = unRecolectorDePosiciones.obtenerPosicionesDeDisparo(posicionElegida, disparo);
		
		return posicionesADisparar;
	}


	public void impactarDisparos() throws ValorDeParametroFueraDeRango {
		
		/* Recorre todas las posiciones del tablero, si la posicion tiene algun/os disparo/s
		 * realiza el impacto de el/los mismo/s, luego remueve los componentes que fueron eliminados.
		 * */
			for(int numeroDeFilaActual = 1 ; numeroDeFilaActual<= this.cantidadDeFilas() ; numeroDeFilaActual++){
			
				for(int numeroDeColumnaActual = 0; numeroDeColumnaActual < this.cantidadDeColumnas() ; numeroDeColumnaActual++){				

				int numeroDeIdentificadorDeColumnaInicial = (int)'A';			
				char identificadorDeColumnaActual = (char) (numeroDeIdentificadorDeColumnaInicial + numeroDeColumnaActual);
				
				Posicion posicionActual = this.obtenerPosicion(identificadorDeColumnaActual, numeroDeFilaActual);
				
					  if(posicionActual.tieneDisparo()){
						posicionActual.impactoDeLosDisparos();
					  }
					  	posicionActual.removerComponentesEliminadas();
				}
			}			
	}


	public boolean noTieneLaColumna(char unaColumna) {
		/*
		 * Devuelve true si el tablero no contiene la columna de identificador pasado por parametro
		 */
		
		return (!columnasDelTablero.tieneLaColumnaDeIdentificador(unaColumna));
		
	}


	public boolean noTieneLaFila(int unaFila) {
		/*
		 * Devuelve true si el tablero no contiene la fila de identificador pasado por parametro
		 */
		return (!columnasDelTablero.tieneFila(unaFila));
	}


	public void moverNaves() {
	/*
	 * Realiza el desplazamiento de cada nave del tablero. 
	 */
		for(int indiceDeNaveActual = 1 ; indiceDeNaveActual<=this.cantidadDeBarcosEnTablero(); indiceDeNaveActual++){
			
			NaveMovible naveAMover = navesDelTablero.naveDeLaPosicion(indiceDeNaveActual);
			
			naveAMover.moverComponentes();
		}
	}
		
}

