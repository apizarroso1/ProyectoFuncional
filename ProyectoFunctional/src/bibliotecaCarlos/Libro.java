import java.util.ArrayList;

public class Libro {

	private String isbn, titulo, autor;
	private ArrayList <Materia> materias;
	
	
	//Constructor con parámetros
	public Libro(String isbn, String titulo, String autor) {
	
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		
		this.materias= new ArrayList <Materia> (); //Array list creado y vacio.
		
	}
	
	//Costructor por defecto sin materia
	public Libro () {
		
		this ("","","");
	}

	//Costructor copia
	public Libro (Libro original) {
		
		this (original.isbn, original.titulo, original.autor);
		this.materias= new ArrayList <Materia> ();
		for (int i = 0; i < original.materias.size(); i++) {
			this.materias.add(original.materias.get(i)); //A mis materias, le guardo en la posicion i,  el objeto.
		}
	}

	//Selectores y modificadores
	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
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



	public ArrayList<Materia> getMaterias() {
		return materias;
	}



	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}



	//To string
	@Override
	public String toString() {
		return "\n Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", materias=" + materias + "]";
	}

	//leer ISBN
	public void leerIsbn () {
		System.out.println("\n Introduce el isbn:");
	}
	//Leer Otros Datos
	public void leerOtrosDatos () {
		System.out.println("\n Introduce el titulo:");
		System.out.println("\n Introduce el autor:");
	}
	
	//Leer Datos
	public void leerDatos () {
		leerIsbn();
		leerOtrosDatos();
	}
	
	//mostrar Datos
	public void mostrarDatos () {
		System.out.println("\n" + toString ());
	}
	
	//Funcion para añadir una materia
	public boolean insertarMateria (Materia a) {
		boolean exito = false;
		if (!materias.contains(a)) {
			exito = materias.add(a);
		}
		
		return exito;
	}

	//Equals
	@Override
	public boolean equals(Object obj) {
		Libro l = (Libro) obj;
		
		return this.isbn.equals(l.getIsbn());
	}
	
	

}
