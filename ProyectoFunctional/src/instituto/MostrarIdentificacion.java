package instituto;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class MostrarIdentificacion implements Consumer<Persona> {

	@Override
	public void accept(Persona t) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n" + t.identificacion());

	}

}
