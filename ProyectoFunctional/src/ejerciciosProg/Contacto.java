package ejerciciosProg;

public class Contacto {
	
	//Atributos
	private String nombre;
	private String telefono;
	
	//Constructor por defecto
	public Contacto() {
		this.nombre = "";
		this.telefono = "111111111";
	}
	
	//Constructor por parámetros
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	//Métodos getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	//Métodos setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
