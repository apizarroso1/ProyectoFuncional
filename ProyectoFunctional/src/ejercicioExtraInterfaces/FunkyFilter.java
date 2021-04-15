package ejercicioExtraInterfaces;

import java.util.function.Predicate;

public class FunkyFilter implements Predicate<Empleado> {
	private static final float SUELDOBASE = 1000;

	@Override
	public boolean test(Empleado t) {
		return (t.getSalario() > SUELDOBASE);
	}

}
