package biblioteca;

import java.util.ArrayList;

public class GestionMaterias {

	// Menu para la gestion de materias
	public static void mostrarMenuMaterias(ArrayList<Materia> materias, ArrayList<Libro> libros) {
		String seleccion = "0";
		do {
			System.out.println("\n[1] Alta de Materia");
			System.out.println("\n[2] Baja de Materia");
			System.out.println("\n[3] Salir");

			seleccion = Validacion.leerOpcion();

			switch (seleccion) {
			case "1":
				altaMaterias(materias);
				break;
			case "2":
				bajaMaterias(materias, libros);
				break;
			case "3":
				salirMenuMaterias();
				break;

			default:
				System.out.println("\nSeleccion invalida");
			}

		} while (!seleccion.equals("3"));
	}

	// Lee los datos de la materia y comprueba si ya esta en el sistema, si lo esta
	// muestra error y envia de vuelta al menu 1.3, en el caso de que no estuviese
	// ya registrada la registra tomando las confirmaciones requeridas
	public static void altaMaterias(ArrayList<Materia> materias) {
		Materia materia = new Materia();
		boolean continuar = false;

		materia.leerDatos();

		if (!materias.contains(materia)) {

			System.out.println(materia.mostrarMateria());

			continuar = Validacion.validarRespuesta();

			if (continuar) {
				System.out.println("\nMateria aniadida");

				materias.add(materia);

				Validacion.solicitarIntro();
			} else {
				System.out.println("\nHa vuelto al menu de materias");

				Validacion.solicitarIntro();
			}
		} else {
			System.out.println("\nLa materia ya se encuentra en el sistema");
			Validacion.solicitarIntro();
		}

	}

	// Se muestran todas las materias por pantalla, permite seleccionar la materia a
	// eliminar entre las que se muestras, realiza las confirmaciones necesarias y
	// suprime la referencia a la materia en los libros cuyas materias sean
	// eliminadas
	public static void bajaMaterias(ArrayList<Materia> materias, ArrayList<Libro> libros) {
		int m;
		String materia;
		boolean existe = false, continuar = false;

		if (materias.size() != 0) {
			for (int i = 0; i < materias.size(); i++) {
				System.out.println(materias.get(i).mostrarMateria() + (i + 1));
			}

			System.out.println("\nSeleccione la materia a eliminar mediante su codigo");

			do {

				m = Validacion.leerNum();

			} while ((m < materias.size() - 1) && (m > 0));

			m--;

			System.out.println(materias.get(m).mostrarMateria());

			materia = materias.get(m).getNombre();

			for (int i = 0; i < libros.size() && !existe; i++) {
				if (libros.get(i).getMateria().equalsIgnoreCase(materia)) {
					existe = true;
					System.out.println("\nHay libros que pertenecen a esta materia");

					continuar = Validacion.validarRespuesta();

					if (continuar) {
						materias.remove(m);
						existe = true;
					}
				}
			}

			if (continuar) {
				for (int i = 0; i < libros.size(); i++) {
					if (libros.get(i).getMateria().equalsIgnoreCase(materia)) {
						libros.get(i).setMateria(null);
					}
				}
			}

			if (!existe) {
				if (Validacion.validarRespuesta()) {
					materias.remove(m);

				} else {
					Validacion.solicitarIntro();
				}
			}
		} else {
			System.out.println("\nNo hay materias registradas");
		}

	}

	public static void mostrarMaterias(ArrayList<Materia> materias) {
		for (Materia m : materias) {
			System.out.println(m.mostrarMateria());
		}
	}

	// Funcion que anuncia la salida del menu de gestion de materias
	public static void salirMenuMaterias() {
		System.out.println("\nHa abandonado el menu de gestion de materias");

		Validacion.solicitarIntro();
	}

}
