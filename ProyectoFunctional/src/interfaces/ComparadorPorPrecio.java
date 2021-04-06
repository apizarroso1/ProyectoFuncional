package interfaces;

import java.util.Comparator;

import interfacesMiguel.VideoJuego;

public class ComparadorPorPrecio implements Comparator<Electrodomestico> {

	@Override
	public int compare(Electrodomestico o1, Electrodomestico o2) {
		
		return Float.compare(o1.calcularPrecio(), (o2).calcularPrecio());
	}

}
