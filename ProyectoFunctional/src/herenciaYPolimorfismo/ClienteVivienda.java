package herenciaYPolimorfismo;

import daw.com.Pantalla;
import daw.com.Teclado;

public class ClienteVivienda {
	private String dni;
	private String nombre;

	public ClienteVivienda(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public ClienteVivienda(String dni) {
		this.dni = dni;
		this.nombre = "";
	}

	public ClienteVivienda() {
		this("", "");
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
		leerClave();
		this.nombre = Teclado.leerString("\nNombre");
	}
	
	public void leerClave() {
		this.dni = Teclado.leerString("\nDNI");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteVivienda other = (ClienteVivienda) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteVivienda [dni=" + dni + ", nombre=" + nombre + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

}
