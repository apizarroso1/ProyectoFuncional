package herenciaYPolimorfismo;

import daw.com.Teclado;

public abstract class Material {
//código identificativo, el título y el autor.
	private String cod;
	private String titulo;
	private String autor;
	private boolean baja = false;
	private int prestamos;

	public Material(String cod, String titulo, String autor, boolean baja, int prestamos) {
		this.cod = cod;
		this.titulo = titulo;
		this.autor = autor;
		this.baja = baja;
		this.prestamos = prestamos;
	}

	public Material() {
		this("1", " ", " ", false, 0);
	}

	public Material(Material o) {
		this(o.cod, o.autor, o.titulo, o.baja, o.prestamos);
	}

	public int getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(int prestamos) {
		this.prestamos = prestamos;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void leerDatos() {
		this.autor = Teclado.leerString("\nAutor");
		this.titulo = Teclado.leerString("\nTitulo");
		this.cod = Teclado.leerString("\nCod");
	}

	@Override
	public String toString() {
		return "Material [cod=" + cod + ", titulo=" + titulo + ", autor=" + autor + "]";
	}

	public String mostrarDatos() {
		return "\n" + toString();
	}
}
