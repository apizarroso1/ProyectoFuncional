package ejerciciosDeMiguel;
import daw.com.Pantalla;
import daw.com.Teclado;

public class AlumnoDAM2ConAsignaturas {
	// constantes de la clase
	private static final int NNOTAS = 5;
	//Estado de la clase
	private String nombre;
	private int edad;
	private Asignatura[] asignaturas;
	
	
	public AlumnoDAM2ConAsignaturas(String nombre, int edad, Asignatura[] asignaturas) 
	{
		this.nombre = nombre;
		setEdad (edad);
						
		this.asignaturas = new Asignatura [asignaturas.length];
		
		for (int i = 0; i < asignaturas.length; i++)
			this.asignaturas[i]=new Asignatura(asignaturas[i]);

		

	}
	
	public AlumnoDAM2ConAsignaturas (String nombre, int edad)
	{
		this (nombre,edad,NNOTAS);
	}
	
	public AlumnoDAM2ConAsignaturas (String nombre, int edad, int cuantas)
	{
		this.nombre = nombre;
		setEdad (edad);
		
		this.asignaturas = new Asignatura[cuantas];
		
		for (int i = 0; i < this.asignaturas.length; i++)
			asignaturas[i] = new Asignatura ();
		
		
	}
	
	public AlumnoDAM2ConAsignaturas ()
	{
		this("indefinido", 18,NNOTAS);
		
	}
	
	public AlumnoDAM2ConAsignaturas (int cuantas)
	{
		this("indefinido", 18,cuantas);
		
	}
	
	public AlumnoDAM2ConAsignaturas (AlumnoDAM2ConAsignaturas original)
	{
		
		this (original.nombre, original.edad, original.asignaturas);
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre (String nuevoNombre)
	{
		nombre = nuevoNombre;
	}
	
	public int getEdad ()
	{
		return edad;
	}
	
	public void setEdad (int nuevaEdad)
	{
		if (nuevaEdad < 18)
			nuevaEdad = 18;
		else if (nuevaEdad > 120)
			nuevaEdad = 120;
		
		edad = nuevaEdad;
	}
	
	
	
	public void setAsignatura (int cual, Asignatura valor)
	{
		if (cual < 0)
			cual = 0;
		else if (cual >= asignaturas.length)
			cual = asignaturas.length - 1;
		
		this.asignaturas[cual] = new Asignatura(valor);
	}
	
	public Asignatura getAsignatura (int cual)
	{
		if (cual < 0)
			cual = 0;
		else if (cual >= asignaturas.length)
			cual = asignaturas.length - 1;

		return new Asignatura(asignaturas[cual]);
	}
	
	public int getCuantasAsignaturas ()
	{
		return asignaturas.length;
	}
	
	public void leerDatos ()
	{
		leerDatosNombre();
		leerOtrosDatos();
	}
	
	public void leerDatosNombre ()
	{
		nombre = Teclado.leerString("nombre ");
	}
	
	public void leerOtrosDatos ()
	{
		setEdad (Teclado.leerInt("edad "));
 
		
		for (int i = 0; i < asignaturas.length; i++)
			asignaturas[i].leerDatos();
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\nNombre " + nombre);
		Pantalla.escribirString("\nEdad " + edad);
		
		for (int i = 0; i < asignaturas.length; i++)
			asignaturas[i].mostrarDatos();
	}

	public boolean estaAprobado()
	{
		boolean aprobado = true;
		
		for (int i = 0; i < asignaturas.length && aprobado; i++)
			if (!asignaturas[i].estaAprobada())
				aprobado = false;
	
		return aprobado;
	}
	
	public float getMedia ()
	{
		float media = 0;

		for (int i = 0; i < asignaturas.length; i++)
			media += asignaturas[i].getNota();

		media /= asignaturas.length;
		
		return media;
	}
}
