package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Profesor extends Empleado
{
	private String titulacion;
	private int publicaciones;
	private final int SUELDOBASE = 1800;
	
	public Profesor(String nombre, int antiguedad, String dni, String titulacion, int publicaciones )
	{
		super(nombre, antiguedad, dni);
		this.titulacion = titulacion;
		this.publicaciones = publicaciones;
	}
	
	public Profesor ()
	{
		this (" ", 0, "1", " ", 0);
	}

	public String getTitulacion() 
	{
		return titulacion;
	}

	public void setTitulacion(String titulacion)
	{
		this.titulacion = titulacion;
	}

	public int getPublicaciones() 
	{
		return publicaciones;
	}

	public void setPublicaciones(int publicaciones) 
	{
		if (publicaciones < 0)
		{
			publicaciones = 0;
		}
		this.publicaciones = publicaciones;
	}
	
	public void leerDatos()
	{
		super.leerDatos();
		titulacion = Teclado.leerString("\nTitulación");
		publicaciones = Teclado.leerInt("\nPublicaciones");
	}
	
	public int calcularSueldo()
	{
		int sueldo = this.SUELDOBASE;
		int aux = super.getAntiguedad();
		int trienio = 0;
		int bonus = 100;
		
		if (publicaciones > 0)
		{
			sueldo = (sueldo + bonus * this.publicaciones);
		}
		
		do
		{
			if (aux % 3 == 0)
			{
				aux = (aux - 3);
				trienio++;
			}
			
		} while (aux > 3);
		
		bonus = bonus + (150 * trienio);
		
		
		return sueldo;
	}
}
