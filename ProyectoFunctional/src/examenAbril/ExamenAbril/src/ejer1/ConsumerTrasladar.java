package ejer1;

import java.util.function.Consumer;

public class ConsumerTrasladar implements Consumer<Figura> {
	
	@Override
	public void accept(Figura t) {
		t.getCentro().setX(t.getCentro().getX() + 1);
	}

}
