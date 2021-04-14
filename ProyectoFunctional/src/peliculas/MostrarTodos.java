package peliculas;

import java.util.function.Consumer;

public class MostrarTodos implements Consumer<Pelicula> {

	@Override
	public void accept(Pelicula t) {
		t.mostrarDatos();
	}

}
