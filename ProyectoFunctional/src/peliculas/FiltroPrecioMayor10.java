package peliculas;

import java.util.function.Predicate;

public class FiltroPrecioMayor10 implements Predicate<Pelicula> {

	@Override
	public boolean test(Pelicula t) {
		return (t.getPrecio() <= 10);
	}

}
