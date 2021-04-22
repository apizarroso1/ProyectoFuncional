package ejerciciocompleto;

import java.util.Comparator;

public class ComparadorPorAprecio implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		return Float.compare(p2.getAfecto(), p1.getAfecto());
	}

}
