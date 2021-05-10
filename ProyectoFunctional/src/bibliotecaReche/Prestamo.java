package bibliotecaReche;
import java.time.LocalDate;

public class Prestamo {

	private Lector lector;
	private Libro libro;
	private LocalDate fecha;
	

	
	public Prestamo() {
	
		this.lector = new Lector ();
		this.libro = new Libro();
		this.fecha = LocalDate.now();
}

	public Prestamo (Libro libro, Lector lector) {
		
		this.libro = libro;
		this.lector = lector;
		this.fecha= LocalDate.now();
	}

	
	public Prestamo ( Lector lector) {
		
		
		this.lector = lector;
	
	}


	
	public Lector getLector() {
		return lector;
	}


	public void setLector(Lector lector) {
		this.lector = lector;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}





	public String toString() {
		return "Prestamo [lector=" + lector + ", libro=" + libro + ", fecha=" + fecha + "]";
	}

	


	public boolean equals(Object obj) {
		Prestamo p = (Prestamo) obj;
		
		return this.lector.equals(p.lector) ;
	}
	

	
	public void mostrarDatos () {
		System.out.println(toString ());
	}
	
}
