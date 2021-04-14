package peliculas;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class FiltroDesdeEstreno implements Predicate<Pelicula> {

	@Override
	public boolean test(Pelicula t) {
		
		// Period period = Period.between(t.getEstreno(), LocalDate.now());
		
		LocalDate nuevaFecha = t.getEstreno().plusMonths(6);
		
		// Seguramente sea cutre
		return !(nuevaFecha.isBefore(LocalDate.now()));
	}

}
