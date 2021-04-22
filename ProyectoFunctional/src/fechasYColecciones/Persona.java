package fechasYColecciones;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Persona implements Comparable<Persona>, LeerYMostrarDatos {

	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private float afecto;
	private HashSet<String> aficiones;
	private Colectivo colectivo;

	private static final Colectivo COL = Colectivo.ALUMNO;
	private static final LocalDate FECHANAC = LocalDate.of(2000, 1, 1);
	private static final float AFECTO = 0;

	public Persona(String nombre, String dni, LocalDate fechaNacimiento, float afecto, HashSet<String> aficiones,
			Colectivo colectivo) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		setAfecto(afecto);
		this.aficiones = aficiones;
		this.colectivo = colectivo;
	}

	public Persona() {
		this("", "", FECHANAC, AFECTO, new HashSet<>(), COL);
	}

	public Persona(String dni) {
		this("", dni, FECHANAC, AFECTO, new HashSet<>(), COL);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getAfecto() {
		return afecto;
	}

	public void setAfecto(float afecto) {
		this.afecto = Math.max(0, afecto);
	}

	public void setAficiones(HashSet<String> aficiones) {
		this.aficiones = aficiones;
	}

	public Colectivo getColectivo() {
		return colectivo;
	}

	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}

	@Override
	public int compareTo(Persona o) {
		return nombre.compareTo(o.getNombre());
	}

	@Override
	public void leerOtrosDatos() {
		this.nombre = Teclado.leerString("\nNombre");
		this.afecto = Teclado.leerFloat("\nAfecto");
		this.fechaNacimiento = leerFecha();
		leerColectivo();
		leerAficiones();
	}

	public void leerAficiones() {
		String aficion;

		do {
			aficion = Teclado.leerString("\nAficion");

			if (!aficiones.contains(aficion)) {
				aficiones.add(aficion);
			}

		} while (Teclado.leerString("\nContinuar (s/n)").equalsIgnoreCase("s"));

	}

	public void leerColectivo() {
		String colectivoString;
		ArrayList<String> colectivos;

		colectivos = Colectivo.getValuesAsString();

		do {

			System.out.println(colectivos);
			colectivoString = Teclado.leerString("\nElegir colectivo").toUpperCase();

		} while (!colectivos.contains(colectivoString));

		setColectivo(Colectivo.valueOf(colectivoString));
	}

	public LocalDate leerFecha() {
		String formatoString;
		DateTimeFormatter formato;
		LocalDate fecha;

		formatoString = "DD/MM/YYYY";

		formato = DateTimeFormatter.ofPattern(formatoString);

		fecha = LocalDate.parse(Teclado.leerString(formatoString), formato);

		return fecha;
	}

	@Override
	public void leerClave() {
		this.dni = Teclado.leerString("\nDni");
	}

	public int getEdad() {
		/*
		 * Period periodo; int anios;
		 * 
		 * periodo = Period.between(fechaNacimiento, LocalDate.now());
		 * 
		 * anios = periodo.getYears();
		 * 
		 * return anios;
		 */

		return fechaNacimiento.until(LocalDate.now()).getYears();
	}

	public boolean esMayorDeEdad() {

		if (getEdad() >= 18) {
			return true;
		} else {
			return false;
		}
	}

	public boolean esSuCumpleHoy() {

		if ((fechaNacimiento.getMonthValue() == LocalDate.now().getMonthValue())
				&& (fechaNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth())) {
			return true;
		} else {
			return false;
		}

		/*
		 * if(fechaNacimiento.getDayOfYear() == LocalDate.now().getDayOfYear()) { return
		 * true; } else { return false; }
		 */
	}

	public void aumentarAfecto() {
		float cant;

		cant = Teclado.leerFloat("\nCantidad a aumentar de afecto");

		if (cant > 0) {
			this.setAfecto(this.getAfecto() + cant);
		}
	}

	public void descontarAfecto() {
		float cant;

		cant = Teclado.leerFloat("\nCantidad a descontar de afecto");

		if (cant > 0) {
			this.setAfecto(this.getAfecto() - cant);
		}
	}

	public boolean insertarAficion() {
		String aficion;

		aficion = Teclado.leerString("\nAficion a insertar");

		if (!aficiones.contains(aficion)) {
			aficiones.add(aficion);
			return true;
		} else {
			return false;
		}
	}

	public boolean tieneAficion(String aficion) {
		if (aficiones.contains(aficion)) {
			return true;
		} else {
			return false;
		}
	}

	public Iterator<String> getAficiones() {
		return aficiones.iterator();
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
		Persona other = (Persona) obj;

		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", afecto="
				+ afecto + ", aficiones=" + aficiones + ", colectivo=" + colectivo + "]";
	}
}
