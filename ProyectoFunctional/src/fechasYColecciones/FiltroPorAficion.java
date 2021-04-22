package fechasYColecciones;

import java.util.function.Predicate;

public class FiltroPorAficion implements Predicate<Persona> {
	private String aficion;
	
	public FiltroPorAficion(String aficion) {
		this.aficion = aficion;
	}
	
	public String getAficion() {
		return aficion;
	}


	public void setAficion(String aficion) {
		this.aficion = aficion;
	}


	@Override
	public boolean test(Persona t) {
		
		return t.tieneAficion(aficion);
	}

}
