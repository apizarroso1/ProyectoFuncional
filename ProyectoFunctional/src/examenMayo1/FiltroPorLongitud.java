package examenMayo1;

import java.util.function.Predicate;

public class FiltroPorLongitud implements Predicate<Via> {

	private int minLongitud;
	
	public FiltroPorLongitud(int minLongitud) {
		this.minLongitud = minLongitud;
	}
	@Override
	public boolean test(Via t) {
		return t.getLongitud() < minLongitud;
	}

}
