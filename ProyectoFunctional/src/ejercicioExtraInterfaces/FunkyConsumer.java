package ejercicioExtraInterfaces;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class FunkyConsumer implements Consumer<Empleado> {

	@Override
	public void accept(Empleado t) {
		t.mostrarDatos();
	}
}
