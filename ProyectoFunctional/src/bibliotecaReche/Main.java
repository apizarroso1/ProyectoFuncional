package bibliotecaReche;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libreria libreria = new Libreria ();
		int opc;
		
System.out.println("Hola bienvenido a la biblioteca creada por Alejandro Reche:");


		do {
			mostrarMenu ();
			opc = Libreria2.leerEntre(1, 5, "\n Introduce la opcion");
			evaluarOpc (opc, libreria);
			
			
		} while (opc != 5); 
	
	}
	private static void mostrarMenu() {
		System.out.println("1.Gestion de libros");
		System.out.println("2.Gestion de lectores");
		System.out.println("3.Gestion de prestamos");
		System.out.println("4.Busquedas");
		System.out.println("5.Salir de la aplicacion");
	}
	private static void mostrarMenuLibros() {
		System.out.println("1.Alta libros");
		System.out.println("2.Baja libros");
		System.out.println("3.Anular baja de libro");
		System.out.println("4.Actualizar libro");
		System.out.println("5.Listar libros");
		System.out.println("6.Compactar registro de libros");
		System.out.println("7.Actualizar lista de materias");
		System.out.println("8.Salir");
	}
	private static void mostrarMenuMaterias() {
		System.out.println("1.Alta materia");
		System.out.println("2.Baja materia");
		System.out.println("3.Salir");
	}
	private static void mostrarMenuLectores() {
		System.out.println("1.Alta lectores");
		System.out.println("2.Baja lectores");
		System.out.println("3.Anular baja de lectores");
		System.out.println("4.Actualizar lectores");
		System.out.println("5.Listar lectores");
		System.out.println("6.Compactar registro de lectores");
		System.out.println("7.Buscar lector");
		System.out.println("8.Salir");
}
	private static void mostrarMenuPrestamos() {
		System.out.println("1.Anotar prestamo");
		System.out.println("2.Anotar devolucion");
		System.out.println("3.Listar morosos");
		System.out.println("4.Prestamos de lector");
		System.out.println("5.Salir");
}
	private static void mostrarBusqueda() {
		System.out.println("1.Buscar por autor");
		System.out.println("2.Buscar por titulo");
		System.out.println("3.Buscar por materia");
		System.out.println("4.Salir ");
	}
	private static void evaluarOpc(int opc, Libreria libreria) {

		switch (opc) {
		case 1:
			int opc2;
			do {
				System.out.println();
				mostrarMenuLibros ();
				opc2 = Libreria2.leerEntre(1, 8, "\n Introduce la opcion");
				evaluarOpcLibros (opc2, libreria);
				
				
			} while (opc2 != 8);
			
			break;
			
		
		case 2:
			int opc4;
			do {
				System.out.println();
				mostrarMenuLectores ();
				opc4 = Libreria2.leerEntre(1, 8, "\n Introduce la opcion");
				evaluarOpcLectores (opc4, libreria);
				
				
			} while (opc4 != 8);
			
			break;
			
		case 3:
			
			int opc5;
			do {
				System.out.println();
				mostrarMenuPrestamos();
				opc5 = Libreria2.leerEntre(1, 5, "\n Introduce la opcion");
				evaluarOpcPrestamos (opc5, libreria);
				
			} while (opc5 != 5);
			
			
			break;	
		
		case 4:
			int opc6;
			do {
				System.out.println();
				mostrarBusqueda();
				opc6 = Libreria2.leerEntre(1, 4, "\n Introduce la opcion");
				evaluarOpcBusquedas (opc6, libreria);
				
			} while (opc6 != 4);
			
			break;

		default:
			break;
		}
		
	}
	

	private static void evaluarOpcBusquedas (int opc6, Libreria libreria) {
		Scanner sc = new Scanner(System.in);
		switch (opc6) {
		case 1:
			validar("Esta seguro de que desea realizar una busqueda de autor?");
			
			String autor = sc.next(" \n Por favor Introduzca el Autor:");
			
			libreria.buscarAutor(autor);
			
			break;
		case 2:
			validar("Esta seguro de que desea realizar una busqueda del titulo?");
			
			String titulo = sc.next("\n Por favor introduzca el Titulo:");
			
			libreria.buscarTitulo(titulo);
			
			break;
			
		case 3:
			validar("Esta seguro de que desea realizar una busqueda por materia?");
			
			String materia = sc.next("\n Por favor introduzca la Materia:");
			
			
			Materia m = new Materia(materia);
			
			libreria.buscarMaterial(m);
			
			break;
			
		default:
			break;
		}
}

	private static void evaluarOpcPrestamos(int opc5, Libreria libreria) {
		switch (opc5) {
		case 1:
			validar("Esta seguro de que desea realizar una alta del prestamo?");
			crearPrestamo (libreria);
			break;
		case 2:
			validar("Esta seguro de que desea realizar una baja del prestamo?");
			devolverPrestamo (libreria);
			break;
			
		case 3:
			validar("Esta seguro de que desea visualizar la lista de morosos?");
			libreria.listarPrestamos();
			break;
			
		case 4:
			validar("Esta seguro de que desea visualizar los prestamos del lector?");
			 PrestamosLector(libreria);
			break;
			
		default:
			break;
		}
}
	private static void evaluarOpcLectores(int opc4, Libreria libreria) {
		Scanner sc = new Scanner(System.in);
		switch (opc4) {
		case 1:
			validar("Esta seguro de que desea realizar un alta del lector?");
			darDeAltaLector (libreria);
			break;
		case 2:
			validar("Esta seguro de que desea realizar una baja del lector?");
			darBajaLector (libreria);
			break;
			
		case 3:
			validar("Esta seguro de que desea realizar una anulacion de la baja del lector?");
			anularBajaLector (libreria);
			break;
			
		case 4:
			validar("Esta seguro de que desea realizar una actualizacion del lector?");
			 actualizarLector(libreria);
			break;
			
		case 5:
			validar("Esta seguro de que desea listar los lectores?");
			libreria.listarLectores();
			break;

		case 6:
			validar("Esta seguro de que desea realizar una compactacion del registro del lector?");
			if(libreria.compactarRegistroLector()) {
				System.out.println(" Los lectores que se han dado de baja ya estan eliminados");
			}
			else {
				System.out.println("Error al tratar de eliminar los lectores de baja");
			}
			break;
			
		case 7:
			validar("Esta seguro de que desea realizar una busqueda del lector?");
			String nombre;
			nombre=sc.next("Por favor introduzca el nombre a buscar:");
			libreria.buscarLectores(nombre);
			
			
			break;
			
		default:
			break;
		}
	
}
	private static void evaluarOpcLibros(int opc2, Libreria libreria) {
		switch (opc2) {
		case 1:
			validar("Esta seguro de que desea realizar un alta del libro?");
			darDeAltaUnLibro(libreria);
			break;
			
		case 2:
			validar("Esta seguro de que desea realizar una baja del libro?");
			darBajaLibro (libreria);
			break;
		case 3:
			validar("Esta seguro de que desea realizar una anulacion de la baja del libro?");
			anularBajaLibro (libreria);
			break;
			
		case 4:
			validar("Esta seguro de que desea realizar una actualizacion del libro?");
			actualizarLibro(libreria);
			break;
		case 5:
			validar("Esta seguro de que desea listas los libros?");
			libreria.listarLibros();
			break;
			
		case 6:
			validar("Esta seguro de que desea realizar una compactacion de regristos del libro?");
			if(libreria.compactarRegistro()) {
				System.out.println(" Los libros que se han dado de baja ya estan eliminados");
			}
			else {
				System.out.println(" Error al tratar de eliminar los libros de baja");
			}
			break;
			
		case 7:
			int opc3;
			do {
				System.out.println();
				mostrarMenuMaterias ();
				opc3 = Libreria2.leerEntre(1, 3, "Por favor introduzca la Opcion que desea realizar");
				evaluarOpcMaterias (opc3, libreria);
				
				
			} while (opc3 != 3);
			break;
		default:
			break;
		}
	}
	private static void evaluarOpcMaterias(int opc3, Libreria libreria) {
		switch (opc3) {
		
		case 1:
			validar("Esta seguro de que desea aniadir materias?");
			Materia m = new Materia ();
			m.leerDatos();
			if(libreria.altaMateria(m))
				System.out.println("la materia ha sido aniadida correctamente");
			else 
				System.out.println("no se ha podido aniadir la materia");
			break;
			
		case 2:
			validar("Esta seguro de que desea borrar materias?");
			Materia m1 = new Materia ();
			m1.leerDatos();
			if(libreria.bajaMateria(m1))
				System.out.println("la materia ha sido borrada correctamente ");
			else 
				System.out.println("no se ha podido borrar la materia");
			break;

		default:
			break;
		}
	}
	public static void darDeAltaUnLibro(Libreria libreria) {
		Scanner sc = new Scanner(System.in);
		Libro a = new Libro ();
		a.leerIsbn();
		if(!libreria.existeLibro(a)) {
			a.leerOtrosDatos();
			do {
				Materia m = new Materia();
				libreria.mostrarMaterias();
				m.setNombre(sc.next("Por favor seleccione la materia  :"));
				if(libreria.getMaterias().contains(m)) {
					a.insertarMateria(m);
					System.out.println("Materia insertada correctamente");
				}else {
					System.out.println("Por favor seleecione una de las materias que estan disponibles");
				}
				
				
				
			}while(sc.next("\n Desea aniadir otra? indiquelo con :(S/N)").equalsIgnoreCase("S"));
			libreria.altaLibro(a);
		}else {
			System.out.println("\n El libro que pretende dar de alta ya existe");
		}
	}
	public static void darBajaLibro (Libreria libreria) {
		
		Libro l = new Libro ();
		
		boolean exito;
		l.leerIsbn();
		exito = libreria.bajaLibro(l);
		
		if (exito) {
			System.out.println("El libro se ha dado de baja correctamente");
		}
		else 
		{
			System.out.println("No se ha podido dar de baja el libro");
		}
		
	}
	private static void anularBajaLibro(Libreria libreria) {
		// TODO Auto-generated method stub
		Libro l = new Libro ();
		
		boolean exito;
		l.leerIsbn();
		exito = libreria.anularBajaLibro(l);
		
		if (exito) {
			System.out.println("Se ha anulado la baja del libro correctamente");
		}
		else 
		{
			System.out.println("No se ha podido anular la baja del libro");
		}
	}
	private static void actualizarLibro(Libreria libreria) {
		Scanner sc = new Scanner(System.in);
		Libro l = new Libro ();
		
		l.leerIsbn();
		
		if (libreria.existeLibro(l)) {
			l.leerOtrosDatos();
			do {
				Materia m = new Materia();
				libreria.mostrarMaterias();
				m.setNombre(sc.next("Por favor seleccione una materia :"));
				if(libreria.getMaterias().contains(m)) {
					l.insertarMateria(m);
					System.out.println("La Materia ha sido insertada correctamente");
				}else {
					System.out.println("por favor Seleccione una de las disponibles ");
				}
			}while(sc.next("\n Quieres aniadir otra? por favor indiquelo con:(S/N)").equalsIgnoreCase("S"));
			
			libreria.actualizarLibro(l);
			System.out.println("\n El Libro ha sido actualizado correctamente");
			
		}
		else
			System.out.println("No ha sido posible actualizarlo");
	}
	private static void darDeAltaLector(Libreria libreria) {
		Lector a = new Lector ();
		a.leerDni();
		if(!libreria.existeLector(a)) {
			a.leerOtrosDatos();
			libreria.altaLector(a);
			System.out.println("El lector ha sido dado de alta correctamente");
		}else {
			System.out.println("El lector que se desea dar de  alta ya existe");
		}
	}
private static void darBajaLector(Libreria libreria) {

		Lector l = new Lector ();
		
		boolean exito;
		l.leerDni();
		exito = libreria.bajaLector(l);
		
		if (exito) {
			System.out.println("\n Dado de baja correctamente");
		}
		else 
		{
			System.out.println("\n Error baja");
		}
	}
	private static void anularBajaLector(Libreria libreria) {

		Lector l = new Lector ();
		
		boolean exito;
		l.leerDni();
		exito = libreria.anularBajaLector(l);
		
		if (exito) {
			System.out.println("La Baja se ha anulado correctamente");
		}
		else 
		{
			System.out.println("No se ha podido realizar la anulacion de la baja del lector");
		}
	}
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
	private static void PrestamosLector(Libreria libreria) {

		
		Lector l = new Lector ();
		l.leerDni();
		libreria.PrestamosLector(l);
	}

	
	private static void devolverPrestamo(Libreria libreria) {
		// TODO Auto-generated method stub
		
		Libro p = new Libro ();
		Lector l = new Lector ();
		
		p.leerIsbn();
		l.leerDni();
		
		if (libreria.anotarDevolucion(p, l)) {
			System.out.println("El prestamo ha sido devuelto correctamente");
		}
		
		else
			System.out.println("El Prestamo no ha podido ser devuelto ");
	}

	private static void crearPrestamo(Libreria libreria) {

		
		Libro p = new Libro ();
		Lector l = new Lector ();
		
		p.leerIsbn();
		l.leerDni();
		
		if (libreria.anotarPrestamo(p, l)) {
			System.out.println("El Prestamo ha sido anotado correctamente.");
		}
		
		else
			System.out.println("El Prestamo  no ha podido ser anotado .");
	}


	

private static boolean validar (String respuesta) {
	int opcion = 0;
	boolean continuar = false;
	System.out.println();
	System.out.println(respuesta);
	opcion=Libreria2.leerEntre(0, 1, "Por favor indica una opcion siendo 0 un NO y siendo un 1 un SI");
	if(opcion == 1)
		continuar = true;
	return continuar;
	}
	

	}


