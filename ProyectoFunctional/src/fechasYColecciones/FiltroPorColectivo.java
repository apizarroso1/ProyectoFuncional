package fechasYColecciones;

import java.util.function.Predicate;

public class FiltroPorColectivo implements Predicate<Persona> {

	private Colectivo colectivo;
	
	public FiltroPorColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}
	
	public Colectivo getColectivo() {
		return colectivo;
	}


	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}

	@Override
	public boolean test(Persona t) {
		
		return t.getColectivo().equals(colectivo);
	}

}
