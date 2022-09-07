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
import interfaz.MainForm;

public class Juego {
	//private String[] listaDePalabras={"huevo","queso","sardo","saldo","clips","messi","calma",};
	
	//Variables
	private String palabraSeleccionadaDeLista;
	
	public enum EstadoLetra { CorrectaUbicada, CorrectaNoUbicada, Incorrecta }
	private String palabraIngresada;
	private EstadoLetra[] palabraEstatus= {EstadoLetra.CorrectaUbicada , EstadoLetra.CorrectaUbicada , EstadoLetra.Incorrecta};
	
	
	
	public Juego(){
		
		seleccionarPalabraAleatoria();
		System.out.println(palabraSeleccionadaDeLista);
		mostrarPalabraSeleccionada();
	};
	
	//Metodos
	
	public void seleccionarPalabraAleatoria() {
		
		File wordFile = new File("\\Users\\agusl\\Desktop\\Universidad\\Progra III\\tpwordle\\assets\\words.txt");
		
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
		compararPalabra(palabra);
	}
	
	public  String[] mostrarPalabraSeleccionada() {
		
		 //List<String> palabraSelec = Arrays.asList(partirPalabra(palabraSeleccionadaDeLista));
		
		String[] palabraSelec = partirPalabra(palabraSeleccionadaDeLista);
		
		return palabraSelec;
		
		
		
		
	}
	public void compararPalabra(String palabra) {
		
		
		
		for (int i = 0; i < palabraSeleccionadaDeLista.length(); i++) {
			
			
			
			ActualizarEstatusLetraDePalabra(palabraSeleccionadaDeLista,palabraIngresada.charAt(i));
		
		}
	}
	
	
	
	
	public void ActualizarEstatusLetraDePalabra(String palabra, char letra) {
	//	System.out.println(palabraSeleccionadaDeLista + " " + palabraSeleccionadaDeLista.length());
		
		List<String> palabraSelec = Arrays.asList(partirPalabra(palabraSeleccionadaDeLista));
		String[] palabraUser = partirPalabra(palabraIngresada);
		
		
		
		for(int i= 0 ; i< 5; i++) {
			
			if(palabraSelec.contains(palabraUser[i])) { //Pertenece alguna letra ingresada a la palabra seleccionada? 
				
				if(palabraSelec.get(i).equals(palabraUser[i])) { //Esta la letra ingresada en la misma posicion que en la palabra seleccionada?
				
					MainForm.cambiarEstadoPanel(i, Color.green);
					
			}
				else {
					
					MainForm.cambiarEstadoPanel(i, Color.yellow);
				}	
			
		}
		
			else {
				
				MainForm.cambiarEstadoPanel(i, Color.gray);
			}
		
		
		
		
		
		
//		for (int i = 0; i < 5; i++) {
//            
//			if(letra == palabraSeleccionadaDeLista.charAt(i)) {
//            	
//				palabraEstatus[i] = EstadoLetra.CorrectaNoUbicada;
//
//                if(palabra.charAt(i) == palabraSeleccionadaDeLista.charAt(i)) {
//                    palabraEstatus[i] = EstadoLetra.CorrectaUbicada;
//                }
//            }
//            else {
//            	palabraEstatus[i] = EstadoLetra.Incorrecta;
//            }

        }

    }
	
	//Herramientas
	
	private String[] partirPalabra(String palabra) { //Divide el string en caracteres individuales
		
		String[] splitWord = palabra.split("");
	
		
		return splitWord;
	
	}
	
	
}
