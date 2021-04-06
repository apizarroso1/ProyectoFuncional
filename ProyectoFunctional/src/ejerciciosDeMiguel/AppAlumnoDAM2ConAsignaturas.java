package ejerciciosDeMiguel;
import daw.com.Teclado;

public class AppAlumnoDAM2ConAsignaturas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlumnoDAM2ConAsignaturas a[];
		int n = Libreria.leerPositivo("cuantos?");
		int cuantasNotas;
		
		a = new AlumnoDAM2ConAsignaturas[n];
				
		// leer los datos de los alumnos
		leerAlumnos (a);
		
		// mostrar alumnos
		for (AlumnoDAM2ConAsignaturas al: a )
			al.mostrarDatos();
	}

	public static void leerAlumnos(AlumnoDAM2ConAsignaturas[] a) {
		// TODO Auto-generated method stub
		String nombre;
		int edad;
		int cuantas;
		
		for (int i = 0; i < a.length;i++)
		{
			do
			{
				nombre = Teclado.leerString("nombre?");
			}while (buscarAlumno (nombre,a)>= 0);
			
			edad = Libreria.leerEntre(18, 100, "edad?");
			
			cuantas = Libreria.leerEntre(1, 6, "cuántas notas?");
			
			a[i] = new AlumnoDAM2ConAsignaturas(nombre,edad,cuantas);
			leerAsignaturas (a[i]);
		}
	}

	public static void leerAsignaturas(AlumnoDAM2ConAsignaturas al) {
		// TODO Auto-generated method stub
		Asignatura asignatura = new Asignatura ();
		
		for (int i = 0; i < al.getCuantasAsignaturas(); i++ )
		{
			do
			{
				asignatura.leerNombre();
			}while (buscarAsignatura (asignatura.getNombre(),al));
			
			asignatura.leerNota();
			
			al.setAsignatura(i, asignatura);
		}
		
	}

	public static boolean buscarAsignatura(String nombre, AlumnoDAM2ConAsignaturas al) {
		// TODO Auto-generated method stub
		boolean esta = false;
		
		for (int i = 0; i < al.getCuantasAsignaturas() && !esta; i++)
			if (al.getAsignatura(i).getNombre().equals(nombre))
				esta = true;
		
		return esta;
	}

	public static int buscarAlumno(String nombre, AlumnoDAM2ConAsignaturas[] a) {
		// TODO Auto-generated method stub
		int lugar = -1;
		
		for (int i = 0; i < a.length && lugar == -1; i++)
			if (a[i]!= null)
				if (nombre.equals(a[i].getNombre()))
					lugar = i;
		
		return lugar;
	}
	
	

}
