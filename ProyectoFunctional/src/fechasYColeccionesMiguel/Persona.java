package ejerciciocompleto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Persona implements Comparable<Persona>{

	private static final LocalDate FECHAINICIAL = LocalDate.of(2000, 1, 1);
	private static final String FORMATOSTRING = "dd-MM-yyyy";
	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern(FORMATOSTRING);
	
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private float afecto;
	private Set<String> aficiones;
	private Colectivo colectivo;
	

	public Persona ()
	{
		this ("");
	}
	
	public Persona (String dni)
	{
		this ("", dni, FECHAINICIAL, 0f, new HashSet<>(),Colectivo.ALUMNO);
	}
	
	public Persona(String nombre, String dni, 
			LocalDate fechaNacimiento, 
			float afecto, 
			Set<String> aficiones,
			Colectivo colectivo) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.afecto = afecto;
		this.aficiones = aficiones;
		this.colectivo = colectivo;
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
		if (fechaNacimiento.isAfter(LocalDate.now()))
			fechaNacimiento = LocalDate.now();
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getAfecto() {
		return afecto;
	}

	public void setAfecto(float afecto) {
		
		this.afecto = Math.max(0,afecto);
	}

	public Iterator<String> getAficiones() {
		return aficiones.iterator();
	}

	public void setAficiones(Set<String> aficiones) {
		this.aficiones = aficiones;
	}

	public Colectivo getColectivo() {
		return colectivo;
	}

	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return dni.compareTo(o.dni);
	}
	
	public int getEdad ()
	{
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}
	
	public boolean esMayorDeEdad ()
	{
		return getEdad() >= 18;
	}
	
	public boolean esSuCumpleHoy ()
	{
		return fechaNacimiento.getMonth() == LocalDate.now().getMonth() 
				&&
				fechaNacimiento.getDayOfMonth() == LocalDate.now().getDayOfMonth();
	}
	
	public void aumentarAfecto (float afecto)
	{
		if (afecto > 0)
			this.afecto += afecto;
	}
	
	public void descontarAfecto (float afecto)
	{
		if (afecto > 0 && afecto < this.afecto)
			this.afecto -= afecto;
	}
	
	public boolean insertarAficion (String aficion)
	{
		return aficiones.add(aficion);
	}
	
	public boolean tieneAficion (String aficion)
	{
		return aficiones.contains(aficion);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + 
				", dni=" + dni + 
				", fechaNacimiento=" + fechaNacimiento.format(FORMATO) + 
				", afecto="	+ afecto + 
				", aficiones=" + aficiones + 
				", colectivo=" + colectivo + "]";
	}
	
	public void leerClave ()
	{
		dni = Teclado.leerString("\nDNI ");
	}
	
	public void leerRestoDatos ()
	{
		nombre = Teclado.leerString("\nNombre ");
		setFechaNacimiento (LocalDate.parse(Teclado.leerString("\nFecha Nacimiento " + FORMATOSTRING),FORMATO));
		setAfecto (Teclado.leerFloat("\nAfecto "));
		
		do
		{
			aficiones.add(Teclado.leerString("\nNueva afición "));
		}while (Teclado.leerString("\nSigo?").equalsIgnoreCase("s"));
	
		leerColectivo ();
	}
	
	public void leerColectivo ()
	{
		String colectivo;
		
		do
		{
			Pantalla.escribirString("\n" + Colectivo.valuesAsString());
			colectivo = Teclado.leerString("\nColectivo").toUpperCase();
		}while (!Colectivo.valuesAsString().contains(colectivo));
		
		this.colectivo = Colectivo.valueOf(colectivo);
	}

}
