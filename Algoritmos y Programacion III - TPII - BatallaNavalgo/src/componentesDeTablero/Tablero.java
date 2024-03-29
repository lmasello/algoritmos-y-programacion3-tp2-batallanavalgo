package componentesDeTablero;

import java.util.Iterator;

import recolectorDePosiciones.RecolectorDePosicionesDeDisparo;
import jugador.Jugador;
import movimientos.Direccion;
import movimientos.DireccionHorizontal;
import movimientos.DireccionVertical;
import nave.ComponenteDeNave;
import nave.Nave;
import nave.NaveMovible;
import colecciones.ColeccionDeColumnas;
import colecciones.ColeccionDeNaves;
import colecciones.ColeccionDePosiciones;
import disparos.Disparo;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.NoHayDisparoParaColocarEnLaPosicion;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;


public class Tablero {

	private static Tablero INSTANCE = null;
	
	private static int CANTIDAD_DE_COLUMNAS = 10;
	private static int CANTIDAD_DE_FILAS = 10;
	
	ColeccionDeColumnas columnasDelTablero;
	ColeccionDeNaves navesDelTablero;

	//Constructor privado
	private Tablero() throws ValoresDeParametroFueraDeRango{
		/*
		 * Constructor de la clase. Inicializa la clase Tablero con una cantidad
		 * determinada de columnas y filas.
		 * 
		 * Precondiciones: cantidadDeColumnas y cantidadDeFilas deben ser
		 * mayores a 0.
		 */

		 if((CANTIDAD_DE_COLUMNAS<=0) | (CANTIDAD_DE_FILAS<=0)){
			 throw new ValoresDeParametroFueraDeRango();
		 }
		 
		columnasDelTablero = this.inicializarColumnasConFilas(CANTIDAD_DE_COLUMNAS, CANTIDAD_DE_FILAS);
		navesDelTablero = new ColeccionDeNaves();
	
	}
	
	public static Tablero getInstance() throws ValoresDeParametroFueraDeRango{
		createInstance();
		return INSTANCE;
	}
	
	private synchronized static void createInstance() throws ValoresDeParametroFueraDeRango {
	    // creador sincronizado para protegerse de posibles problemas  multi-hilo
	    // otra prueba para evitar instanciación múltiple 	
		if(INSTANCE == null){
			INSTANCE = new Tablero();
		}
	}
	
	public static Tablero deleteInstance() throws ValoresDeParametroFueraDeRango{
		return INSTANCE = null;
	}

	public void colocarNavesEnElTablero() throws ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
	/*
	 * Metodo que consiste en agregar naves en el tablero.
	 * Esta determinado por la consigna del trabajo la cantidad de naves a colocar.
	 * Dicha cantidad consiste en: 2 lanchas - 2 destructores - 1 buque - 1 portaaviones - 1 rompehielos.
	 * Las posiciones en donde se colocaran dichas naves es arbitraria.
	 * 
	 */
 
		this.establecerNavesDelJuego();

		Iterator iterator = navesDelTablero.iterator();
		
		while(iterator.hasNext()){
			Nave naveActual = (Nave) iterator.next();
			this.colocarNave(naveActual);
		}		
	}
	
	private void establecerNavesDelJuego() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango {
		
		navesDelTablero.establecerNavesDelJuego();
	}

	private void colocarNave(Nave naveActual) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {
	/*
	 * Metodo que coloca una nave en el tablero, de acuerdo a una direccion aleatoria.
	 * A su vez, setea la direccion del movimiento de la nave. 
	 * 
	 */
		
		Direccion direccion = this.establecerOrientacion(); // direccionVertical | direccionHorizontal
		naveActual.establecerDireccionDelMovimiento(direccion);

		this.ubicarNaveEnTablero(naveActual, direccion);
		
	}
		
	private void ubicarNaveEnTablero(Nave naveActual, Direccion direccion) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {
	/*
	 * Establece las posiciones aleatoriamente, pero teniendo en cuenta las dimensiones del barco a colocar, y
	 * la direccion inicial de la nave.
	 * A su vez, setea la direccion del movimiento de la nave. 
	 * 
	 * Para establecer las posiciones, se selecciona aleatoriamente una posicion determinada,
	 * la cual representara la ubicacion de la proa de la nave. 
	 * Una vez establecida dicha posicion las demas componentes de la nave se ubicaran de acuerdo al largo
	 * determinado de la nave en cuestion y de acuerdo a la orientacion.	
	 */
				
		Posicion posicionDeProa;
		
		if(direccion.equals(new DireccionHorizontal())){ 

			posicionDeProa = this.determinarPosicionDeProaParaNaveHorizontal(naveActual);
			this.colocarComponentesEnDireccionHorizontal(naveActual , posicionDeProa);
		}
		
			
		else if(direccion.equals(new DireccionVertical())){ 
			
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

	private Direccion establecerOrientacion() throws ValoresDeParametroFueraDeRango {
	/*
	 * Establece una orientacion aleatoria, o bien 'H' haciendo referencia a horizontal o bien 'V' haciendo referencia
	 * a vertical.
	 * 
	 * Postcondiciones: devuelve un char indicado la orientacion resultante	
	 */
		
		int numeroAleatorio = this.generarNumeroAleatorioEntreDosValores(0,1); //El numeroAleatorio sera 1 o 0
		Direccion direccionADevolver = null;
		
		if(numeroAleatorio == 0){direccionADevolver= new DireccionHorizontal();}
		else if(numeroAleatorio ==1){direccionADevolver=new DireccionVertical();}
		
		return direccionADevolver;
	}

	public int generarNumeroAleatorioEntreDosValores(int desde, int hasta) {
		
		return (int)(Math.random()*(hasta-desde+1)+desde);
		
	}

	public void colocarComponentesEnDireccionHorizontal(Nave naveAColocar,Posicion posicionDeProa) throws ValorDeParametroFueraDeRango {
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
		
		for(int numeroDeComponenteActualDelBarco = naveAColocar.numeroDeComponenteDeLaProa() ; numeroDeComponenteActualDelBarco <= naveAColocar.cantidadDeComponentes() ; numeroDeComponenteActualDelBarco++){
			
			Posicion posicionAAgregarElComponente = this.obtenerPosicion((char)columnaActual, filaActual);
			ComponenteDeNave componenteAAgregar = naveAColocar.obtenerComponenteDeNumero(numeroDeComponenteActualDelBarco);

			componenteAAgregar.establecerPosicionActual(posicionAAgregarElComponente);
			
			columnaActual = columnaActual-1; 
		}
	}

	public void colocarComponentesEnDireccionVertical(Nave naveAColocar,Posicion posicionDeProa) throws ValorDeParametroFueraDeRango {
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
		
		for(int numeroDeComponenteActualDelBarco = naveAColocar.numeroDeComponenteDeLaProa() ; numeroDeComponenteActualDelBarco <= naveAColocar.cantidadDeComponentes() ; numeroDeComponenteActualDelBarco++){
			
			Posicion posicionAAgregarElComponente = this.obtenerPosicion(columnaActual, filaActual);
			ComponenteDeNave componenteAAgregar = naveAColocar.obtenerComponenteDeNumero(numeroDeComponenteActualDelBarco);
		
			componenteAAgregar.establecerPosicionActual(posicionAAgregarElComponente);
			
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

	private void removerComponentesDeNavesEliminadas() throws ValorDeParametroFueraDeRango {
		/*
		 * Recorre las naves que se encuentran en el tablero removiendo las componentes de cada
		 * una que hayan sido eliminadas previamente.
		 */
		for(int numeroDeNave = 1; numeroDeNave <= navesDelTablero.cantidadDeNaves(); numeroDeNave++){
			
			Nave naveActual = navesDelTablero.naveDeLaPosicion(numeroDeNave);
		}
	}


	public ColeccionDeNaves obtenerNavesDelTablero(){
		
		return navesDelTablero;
	}

	public int cantidadDeBarcosEnTablero() {
		
		return navesDelTablero.cantidadDeNaves();
	}

	public boolean hayComponenteEnPosicion(char columnaDeLaPosicion, int filaDeLaPosicion) throws ValorDeParametroFueraDeRango {
		/*
		 * Evalua si una posicion del tablero pasada por parametro, tiene una componente de nave
		 */
		Posicion posicionAEvaluar = this.obtenerPosicion(columnaDeLaPosicion, filaDeLaPosicion);
		
		return posicionAEvaluar.tieneComponenteDeNave();
	}

	private ColeccionDePosiciones obtenerPosicionesDondeDisparar(Posicion posicionElegida, Disparo disparo) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
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

		RecolectorDePosicionesDeDisparo unRecolectorDePosiciones = new RecolectorDePosicionesDeDisparo();
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
				}
			}
			this.quitarNavesEliminadas();

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

	public void moverNaves() throws ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene {
	/*
	 * Realiza el desplazamiento de cada nave del tablero. 
	 */
		Iterator<ColeccionDeNaves> iterator = navesDelTablero.iterator();
		while(iterator.hasNext()){
			NaveMovible naveAMover = (NaveMovible) iterator.next();
			naveAMover.moverComponentes();
		}

	}


	public boolean tieneLaColumna(char unaColumna) {
		
		return (columnasDelTablero.tieneLaColumnaDeIdentificador(unaColumna));

	}


	public boolean tieneLaFila(int unaFila) {
		
		return (columnasDelTablero.tieneFila(unaFila));
		
	}
	
	public void agregarNaveHorizontalManualmenteConPosicionDeProa(Nave naveAgregada , Posicion posicionDeProa) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango{
	/*
	 * Metodo creado para poder tener un control sobre las posiciones en donde se ubicara la nave, ya que cuando se
	 * realiza la asignacion automatica, esta asignacion es aleatoria y se pierde el control de que posiciones 
	 * continen componentes y cuales otras no.	
	 */
		navesDelTablero.agregarNave(naveAgregada);
		
		naveAgregada.establecerDireccionDelMovimiento(new DireccionHorizontal());

		this.colocarComponentesEnDireccionHorizontal(naveAgregada, posicionDeProa);
	}


	public void agregarNaveVerticalManualmenteConPosicionDeProa(Nave naveAColocar, Posicion posicionDeProaDeLanchaAColocar) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango {
		/*
		 * Metodo creado para poder tener un control sobre las posiciones en donde se ubicara la nave, ya que cuando se
		 * realiza la asignacion automatica, esta asignacion es aleatoria y se pierde el control de que posiciones 
		 * continen componentes y cuales otras no.	
		 */
		navesDelTablero.agregarNave(naveAColocar);
			
		naveAColocar.establecerDireccionDelMovimiento(new DireccionVertical());

		this.colocarComponentesEnDireccionVertical(naveAColocar, posicionDeProaDeLanchaAColocar);
	}
	
	public void quitarNavesEliminadas() throws ValorDeParametroFueraDeRango{
		
		Iterator<Nave> iterator = navesDelTablero.iterator();
		while(iterator.hasNext()){
			Nave naveAEliminar = iterator.next();
			if(naveAEliminar.estaDestruida()){
				iterator.remove();
			}
		}
		
		for(int numeroDeNave = 1; numeroDeNave<= navesDelTablero.cantidadDeNaves(); numeroDeNave++){
			Nave naveAEliminar = navesDelTablero.naveDeLaPosicion(numeroDeNave);
			if(naveAEliminar.estaDestruida()){
				navesDelTablero.quitarNave(naveAEliminar);
			}
		}
	}
	

	public void realizarDisparoALaPosicion( Disparo disparo, Posicion posicionElegida) throws ValorDeParametroFueraDeRango, ValoresDeParametroFueraDeRango, NoHayDisparoParaColocarEnLaPosicion{
		/* Metodo que a partir de un disparo y una posicion elegida, obtiene todas las posiciones afectadas por ese disparo,
		 * y lo ubica en las mismas.
		 */
		
		if(disparo==null){
			throw new NoHayDisparoParaColocarEnLaPosicion();
		}
		ColeccionDePosiciones posicionesAfectadas = this.obtenerPosicionesDondeDisparar(posicionElegida, disparo);
		this.colocarDisparoEnPosicionesAfectadas(disparo, posicionesAfectadas);
	}

	private void colocarDisparoEnPosicionesAfectadas(Disparo disparo,ColeccionDePosiciones posicionesAfectadas) throws ValorDeParametroFueraDeRango {
		
	/* Recorre la coleccion de posiciones. Crea el disparo correspondiente y lo
	 * agrega a la posicion. Al finalizar disminuye el puntaje debido al disparo seleccionado 
	 */
		
		for(int posicionEnColeccion = 1; posicionEnColeccion < posicionesAfectadas.cantidadDePosiciones()
				; posicionEnColeccion++){
				Posicion posicionActual = posicionesAfectadas.obtenerPosicionDeLaFila(posicionEnColeccion);
				Disparo disparoAAgregar = disparo.crearDisparo();
				posicionActual.agregarDisparoAPosicion(disparoAAgregar);
		}	
		Posicion posicionAAgregar = posicionesAfectadas.obtenerPosicionDeLaFila(posicionesAfectadas.cantidadDePosiciones());
		posicionAAgregar.agregarDisparoAPosicion(disparo);
	}
}

