package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Disco extends Material {

	private String discografica;

	public Disco(String cod, String titulo, String autor, String discografica, boolean baja, int prestamos) {
		super(cod, titulo, autor, baja, prestamos);
		this.discografica = discografica;
	}

	public Disco() {
		super("1", " ", " ", false, 0);
		this.discografica = " ";
	}

	public String getDiscografica() {
		return discografica;
	}

	public void setDiscografica(String discografica) {
		this.discografica = discografica;
	}
	
	public void leerDatos() {
		super.leerDatos();
		this.discografica = Teclado.leerString("\nDiscografica");
	}

	@Override
	public String toString() {
		return "Disco [discografica=" + discografica + ", toString()=" + super.toString() + "]";
	}

	public String mostrarDatos() {
		return "\n" + toString();
	}

}
