package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Auxiliar extends Empleado
{
	private boolean ingles;
	private final int SUELDOBASE = 1100;
	
	public Auxiliar (String nombre, int antiguedad, String dni, boolean ingles)
	{
		super(nombre, antiguedad, dni);
		this.ingles = false;
	}
	
	public Auxiliar ()
	{
		this(" ", 0, "1", false);
	}

	public boolean isIngles() 
	{
		return ingles;
	}

	public void setIngles(boolean ingles) 
	{
		this.ingles = ingles;
	}
	
	public void leerDatos()
	{
		super.leerDatos();
		if (Teclado.leerString("\nInglés (s/n)").contentEquals("s"))
		{
			ingles = true;
		}
	}
	
	public int calcularSueldo()
	{
		int sueldo = this.SUELDOBASE;
		int bonus = 0;
		int aux = super.getAntiguedad();
		int trienio = 0;
		
		if (this.ingles)
		{
			bonus = 400;
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
		
		sueldo = sueldo + bonus;
		
		return sueldo;
	}
	
}
