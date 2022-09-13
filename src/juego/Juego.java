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
	
	public enum EstadoJuego {StandBy, EnProceso, Terminado, Victoria, Derrota}
	private EstadoJuego juegoEstatus;
	
	
	
	//Variables
	private String palabraSeleccionadaDeLista;
	private  String idioma;
	
	//public enum EstadoLetra { CorrectaUbicada, CorrectaNoUbicada, Incorrecta }
	private String palabraIngresada;
	//private EstadoLetra[] palabraEstatus= {EstadoLetra.CorrectaUbicada , EstadoLetra.CorrectaUbicada , EstadoLetra.Incorrecta};
	
	private int intentos = 5, contadorVerdes;
	
	
	public Juego(String idioma){
		this.idioma = idioma;
		setStatus(EstadoJuego.EnProceso);
		seleccionarPalabraAleatoria();
		mostrarPalabraSeleccionada();
	};
	
	//Metodos
	
	private void seleccionarPalabraAleatoria() {
		//File wordFile = new File("C:\\Users\\Juani\\git\\tpwordle\\assets\\words.txt");
		File wordFile = new File(".\\assets\\words.txt");
		
		if(idioma == "Inglés") {
			wordFile = new File(".\\assets\\words-en.txt");

		}
		
		

			
		List<String> listaDePalabras = new ArrayList<String>();	
		Random r= new Random();
		
		try {
			listaDePalabras = Files.readAllLines(wordFile.toPath());
		}catch(IOException ex) {
			
		}
		
	//	System.out.println(listaDePalabras.toString());
		palabraSeleccionadaDeLista = listaDePalabras.get(r.nextInt(listaDePalabras.size()));
		palabraSeleccionadaDeLista.trim();
	}
	
	public void obtenerPalabraIngresada(String palabra) {
		this.palabraIngresada = palabra;
		intentos--;
		//compararPalabra(palabra);
		ActualizarEstatusLetraDePalabra();
	}
	
	private String[] mostrarPalabraSeleccionada() {
		 //List<String> palabraSelec = Arrays.asList(partirPalabra(palabraSeleccionadaDeLista));
		String[] palabraSelec = partirPalabra(palabraSeleccionadaDeLista);
		return palabraSelec;
	}
	
//	private void compararPalabra(String palabra) {
//		for (int i = 0; i < palabraSeleccionadaDeLista.length(); i++) {	
//			ActualizarEstatusLetraDePalabra(palabraSeleccionadaDeLista,palabraIngresada.charAt(i));
//		}
//	}
	
	private void ActualizarEstatusLetraDePalabra() {
		//System.out.println(palabraSeleccionadaDeLista + " " + palabraSeleccionadaDeLista.length());
		List<String> palabraSelec = Arrays.asList(partirPalabra(palabraSeleccionadaDeLista));
		String[] palabraUser = partirPalabra(palabraIngresada);
		int contadorL = 0;
		contadorVerdes = 0;	//reinicia la variable cada vez que va a entrar al ciclo
			for(int i= 0 ; i< 5; i++) {
				if(palabraSelec.contains(palabraUser[i])) { //Pertenece alguna letra ingresada a la palabra seleccionada? 
					if(palabraSelec.get(i).equals(palabraUser[i])) { //Esta la letra ingresada en la misma posicion que en la palabra seleccionada?
						contadorL = contadorL + 1;
						
						//System.out.println(contadorL);
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
		
			
			if(contadorL == 5) {
				setStatus(EstadoJuego.Victoria); //El Usuario gano el juego
			
			}
			
			if(intentos == 0 && this.juegoEstatus != EstadoJuego.Victoria) {
				
				setStatus(EstadoJuego.Derrota);
			}
			
	
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
	
	public boolean consultarVictoria() {
		if(juegoEstatus == EstadoJuego.Victoria) {
			
			return true;
		}
		return false;
	}
	
	public boolean consultarDerrota() {
		if(juegoEstatus == EstadoJuego.Derrota) {
			return true;
		}
		
		return false;
	}

	public EstadoJuego consultarEstado() {
		
		if(juegoEstatus ==  EstadoJuego.EnProceso) {
			
			return EstadoJuego.EnProceso;
		
		}
		
		if(juegoEstatus == EstadoJuego.Victoria) {
			
			return EstadoJuego.Victoria;
		}
		
		if(juegoEstatus == EstadoJuego.Derrota) {
			return EstadoJuego.Derrota;
		}
		
		return null;
	}


	private void setStatus(EstadoJuego estado) {
		
		this.juegoEstatus = estado;
	}
	

	public void reiniciarJuego() {
	
		seleccionarPalabraAleatoria();
		
		setStatus(EstadoJuego.EnProceso);
		
		this.intentos = 5;
		
	}

	public String getPalabraJuego() {
		
		return this.palabraSeleccionadaDeLista;
	}


}

