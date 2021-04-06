package biblioteca;

import java.util.ArrayList;

public class GestionLectores {
	public static void mostrarMenuLectores(ArrayList<Lector> lectores) {
		String seleccion = "0";
		do {
			System.out.println("\n[1] Alta de Lector");
			System.out.println("\n[2] Baja de Lector");
			System.out.println("\n[3] Anular baja de Lector");
			System.out.println("\n[4] Actualizar Lector");
			System.out.println("\n[5] Listar Lectores");
			System.out.println("\n[6] Compactar registro de Lectores");
			System.out.println("\n[7] Buscar Lector");
			System.out.println("\n[8] Salir");

			seleccion = Validacion.leerOpcion();

			switch (seleccion) {
			case "1":
				altaLectores(lectores);
				break;
			case "2":
				bajaLectores(lectores);
				break;
			case "3":
				anularBajaLectores(lectores);
				break;
			case "4":
				actualizarLector(lectores);
				break;
			case "5":
				listarLectores(lectores);
				break;
			case "6":
				compactarLectores(lectores);
				break;
			case "7":
				buscarLector(lectores);
				break;
			case "8":
				salirMenuLectores();
				break;
			default:
				System.out.println("\nSeleccion invalida");
			}

		} while (!seleccion.equals("8"));
	}

	// Funcion que permite dar de alta un lector, leyendo sus datos y comprobando si
	// se encuentra ya en el sistema
	public static void altaLectores(ArrayList<Lector> lectores) {
		Lector l = new Lector();
		boolean continuar = false;

		l.leerDatos();

		if (!lectores.contains(l)) {

			l.mostrarDatos();

			System.out.println("\nEl lector se aniadira al sistema");

			continuar = Validacion.validarRespuesta();

			if (continuar) {
				System.out.println("\nEl lector se ha aniadido al sistema");

				lectores.add(l);
			}
		} else {
			System.out.println("\nEl lector ya se encuentra en la base de datos");

			Validacion.solicitarIntro();
		}
	}

	// Funcion que mediante su codigo, lee un lector y lo marca como baja
	public static void bajaLectores(ArrayList<Lector> lectores) {
		int lector = 0;
		boolean continuar = false;

		mostrarTodosLectores(lectores);

		if (lectores.size() != 0) {
			lector = Validacion.leerInt("\nSeleccione el lector a dar de baja mediante su codigo");

			lector--;

			continuar = Validacion.validarRespuesta();

			if (continuar) {
				if (lectores.contains(lectores.get(lector)) || lectores.get(lector).isBaja()) {

					System.out.println("\nEl lector se ha marcado como baja");
					lectores.get(lector).setBaja(true);

					Validacion.solicitarIntro();
				} else {
					System.out
							.println("\nEl lector no se encuentra en la base de datos o ya se encuentra dado de baja");
				}
			} else {
				System.out.println("\nVolviendo al menu de gestion de lectores");
			}
		} else {
			System.out.println("\nNo hay lectores registrados");
		}
	}

	// Funcion que permite leer un lector mediante su codigo y si esta marcado de
	// baja, anula la marca
	public static void anularBajaLectores(ArrayList<Lector> lectores) {
		int lector = 0;
		boolean continuar = false;

		for (Lector l : lectores) {
			if (l.isBaja()) {
				l.mostrarDatos();
				System.out.println((lectores.indexOf(l) + 1));
			}
		}

		if (lectores.size() != 0) {
			lector = Validacion.leerInt("\nSeleccione el lector al que anular la baja mediante su codigo");

			lector--;

			if (lectores.get(lector).isBaja()) {

				lectores.get(lector).mostrarDatos();

				continuar = Validacion.validarRespuesta();

				if (continuar) {
					lectores.get(lector).setBaja(false);

					System.out.println("\nLa marca de baja se ha suprimido en el lector");

					System.out.println("\nVolviendo al menu de gestion de lectores");

					Validacion.solicitarIntro();
				} else {

					System.out.println("\nVolviendo al menu de gestion de lectores");

					Validacion.solicitarIntro();
				}
			} else {

				System.out.println("\nEl lector no esta de baja");

				System.out.println("\nVolviendo al menu de gestion de lectores");

				Validacion.solicitarIntro();
			}
		} else {
			System.out.println("\nNo hay lectores registrados");
		}

	}

	// Funcion que lee un lector mediante su codigo y permite actualizar sus datos
	public static void actualizarLector(ArrayList<Lector> lectores) {
		int lector = 0;
		boolean continuar = false;

		mostrarTodosLectores(lectores);

		if (lectores.size() != 0) {
			lector = Validacion
					.leerInt("\nSeleccione el lector cuya informacion esta para actualizar mediante su codigo");
			lector--;

			if (lector >= 0 || lector <= lectores.size()) {
				lectores.get(lector).mostrarDatos();

				continuar = Validacion.validarRespuesta();

				if (continuar) {
					lectores.get(lector).leerDatos();

					System.out.println("\nDatos de lector actualizados");

					System.out.println("\nVolviendo al menu de gestion de lectores");

				} else {

					System.out.println("\nVolviendo al menu de gestion de lectores");

					Validacion.solicitarIntro();
				}
			} else {
				System.out.println("\nEl lector no se encuentra en el sistema");

				System.out.println("\nVolviendo al menu de gestion de lectores");

				Validacion.solicitarIntro();
			}
		} else {
			System.out.println("\nNo hay lectores registrados");
		}

	}

	// Funcion que lista todos los lectores, marcados de baja o no
	public static void listarLectores(ArrayList<Lector> lectores) {

		if (lectores.size() != 0) {
			mostrarTodosLectores(lectores);

			System.out.println("\nFin del listado de lectores");
			Validacion.solicitarIntro();
		} else {
			System.out.println("\nNo hay lectores registrados");
		}

	}

	// Funcion que elimina todos los lectores marcados como baja del sistema
	public static void compactarLectores(ArrayList<Lector> lectores) {

		if (lectores.size() != 0) {
			for (Lector l : lectores) {

				if (l.isBaja()) {
					lectores.remove(l);
				}
			}

			System.out.println("\nFin de la compactacion del sistema de lectores");
		} else {
			System.out.println("\nNo hay lectores marcados como baja");
		}

	}

	// Funcion que permite buscar un lector mediante su nombre o apellido, mostrando
	// todos sus datos
	public static void buscarLector(ArrayList<Lector> lectores) {
		String nombre = " ";
		String apellidos = " ";

		if (lectores.size() != 0) {
			nombre = Validacion.leerString("\nIntroduzca el nombre a buscar");
			apellidos = Validacion.leerString("\nIntroduzca los apellidos a buscar");

			for (Lector l : lectores) {
				if (l.getNombre().equalsIgnoreCase(nombre) || l.getApellidos().equalsIgnoreCase(apellidos)) {
					l.mostrarDatos();
				}
			}
		} else {
			System.out.println("\nNo hay lectores registrados");
		}

	}

	// Funcion que anuncia la salida del menu de gestion de lectores
	public static void salirMenuLectores() {
		System.out.println("\nHa abandonado el menu de gestion de lectores");
	}

	// Funcion que muestra todos los lectores
	public static void mostrarTodosLectores(ArrayList<Lector> lectores) {
		for (Lector l : lectores) {

			l.mostrarDatos();
			System.out.println((lectores.indexOf(l) + 1));
		}
	}

	// Funcion que muestra todos los lectores que no tengan la marca de baja
	public static void mostrarTodosLectoresSinbaja(ArrayList<Lector> lectores) {
		for (Lector l : lectores) {
			if (!l.isBaja()) {
				l.mostrarDatos();
				System.out.println(lectores.indexOf(l) + 1);
			}
		}
	}
}
