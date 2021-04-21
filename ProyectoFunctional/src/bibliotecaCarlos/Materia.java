public class Materia {

	//Variables
	private String nombre;

	//Constructor con parámetros
	public Materia(String nombre) {
	
		this.nombre = nombre;
	}

	//Costructor por defecto
	public Materia () {
		this ("");
	}
	
	//Costructor copia
	public Materia (Materia original) {
		this(original.nombre);
		
	}
	
	//Selectores y modificadores
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//To String
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + "]";
	}
	
	//Leer datos
	public void leerDatos () {
		System.out.println("\n Introduce el nombre de la materia:");
	}
	
	//Mostrar datos
	public void mostrarDatos () {
		System.out.println("\n" + toString());
	}

	//Equals
	@Override
	public boolean equals(Object obj) {
	
		Materia a = (Materia) obj;
		
		return this.nombre.equals(a.getNombre());
	}
	
	
}
