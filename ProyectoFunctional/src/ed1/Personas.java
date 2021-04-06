/**
 * 
 */
package ed1;

/**
 * @author anmar
 *
 */
public class Personas {

	//Estructura --> Atributos
	private String nombre;
	private String apellidos;
	private int edad;
	private String genero;
	private String dni;
	
	//Comportamiento --> M�todos
	
	//M�todos constructores
	// Constructor por defecto
	public Personas() {
		this.nombre = "desconocido";
		this.apellidos = "desconocido";
		this.edad = -1;
		this.genero = "desconocido";
		this.dni = "desconocido";
	}
	
	//Constructor parametrizado 
	public Personas (String nombre, String apellidos, int edad, String genero, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
	}
	
	//M�todos getters --> selectores

	public String getNombre() {
		   return nombre;
	}
	
	public String getApellidos() {
		   return apellidos;
	}
	
	public int getEdad() {
		   return edad;
	}
	
	public String getGenero() {
		   return genero;
	}
	
	public String getDni() {
		   return dni;
	}
	
	//M�todos setters --> modificadores
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	//M�todos propios del comportamiento del objeto persona
	public void hablar(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void presentarme (String nombre, String apellidos, int edad, String genero, String dni ) {
		System.out.println("Hola. Me llamo " + nombre + " " + apellidos + ".Tengo " + edad + " a�os. Soy " +
			 genero + " con dni " + dni);
	}
	
}
