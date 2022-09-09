package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PrimerPantalla {
	private JFrame frame = new JFrame();
	private JLabel titulo;
	private JButton botonEnter;
	
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
		frame.setTitle("Jueguito Wordle");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(650, 250, 642, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titulo = new JLabel("Wordle");
		titulo.setBounds(0, 0, 600, 100);
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 36));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(titulo);
		
		botonEnter = new JButton("EMPEZAR");
		botonEnter.setFont(new Font("Verdana", Font.PLAIN, 16));
		botonEnter.setBounds(200, 200, 200, 100);
		frame.getContentPane().add(botonEnter);
		
		botonEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if(botonEnter.getText().equals(accion)) {
					frame.dispose();
					avanzarPantalla();
				}
			}
		});
	}

	public void avanzarPantalla() {
		MainForm juego = new MainForm();
		juego.visualizarJuego();
	}	
}
