package bibliotecaCarlos;

public class Materia {

	//Variables
	private String nombre;

	//Constructor con par�metros
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
		this.nombre = Libro.leerString("Nombre");
	}
	
	//Mostrar datos
	public void mostrarDatos () {
		System.out.println("\n" + toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
}
