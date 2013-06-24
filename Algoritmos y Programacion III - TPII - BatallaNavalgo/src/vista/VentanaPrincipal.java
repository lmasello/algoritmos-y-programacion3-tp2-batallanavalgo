package vista;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import juego.Juego;

import nave.ComponenteDeNave;
import nave.Nave;

import componentesDeTablero.Modelo;
import componentesDeTablero.Posicion;
import componentesDeTablero.Tablero;
import disparos.Disparo;
import disparos.DisparoConvencional;
import disparos.MinaSubmarinaDoble;
import disparos.MinaSubmarinaPorContacto;
import disparos.MinaSubmarinaPuntual;
import disparos.MinaSubmarinaTriple;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.NoHayDisparoParaColocarEnLaPosicion;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaPrincipal {

	// Constantes que hacen referencia a pasos de posiciones en la superficie del modelo
	private static int PASO_HORIZONTAL = 50;
	private static int PASO_VERTICAL = 50;
	
	private Modelo modelo;
	private JFrame frame;
	private Set<ObjetoVivo> objetosVivos;
	private Set<ObjetoDibujable> objetosDibujables;
	private SuperficieDeDibujo superficieDeDibujo;
	private Boolean estaEjecutando;
	private Disparo disparoARealizar;
	private TextField puntajeRestante;
	private Frame framePregunta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ValoresDeParametroFueraDeRango 
	 */
	public VentanaPrincipal() throws ValoresDeParametroFueraDeRango {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws ValoresDeParametroFueraDeRango 
	 */
	

	private void initialize() throws IOException, ValoresDeParametroFueraDeRango {
		modelo = new Juego("Ejemplo");
		frame = new JFrame();
		framePregunta = new Frame("DESEA JUGAR OTRA VEZ ?");
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(200, 10, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Batalla Navalgo");
		estaEjecutando = false;		
		
		JButton botonIniciar = this.agregarBotonIniciar();
				
		JButton botonPasarTurno = this.agregarBotonPasarTurno();
		
		this.agregarPanelDeDisparos();
		
		this.agregarPuntajeDelJugador();
		
		JPanel superficie = this.addSuperficiePanel();
		
		superficieDeDibujo = (SuperficieDeDibujo) superficie;
	
				
		try {
			this.inicializarModelo();
		} catch (LargoDeNaveIncorrecto | ValoresDeParametroFueraDeRango
				| ValorDeParametroFueraDeRango e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.addMouseListener(superficie);
		
		this.addKeyListener();

		this.setComponentsFocus(botonIniciar,botonPasarTurno);

	}

	private void inicializarModelo() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {

		modelo.colocarNavesEnElTablero();
		
		objetosVivos = new HashSet<ObjetoVivo>();
		objetosDibujables= new HashSet<ObjetoDibujable>();
		
		Iterator<Nave> iterator = modelo.obtenerNavesDelTablero().iterator();
		
		while(iterator.hasNext()){
			Nave naveARepresentar = iterator.next();
			
			this.establecerObjetosPosicionables(naveARepresentar);
			this.establecerObjetosVivos(naveARepresentar);
		}
		
	}

	private void establecerObjetosVivos(ObjetoVivo naveARepresentar) {
		
		objetosVivos.add(naveARepresentar);
	}
	

	private void establecerObjetosPosicionables(Nave naveARepresentar) {
		
		Iterator<ComponenteDeNave> iterator = naveARepresentar.obtenerComponentes().iterator();
		while (iterator.hasNext()){
			ObjetoPosicionable componenteDeLaNave = iterator.next();
			VistaDeComponenteDeNave vista = new VistaDeComponenteDeNave(componenteDeLaNave);
			
			objetosDibujables.add(vista);
		}
		
	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
	}

	private void addKeyListener() {
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Ping");
			}  
			 	
		});
	}

	private void addMouseListener(JPanel superficie) {
		superficie.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent e) {	
				
				int coordenadaHorizontal = e.getX();
				int coordenadaVertical = e.getY();
				
				try {
					Posicion posicionClickeadaDelModelo = this.obtenerPosicionClickeada(coordenadaHorizontal,coordenadaVertical);
					
					Disparo disparoAPonerEnPosicion = disparoARealizar;
					
					modelo.realizarDisparoALaPosicion(disparoAPonerEnPosicion, posicionClickeadaDelModelo);
					modelo.obtenerJugador().obtenerPuntaje().disminuirPuntajePorDisparo(disparoAPonerEnPosicion);
					
				} catch (ValoresDeParametroFueraDeRango
						| ValorDeParametroFueraDeRango e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoHayDisparoParaColocarEnLaPosicion e1) {
					
					System.out.println("No se ha seleccionado ningun disparo para colocar en dicha posicion.");
				} 
				
			}

			private Posicion obtenerPosicionClickeada(int coordenadaHorizontal,	int coordenadaVertical) throws ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {
				
				/*
				 * Devuelve la posicion del Modelo, que ha sido clickeada. Para ello, a la posicion clickeada se le tiene 
				 * que sumar el paso de posicion y
				 * dividir por este mismo, para llevar a dicha posicion a las mismas unidades que se maneja el modelo
				 */
				
				int coordenadaHorizontalDeModelo = (coordenadaHorizontal+PASO_HORIZONTAL) / PASO_HORIZONTAL;
				int coordenadaVerticalDeModelo = (coordenadaVertical+PASO_VERTICAL) / PASO_VERTICAL;
								
				char identificadorDeColumna = this.convertirAIdentificadorDeColumna(coordenadaHorizontalDeModelo);
				
				return modelo.obtenerPosicion(identificadorDeColumna, coordenadaVerticalDeModelo);
				
			}

			private char convertirAIdentificadorDeColumna(int coordenadaHorizontalDeModelo) {
				
				char primerColumnaDelModelo = 'A';

				return (char)(coordenadaHorizontalDeModelo-1 + (int)primerColumnaDelModelo);
			}});
	}

	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(87, 174, 221));
		panel.setBounds(325, 153, PASO_HORIZONTAL*10,PASO_VERTICAL*10);
		
		frame.getContentPane().add(panel);
		return panel;
	}

	
	private JButton agregarBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(ObjetoDibujable objetoDibujable : objetosDibujables) {
					objetoDibujable.dibujar(superficieDeDibujo);
				}
				superficieDeDibujo.actualizar();
				estaEjecutando = true;
				puntajeRestante.setText(" PUNTAJE RESTANTE: " + modelo.obtenerJugador().obtenerPuntaje().obtenerPuntaje());
			}
		});
		btnIniciar.setBounds(85, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
	private JButton agregarBotonPasarTurno(){
		/*
		 * Al hacer click en dicho boton se realizan los impactos de los disparos,
		 * se mueven todas las naves y se actualiza la vista.
		 */
		JButton botonPasarTurno = new JButton("Pasar Turno");
		botonPasarTurno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(estaEjecutando){

					try {
						
						modelo.impactarDisparos();
						
						this.actualizarObjetosARepresentar();
						
					} catch (ValoresDeParametroFueraDeRango | ValorDeParametroFueraDeRango e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(ObjetoVivo objetoVivo : objetosVivos) {
						objetoVivo.vivir();
					}
					for(ObjetoDibujable objetoDibujable : objetosDibujables) {
						objetoDibujable.dibujar(superficieDeDibujo);
					}
					
					modelo.disminuirPuntajeDeJugadorPorPasajeDeTurno();
					puntajeRestante.setText(" PUNTAJE RESTANTE: " + modelo.obtenerJugador().obtenerPuntaje().obtenerPuntaje());
					superficieDeDibujo.actualizar();
					if(modelo.obtenerJugador().obtenerPuntaje().obtenerPuntaje() <= 0 ){
						try {
							terminarPartida();
						} catch (ValoresDeParametroFueraDeRango e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
			}

			private void actualizarObjetosARepresentar() throws ValoresDeParametroFueraDeRango {

				Iterator<Nave> iterator = modelo.obtenerNavesDelTablero().iterator();
								
				objetosVivos = new HashSet<ObjetoVivo>();
				objetosDibujables= new HashSet<ObjetoDibujable>();

				while(iterator.hasNext()){
					Nave naveARepresentar = iterator.next();
					
					this.establecerObjetosPosicionables(naveARepresentar);
					this.establecerObjetosVivos(naveARepresentar);
				}
				
			}

			private void establecerObjetosVivos(ObjetoVivo naveARepresentar) {
				
				objetosVivos.add(naveARepresentar);
			}
			

			private void establecerObjetosPosicionables(Nave naveARepresentar) {
				Iterator<ComponenteDeNave> iterator = naveARepresentar.obtenerComponentes().iterator();
				while (iterator.hasNext()){
					ObjetoPosicionable componenteDeLaNave = iterator.next();
					VistaDeComponenteDeNave vista = new VistaDeComponenteDeNave(componenteDeLaNave);
					
					objetosDibujables.add(vista);
				}

				
			}		
		});
		botonPasarTurno.setBounds(72,260, 115, 25);
		frame.getContentPane().add(botonPasarTurno);
		return botonPasarTurno;
	}
	
	private JButton agregarBotonNo() {
		JButton botonCancelar = new JButton("NO");
		botonCancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				framePregunta.setVisible(false);
				System.exit(0);
			}
		});
		return botonCancelar;
	}

	private JButton agregarBotonSi() {
		JButton botonAceptar = new JButton("SI");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					framePregunta.setVisible(false);
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (ValoresDeParametroFueraDeRango e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return botonAceptar;
	}
	
	protected void terminarPartida() throws ValoresDeParametroFueraDeRango {
			
			frame.setVisible(false);
			JButton botonAceptar = this.agregarBotonSi();
			JButton botonCancelar = this.agregarBotonNo();
			
			Panel panelBotonesPregunta = new Panel();
			panelBotonesPregunta.add(botonAceptar);
			panelBotonesPregunta.add(botonCancelar);
			
			framePregunta.add("South",panelBotonesPregunta);
			
			framePregunta.setVisible(true);
	}
	

	private void agregarPanelDeDisparos(){
		/* 
		 * Evaluar refactorizacion, ya que el metodo queda bastante extenso
		 */
		
		JRadioButton botonOpcion1=new JRadioButton("Disparo Convencional",false);
		botonOpcion1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disparoARealizar = new DisparoConvencional();
				
			}
		});
		JRadioButton botonOpcion2=new JRadioButton("Mina Submarina Doble",false);
		botonOpcion2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disparoARealizar = new MinaSubmarinaDoble();
				
			}
		});
		JRadioButton botonOpcion3=new JRadioButton("Mina Submarina Por Contacto",false);
		botonOpcion3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disparoARealizar = new MinaSubmarinaPorContacto();
				
			}
		});
		JRadioButton botonOpcion4=new JRadioButton("Mina Submarina Puntual",false);
		botonOpcion4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disparoARealizar = new MinaSubmarinaPuntual();
				
			}
		});
		JRadioButton botonOpcion5=new JRadioButton("Mina Submarina Triple",false);
		botonOpcion5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				disparoARealizar = new MinaSubmarinaTriple();
				
			}
		});
		
		ButtonGroup botonera = new ButtonGroup();
		botonera.add(botonOpcion1);
		botonera.add(botonOpcion2);
		botonera.add(botonOpcion3);
		botonera.add(botonOpcion4);
		botonera.add(botonOpcion5);
		
		JPanel panelDeDisparos = new JPanel();
		panelDeDisparos.add(botonOpcion1);
		panelDeDisparos.add(botonOpcion2);
		panelDeDisparos.add(botonOpcion3);
		panelDeDisparos.add(botonOpcion4);
		panelDeDisparos.add(botonOpcion5);
		
		panelDeDisparos.setBounds(5, 300, 250, 300);
		frame.getContentPane().add(panelDeDisparos);	
		
	}

	private void agregarPuntajeDelJugador() {
		
		puntajeRestante = new TextField();
		puntajeRestante.setBackground(Color.black);
		puntajeRestante.setBounds(40, 150, 200, 50);
		frame.getContentPane().add(puntajeRestante);
	}
}
