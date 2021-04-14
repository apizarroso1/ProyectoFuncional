package peliculas;

import java.util.function.Predicate;

public class FiltroPorPrecio50 implements Predicate<Pelicula> {

	@Override
	public boolean test(Pelicula t) {
		return !(t.getPrecio() > 50);
	}

}
