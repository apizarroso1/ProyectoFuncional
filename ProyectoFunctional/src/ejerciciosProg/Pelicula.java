package ejerciciosProg;
import daw.com.Teclado;
public class Pelicula {
	
	private String titulo;
	private int duracion;
	private int edadMinima;
	private String director;
	
	//constructor por defecto
	public Pelicula() {
		this.titulo = "";
		this.duracion = 0;
		this.edadMinima = 0;
		this.director = "";
	}
	//constructor
	public Pelicula(String titulo, int duracion, int edadMinima, String director) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMinima;
		this.director = director;
	}
	
	public Pelicula(String titulo) {
		this (titulo, 0, 0, "");
	}
	
	//Copia
	public Pelicula(Pelicula original) {
		this (original.titulo, original.duracion, original.edadMinima, original.director);
	}
	
	//getters
	public String getTitulo() {
		return this.titulo;
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	
	public int getEdadMinima() {
		return this.edadMinima;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	//setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDuracion(int duracion) {
		
		if (duracion < 0) {
			duracion = 0;
		}
		this.duracion = duracion;
	}
	
	public void setEdadMinima(int edadMinima) {
		
		if (edadMinima < 0) {
			edadMinima = 0;
		}
		this.edadMinima = edadMinima;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	//metodos adicionales
	public void leerTitulo() {
		this.titulo = Teclado.leerString("\nTítulo de la película");
	}
	
	public void leerDatos() {
		this.edadMinima = Teclado.leerInt("Edad mÃ­nima");
		this.duracion = Teclado.leerInt("DuraciÃ³n");
		this.director = Teclado.leerString("Director");
	}

}
