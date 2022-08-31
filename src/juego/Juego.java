package juego;

import java.util.Random;

public class Juego {
	private String[] listaDePalabras={"sd","sd","sd","sd"};
	private String palabraSeleccionadaDeLista;
	
	private String palabraIngresada;
	private EstadoLetra[] palabraEstatus= {EstadoLetra.CorrectaUbicada , EstadoLetra.CorrectaUbicada , EstadoLetra.Incorrecta};
	
	Juego(){
		
	};
	
	public void seleccionarPalabraAleatoria() {
		Random r= new Random();
		palabraSeleccionadaDeLista = listaDePalabras[r.nextInt(listaDePalabras.length)];
	}
	
	public void ingresarPalabraYComparar(String palabra) {
		palabraIngresada = palabra;
		
		for (int i = 0; i < palabraSeleccionadaDeLista.length(); i++) {
			
			ActualizarEstatusLetraDePalabra(palabraSeleccionadaDeLista,palabraIngresada.charAt(i));
		
	}
	}
	
	public enum EstadoLetra { CorrectaUbicada, CorrectaNoUbicada, Incorrecta }
	
	
	
	public void ActualizarEstatusLetraDePalabra(String palabra, char letra) {
		for (int i = 0; i < palabraSeleccionadaDeLista.length(); i++) {
            if(letra == palabraSeleccionadaDeLista.charAt(i)) {
            	palabraEstatus[i] = EstadoLetra.CorrectaNoUbicada;

                if(palabra.charAt(i) == palabraSeleccionadaDeLista.charAt(i)) {
                    palabraEstatus[i] = EstadoLetra.CorrectaUbicada;
                }
            }
            else {
            	palabraEstatus[i] = EstadoLetra.Incorrecta;
            }

        }

    }
	
}
