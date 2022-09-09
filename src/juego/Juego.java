package juego;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import interfaz.MainForm;

public class Juego {
	//private String[] listaDePalabras={"huevo","queso","sardo","saldo","clips","messi","calma",};
	
	//Variables
	private String palabraSeleccionadaDeLista;
	
	//public enum EstadoLetra { CorrectaUbicada, CorrectaNoUbicada, Incorrecta }
	private String palabraIngresada;
	//private EstadoLetra[] palabraEstatus= {EstadoLetra.CorrectaUbicada , EstadoLetra.CorrectaUbicada , EstadoLetra.Incorrecta};
	
	private int intentos = 6, contadorVerdes;
	
	
	public Juego(){
		
		seleccionarPalabraAleatoria();
		System.out.println(palabraSeleccionadaDeLista);
		mostrarPalabraSeleccionada();
	};
	
	//Metodos
	
	private void seleccionarPalabraAleatoria() {
		//File wordFile = new File("\\Users\\agusl\\Desktop\\Universidad\\Progra III\\tpwordle\\assets\\words.txt");
		//File wordFile = new File("C:\\Users\\Juani\\git\\tpwordle\\assets\\words.txt");
		File wordFile = new File(".\\assets\\words.txt");
		
//		try {
//			Scanner scan = new Scanner(wordFile);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
			
		List<String> listaDePalabras = new ArrayList<String>();	
		Random r= new Random();
		//palabraSeleccionadaDeLista = listaDePalabras[r.nextInt(listaDePalabras.length)];
		
		try {
			listaDePalabras = Files.readAllLines(wordFile.toPath());
		}catch(IOException ex) {
			
		}
		
		System.out.println(listaDePalabras.toString());
		palabraSeleccionadaDeLista = listaDePalabras.get(r.nextInt(listaDePalabras.size()));
		palabraSeleccionadaDeLista.trim();
	}
	
	public void obtenerPalabraIngresada(String palabra) {
		this.palabraIngresada = palabra;
		System.out.println(palabra);
		intentos--;
		System.out.println(intentos);
		compararPalabra(palabra);
	}
	
	private String[] mostrarPalabraSeleccionada() {
		 //List<String> palabraSelec = Arrays.asList(partirPalabra(palabraSeleccionadaDeLista));
		String[] palabraSelec = partirPalabra(palabraSeleccionadaDeLista);
		return palabraSelec;
	}
	
	private void compararPalabra(String palabra) {
		for (int i = 0; i < palabraSeleccionadaDeLista.length(); i++) {	
			ActualizarEstatusLetraDePalabra(palabraSeleccionadaDeLista,palabraIngresada.charAt(i));
		}
	}
	
	private void ActualizarEstatusLetraDePalabra(String palabra, char letra) {
		//System.out.println(palabraSeleccionadaDeLista + " " + palabraSeleccionadaDeLista.length());
		List<String> palabraSelec = Arrays.asList(partirPalabra(palabraSeleccionadaDeLista));
		String[] palabraUser = partirPalabra(palabraIngresada);
	
		contadorVerdes = 0;	//reinicia la variable cada vez que va a entrar al ciclo
		//if(contadorVerdes < 5) {
			for(int i= 0 ; i< 5; i++) {
				if(palabraSelec.contains(palabraUser[i])) { //Pertenece alguna letra ingresada a la palabra seleccionada? 
					if(palabraSelec.get(i).equals(palabraUser[i])) { //Esta la letra ingresada en la misma posicion que en la palabra seleccionada?
						MainForm.cambiarEstadoPanel(i, Color.green);
						contadorVerdes++;
					}
					else {
						MainForm.cambiarEstadoPanel(i, Color.yellow);
					}	
				}
				else {
					MainForm.cambiarEstadoPanel(i, Color.gray);
				}
			}
		/*}
		else {
			consultarVictoria();
		}*/
    }
	
	//Herramientas
	
	private String[] partirPalabra(String palabra) { //Divide el string en caracteres individuales	
		String[] splitWord = palabra.split("");
	
		return splitWord;
	}
	
	public int intentosRestantes() {
		return this.intentos;
	}
	
	public int contadorVerdes() {
		return this.contadorVerdes;
	}
	
	public void consultarVictoria() {
		if(contadorVerdes() == 5) {
			JOptionPane.showMessageDialog(null, "GANASTE", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void consultarDerrota() {
		if(intentosRestantes() == 0 && contadorVerdes() < 5) {
			JOptionPane.showMessageDialog(null, "PERDISTE", "...", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
