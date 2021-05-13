package practicaFinal;

import java.util.function.Consumer;

public class ConsumerMostrar implements Consumer<Producto> {

	@Override
	public void accept(Producto t) {
		
		t.mostrarDatos();
	}

}
