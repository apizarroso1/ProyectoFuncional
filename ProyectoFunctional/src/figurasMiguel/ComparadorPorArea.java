package ficherosherencia;

import java.util.Comparator;

public class ComparadorPorArea implements Comparator<Figura> {

	@Override
	public int compare(Figura o1, Figura o2) {
		// TODO Auto-generated method stub
		return Float.compare(o1.getArea(), o2.getArea());
	}

}
