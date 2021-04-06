package biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionLibros {

	// Menu para la gestion de libros
	public static void mostrarMenuLibros(ArrayList<Libro> libros, ArrayList<Materia> materias, ArrayList<Libro> bajas) {
		String seleccion = "0";
		do {
			System.out.println("\n[1] Alta de libro");
			System.out.println("\n[2] Baja de libro");
			System.out.println("\n[3] Anular baja de libro");
			System.out.println("\n[4] Actualizar libro");
			System.out.println("\n[5] Listar libros");
			System.out.println("\n[6] Compactar registro de libros");
			System.out.println("\n[7] Actualizar lista de materias");
			System.out.println("\n[8] Salir");

			seleccion = Validacion.leerOpcion();

			switch (seleccion) {
			case "1":
				altaLibro(libros, materias);
				break;
			case "2":
				bajaLibro(libros, bajas);
				break;
			case "3":
				anularBajaLibro(libros, bajas);
				break;
			case "4":
				actualizarLibro(libros, materias);
				break;
			case "5":
				listarLibros(libros);
				break;
			case "6":
				compactarRegistro(libros, bajas);
				break;
			case "7":
				GestionMaterias.mostrarMenuMaterias(materias, libros);
				break;
			case "8":
				salirMenuLibros();
				break;
			default:
				System.out.println("\nSeleccion invalida");
			}

		} while (!seleccion.equals("8"));
	}

	// Funcion que permite introducir los datos de un libro en el sistema,
	// comprobara si el libro existe ya en el sistema y pedira una confirmacion
	public static void altaLibro(ArrayList<Libro> libros, ArrayList<Materia> materias) {
		Libro l = new Libro();
		boolean continuar;
		continuar = l.leerDatos(materias);

		// Comprobacion de si el libro ya esta en el sistema
		if (!libros.contains(l) && (continuar)) {
			// Impresion del libro
			System.out.println(l.mostrarDatos());
			System.out.println("\nEl libro se aniadira al sistema");

			// Solicitacion de la validacion
			if (Validacion.validarRespuesta()) {

				System.out.println("\nEl libro se ha aniadido al sistema");

				libros.add(l);

				Validacion.solicitarIntro();
			}
		} else {
			System.out.println("\nEl libro no ha sido registrado");
		}
	}

	// Funcion que marcara el libro seleccionado de entre los que se encuentran en
	// el sistema como de baja, reduciendo su cantidad en uno
	public static void bajaLibro(ArrayList<Libro> libros, ArrayList<Libro> bajas) {
		int libro = 0, cant, cant2;
		Libro aux;

		if (libros.size() != 0) {
			mostrarTodosLibros(libros);

			// Para evitar error por introducir un numero que exceda o no llegue al tamanio
			// del arralist
			do {

				libro = Validacion.leerInt("\nSeleccione el libro a dar de baja mediante su codigo");

				libro--;

			} while ((libro < libros.size() - 1) && (libro > 0));

			if (Validacion.validarRespuesta()) {
				System.out.println("\nEl libro se marcara como baja en el sistema");

				aux = libros.get(libro);

				if (bajas.contains(aux)) {

					cant = aux.getCantEjemplares();

					aux.setCantEjemplares(cant++);

				} else {
					aux.setCantEjemplares(1);
				}

				bajas.add(aux);

				cant2 = libros.get(libro).getCantEjemplares();
				cant2--;

				libros.get(libro).setCantEjemplares(cant2);
			}
		} else {
			System.out.println("\nNo existe ningun libro en el registro");
		}

	}

	// Funcion que nos permitira anular la baja en un libro, aumentando en uno su
	// cantidad
	public static void anularBajaLibro(ArrayList<Libro> libros, ArrayList<Libro> bajas) {
		int libro, n;

		for (Libro l : bajas) {
			System.out.println(l.mostrarDatos());
			System.out.println(bajas.indexOf(l));
		}

		if (bajas.size() != 0) {
			System.out.println("\nEscoja el libro al cual anular la baja");

			do {

				libro = Validacion.leerNum();

				libro--;

			} while ((libro < libros.size() - 1) && (libro > 0));

			if (Validacion.validarRespuesta()) {
				System.out.println("\nLa baja del libro se anulara en el sistema");

				bajas.get(libro).setCantEjemplares(bajas.get(libro).getCantEjemplares() - 1);

				libros.get(libro).setCantEjemplares(libros.get(libro).getCantEjemplares() + 1);
			}
		}
	}

	public static void actualizarLibro(ArrayList<Libro> libros, ArrayList<Materia> materias) {
		int libro;

		// Mostrar todos los libros en el sistema
		mostrarTodosLibros(libros);

		if (libros.size() != 0) {
			// Seleccion del libro a actualizar
			libro = Validacion.leerInt("\nSeleccione el libro a actualizar");

			libro--;
			// Comprobacion de la existencia o estado de baja del libro, en cuyo caso se
			// muestra un aviso
			if (!((libros.get(libro) == null) || (libros.get(libro).getCantEjemplares() == 0))) {
				libros.get(libro).leerDatos(materias);

				libros.get(libro).mostrarDatos();

				Validacion.validarRespuesta();

			} else {
				System.out.println(
						"\nEl libro no se encuentra en el sistema o no se encuentran ejemplares sin dar de baja");

				Validacion.solicitarIntro();
			}
		} else {
			System.out.println("\nNo hay libros registrados");
		}

	}

	public static void listarLibros(ArrayList<Libro> libros) {
		// Muestro todos los libros registrados si existe alguno, si no existiesen
		// muestro aviso por pantalla, solicito intro y envio de vuelta a menu 1.2
		if (libros.isEmpty()) {

			System.out.println("\nNo hay libros registrados");

			Validacion.solicitarIntro();

		} else {

			for (int i = 0; i < libros.size(); i++) {
				libros.get(i).mostrarDatos();

				System.out.println("\nFin de la lista de libros");

				Validacion.solicitarIntro();
			}
		}
	}

	public static void compactarRegistro(ArrayList<Libro> libros, ArrayList<Libro> bajas) {
		// Antes de comenzar comprueba si hay libros marcados como baja y en el caso de
		// que haya los elimina
		if (!bajas.isEmpty()) {

			for (Libro l : bajas) {

				bajas.remove(l);
			}

		} else {

			System.out.println("\nNo hay libros marcados como baja");

			Validacion.solicitarIntro();

		}
	}

	public static void salirMenuLibros() {

		System.out.println("\nHa abandonado el menu de gestion de libros");

		Validacion.solicitarIntro();
	}

	// Funcion que muestra todos los libros junnto a su codigo
	public static void mostrarTodosLibros(ArrayList<Libro> libros) {
		for (Libro l : libros) {
			System.out.println(l.mostrarDatos());
			System.out.println((libros.indexOf(l) + 1));
		}
	}
	
	public static void mostrarTodosLibrosDisponibles(ArrayList<Libro> libros) {
		for (Libro l : libros) {
			if (l.getCantEjemplares() != 0) {
				System.out.println(l.mostrarDatos());
				System.out.println(libros.indexOf(l) + 1);
			}
		}
	}
	
	public static boolean comprobarDisponibilidad(ArrayList<Libro> libros, int libro) {
		
		if (libros.get(libro).getCantEjemplares() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
