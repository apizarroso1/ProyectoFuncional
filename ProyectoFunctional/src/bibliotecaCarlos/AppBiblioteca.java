import java.util.Scanner;

public class AppBiblioteca {

	public static void main(String[] args) {
		

		//Creamos el objeto libreria
		
		Libreria libreria = new Libreria ();
		
		//Declarmos una nueva variable para leer 
		int opcion;
		
		System.out.println();
		System.out.println("Biblioteca");
		System.out.println();
		System.out.println
		("\n (Mensaje infromativo: para seleccionar las materias de los libros antes hay que añadirlas."
		+ "\n Getion de libros - Actualizar lista de materias.)");
		System.out.println();
		
		//Leemos la opcion en un determinado rango.
		do {
			mostrarMenu ();
			opcion = Libreria.leerEntre(1, 5, "\n Opciones a elegir");
			evaluarOpc (opcion, libreria);
			
			
		} while (opcion != 5); 
	
	}
	

	//Menu principal
	//LOS /N NO SON OBLIGATORIOS PORQUE CON EL SYSTEM.OUT.PRINTLN SE HACEN LOS SALTOS LÍNEA
	private static void mostrarMenu() {
		// TODO Auto-generated method stub
		
		System.out.println("\n 1.Gestión de libros");
		System.out.println("\n 2.Gestión de lectores");
		System.out.println("\n 3.Gestion de prestamos");
		System.out.println("\n 4.Busquedas");
		System.out.println("\n 5.Salir de la aplicacion");
	}
	
	//Menu materias 
	private static void mostrarMenuMaterias() {
		// TODO Auto-generated method stub
		System.out.println("\n 1.Alta materia");
		System.out.println("\n 2.Baja materia");
		System.out.println("\n 3.Salir");
	}

	//Menu Libros 
	private static void mostrarMenuLibros() {
		// TODO Auto-generated method stub

		System.out.println("\n 1.Alta libros");
		System.out.println("\n 2.Baja libros");
		System.out.println("\n 3.Anular baja de libro");
		System.out.println("\n 4.Actualizar libro");
		System.out.println("\n 5.Listar libros");
		System.out.println("\n 6.Compactar registro de libros");
		System.out.println("\n 7.Actualizar lista de materias");
		System.out.println("\n 8.Salir");
												}
	
	
	//Menú Lector
	private static void mostrarMenuLectores() {
	// TODO Auto-generated method stub
		System.out.println("\n 1.Alta lectores");
		System.out.println("\n 2.Baja lectores");
		System.out.println("\n 3.Anular baja de lectores");
		System.out.println("\n 4.Actualizar lectores");
		System.out.println("\n 5.Listar lectores");
		System.out.println("\n 6.Compactar registro de lectores");
		System.out.println("\n 7.Buscar lector");
		System.out.println("\n 8.Salir");
												}
	//Menú préstamo
	private static void mostrarMenuPrestamos() {
	// TODO Auto-generated method stub
		System.out.println("\n 1.Anotar prestamo");
		System.out.println("\n 2.Anotar devolucion");
		System.out.println("\n 3.Listar morosos");
		System.out.println("\n 4.Prestamos de lector");
		System.out.println("\n 5.Salir");
													}
	//Menu busqueda
	private static void mostrarBusqueda() {
		// TODO Auto-generated method stub
		System.out.println("\n 1.Buscar por autor");
		System.out.println("\n 2.Buscar por título");
		System.out.println("\n 3.Buscar por materia");
		System.out.println("\n 4.Salir ");
													}
	
	//Funcion para evaluar opcion del menu principal.
	private static void evaluarOpc(int opcion, Libreria libreria) {
		// TODO Auto-generated method stub
		
		switch (opcion) {
		case 1:
			int opcion2;
			do {
				System.out.println();
				mostrarMenuLibros ();
				opcion2 = Libreria.leerEntre(1, 8, "\n Introduce la opcion");
				evaluarOpcLibros (opcion2, libreria);
				
				
			} while (opcion2 != 8);
			
			break;
			
		
		case 2:
			int opcion4;
			do {
				System.out.println();
				mostrarMenuLectores ();
				opcion4 = Libreria.leerEntre(1, 8, "\n Introduce la opcion");
				evaluarOpcLectores (opcion4, libreria);
				
				
			} while (opcion4 != 8);
			
			break;
			
		case 3:
			
			int opcion5;
			do {
				System.out.println();
				mostrarMenuPrestamos();
				opcion5 = Libreria.leerEntre(1, 5, "\n Introduce la opcion");
				evaluarOpcPrestamos (opcion5, libreria);
				
			} while (opcion5 != 5);
			
			
			break;	
		
		case 4:
			int opcion6;
			do {
				System.out.println();
				mostrarBusqueda();
				opcion6 = Libreria.leerEntre(1, 4, "\n Introduce la opcion");
				evaluarOpcBusquedas (opcion6, libreria);
				
			} while (opcion6 != 4);
			
			break;

		default:
			break;
		}
		
	}
	

	//Evaluar opciones de búsquedas
	private static void evaluarOpcBusquedas (int opcion6, Libreria libreria) {
	Scanner sc = new Scanner(System.in); 
		switch (opcion6) {
		case 1:
		
		    validar("¿Deseas continuar con la busqueda del autor?");
		
			String autor = sc.next("\n Introduce autor:");
			
			libreria.buscarAutor(autor);
			
			break;
		case 2:
			validar("¿Deseas continuar con la busqueda del titulo?");
			
			String titulo = sc.next("\n Introduce titulo:");
			
			libreria.buscarTitulo(titulo);
			
			break;
			
		case 3:
			validar("¿Deseas continuar con la busqueda por materia?");
			
			String materia = sc.next("\n Introduce materia:");
			
			
			Materia materia = new Materia(materia);
			
			libreria.buscarMaterial(materia);
			
			break;
			
		default:
			break;
		}
}

	
	
	//Evaluar opciones de Préstamos
	private static void evaluarOpcPrestamos(int opcion5, Libreria libreria) {
	// TODO Auto-generated method stub
		switch (opcion5) {
		case 1:
			validar("¿Deseas continuar con la alta del prestamo?");
			crearPrestamo (libreria);
			break;
		case 2:
			validar("¿Deseas continuar con la baja del prestamo?");
			devolverPrestamo (libreria);
			break;
			
		case 3:
			validar("¿Deseas continuar con la lista de morosos?");
			libreria.listarPrestamos();
			break;
			
		case 4:
			validar("¿Deseas continuar para ver los prestamos del lector?");
			 PrestamosLector(libreria);
			break;
			
		default:
			break;
		}
}

	

	//Funcion para evaluar la opcion del menu lectores.
	private static void evaluarOpcLectores(int opcion4, Libreria libreria) {
	
		switch (opcion4) {
		case 1:
			validar("¿Deseas continuar con la alta del lector?");
			darDeAltaLector (libreria);
			break;
		case 2:
			validar("¿Deseas continuar con la baja del lector?");
			darBajaLector (libreria);
			break;
			
		case 3:
			validar("¿Deseas continuar con la anulacion de la baja del lector?");
			anularBajaLector (libreria);
			break;
			
		case 4:
			validar("¿Deseas continuar con la actualizacion del lector?");
			 actualizarLector(libreria);
			break;
			
		case 5:
			validar("¿Deseas listar los lectores?");
			libreria.listarLectores();
			break;

		case 6:
			validar("¿Deseas continuar con la compactacion del registro del lector?");
			if(libreria.compactarRegistroLector()) {
				System.out.println("\n Los lectores dados de baja ya estan eliminados");
			}
			else {
				System.out.println("\n Error al eliminar los lectores de baja");
			}
			break;
			
		case 7:
			validar("¿Deseas continuar con la búsqueda del lector?");
			String nombre = sc.NextLine("Introduce el nombre a buscar:");
			libreria.buscarLectores(nombre);
			
			
			break;
			
		default:
			break;
		}
	
}

	
	//Funcion para evaluar la opcion del menu libros.
	private static void evaluarOpcLibros(int opcion2, Libreria libreria) {
		// TODO Auto-generated method stub
		switch (opcion2) {
		case 1:
			validar("¿Deseas continuar con la alta del libro?");
			darDeAltaUnLibro(libreria);
			break;
			
		case 2:
			validar("¿Deseas continuar con la baja del libro?");
			darBajaLibro (libreria);
			break;
		case 3:
			validar("¿Deseas continuar con la anulacion de la baja del libro?");
			anularBajaLibro (libreria);
			break;
			
		case 4:
			validar("¿Deseas continuar con la actualizacion del libro?");
			actualizarLibro(libreria);
			break;
		case 5:
			validar("¿Deseas continuar con la lista de libros?");
			libreria.listarLibros();
			break;
			
		case 6:
			validar("¿Deseas continuar con la compctacion de regristos del libro?");
			if(libreria.compactarRegistro()) {
				System.out.println("\n Los libros dados de baja ya estan eliminados");
			}
			else {
				System.out.println("\n Error al eliminar los libros de baja");
			}
			break;
			
		case 7:
			int opcion3;
			do {
				
            System.out.println();
            mostrarMenuMaterias ();
				opcion3 = Libreria2.leerEntre(1, 3, "\n Introduce la opcion");
				evaluarOpcMaterias (opcion3, libreria);
				
				
			} while (opcion3 != 3);
			break;
		default:
			break;
		}
	}

	//Evaluar la opcion del menu de materias
	private static void evaluarOpcMaterias(int opcion3, Libreria libreria) {
		// TODO Auto-generated method stub
		switch (opcion3) {
		
		case 1:
			validar("¿Deseas añadir materias?");
			Materia m = new Materia ();
			m.leerDatos();
			if(libreria.altaMateria(m))
				System.out.println("\n materia añadida");
			else 
				System.out.println("\n error al añadir materia");
			break;
			
		case 2:
			validar("¿Deseas borrar materias?");
			Materia materia1 = new Materia ();
			materia1.leerDatos();
			if(libreria.bajaMateria(materia1))
				System.out.println("\n materia borrada correctamente ");
			else 
				System.out.println("\n error al borrar la materia");
			break;

		default:
			break;
		}
	}


	
	//Funciones para dar de alta un libro

	public static void darDeAltaUnLibro(Libreria libreria) {
		
		Libro a = new Libro ();
		a.leerIsbn();
		if(!libreria.existeLibro(a)) {
			a.leerOtrosDatos();
			do {
				Materia materia = new Materia();
				libreria.mostrarMaterias();
				m.setNombre(Teclado.leerString("\n Selecciona una materia :"));
				
				
				//Meto un libro
				if(libreria.getMaterias().contains(materia)) {
					a.insertarMateria(materia);
					System.out.println("\n Materia insertada");
				}else {
					System.out.println("\n Selecciona una de las disponibles ");
				}
				
				
				
			}while(System.out.println("\n Quieres añadir otra?(S/N)").equalsIgnoreCase("S"));
			libreria.altaLibro(a);
		}else {
			System.out.println("\n El libro a dar de alta ya EXISTE");
		}
	}
	

	//Funcion que da de baja un libro.
	public static void darBajaLibro (Libreria libreria) {
		
		 //Nuevo libro
		Libro l = new Libro ();
		
		//Leer ISBN
		boolean exito;
		l.leerIsbn();
		exito = libreria.bajaLibro(l);
		
		if (exito) {
			System.out.println("\n Dado de baja correctamente");
		}
		else 
		{
			System.out.println("\n Error baja");
		}
		
	}
	
	
	
	//Función que anula la baja de un libro

	private static void anularBajaLibro(Libreria libreria) {
		// TODO Auto-generated method stub
		Libro l = new Libro ();
		
		
		//funcion del objeto librería
		boolean exito;
		l.leerIsbn();
		exito = libreria.anularBajaLibro(l);
		
		if (exito) {
			System.out.println("\n Baja anulada correctamente");
		}
		else 
		{
			System.out.println("\n Error anulacion");
		}
	}
	
	 //Función que actualiza los libros
	private static void actualizarLibro(Libreria libreria) {
		// TODO Auto-generated method stub
		Libro l = new Libro ();
		          
		
		//Creo un ISBN y lo leo
		l.leerIsbn();
		
		if (libreria.existeLibro(l)) {
			l.leerOtrosDatos();
			do {
			Scanner sc = new Scanner(System.in);
				Materia materia = new Materia();
				libreria.mostrarMaterias();
				materia.setNombre(System.out.println("\n Selecciona una materia :"));
				if(libreria.getMaterias().contains(m)) {
					l.insertarMateria(m);
					System.out.println("\n Materia insertada");
				}else {
					System.out.println("\n Selecciona una de las disponibles ");
				}
			}while(System.out.println("\n Quieres añadir otra?(S/N)").equalsIgnoreCase("S"));
			
			libreria.actualizarLibro(l);
			System.out.println("\n Libro actualizado");
			
		}
		else
			System.out.println("\n No se puede actualizar");
	}
	

	

	//Funciones de préstamos para el lector


		private static void PrestamosLector(Libreria libreria) {
			// TODO Auto-generated method stub
			
			Lector l = new Lector ();
			l.leerDni();
			libreria.PrestamosLector(l);
		}

		 //Funcion que devuelve un prestamo
		private static void devolverPrestamo(Libreria libreria) {
			// TODO Auto-generated method stub
			
			Libro prestamo = new Libro ();
			Lector l = new Lector ();
			
			prestamo.leerIsbn();
			l.leerDni();
			
			if (libreria.anotarDevolucion(prestamo, l)) {
				System.out.println("\n Prestamo devuelto correctamente.");
			}
			
			else
				System.out.println("\n Prestamo no devuelto.");
		}

		
		 //Funcion que guarda un prestamo
		private static void crearPrestamo(Libreria libreria) {
			// TODO Auto-generated method stub
			
			Libro prestamo = new Libro ();
			Lector l = new Lector ();
			
			prestamo.leerIsbn();
			l.leerDni();
			
			if (libreria.anotarPrestamo(prestamo, l)) {
				System.out.println("\n Prestamo anotado correctamente.");
			}
			
			else
				System.out.println("\n Prestamo  no anotado .");
		}


	
	
	//Función que da de alta a un Lector

	private static void darDeAltaLector(Libreria libreria) {
		// TODO Auto-generated method stub
		Lector a = new Lector ();
		a.leerDni();
		if(!libreria.existeLector(a)) {
			a.leerOtrosDatos();
			libreria.altaLector(a);
			System.out.println("\n Insertado correctamente");
		}else {
			System.out.println("\n El lector a dar de alta ya EXISTE");
		}
	}
	
	
	//Función que da de baja al lector
		private static void darBajaLector(Libreria libreria) {
			// TODO Auto-generated method stub
			Lector l = new Lector ();
			
			boolean exito;
			l.leerDni();
			exito = libreria.bajaLector(l);
			
			if (exito) {
				System.out.println("\n Se ha dado de baja correctamente");
			}
			else 
			{
				System.out.println("\n Error al dar de baja");
			}
		}


	 //Funcion que anula la baja de un Lector
	
	private static void anularBajaLector(Libreria libreria) {
		// TODO Auto-generated method stub
		Lector l = new Lector ();
		
		boolean exito;
		l.leerDni();
		exito = libreria.anularBajaLector(l);
		
		if (exito) {
			System.out.println("\n Baja anulada correctamente");
		}
		else 
		{
			System.out.println("\n Error anulacion");
		}
	}
	
	

	
	 //Funcion que actualiza al lector
	 
	private static void actualizarLector(Libreria libreria) {
	
		Lector l = new Lector ();
		
		l.leerDni();
		
		if (libreria.existeLector(l)) {
			l.leerOtrosDatos();
		
			libreria.actualizarLector(l);
			System.out.println("\n Lector actualizado");
			
		}
		else
			System.out.println("\n No se puede actualizar");
	}
	



	

//Función validar

	
private static boolean validar (String respuesta) {
	int opcion = N;
	boolean continuar = false;
	System.out.println();
	System.out.println(respuesta);
	opcion=Libreria.leerEntre(N, S, "\n Elige una opcion (N = NO; S = SI)");
	if(opcion == S)
		continuar = true;
	return continuar;
	}
	
}

	