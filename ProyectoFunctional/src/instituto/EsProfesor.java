package institutosimple;

import java.util.function.Predicate;

public class EsProfesor implements Predicate<Persona> {

	@Override
	public boolean test(Persona t) {
		// TODO Auto-generated method stub
		return t instanceof Profesor;
	}

}
