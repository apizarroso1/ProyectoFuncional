package ejerciciosDeMiguel;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Cliente {

	private String dni;
	private String nombre;

	public Cliente ()
	{
		this ("","");
	}
	
	public Cliente(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public Cliente(Cliente original) {
		this (original.dni, original.nombre);
	}

	public Cliente(String dni) {
		this (dni,"");
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public boolean equals(Object obj) {
		
		Cliente other = (Cliente) obj;
		return dni.equals(other.dni);
	}
	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}

	public void leerOtrosDatos() {
		nombre = Teclado.leerString("nombre");
	}

	public void leerClave() {
		dni = Teclado.leerString("dni");
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	public void verDatos ()
	{
		Pantalla.escribirString("\n" + this);
	}
	
	
	
}
