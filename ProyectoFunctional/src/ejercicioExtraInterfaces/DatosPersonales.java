package ejercicioExtraInterfaces;

import daw.com.Teclado;

public class DatosPersonales implements LeerYMostrarDatos {
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;

	public DatosPersonales(String nombre, String apellidos, String dni, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
	}
	
	public DatosPersonales(String dni) {
		this.nombre = "";
		this.apellidos = "";
		this.dni = dni;
		this.direccion = "";
	}

	public DatosPersonales() {
		this("", "", "", "");
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public void leerClave() {
		this.dni = Teclado.leerString("\nDni");

	}

	@Override
	public void leerOtrosDatos() {
		this.nombre = Teclado.leerString("\nNombre");
		this.apellidos = Teclado.leerString("\nApellidos");
		this.direccion = Teclado.leerString("\nDireccion");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		DatosPersonales other = (DatosPersonales) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatosPersonales [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", direccion="
				+ direccion + "]";
	}
}
