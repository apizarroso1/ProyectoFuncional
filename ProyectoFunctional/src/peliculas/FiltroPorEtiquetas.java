package peliculas;

import java.util.function.Predicate;

public class FiltroPorEtiquetas implements Predicate<Pelicula> {

	@Override
	public boolean test(Pelicula t) {
		
		return !(t.getEtiquetas().contains("Divertida") || t.getEtiquetas().contains("divertida"));
	}

}
