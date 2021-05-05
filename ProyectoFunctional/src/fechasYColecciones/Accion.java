package fechasYColecciones;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Accion implements Consumer<Persona> {

	private InsertarAficion InsertarAficiones;
	
	public Accion (Consumer <String> InsertarAficiones) {
		this.InsertarAficiones = InsertarAficiones;
		
		
	}
	
	
	@Override
	public void accept(Persona t) {
		// TODO Auto-generated method stub
		
	}

	
}
