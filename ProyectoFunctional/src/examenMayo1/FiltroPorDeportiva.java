package examenMayo1;

import java.util.function.Predicate;

public class FiltroPorDeportiva implements Predicate<Via> {

	@Override
	public boolean test(Via t) {
		return t instanceof Deportiva;
	}

}
