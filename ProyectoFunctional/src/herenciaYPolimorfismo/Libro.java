package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Libro extends Material {
	private int nPaginas;

	public Libro(String cod, String titulo, String autor, int prestamos, int nPaginas, boolean baja) {
		super(cod, titulo, autor, baja, prestamos);
		this.nPaginas = nPaginas;
	}

	public Libro() {
		super("1", " ", " ", false, 0);
		this.nPaginas = 0;
	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		if (nPaginas < 0) {
			nPaginas = 0;
		}
		this.nPaginas = nPaginas;
	}
	
	public void leerDatos() {
		super.leerDatos();
		this.nPaginas = Teclado.leerInt("\nNumero de paginas");
	}

	@Override
	public String toString() {
		return "Libro [nPaginas=" + nPaginas + ", toString()=" + super.toString() + "]";
	}

	public String mostrarDatos() {
		return "\n" + toString();
	}

}
