package testsIntegrales;

import static org.junit.Assert.*;

import org.junit.Test;

import tablero.Tablero;

public class TableroTest {

	public void testCrearTableroDe10FilasPor10Columnas(){
		/* Metodo que prueba el inicializador del tablero, el cual se inicializa con 10 filas y 10 columnas. 
		Primer parametro del constructor representa el numero de columnas y el segundo parametro representa el numero de filas.
		*/
		
		Tablero tableroDelJuego = new Tablero(10,10); 
		
		assertNotNull (tableroDelJuego);
	}
	
	public void testInicializaElTableroCon7Naves(){
		/* Metodo que prueba el inicializador del tablero, el cual se inicializa con 7 naves. 
		 * La ubicacion inicial de las naves es arbitraria.
		 * */
		
		Tablero tableroDelJuego = new Tablero(10,10);
		
		assertEquals (7 , tablero.cantidadDeNavesEnElTablero());
	}
	
	public void testExaminarSiUnaPosicionDeterminadaPoseeUnaComponenteDeUnaNave(){
		
		tablero tableroDelJuego = new Tablero(10,10);
		
		tablero.insertarComponenteDeNaveEnPosicion(1,1);
		
		assertEquals (true , tablero.laPosicionTieneComponenteDeNave('A',1));
		
	}

	public void testRealizarDisparoAUnaPosicionQueTieneUnaComponenteDeResistenciaDeUnTiro(){
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Disparo disparoAgresivo = new Disparo();
		
		assertEquals (true, tablero.laPosicionTieneComponenteDeNave('A',1));
		
		tablero.realizarDisparoALaPosicion(disparoAgresivo , 'A' , 1); //Al recibir el impacto la componente desaparece
		
		assertEquals (false, tablero.laPosicionTieneComponenteDeNave('A',1));
				
	}

	public void testRealizarDisparoAUnaPosicionQueTieneUnaComponenteDeResistenciaDeDosTiros(){
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Disparo disparoAgresivo = new Disparo();
		
		assertEquals (true, tablero.laPosicionTieneComponenteDeNave('A',1));
		
		tablero.realizarDisparoALaPosicion(disparoAgresivo , 'A' , 1);
		
		assertEquals (true, tablero.laPosicionTieneComponenteDeNave('A',1));
		
		tablero.realizarDisparoALaPosicion(disparoAgresivo , 'A' , 1);
		
		assertEquals (false, tablero.laPosicionTieneComponenteDeNave('A',1)); //Luego de disparar dos veces, la componente desaparece
}

	public void testDinamicaDeUnTurno(){
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Jugador jugadorHumano = new Jugador("Leandro Masello");
		
		jugadorHumano.dispararDisparoConvencionalEnPosicion(2,4);
		
		assertEquals (9800 , jugadorHumano.puntaje());
	}
	
	public void testDinamicaDeDosTurnos(){
		
		Tablero tableroDelJuego = new Tablero(10,10);
		Jugador jugadorHumano = new Jugador("Leandro Masello");
		
		jugadorHumano.dispararMinaSubmarinaPuntualEnPosicion('C',5);
		
		tableroDelJuego.nuevoTurno(); //Realiza el movimiento de las naves y resta puntaje al jugador
		
		jugadorHumano.dispararMinaSubmarinaDobleEnPosicion('H',8);
		
		assertEquals ( 9840 , jugadorHumano.puntaje()); //Le resta el puntaje de los dos disparos y del turno
	}

}