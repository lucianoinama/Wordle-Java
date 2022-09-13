package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class PrimerPantalla {
	JFrame frame = new JFrame();
	private JLabel titulo;
	private JButton botonEnter;
	private String idioma;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimerPantalla window = new PrimerPantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PrimerPantalla() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Jueguito Wordle");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(650, 250, 642, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//TITULO
		
		titulo = new JLabel("");
		
		ImageIcon banner = new ImageIcon(".\\assets\\images\\logo.jpg");
		
		Image imgM = banner.getImage();
		
		Image img = imgM.getScaledInstance(605, 110, java.awt.Image.SCALE_SMOOTH);
		
		banner = new ImageIcon(img);
		titulo.setIcon(banner);
		titulo.setBounds(0, 10, 628, 107);
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 36));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		frame.getContentPane().add(titulo);
		
		botonEnter = new JButton("EMPEZAR");
		botonEnter.setFont(new Font("Verdana", Font.PLAIN, 16));
		botonEnter.setBounds(200, 200, 200, 100);
		frame.getContentPane().add(botonEnter);
		
		//LISTA DE IDIOMAS
		
		JLabel lblNewLabel = new JLabel("Seleccionar Idioma");
		lblNewLabel.setBounds(242, 121, 118, 21);
		String[] idiomas = {"Espanol", "Ingles"};
		JComboBox comboBox = new JComboBox(idiomas);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				idioma = (String)comboBox.getSelectedItem();
			
			}
		});
		comboBox.setBounds(221, 152, 156, 21);
		
		
		
		
		frame.getContentPane().add(comboBox);
		
		frame.getContentPane().add(lblNewLabel);
		
		botonEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if(botonEnter.getText().equals(accion)) {
					frame.dispose();
					avanzarPantalla(idioma);
				}
			}
		});
	}

	public void avanzarPantalla(String idioma) {
		MainForm juego = new MainForm(idioma);
		juego.visualizarJuego();
	}	
}
