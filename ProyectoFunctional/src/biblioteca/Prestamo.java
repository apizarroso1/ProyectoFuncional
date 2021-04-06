package biblioteca;

import java.time.LocalDate;

public class Prestamo {
	public LocalDate fecha;
	public Libro libro;
	public Lector lector;
	public boolean devuelto = false;

	public Prestamo(LocalDate fecha, Libro libro, Lector lector, boolean devuelto) {
		this.fecha = fecha;
		this.libro = libro;
		this.lector = lector;
		this.devuelto = devuelto;
	}

	public Prestamo() {
		this(null, null, null, false);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	// Funcion que mostrara solo el titulo y el autor de un libro
	public void mostrarLibroAbreviado() {
		System.out.println("\n" + this.libro.getTitulo());
		System.out.println("\n" + this.libro.getAutor());
	}

	@Override
	public String toString() {
		return "Prestamo [fecha=" + fecha + ", libro=" + libro + ", lector=" + lector + ", devuelto=" + devuelto + "]";
	}

	public void mostrarDatos() {
		System.out.println("\n" + toString());
	}

}
