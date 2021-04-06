package herenciaYPolimorfismo;

import daw.com.Teclado;

public abstract class Empleado 
{
	private String nombre;
	private int antiguedad;
	private static String dni;
	
	public Empleado()
	{
		this (" ", 0, "1");
	}
	
	public Empleado(String nombre, int antiguedad, String dni) 
	{
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.dni = "1";
	}
	
	public Empleado (String nombre, int antiguedad)
	{
		this (nombre, antiguedad, leerDni());
	}

	public static String leerDni() 
	{
		do {
			String dni = Teclado.leerString("\nDni");
		} while (dni.equals(" "));
		
		return dni;
	}

	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public int getAntiguedad() 
	{
		return antiguedad;
	}
	
	public void setAntiguedad(int antiguedad) 
	{
		if (antiguedad < 0)
		{
			antiguedad = 0;
		}
		this.antiguedad = antiguedad;
	}
	
	public String getDni() 
	{
		return dni;
	}
	
	public void setDni(String dni) 
	{
		this.dni = dni;
	}
	
	public void leerDatos()
	{
		nombre = Teclado.leerString("\nNombre");
		dni = leerDni();
		antiguedad = Teclado.leerInt("\nAntiguedad");
	}
	
	abstract public int calcularSueldo();
	
	@Override
	public boolean equals(Object obj) 
	{
		Empleado other = (Empleado) obj;
		return this.dni.equals(other.dni);
	}
}
