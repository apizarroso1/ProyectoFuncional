import daw.com.Pantalla;
import daw.com.Teclado;

public class Pelicula {
	private String titulo;
	private int duracion;
	private int edad;
	private String director;
	
	
	public Pelicula(String titulo, int duracion, int edad, String director) {
		this.titulo = titulo;
		setDuracion (duracion);
		setEdad (edad);
		this.director = director;
	}
	
	public Pelicula ()
	{
		this ("");
	}
	
	public Pelicula (String titulo)
	{
		this (titulo, 0, 0, "");
	}
	
	public Pelicula (Pelicula original)
	{
		this (original.titulo, original.duracion, original.edad, original.director);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		if (duracion < 0)
			duracion = 0;
		this.duracion = duracion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 0)
			edad = 0;
		
		this.edad = edad;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}



	@Override
	public boolean equals(Object obj) {
		
		Pelicula other = (Pelicula) obj;
		
		return titulo.equalsIgnoreCase(other.titulo);
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", duracion=" + duracion + ", edad=" + edad + ", director=" + director
				+ "]";
	}

	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerClave ()
	{
		titulo = Teclado.leerString("\ntitulo pelicula ");
	}
	
	public void leerOtrosDatos ()
	{
		do
		{
			edad = Teclado.leerInt("\nEdad minima pelicula ");
		}while (edad < 0);
		
		do 
		{
			duracion = Teclado.leerInt("\nDuracion pelicula ");
			
		}while (duracion < 0);
		
		director = Teclado.leerString("Director pelicula ");
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}

	
	
}
