package ed1;

import daw.com.Pantalla;

public class Vendedores {
	
	//Atributos
	private String dni;
	private String nombre;
	private int nCoches;
	private int fondos;
	
	//Constructor 1: por defecto
	public Vendedores() {
		this.dni = "11111111A";
		this.nombre = "Por defecto";
		this.nCoches = 1;
		this.fondos = 0;
	}
	
	//Constructor 2: 2 variables String
	public Vendedores(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	//Constructor 3: todas las variables
	public Vendedores(String dni, String nombre, int nCoches, int fondos) {
		this.dni = dni;
		this.nombre = nombre;
		this.nCoches = nCoches;
		this.fondos = fondos;
	}
	
	//M�todos getters
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getNCoches() {
		return this.nCoches;
	}
	
	public int getFondos() {
		return this.fondos;
	}
	
	//M�todos setters
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNCoches(int nCoches) {
		this.nCoches = nCoches;
	}
	
	public void setFondos(int fondos) {
		this.fondos = fondos;
	}
	
	//M�todos adicionales
	public static void mostrarDatosV(String dni, String nombre, int nCoches, int fondos) {
		Pantalla.escribirString(nombre);
		Pantalla.escribirString(dni);
		Pantalla.escribirInt(nCoches);
		Pantalla.escribirInt(fondos);
	}
}

	
