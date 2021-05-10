import java.util.ArrayList;
import java.util.Scanner;

public class Libro {

	private String isbn, titulo, autor;
	private ArrayList <Materia> materias;
	
	
	//Constructor con par�metros
	public Libro(String isbn, String titulo, String autor, ArrayList <Materia> materias) {
	
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.materias = materias;
	}
	
	//Costructor por defecto sin materia
	public Libro () {
		
		this ("","","", new ArrayList<>());
	}
	
	public Libro(String isbn) {
		this(isbn, "", "", new ArrayList<>());
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
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", materias=" + materias + "]";
	}

	//leer ISBN
	public void leerIsbn () {
		this.isbn = leerString("Isbn");
		
	}
	//Leer Otros Datos
	public void leerOtrosDatos () {
		System.out.println("Introduce el titulo:");
		System.out.println("Introduce el autor:");
		this.titulo = leerString("Titulo");
		this.autor = leerString("Autor");
	}
	
	//Leer Datos
	public void leerDatos () {
		leerIsbn();
		leerOtrosDatos();
	}
	
	//mostrar Datos
	public void mostrarDatos () {
		System.out.println(toString ());
	}
	
	//Funcion para a�adir una materia
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
	
	public static String leerString(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		return sc.nextLine();
	}
	

}
