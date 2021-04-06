package Objetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppAlumno {

	public static void main(String[] args) {
		Alumno a1, a2;

		a1 = new Alumno();
		a2 = new Alumno("Miguel", 15, 11);

		a1.leerDatos();

		a1.mostrarDatos();
		a2.mostrarDatos();

		if (a1.estaAprobado())
			Pantalla.escribirString("\n" + a1.getNombre() + " está aprobado");
		else
			Pantalla.escribirString("\n" + a1.getNombre() + "No está aprobado");

		a1.mostrarDatos();
		a1.setNota(a1.getNota() + 1);
		a1.mostrarDatos();
	}
}