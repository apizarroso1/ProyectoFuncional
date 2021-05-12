package clubDeportistas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import daw.com.Teclado;

public class Deportista {

	private String dni, nombre, tipo;
	private LocalDate fechaNac;

	public Deportista(String dni, String nombre, String tipo, LocalDate fechaNac) {
		this.dni = dni;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaNac = fechaNac;
	}

	public Deportista() {
		this("", "", "Atleta", null);
	}

	public Deportista(String dni) {
		this(dni, "", "Atleta", LocalDate.now());
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if (!tipo.equalsIgnoreCase("atleta") || !tipo.equalsIgnoreCase("ciclista")) {
			throw new IllegalArgumentException();
		} else {
			this.tipo = tipo;
		}
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {

		/*
		 * Period periodo; Period catorceAnios; periodo = Period.between(fechaNac,
		 * LocalDate.now()); catorceAnios = Period.of(14, 0, 0);
		 * 
		 * if (periodo.minus(catorceAnios).isNegative()) { this.fechaNac =
		 * LocalDate.now().minus(catorceAnios); throw new
		 * IllegalArgumentException("Deportista demasiado joven"); } else {
		 * this.fechaNac = fechaNac; }
		 */

		Period periodo;
		periodo = Period.between(fechaNac, LocalDate.now());

		if (periodo.getYears() < 14) {
			throw new IllegalArgumentException("Deportista demasiado joven");
		} else {
			this.fechaNac = fechaNac;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deportista other = (Deportista) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deportista [dni=" + dni + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaNac=" + fechaNac + "]";
	}

	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		this.dni = Teclado.leerString("\nDni");
	}

	public void leerOtrosDatos() {
		this.nombre = Teclado.leerString("\nNombre");
		leerFechaNac();
		setTipo(Teclado.leerString("\nAtleta o ciclista"));
	}

	public void leerFechaNac() {
		String formatoString = "dd/mm/yyyy";
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoString);

		setFechaNac(LocalDate.parse(formatoString, formato));
	}

	public void mostrarDatos() {
		System.out.println(toString());
	}
	
	public void escribirFichero(DataOutputStream Deportistas) throws IOException{
		
		Deportistas.writeUTF(dni);
		Deportistas.writeUTF(nombre);
		Deportistas.writeUTF(tipo);
		Deportistas.writeUTF(this.fechaNac.toString());
	}
	
	public void leerFichero(DataInputStream Deportistas) throws IOException {
		
		this.dni = Deportistas.readUTF();
		this.nombre = Deportistas.readUTF();
		this.tipo = Deportistas.readUTF();
		this.fechaNac = LocalDate.parse(Deportistas.readUTF());
	}

}
