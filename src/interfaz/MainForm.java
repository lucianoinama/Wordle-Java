package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import juego.Juego;

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
	public Juego juego = new Juego();
	static ArrayList<JLabel> lblF1 = new ArrayList<JLabel>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
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
	public MainForm() {
		initialize();
		panel_1 = new JPanel();
	
	}

//	public static void escribirLabels(ArrayList<JLabel> array, char a) {
//		
//		for()
//		
//	}
//	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		//frame = new JFrame();
		frame.setBounds(100, 100, 642, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				

					
					juego.obtenerPalabraIngresada(textField.getText().trim());
					textField.setText("");
					
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
		
		//crearLabel(this.juego.mostrarPalabraSeleccionada(), panel_1);
		
		
		
		

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
	
	public static void crearLabel(String palabra, JPanel panel) {
		
		String[] splitWord = palabra.split("");
	
		
		
		
		for(int i = 0; i< splitWord.length; i++) {
		
			JLabel aux = new JLabel(splitWord[i], JLabel.CENTER);
			//System.out.println(splitWord[i]);
			panel.add(aux);
			panel.revalidate();
			panel.repaint();
			lblF1.add(aux);
		}
		
	}
}
