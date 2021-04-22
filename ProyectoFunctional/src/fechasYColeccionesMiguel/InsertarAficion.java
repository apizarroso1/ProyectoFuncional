package ejerciciocompleto;

import java.util.Set;
import java.util.function.Consumer;

public class InsertarAficion implements Consumer<String> {
	
	private Set<String> acciones;
	
	

	public InsertarAficion(Set<String> acciones) {
		this.acciones = acciones;
	}

	

	public Set<String> getAcciones() {
		return acciones;
	}



	public void setAcciones(Set<String> acciones) {
		this.acciones = acciones;
	}



	@Override
	public void accept(String t) {
		// TODO Auto-generated method stub
		acciones.add(t);

	}

}
