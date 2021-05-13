package practicaFinal;

import java.time.LocalDate;
import java.util.function.Predicate;

public class FiltroCaducidad implements Predicate<Perecedero> {

	@Override
	public boolean test(Perecedero t) {
		return LocalDate.now().isAfter(t.getFechaCad());
	}
}
