package biblioteca;

import java.util.Scanner;

public class Lector {
	private String nombre;
	private String apellidos;
	private String dni;
	private String domicilio;
	private String telefono;
	private boolean baja;

	public Lector(String nombre, String apellidos, String dni, String domicilio, String telefono, boolean baja) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.baja = baja;
	}

	public Lector() {
		this(" ", " ", "1", " ", "111111111", false);
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void leerDatos() {
		this.nombre = Validacion.leerString("\nNombre");
		this.apellidos = Validacion.leerString("\nApellidos");
		this.dni = Validacion.leerString("\nDni");
		this.domicilio = Validacion.leerString("\nDomicilio");
		this.telefono = Validacion.leerString("\nTelefono");
	}

	@Override
	public String toString() {
		return "Lector [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + ", baja=" + baja + "]";
	}

	public void mostrarDatos() {
		System.out.println("\n" + toString());
	}

	// Equals que compara lectores por su dni
	@Override
	public boolean equals(Object obj) {
		Lector other = (Lector) obj;
		return this.dni.equals(other.dni);
	}

}
