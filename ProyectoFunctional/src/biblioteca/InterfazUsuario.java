package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfazUsuario {

	public static void mostrarInicio() {
		System.out.println("--------------------------------");
		System.out.println("\nINICIO DEL PROGRAMA BIBLIOTECA");
		System.out.println("\n--------------------------------");
	}

	public static void mostrarFin() {
		System.out.println("\n--------------------------------");
		System.out.println("\nFIN DEL PROGRAMA BIBLIOTECA");
		System.out.println("\n--------------------------------");
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void mostrarMenu(ArrayList<Libro> libros, ArrayList<Materia> materias, ArrayList<Lector> lectores,
			ArrayList<Libro> bajas, ArrayList<Prestamo> prestamos) {
		String seleccion = "0";
		do {
			// Menu principal, he incorporado el uso de la opcion como String para evitar el
			// error por tipos dispares de valores
			System.out.println("\n[1] Gestion de libros");
			System.out.println("\n[2] Gestion de lectores");
			System.out.println("\n[3] Gestion de prestamos");
			System.out.println("\n[4] Busquedas");
			System.out.println("\n[5] Salir");

			seleccion = Validacion.leerOpcion();

			switch (seleccion) {
			case "1":
				GestionLibros.mostrarMenuLibros(libros, materias, bajas); // Funcion que abrira el menu de gestion de
																			// libros
				break;
			case "2":
				GestionLectores.mostrarMenuLectores(lectores);// Funcion que abrira el menu de gestion de lectores
				break;
			case "3":
				GestionPrestamos.mostrarMenuPrestamos(libros, lectores, prestamos);// Funcion que abrira el menu de
				// gestion de prestamos
				break;
			case "4":
				GestionBusquedas.mostrarMenuBusquedas(libros);// Funcion que abrira el menu de
				// busquedas
				break;
			case "5":
				mostrarFin();// Funcion que mostrara el fin del programa y cerrara el objeto Scanner
				break;
			default:
				System.out.println("\nSeleccion invalida");
			}

		} while (!seleccion.equals("5"));

	}

}
