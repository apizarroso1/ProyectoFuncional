

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Persona  {

	private String nombre;
	private int edad;
	private LocalDate fecha;
	private EstadoCivil estadoCivil; // soltero, casado, divorciado, viudo
	
	public Persona ()
	{
		this ("", 0, LocalDate.now(), EstadoCivil.SOLTERO);
	}
	
	
	public Persona(String nombre, int edad, LocalDate fecha, EstadoCivil estadoCivil) {
	
		this.nombre = nombre;
		this.edad = edad;
		this.fecha = fecha;
		this.estadoCivil = estadoCivil;
	
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	@Override
	public String toString() {
		
		return "Persona [nombre=" + nombre + 
					", edad=" + edad + 
					", fecha=" + fecha + 
					", estadoCivil=" + estadoCivil.toString() + 
					"]";
	}
	
	public void leerDatos ()
	{
		nombre = Teclado.leerString("\nnombre");
		edad = Teclado.leerInt("edad");
		fecha = LocalDate.parse(Teclado.leerString("aaaa-mm-dd"));
		estadoCivil = leerEstadoCivil ();
	}
	
	public EstadoCivil leerEstadoCivil ()
	{
		String estado;
		ArrayList <String> estados = new ArrayList<> ();
		
		
		estados = EstadoCivil.getValuesAsStringArrayList();
		
		do
		{
			Pantalla.escribirString("\nElija un estado");
			Pantalla.escribirString("\n" + estados);
			estado = Teclado.leerString("\nestado").toUpperCase();
		}while (!estados.contains(estado));

		
		
		return EstadoCivil.valueOf(estado); // Convertir String a enum
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
