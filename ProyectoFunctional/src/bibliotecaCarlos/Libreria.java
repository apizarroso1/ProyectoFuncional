import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
	// Variables
	private ArrayList<Libro> librosAlta;
	private ArrayList<Libro> librosBaja;
	private ArrayList<Materia> materias;
	private ArrayList<Lector> lectores;
	private ArrayList<Lector> lectoresBaja;
	private ArrayList<Prestamo> prestamos;

	// Costructor por defecto
	public Libreria() {

		this.librosAlta = new ArrayList<Libro>();
		this.librosBaja = new ArrayList<Libro>();
		this.materias = new ArrayList<Materia>();
		this.lectores = new ArrayList<Lector>();
		this.lectoresBaja = new ArrayList<Lector>();
		this.prestamos = new ArrayList<Prestamo>();
	}

	// Selectores y modificadores

	public ArrayList<Lector> getLectoresBaja() {
		return lectoresBaja;
	}

	public void setLectoresBaja(ArrayList<Lector> lectoresBaja) {
		this.lectoresBaja = lectoresBaja;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public ArrayList<Lector> getLectores() {
		return lectores;
	}

	public void setLectores(ArrayList<Lector> lectores) {
		this.lectores = lectores;
	}

	public ArrayList<Libro> getLibrosAlta() {
		return librosAlta;
	}

	public void setLibrosAlta(ArrayList<Libro> librosAlta) {
		this.librosAlta = librosAlta;
	}

	public ArrayList<Libro> getLibrosBaja() {
		return librosBaja;
	}

	public void setLibrosBaja(ArrayList<Libro> librosBaja) {
		this.librosBaja = librosBaja;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	// Comprobar si existe libro prestado
	public boolean existeLibroPrestado(Libro l) {
		boolean exito = false;

		for (int i = 0; i < prestamos.size(); i++) {

			if (prestamos.get(i).getLibro().equals(l)) {
				exito = true;
			}
		}
		return exito;
	}

	// Comprobar si existe Lector con prestamo
	public boolean existeLectorConPrestamo(Lector l) {
		boolean exito = false;
		for (int i = 0; i < prestamos.size(); i++) {

			if (prestamos.get(i).getLector().equals(l)) {
				exito = true;
			}
		}
		return exito;
	}

	// Funcion de anotar prestamo
	public boolean anotarPrestamo(Libro l, Lector t) {

		boolean exito = false;

		if (existeLibro(l)) {
			if (existeLector(t)) {
				if (!existeLibroPrestado(l)) {
					if (!existeLectorConPrestamo(t)) {

						Prestamo p = new Prestamo(l, t);
						prestamos.add(p);
						exito = true;
					}
				}
			}
		}

		return exito;

	}

	// Funcion de Anotar devoluci�n
	public boolean anotarDevolucion(Libro l, Lector t) {

		boolean exito = false;

		if (existeLibro(l)) {
			if (existeLector(t)) {
				if (existeLibroPrestado(l)) {
					if (existeLectorConPrestamo(t)) {

						Prestamo p = new Prestamo(l, t);

						prestamos.remove(p);

						exito = true;
					}
				}
			}
		}

		return exito;

	}

	// Funci�n de Lista de morosos
	public void listarPrestamos() {
		for (Prestamo p : prestamos) { // Del objeto Prestamo sacamos un prestamo del array listo de prestamos
			p.mostrarDatos(); // mostrar los datos de cada prestamo.
		}
	}

	// Funci�n Pr�stamos de lector
	public void PrestamosLector(Lector t) {

		if (existeLectorConPrestamo(t)) {

			Prestamo p = new Prestamo(t);

			for (int i = 0; i < prestamos.size(); i++) {

				if (prestamos.get(i).equals(p)) {

					prestamos.get(i).mostrarDatos();

				}
			}
		}
	}

	// Funci�n para comprobar si existe un lector
	public boolean existeLector(Lector m) {

		return lectores.contains(m);
	}

	// Funci�n para comprobar si existe un lector para darlo de baja

	public boolean existeLectorBaja(Lector m) {

		return lectoresBaja.contains(m);
	}

	// Funci�n para dar de alta un lector
	public boolean altaLector(Lector m) {
		boolean exito = false;
		if (!existeLector(m)) {
			exito = lectores.add(m);
		}
		return exito;
	}

	// Funci�n listar lectores
	public void listarLectores() {
		for (Lector lector : lectores) {
			lector.mostrarDatos();
		}
	}

	// Funcion baja lector
	public boolean bajaLector(Lector a) {
		Lector nuevo;
		boolean exito = false;
		if (existeLector(a)) {
			for (int i = 0; i < lectores.size(); i++) {
				if (lectores.get(i).equals(a)) {
					nuevo = lectores.get(i);
					lectoresBaja.add(nuevo);
					exito = true;
				}
			}

			lectores.remove(a);
		}

		return exito;
	}

	// Funci�n para anular la baja de un lector
	public boolean anularBajaLector(Lector a) {
		Lector nuevo;
		boolean exito = false;
		if (existeLectorBaja(a)) {
			for (int i = 0; i < lectoresBaja.size(); i++) {
				if (lectoresBaja.get(i).equals(a)) {
					nuevo = lectoresBaja.get(i);
					lectores.add(nuevo);
					exito = true;
				}
			}

			lectoresBaja.remove(a);
		}

		return exito;
	}

	// Funci�n para acualizar lector
	public boolean actualizarLector(Lector a) {
		boolean exito = false;
		
		a.leerDatos();

		return exito;
	}

	// Funcion para compactar registros (vaciar lista de bajas)
	public boolean compactarRegistroLector() {

		this.lectoresBaja.clear();
		return lectoresBaja.isEmpty();

	}

	// Funcion para buscar lector
	public void buscarLectores(String nombre) {

		for (int i = 0; i < lectores.size(); i++) {
			if (lectores.get(i).getNombre().equals(nombre)) {
				lectores.get(i).mostrarDatos();
			}
		}
	}

	// Funcion Listar Libros
	public void listarLibros() {
		for (Libro libro : librosAlta) {
			libro.mostrarDatos();
		}
	}

	// Funcion para ver si un libro existe
	public boolean existeLibro(Libro a) {

		return this.librosAlta.contains(a);
	}

	// Funcion para comprobar si existe el libro en el array de bajas
	public boolean existeLibroBajas(Libro a) {

		return this.librosBaja.contains(a);
	}

	// Funcion alta libro
	public boolean altaLibro(Libro a) {

		return librosAlta.add(a);
	}

	// Funcion baja libro
	public boolean bajaLibro(Libro a) {
		Libro nuevo;
		boolean exito = false;
		if (existeLibro(a)) {
			for (int i = 0; i < librosAlta.size(); i++) {
				if (librosAlta.get(i).equals(a)) {
					nuevo = librosAlta.get(i);
					librosBaja.add(nuevo);
					exito = true;
				}
			}

			librosAlta.remove(a);
		}

		return exito;
	}

	// Funcion para anular la baja de un libro
	public boolean anularBajaLibro(Libro a) {
		Libro nuevo;
		boolean exito = false;
		if (existeLibroBajas(a)) {
			for (int i = 0; i < librosBaja.size(); i++) {
				if (librosBaja.get(i).equals(a)) {
					nuevo = librosBaja.get(i);
					librosAlta.add(nuevo);
					exito = true;
				}
			}

			librosBaja.remove(a);
		}

		return exito;
	}

	// Funcion para acualizar libro
	public boolean actualizarLibro(Libro a) {
		boolean exito = false;
		int pos = librosAlta.indexOf(a);
		if (pos >= 0) {
			librosAlta.set(pos, a);
			exito = true;
		}

		return exito;
	}

	// Funcion para compactar registros (vaciar lista de bajas)
	public boolean compactarRegistro() {

		this.librosBaja.clear();
		return librosBaja.isEmpty();

	}

	// Funci�n para mostrar materia
	public void mostrarMaterias() {
		for (Materia m : materias) {
			m.mostrarDatos();
		}
	}

	// Funci�n para comprobar si existe la materia
	public boolean existeMateria(Materia m) {

		return materias.contains(m);
	}

	// Funcion para dar de alta una materia
	public boolean altaMateria(Materia m) {
		boolean exito = false;
		if (!existeMateria(m)) {
			exito = materias.add(m);
		}
		return exito;
	}

	// Funcion para dar de baja una materia
	public boolean bajaMateria(Materia m) {
		boolean exito = false;
		if (existeMateria(m)) {
			exito = materias.remove(m);
		}

		for (int i = 0; i < librosAlta.size(); i++) {
			if (librosAlta.get(i).getMaterias().contains(m)) {
				librosAlta.get(i).getMaterias().remove(m);
			}
		}

		for (int i = 0; i < librosBaja.size(); i++) {
			if (librosBaja.get(i).getMaterias().contains(m)) {
				librosBaja.get(i).getMaterias().remove(m);
			}
		}
		return exito;
	}

	// Funcion para buscar un autor
	public void buscarAutor(String autor) {

		for (int i = 0; i < librosAlta.size(); i++) {

			if (librosAlta.get(i).getAutor().equals(autor)) {
				librosAlta.get(i).mostrarDatos();
			}
		}
	}

	// Funcion de busqueda de titulo
	public void buscarTitulo(String titulo) {

		for (int i = 0; i < librosAlta.size(); i++) {

			if (librosAlta.get(i).getAutor().equals(titulo)) {
				librosAlta.get(i).mostrarDatos();
			}
		}
	}

	// Funcion de busqueda de materia
	public void buscarMaterial(Materia m) {

		for (int i = 0; i < librosAlta.size(); i++) {
			for (int j = 0; j < librosAlta.get(i).getMaterias().size(); j++) {
				if (librosAlta.get(i).getMaterias().get(j).equals(m)) {
					librosAlta.get(i).mostrarDatos();
				}
			}
		}
	}

	public static int leerEntre(int minimo, int maximo, String mensaje) {
		int valor;

		do {
			valor = leerInt(mensaje);

		} while (valor < minimo || valor > maximo);

		return valor;
	}

	public static int leerInt(String mensaje) {
		Scanner sc = new Scanner(System.in);

		System.out.println(mensaje);

		return sc.nextInt();
	}
}
