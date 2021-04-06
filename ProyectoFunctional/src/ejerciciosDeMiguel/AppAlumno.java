import daw.com.Pantalla;
import daw.com.Teclado;

public class AppAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a1,a2;
		
		
		a1 = new Alumno (); // Construir el objeto
		a2 = new Alumno ("Miguel", 15, 11);
		
		
		a1.leerDatos();
		
		
		a1.mostrarDatos();
		a2.mostrarDatos();
		
		if (a1.estaAprobado())
			Pantalla.escribirString("\n" +a1.getNombre() + " está aprobado" );
		else
			Pantalla.escribirString("\n" +a1.getNombre() + "NO está aprobado" );
		
		// Subir un punto al alumno a2
		a1.mostrarDatos();
		a1.setNota(a1.getNota()+1);
		a1.mostrarDatos();
		
	}

}
