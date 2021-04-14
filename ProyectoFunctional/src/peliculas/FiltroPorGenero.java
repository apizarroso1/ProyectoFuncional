package peliculas;

import java.util.function.Predicate;

public class FiltroPorGenero implements Predicate<Pelicula> {

	@Override
	public boolean test(Pelicula t) {
		
		return !(t.getGenero() == Genero.AVENTURA);
	}

}
