package ejerciciocompleto;

import java.util.function.Consumer;

public class Incrementar1Afecto implements Consumer<Persona> {

	@Override
	public void accept(Persona p) {
		// TODO Auto-generated method stub
		p.setAfecto(p.getAfecto() + 1);
	}

}
