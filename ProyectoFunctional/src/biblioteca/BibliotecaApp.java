package biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

	public static void main(String[] args) {

		// Creo el ArrayList que van a contener los libros, las materias, los lectores y
		// los libros en baja
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<Materia> materias = new ArrayList<Materia>();
		ArrayList<Lector> lectores = new ArrayList<Lector>();
		ArrayList<Libro> bajas = new ArrayList<Libro>();
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		// Muestro un mensaje de incio sencillo de inicio del programa
		InterfazUsuario.mostrarInicio();

		// Muestro el menu principal con las opciones para acceder a los submenus o
		// abandonar el programa
		InterfazUsuario.mostrarMenu(libros, materias, lectores, bajas, prestamos);

	}

}
