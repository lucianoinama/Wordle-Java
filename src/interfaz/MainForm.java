package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import juego.Juego;
import juego.Juego.EstadoJuego;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

public class MainForm {

	private final JFrame frame = new JFrame();
	private JTextField textField;
	public JPanel panel_1;
	private String idioma;
	public Juego juego;
	static ArrayList<JLabel> lblF1 = new ArrayList<JLabel>();

	public int intentos;
	public enum Status {StandBy, EnProceso, Reinicio, Terminado};
	private static Status status;
	/**
	 * Create the application.
	 */
	public MainForm(String idioma) {
		this.idioma = idioma;
		
		this.juego = new Juego(idioma);
		initialize();
		panel_1 = new JPanel();
	
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm("Español");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//frame = new JFrame();
		//frame.setBounds(100, 100, 642, 415);
		frame.setTitle("Jueguito Wordle");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(650, 250, 642, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		System.out.println(idioma + " idioma");
		textField = new JTextField();
		textField.setBounds(217, 60, 173, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngr = new JLabel("Ingresar Palabra");
		lblIngr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIngr.setBounds(33, 65, 171, 28);
		frame.getContentPane().add(lblIngr);
		
		JButton boton1 = new JButton("Ingresar");
		
		JPanel panel_1 = new JPanel();
		
		Object[] opciones = {"Si", "No", "Cerrar"}; //Opciones para los botones
		
		System.out.println(juego.consultarEstado());
		
		
		

		
		if(checkStatus() == Status.Reinicio) {
			intentos = 5;
			panel_1.removeAll();
			panel_1.revalidate();
			panel_1.repaint();
			setStatus(Status.EnProceso);
		}
		

		
		
		boton1.addActionListener(new ActionListener() {
			//Juego game = new Juego();
			
			public void actionPerformed(ActionEvent e) {
			
				String palabra = textField.getText();
				if(wordVerif(palabra)) {
					JOptionPane.showMessageDialog(null, "Palabra Invalida", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					
				
						lblF1.clear();
					
						crearLabel(palabra, panel_1);
					
						juego.obtenerPalabraIngresada(textField.getText().trim()
								.toLowerCase());
						textField.setText("");
					
					
					
					if(juego.consultarVictoria()) {
						
						int result = JOptionPane.showOptionDialog(null, "Reiniciar?", "Ganaste!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);
						
						
						
						if(result == JOptionPane.CANCEL_OPTION) { //Cierra el programa en caso de que se elija la opcion cerrar
							
							frame.dispose();
						}

						if(result == JOptionPane.YES_OPTION) { //Reinicia el Juego
							
							juego.reiniciarJuego();
							panel_1.removeAll();
							panel_1.revalidate();
							panel_1.repaint();
							
							
							setStatus(Status.Reinicio);
						}
					
						if(result == JOptionPane.NO_OPTION) {
							frame.dispose();
							volverAHome();
						}
					
					}		
					
					
					
					
					if(juego.consultarDerrota()) {
						
						
						int result2 = JOptionPane.showOptionDialog(null,"Palabra a descubrir: " + juego.getPalabraJuego() + "\n" + "Reiniciar?", "Perdiste!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);
						
						
						
						if(result2 == JOptionPane.CANCEL_OPTION) { //Cierra el programa en caso de que se elija la opcion cerrar
							
							frame.dispose();
						}

						if(result2 == JOptionPane.YES_OPTION) { //Reinicia el Juego
							
							juego.reiniciarJuego();
							panel_1.removeAll();
							panel_1.revalidate();
							panel_1.repaint();
							
							
							setStatus(Status.Reinicio);						
						
						}
						
						if(result2 == JOptionPane.NO_OPTION) {
							frame.dispose();
							volverAHome();
						}
					
					}

				}
			}
		});
		boton1.setBounds(441, 71, 85, 21);
		frame.getContentPane().add(boton1);
		
		
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(33, 149, 585, 198);
		frame.getContentPane().add(panel_1);
		
		panel_1.setLayout(new GridLayout(0, 5));
		panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_1.setOpaque(true);
		
		}
		
	//Herramientas
	
	private static boolean wordVerif(String str) { // Verifica si la string posee un caracter especial, numero y/o longitud adecuada
		if(!(str.length() == 5)) {
			return true;
		}
		boolean result = false;
		for (int i = 0; i < str.length(); i++) {
			boolean acum = true;
			int ascii = (int) str.charAt(i);
			
			if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
				acum = acum && false;
			}
			
			result = result || acum;
			acum = true;
		}
		return result;
	}


	public static void cambiarEstadoPanel(int posicion , Color color) {
		JLabel auxJ =  lblF1.get(posicion);
		//System.out.println(auxJ.toString());
		auxJ.setOpaque(true);
		auxJ.setBackground(color);	
	}
	//TW Cen MT
	public static void crearLabel(String palabra, JPanel panel) {	
		String[] splitWord = palabra.split("");
		for(int i = 0; i< splitWord.length; i++) {
			JLabel aux = new JLabel(splitWord[i].toUpperCase(), JLabel.CENTER);
			aux.setFont(new Font("TW Cen MT", Font.BOLD, 36));

			//System.out.println(splitWord[i]);
			panel.add(aux);
			panel.revalidate();
			panel.repaint();
			lblF1.add(aux);
		}	
	}
	
	//usado para mostrar pantalla luego de tocar el boton enter en la primer imagen
	public void visualizarJuego() {
		this.frame.setVisible(true);
	}

//	public static void terminarJuego() {
//		Object[] opciones = {"Si", "No", "Cerrar"}; //Opciones para los botones
//
//		
//		int result = JOptionPane.showOptionDialog(null, "Reiniciar?", "Ganaste!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);
//	
//	
//	
//		if(result == JOptionPane.CANCEL_OPTION) { //Cierra el programa en caso de que se elija la opcion cerrar
//			
//			setStatus(Status.Terminado);
//		}
//
//		if(result == JOptionPane.YES_OPTION) { //Reinicia el Juego
//			
//			
//			setStatus(Status.Reinicio);
//		}
//	
//	
//	
//	}


	private static  void setStatus(Status estado) {
		
		status = estado;		
	}

	public Status checkStatus() {
		
		return this.status;
	}

	public void volverAHome() {
		
		PrimerPantalla home = new PrimerPantalla();
		home.initialize();
		home.frame.setVisible(true);
	}
	
	
}
