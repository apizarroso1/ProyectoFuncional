package practicaFinal;

import java.util.ArrayList;

public enum Tipo {
	COMESTIBLE(2), LIMPIEZA(2), BELLEZA(1.4);

	private double bonus;

	Tipo(double bonus) {
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public static ArrayList<String> getValuesAsStringArrayList() {
		ArrayList<String> tipos = new ArrayList<>();

		Tipo tipo[] = Tipo.values();

		for (int i = 0; i < tipo.length; i++) {
			tipos.add(tipo[i].name());
		}

		return tipos;
	}
}
