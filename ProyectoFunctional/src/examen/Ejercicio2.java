package examen;

import java.util.Iterator;

import daw.com.Teclado;

public class Ejercicio2 {

	public static void main(String[] args) {
		String frases [];
		frases = new String [10];
		String masLarga, nuevaPalabra;
		
		for (int i = 0; i < frases.length; i++) {
	
			frases [i] = Teclado.leerString("Introduzca la frase" + (i +1));
			String n = frases [i].stripLeading();
			for (int j = 0; j < n.length(); j++) {
				
				
			}
			
		}
		
		

	}

}
