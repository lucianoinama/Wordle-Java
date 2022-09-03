package wordle2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Pantalla implements ActionListener{

	private JFrame frame;
	private JLabel titulo;
	private JButton botonEnter;
	private JTextField entradaDeTexto;

	private JPanel panel;
	
	private String palabraUsuario;
	
	private static final CajaDeLetra[][] cajas = new CajaDeLetra[6][5];
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
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
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Jueguito Wordle");
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(650, 250, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titulo = new JLabel("Wordle");
		titulo.setBounds(0, 0, 425, 70);
		titulo.setVerticalAlignment(SwingConstants.TOP);
		titulo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 36));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(titulo);
		
		botonEnter = new JButton("Enter");
		botonEnter.setFont(new Font("Verdana", Font.PLAIN, 16));
		botonEnter.setBounds(300, 450, 110, 50);
		frame.getContentPane().add(botonEnter);
		
		entradaDeTexto = new JTextField();
		entradaDeTexto.setToolTipText("");
		entradaDeTexto.setBounds(40, 450, 80, 20);
		frame.getContentPane().add(entradaDeTexto);
		entradaDeTexto.setColumns(10);

		panel = new JPanel();
		panel.setBounds(75, 65, 300, 300);
		//caja de letras
		panel.setLayout(new GridLayout(6, 5, 5, 5));	//filas, columnas, y distancia vertical/horizontal en pixeles
        panel.setSize(280, 320);	//tamaño total del panel
        
        //se recorre y ubica las cajas como en una matriz
        for (int i = 0; i < cajas.length; i++){
        	for (int j = 0; j < cajas[i].length; j++){
                cajas[i][j] = new CajaDeLetra();
                panel.add(cajas[i][j]);	//creo y agrego en este panel 30 cajitas, para cada una de las letras
            }
        }
		frame.getContentPane().add(panel);
		
		botonEnter.addActionListener(this);

	
		/*Panel panel = new Panel();
		panel.setBounds(61, 48, 316, 316);
		int variableX = 100, variableY = 100, altura = 300, ancho = 300;
		JLabel[][] cuadrado = new JLabel[6][5];
		for (int i = 0; i < 6; i++) {
			for(int j = 0; j < 5; j++) {
				cuadrado[i][j] = new JLabel();
				cuadrado[i][j].setBounds(variableX, variableY, altura, ancho);
				frame.getContentPane().add(cuadrado[i][j]);
				variableX += 30;
				variableY += 30;
			}
		}*/
		
		
		//frame.getContentPane().add(panel);
		
		
//		JLabel[] wordColumns = new JLabel[5];
//			
//			
//		frame.getContentPane().setLayout(new GridLayout(2, 5));
//		Border blackBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
//		for (int i = 0; i < wordColumns.length; i++) {
//			wordColumns[i] = new JLabel();
//			wordColumns[i].setOpaque(true);
//			wordColumns[i].setBorder(blackBorder);
//			wordColumns[i].setBounds(10, 10, 50, 50);
//			frame.getContentPane().add(wordColumns[i]);
//		}
			
	}
	
	
	
	class CajaDeLetra extends JLabel{
		private static final Color _borderGray = new Color(212,214,218);
		private Border border = null;
		
		public CajaDeLetra(){
	        border = BorderFactory.createLineBorder(_borderGray, 4);  //color de los bordes inicial es gris
	        this.setBorder(border);
	        this.setText(palabraUsuario);
	        this.setFont(new Font("SansSerif", Font.BOLD, 30));
	        this.setSize(63, 63);
	        this.setHorizontalAlignment(JLabel.CENTER);
	        this.setVerticalAlignment(JLabel.CENTER);
	        this.setBackground(Color.WHITE);    //color inicial es blanco
	        this.setOpaque(true);  //no transparente
	        this.setForeground(Color.BLACK);
	    }	
	}
	
	private void asignarTextoCuadrito(CajaDeLetra c, String d) {
		c.setText(d);
	}
	
	//prueba de accion para la interfaz.
	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if(botonEnter.getText().equals(accion)) {
			if(this.entradaDeTexto.getText().length() == 5) {
				palabraUsuario = recibirPalabraDelUsuario(this.entradaDeTexto.getText());
				System.out.println(palabraUsuario);
			}
			
		}
	}
	
	private String recibirPalabraDelUsuario(String palabra) {
		return palabra;
	}
	
}
