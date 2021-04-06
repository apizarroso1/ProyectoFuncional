package interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public enum Color  {
	BLANCO, NEGRO, ROJO, AZUL, GRIS;
	
	public static ArrayList<String> getValuesAsStringArrayList(){
		ArrayList<String> colores = new ArrayList<>();
		Color color[] = Color.values();
		
		for (int i = 0; i < color.length; i++) {
			colores.add(color[i].name());
		}
		
		
		return colores;
	}
}
