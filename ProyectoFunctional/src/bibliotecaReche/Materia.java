package bibliotecaReche;
import java.util.Scanner;

public class Materia {
	private String nombre;

	public Materia(String nombre) {
	
		this.nombre = nombre;
	}

	public Materia () {
		this ("");
	}
	
	public Materia (Materia original) {
		this(original.nombre);
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "Materia [nombre=" + nombre + "]";
	}
	
	public void leerDatos () {
		Scanner sc = new Scanner(System.in);
		nombre = sc.next("Por favor introduzca el nombre de la materia:");
	}
	
	public void mostrarDatos () {
		System.out.println( toString());
	}


	public boolean equals(Object obj) {
	
		Materia a = (Materia) obj;
		
		return this.nombre.equals(a.getNombre());
	}
}
