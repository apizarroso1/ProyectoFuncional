package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Cliente {
	private String dni;
	private String nombre;
	private boolean prestamo = false;

	public Cliente(String dni, String nombre, boolean prestamo) {
		this.dni = dni;
		this.nombre = nombre;
		this.prestamo = prestamo;
	}

	public Cliente() {
		this("1", " ", false);
	}

	public boolean isPrestamo() {
		return prestamo;
	}

	public void setPrestamo(boolean prestamo) {
		this.prestamo = prestamo;
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

	public void leerDatos() {
		this.nombre = Teclado.leerString("\nNombre");
		this.dni = Teclado.leerString("\nDni");
	}

	@Override
	public boolean equals(Object obj) {
		Cliente other = (Cliente) obj;
		return this.dni.equals(other.dni);
	}
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", prestamo=" + prestamo + "]";
	}

	public String mostrarDatos() {
		return "\n" + toString();
	}
}
