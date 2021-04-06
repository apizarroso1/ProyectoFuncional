package institutosimple;

import java.util.function.Predicate;

public class EsAlumno implements Predicate<Persona> {

	@Override
	public boolean test(Persona t) {
		// TODO Auto-generated method stub
		return t instanceof Alumno;
	}

}
