package fechasYColecciones;

import java.util.function.Predicate;

public class FiltroPorCumple implements Predicate<Persona> {

	@Override
	public boolean test(Persona t) {
		return t.esSuCumpleHoy();
	}

}
