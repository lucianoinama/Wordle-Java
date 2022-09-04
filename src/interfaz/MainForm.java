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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

public class MainForm {

	private JFrame frame;
	private JTextField textField;

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
		
		
	    Juego game = new Juego();
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(217, 60, 173, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingresar Palabra");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(33, 65, 171, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String palabra = textField.getText();
				if(wordVerif(palabra)) {
					JOptionPane.showMessageDialog(null, "Palabra Invalida", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					game.obtenerPalabraIngresada(textField.getText().trim());
				}
			}
		});
		btnNewButton.setBounds(441, 71, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(33, 149, 585, 198);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(5, 5, 0, 0));
		
		
		ArrayList<JLabel> lblF1 = new ArrayList<JLabel>();
		
		
		
		// PRIMERA FILA
		JLabel lbl1F1 = new JLabel("");
		panel_1.add(lbl1F1);
		lblF1.add(lbl1F1);
		
		JLabel lbl2F1 = new JLabel("");
		panel_1.add(lbl2F1);
		lblF1.add(lbl2F1);

		
		JLabel lbl3F1 = new JLabel("");
		panel_1.add(lbl3F1);
		lblF1.add(lbl3F1);

		JLabel lbl4F1 = new JLabel("");
		panel_1.add(lbl4F1);
		lblF1.add(lbl4F1);

		JLabel lbl5F1 = new JLabel("");
		panel_1.add(lbl5F1);
		lblF1.add(lbl5F1);

		// SEGUNDA FILA
		JLabel lblNewLabel_7 = new JLabel("New label");
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_1.add(lblNewLabel_8);
		
		// TERCERA FILA
		JLabel lblNewLabel_10 = new JLabel("New label");
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		panel_1.add(lblNewLabel_21);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel_1.add(lblNewLabel_13);
		
		// CUARTA FILA
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		panel_1.add(lblNewLabel_19);
		
		//QUINTA FILA
		JLabel lblNewLabel_20 = new JLabel("New label");
		panel_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_22 = new JLabel("New label");
		panel_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("New label");
		panel_1.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("New label");
		panel_1.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("New label");
		panel_1.add(lblNewLabel_25);
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


}
