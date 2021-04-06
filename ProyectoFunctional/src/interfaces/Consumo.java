package interfaces;

import java.util.ArrayList;

public enum Consumo {
	A, B, C, D, E, F;
	
	public static ArrayList<String> getValuesAsStringArrayList(){
		ArrayList<String> consumos = new ArrayList<>();
		Consumo consumo[] = Consumo.values();
		
		for (int i = 0; i < consumo.length; i++) {
			consumos.add(consumo[i].name());
		}
		
		return consumos;
	}
}
