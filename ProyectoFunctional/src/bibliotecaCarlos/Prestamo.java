import java.time.LocalDate;

public class Prestamo {

	private Lector lector;
	private Libro libro;
	private LocalDate fecha;
	
	//Costructor por defecto 
	
	public Prestamo() {
	
		this.lector = new Lector ();
		this.libro = new Libro();
		this.fecha = LocalDate.now();
}
	//Costructor con parametros
	
	public Prestamo (Libro libro, Lector lector) {
		
		this.libro = libro;
		this.lector = lector;
		this.fecha= LocalDate.now();
	}
	//Costructor con parametros de lector
	
	public Prestamo ( Lector lector) {
		
		
		this.lector = lector;
	
	}

	//Selectores y modificadores
	
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



	//To string
	
	@Override
	public String toString() {
		return "Prestamo [lector=" + lector + ", libro=" + libro + ", fecha=" + fecha + "]";
	}

	
	//Equals

	@Override
	public boolean equals(Object obj) {
		Prestamo p = (Prestamo) obj;
		
		return this.lector.equals(p.lector) ;
	}
	
	//Mostrar datos 
	
	public void mostrarDatos () {
		System.out.println("\n" + toString ());
	}
	
}
