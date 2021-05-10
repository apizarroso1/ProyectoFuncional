package ficherosherencia;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class EscribirFiguraPorPantalla implements Consumer<Figura> {

	@Override
	public void accept(Figura figura) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n" + figura);
		
	}

}
