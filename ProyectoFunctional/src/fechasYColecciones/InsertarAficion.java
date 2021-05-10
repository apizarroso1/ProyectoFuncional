package fechasYColecciones;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class InsertarAficion implements Consumer<String> {


	private Set<String> aficiones;
	
	public InsertarAficion(HashSet<String> aficiones) {
		this.aficiones = aficiones;
	}
	
	public Set<String> getAficiones() {
		return aficiones;
	}

	public void setAficiones(Set<String> aficiones) {
		this.aficiones = aficiones;
	}

	@Override
	public void accept(String t) {
		aficiones.add(t);
	}

}
