package bibliotecaReche;
import java.util.ArrayList;
import java.util.Scanner;

public class Libro {
	private String isbn, titulo, autor;
	private ArrayList <Materia> materias;
	
	
	public Libro(String isbn, String titulo, String autor) {
	
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		
		this.materias= new ArrayList <Materia> ();
		
	}

	public Libro () {
		
		this ("","","");
	}

	public Libro (Libro original) {
		
		this (original.isbn, original.titulo, original.autor);
		this.materias= new ArrayList <Materia> ();
		for (int i = 0; i < original.materias.size(); i++) {
			this.materias.add(original.materias.get(i));
		}
	}


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



	public String toString() {
		return "\n Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", materias=" + materias + "]";
	}


	public void leerIsbn () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor introduzca el isbn:");
		isbn = sc.next();
	}
	public void leerOtrosDatos () {
		Scanner sc = new Scanner(System.in);
		titulo = sc.next("Por favor introduzca el titulo:");
		autor = sc.next("Por favor introduzca el autor:");
	}
	

	public void leerDatos () {
		leerIsbn();
		leerOtrosDatos();
	}
	

	public void mostrarDatos () {
	System.out.println( toString ());
	}
	

	public boolean insertarMateria (Materia a) {
		boolean exito = false;
		if (!materias.contains(a)) {
			exito = materias.add(a);
		}
		
		return exito;
	}


	public boolean equals(Object obj) {
		Libro l = (Libro) obj;
		
		return this.isbn.equals(l.getIsbn());
	}
}
