package ejer1;

import java.util.ArrayList;

import daw.com.Pantalla;

public enum Color {
	ROJO, VERDE, AZUL, NEGRO;
	
	public static ArrayList asString() {
		ArrayList<String> colores = new ArrayList();
		colores.add("Rojo");
		colores.add("Verde");
		colores.add("Azul");
		colores.add("Negro");
		
		return colores;
	}
	
	
	public static void mostrarDatos() {
		Pantalla.escribirString("\n" + "Rojo, verde, azul, negro");
	}
}
