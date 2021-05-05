package fechasYColecciones;

import java.util.Comparator;

public class ComparadorPorAfecto implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		return Float.compare(o1.getAfecto(), o2.getAfecto());
	}

}
