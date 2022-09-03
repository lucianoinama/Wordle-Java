package wordle2;

import java.util.Scanner;

public interface DatosJuego {
	String[] palabras = { "juani", "fulvo", "letra", "juego"};
	String palabraParaAdivinar = palabras[(int) (Math.random() * palabras.length)];
	Scanner input = new Scanner(System.in);
	int intentos = 6;
	String palabraIngresada = "";
}
