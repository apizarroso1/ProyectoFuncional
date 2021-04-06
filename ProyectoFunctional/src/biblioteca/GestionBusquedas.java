package biblioteca;

import java.util.ArrayList;

public class GestionBusquedas {

	public static void mostrarMenuBusquedas(ArrayList<Libro> libros) {
		String seleccion = "0";
		do {
			System.out.println("\n[1] Busqueda por autor");
			System.out.println("\n[2] Busqueda por titulo");
			System.out.println("\n[3] Busqueda por materia");
			System.out.println("\n[4] Salir");

			seleccion = Validacion.leerOpcion();

			switch (seleccion) {
			case "1":
				buscarPorAutor(libros);
				break;
			case "2":
				buscarPorTitulo(libros);
				break;
			case "3":
				buscarPorMateria(libros);
				break;
			case "4":
				salirMenuBusquedas();
				break;
			default:
				System.out.println("\nSeleccion invalida");
			}

		} while (!seleccion.equals("4"));
	}

	// Funcion que leyendo un autor busca los libros registrados bajo su nombre
	public static void buscarPorAutor(ArrayList<Libro> libros) {
		String autor;

		if (libros.size() > 0) {

			autor = Validacion.leerString("\nIntroduzca el autor para buscar sus libros");

			for (Libro l : libros) {
				if (l.getAutor().equalsIgnoreCase(autor)) {
					System.out.println(l.mostrarDatos());
				}
			}

			System.out.println("\nFin del listado de libros");

		} else {
			System.out.println("\nNo hay libros registrados");
		}

		Validacion.solicitarIntro();
	}

	// Funcion que leyendo un titulo busca libros
	public static void buscarPorTitulo(ArrayList<Libro> libros) {
		String titulo;

		if (libros.size() > 0) {

			titulo = Validacion.leerString("\nIntroduzca el titulo para buscar libros");

			for (Libro l : libros) {
				if (l.getTitulo().equalsIgnoreCase(titulo)) {
					System.out.println(l.mostrarDatos());
				}
			}

			System.out.println("\nFin del listado de libros");

		} else {
			System.out.println("\nNo hay libros registrados");
		}

		Validacion.solicitarIntro();
	}

	// Funcion que leyendo una materia busca los libros registrados bajo la misma
	public static void buscarPorMateria(ArrayList<Libro> libros) {
		String materia;

		if (libros.size() > 0) {

			materia = Validacion.leerString("\nIntroduzca la materia para buscar las obras que pertenezcan");

			for (Libro l : libros) {
				if (l.getMateria().equalsIgnoreCase(materia)) {
					System.out.println(l.mostrarDatos());
				}
			}

			System.out.println("\nFin del listado de libros");

		} else {
			System.out.println("\nNo hay libros registrados");
		}

		Validacion.solicitarIntro();
	}

	// Funcion que anuncia la salida del menu de busquedas
	public static void salirMenuBusquedas() {
		System.out.println("\nHa abandonado el menu de busquedas");
	}
}
