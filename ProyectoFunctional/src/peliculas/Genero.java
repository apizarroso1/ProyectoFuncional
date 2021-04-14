package peliculas;

import java.util.ArrayList;

public enum Genero {
	AVENTURA, COMEDIA, TERROR, SCIFI;
	
	public static ArrayList<String> getValuesAsStringArrayList(){
		ArrayList<String> generos = new ArrayList<>();
		
		Genero genero[] = Genero.values();
		
		for (int i = 0; i < genero.length; i++) {
			generos.add(genero[i].name());
		}
		
		return generos;
	}
}
