package vista;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import colecciones.ColeccionDeNaves;

import componentesDeTablero.Modelo;
import componentesDeTablero.Tablero;

import nave.ComponenteDeNave;
import nave.Lancha;
import nave.Nave;
import nave.Resistencia;

import excepciones.LargoDeNaveIncorrecto;
import excepciones.ValorDeParametroFueraDeRango;
import excepciones.ValoresDeParametroFueraDeRango;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaPrincipal {
	private JFrame frame;
	private GameLoop gameLoop;

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
	 */
	public VentanaPrincipal() {
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
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(300, 10, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Batalla Navalgo");
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnDetener = this.addBotonDetener();
		
		JPanel panelDeDisparos = this.agregarPanelDeDisparos();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		try {
			this.inicializarModelo();
		} catch (LargoDeNaveIncorrecto | ValoresDeParametroFueraDeRango
				| ValorDeParametroFueraDeRango e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.addMouseListener(panel);
		
		this.addKeyListener();

		this.setComponentsFocus(btnIniciar, btnDetener);

	}

	private void inicializarModelo() throws LargoDeNaveIncorrecto, ValoresDeParametroFueraDeRango, ValorDeParametroFueraDeRango {

		Modelo modelo = Tablero.getInstance();
		modelo.colocarNavesEnElTablero();
		
		Iterator<Nave> iterator = modelo.obtenerNavesDelTablero().iterator();
		
		while(iterator.hasNext()){
			Nave naveARepresentar = iterator.next();
			
			this.establecerObjetosPosicionables(naveARepresentar);
			this.establecerObjetosVivos(naveARepresentar);
		}
		
	}

	private void establecerObjetosVivos(Nave naveARepresentar) {
		
		Iterator<ComponenteDeNave> iterator = naveARepresentar.obtenerComponentes().iterator();
		while (iterator.hasNext()){
			ObjetoVivo componenteDeLaNave = iterator.next();		
			this.gameLoop.agregar(componenteDeLaNave);
		}
	}

	private void establecerObjetosPosicionables(Nave naveARepresentar) {
		
		Iterator<ComponenteDeNave> iterator = naveARepresentar.obtenerComponentes().iterator();
		while (iterator.hasNext()){
			ObjetoPosicionable componenteDeLaNave = iterator.next();
			VistaDeComponenteDeNave vista = new VistaDeComponenteDeNave(componenteDeLaNave);
			
			this.gameLoop.agregar(vista);
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

	private void addMouseListener(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {				
			}});
	}

	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(325, 153, 500,500);
		frame.getContentPane().add(panel);
		return panel;
	}

	private JButton addBotonDetener() {
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}

	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
	private JPanel agregarPanelDeDisparos(){
		
		JRadioButton botonOpcion1=new JRadioButton("Disparo Convencional",true);
		JRadioButton botonOpcion2=new JRadioButton("Mina Submarina Doble",false);
		JRadioButton botonOpcion3=new JRadioButton("Mina Submarina Por Contacto",false);
		JRadioButton botonOpcion4=new JRadioButton("Mina Submarina Puntual",false);
		JRadioButton botonOpcion5=new JRadioButton("Mina Submarina Triple",false);
		
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
		
		panelDeDisparos.setBounds(5, 300, 300, 300);
		frame.getContentPane().add(panelDeDisparos);
		
		return panelDeDisparos;
		
		
	}

}
