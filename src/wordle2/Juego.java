package wordle2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Juego implements DatosJuego{
	private String[] palabras;
	private String palabraParaAdivinar;
	private Scanner input;
	private int intentos;
	private String palabraIngresada;
	
	private boolean verde = false, amarillo = false, rojo = false;

	public Juego() {
		palabras = DatosJuego.palabras;
		palabraParaAdivinar = DatosJuego.palabraParaAdivinar;
		input = DatosJuego.input;
		intentos = DatosJuego.intentos;
		palabraIngresada = DatosJuego.palabraIngresada;
	}

//	public void jugar() {
//		System.out.println("Wordle iniciado");
//		int contadorVerdes = 0;
//		while (palabraIngresada != palabraParaAdivinar && intentos > 0) {
//			palabraIngresada = input.nextLine();
//			if (palabraIngresada.length() != 5) {
//				System.out.println("la palabra debe tener 5 caracteres.");
//				continue;
//			}
//			for (int i = 0; i < palabraParaAdivinar.length(); i++) {
//				if (palabraIngresada.charAt(i) == palabraParaAdivinar.charAt(i)) {
//					contadorVerdes++;
//					System.out.println("verde");
//				} else if (existeLaLetra(palabraParaAdivinar, palabraIngresada.charAt(i))) {
//					System.out.println("amarillo");
//				} else {
//					System.out.println("rojo");
//				}
//			}
//			if (contadorVerdes == 5) {
//				System.out.println("ganaste!");
//				break;
//			}
//			if (intentos == 1) {
//				System.out.println("perdiste.");
//				break;
//			}
//			contadorVerdes = 0;
//			intentos--;
//			System.out.println("intentos restantes: " + intentos);
//		}
//	}

	public void jugar() {
		System.out.println("Wordle iniciado");
		int contadorVerdes = 0;
		while (palabraIngresada != palabraParaAdivinar && intentos > 0) {
			palabraIngresada = input.nextLine();
			if (palabraIngresada.length() != 5) {
				System.out.println("la palabra debe tener 5 caracteres.");
				continue;
			}
			for (int i = 0; i < palabraParaAdivinar.length(); i++) {
				if (palabraIngresada.charAt(i) == palabraParaAdivinar.charAt(i)) {
					System.out.println("verde");
					contadorVerdes++;
				} else if (existeLaLetra(palabraParaAdivinar, palabraIngresada.charAt(i))) {
					System.out.println("amarillo");
				} else {
					System.out.println("rojo");
				}
				
			}
			if (contadorVerdes == 5) {
				System.out.println("ganaste!");
				break;
			}
			if (intentos == 1) {
				System.out.println("perdiste.");
				break;
			}
			contadorVerdes = 0;
			intentos--;
			System.out.println("intentos restantes: " + intentos);
		}
	}
	
	private static boolean existeLaLetra(String palabra, char c) {
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}

	public boolean esVerde() {
		return verde = true;
	}
	
	public boolean esAmarillo() {
		return amarillo = true;
	}
	
	public boolean esRojo() {
		return rojo = true;
	}
}