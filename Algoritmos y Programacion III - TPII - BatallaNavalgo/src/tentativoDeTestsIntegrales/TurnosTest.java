package tentativoDeTestsIntegrales;

import pruebaGrafica.GraficadorDeTableroEnConsola;
import nave.Buque;
import nave.Destructor;
import nave.Lancha;
import nave.Nave;
import nave.PortaAviones;
import nave.RompeHielos;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import disparos.Disparo;
import disparos.DisparoConvencional;
import excepciones.ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene;
import excepciones.LargoDeNaveIncorrecto;
import excepciones.NoHayDisparoParaColocarEnLaPosicion;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;

import jugador.Jugador;
import junit.framework.TestCase;

public class TurnosTest extends TestCase {
	
	public void testPrimerTurnoCompletoSinGrafico() throws ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene, NoHayDisparoParaColocarEnLaPosicion{
		
			Tablero tableroDePrueba = Tablero.getInstance();
			Jugador jugador1 = new Jugador("Robert");
			Nave nave1 = new Lancha();
			Nave nave2 = new Buque();
			Nave nave3 = new Destructor();
			Nave nave4 = new PortaAviones();
			Nave nave5 = new RompeHielos();
			
			Posicion posicion1 = tableroDePrueba.obtenerPosicion('C', 3);
			Posicion posicion2 = tableroDePrueba.obtenerPosicion('F', 6);
			Posicion posicion3 = tableroDePrueba.obtenerPosicion('I', 2);
			Posicion posicion4 = tableroDePrueba.obtenerPosicion('C', 2);
			Posicion posicion5 = tableroDePrueba.obtenerPosicion('D', 3);
			
			tableroDePrueba.agregarNaveHorizontalManualmenteConPosicionDeProa(nave1, posicion1);
			tableroDePrueba.agregarNaveVerticalManualmenteConPosicionDeProa(nave2, posicion1);
			tableroDePrueba.agregarNaveHorizontalManualmenteConPosicionDeProa(nave3, posicion2);
			tableroDePrueba.agregarNaveVerticalManualmenteConPosicionDeProa(nave4, posicion2);
			tableroDePrueba.agregarNaveVerticalManualmenteConPosicionDeProa(nave5, posicion3);
			
			jugador1.asignarTablero(tableroDePrueba);
			
			Disparo disparo1 = new DisparoConvencional();
			
			tableroDePrueba.realizarDisparoALaPosicion(disparo1, posicion1);
			
			assertEquals(2, posicion1.cantidadDeComponentesEnPosicion()); // Una lancha y un buque se superponen
			assertEquals(1, posicion1.obtenerDisparosEnPosicion().cantidadDeDisparos()); // Solo un disparo convencional
			
			assertEquals(false, posicion1.obtenerComponentesEnPosicion().obtenerComponente(1).estaDestruida());
			
			tableroDePrueba.impactarDisparos();
			tableroDePrueba.pasarTurno(jugador1);
			
/*
La reduccion del puntaje se realiza en etapa previa al modelo, en etapa en dnde se lo elige
		
			assertEquals(9790, jugador1.obtenerPuntaje().obtenerPuntaje()); // Disminuye el puntaje por disparo y por turno
*/
			assertEquals(2, posicion1.cantidadDeComponentesEnPosicion());	// hay 2 componentes en la posicion en la que se disparo ya que la lancha y el buque avanzaron
			assertEquals(0, posicion4.cantidadDeComponentesEnPosicion());	// En la posicion donde deberia estar la proa de la lancha
			assertEquals(0, posicion5.cantidadDeComponentesEnPosicion());	//	y el buque no hay nada ya que fueron destruidos
			assertEquals(0, posicion1.obtenerDisparosEnPosicion().cantidadDeDisparos()); // No hay disparos ya que fueron ejecutados
	
			
			Tablero.deleteInstance();
	}

	public void testPrimerTurnoCompletoConGrafico() throws ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango, LargoDeNaveIncorrecto, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene, NoHayDisparoParaColocarEnLaPosicion{
		
		Tablero tableroDePrueba = Tablero.getInstance();
		Jugador jugador1 = new Jugador("Robert");
		Nave nave1 = new Lancha();
		Nave nave2 = new Buque();
		Nave nave3 = new Destructor();
		Nave nave4 = new PortaAviones();
		Nave nave5 = new RompeHielos();
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		
		unGraficador.establecerTableroAGraficar(tableroDePrueba);
		
		Posicion posicion1 = tableroDePrueba.obtenerPosicion('C', 3);
		Posicion posicion2 = tableroDePrueba.obtenerPosicion('F', 6);
		Posicion posicion3 = tableroDePrueba.obtenerPosicion('I', 2);
		Posicion posicion4 = tableroDePrueba.obtenerPosicion('C', 2);
		Posicion posicion5 = tableroDePrueba.obtenerPosicion('D', 3);
		
		tableroDePrueba.agregarNaveHorizontalManualmenteConPosicionDeProa(nave1, posicion1);
		tableroDePrueba.agregarNaveVerticalManualmenteConPosicionDeProa(nave2, posicion1);
		tableroDePrueba.agregarNaveHorizontalManualmenteConPosicionDeProa(nave3, posicion2);
		tableroDePrueba.agregarNaveVerticalManualmenteConPosicionDeProa(nave4, posicion2);
		tableroDePrueba.agregarNaveVerticalManualmenteConPosicionDeProa(nave5, posicion3);
		
		jugador1.asignarTablero(tableroDePrueba);
		
		Disparo disparo1 = new DisparoConvencional();
		tableroDePrueba.realizarDisparoALaPosicion(disparo1, posicion1);
		
		assertEquals(2, posicion1.cantidadDeComponentesEnPosicion()); // Una lancha y un buque se superponen
		assertEquals(1, posicion1.obtenerDisparosEnPosicion().cantidadDeDisparos()); // Solo un disparo convencional
		assertEquals(false, posicion1.obtenerComponentesEnPosicion().obtenerComponente(1).estaDestruida()); //La componente en posicion no esta destruida
		
		unGraficador.graficarEnConsola(); 
		System.out.println();
		
		tableroDePrueba.impactarDisparos();
		tableroDePrueba.pasarTurno(jugador1);
/*		
		assertEquals(9790, jugador1.obtenerPuntaje().obtenerPuntaje()); // Disminuye el puntaje por disparo y por turno
*/
		assertEquals(2, posicion1.cantidadDeComponentesEnPosicion());	// hay 2 componentes en la posicion en la que se disparo ya que la lancha y el buque avanzaron
		assertEquals(0, posicion4.cantidadDeComponentesEnPosicion());	// En la posicion donde deberia estar la proa de la lancha
		assertEquals(0, posicion5.cantidadDeComponentesEnPosicion());	//	y el buque no hay nada ya que fueron destruidos
		assertEquals(0, posicion1.obtenerDisparosEnPosicion().cantidadDeDisparos()); // No hay disparos ya que fueron ejecutados

		unGraficador.graficarEnConsola();
		
		Tablero.deleteInstance();
	}
	
	public void testSeDestruyeUnaNavePorCompletoEnElTablero() throws ValoresDeParametroFueraDeRango, LargoDeNaveIncorrecto, ValorDeParametroFueraDeRango, ErrorAlQuererRemoverUnaComponenteEnUnaColeccionQueNoLaContiene, NoHayDisparoParaColocarEnLaPosicion{
		
		Tablero tableroDelJuego = Tablero.getInstance();
		Jugador jugador1 = new Jugador("Robert");
		Nave nave1 = new Lancha();
		Disparo disparo1 = new DisparoConvencional();
		Disparo disparo2 = new DisparoConvencional();
		GraficadorDeTableroEnConsola unGraficador = new GraficadorDeTableroEnConsola();
		
		unGraficador.establecerTableroAGraficar(tableroDelJuego);
		jugador1.asignarTablero(tableroDelJuego);
		
		Posicion posicion1 = tableroDelJuego.obtenerPosicion('D', 5);
		Posicion posicion2 = tableroDelJuego.obtenerPosicion('C', 5);
		
		tableroDelJuego.agregarNaveHorizontalManualmenteConPosicionDeProa(nave1, posicion1);
		
		unGraficador.graficarEnConsola();
		System.out.println();
		
		tableroDelJuego.realizarDisparoALaPosicion(disparo1, posicion1);
		tableroDelJuego.realizarDisparoALaPosicion(disparo2, posicion2);
		
		tableroDelJuego.impactarDisparos();
		tableroDelJuego.pasarTurno(jugador1);
		
		unGraficador.graficarEnConsola();
		
		assertEquals(true, tableroDelJuego.cantidadDeBarcosEnTablero() == 0);
		
	}
}
