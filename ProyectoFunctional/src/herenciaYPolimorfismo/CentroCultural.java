package herenciaYPolimorfismo;

import java.util.ArrayList;
import java.util.Iterator;

import daw.com.Pantalla;
import daw.com.Teclado;

public class CentroCultural{

	public static void main(String[] args) {
		ArrayList<Material> materiales = new ArrayList<Material>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

		mostrarMenu(materiales, clientes, prestamos);

	}

	public static void mostrarMenu(ArrayList<Material> materiales, ArrayList<Cliente> clientes,
			ArrayList<Prestamo> prestamos) {
		int opcion = 0;

		do {
			Pantalla.escribirString("\n[1] Insertar material");
			Pantalla.escribirString("\n[2] Insertar cliente");
			Pantalla.escribirString("\n[3] Solicitar prestamo");
			Pantalla.escribirString("\n[4] Devolver prestamo");
			Pantalla.escribirString("\n[5] Listar materiales");
			Pantalla.escribirString("\n[6] Mostrar el material mas prestado");
			Pantalla.escribirString("\n[7] Salir");

			opcion = Libreria.leerEntre(1, 7, "\nSeleccione su opcion");
			switch (opcion) {
			case 1:
				insertarMaterial(materiales);
				break;
			case 2:
				insertarCliente(clientes);
				break;
			case 3:
				solicitarPrestamo(clientes, materiales, prestamos);
				break;
			case 4:
				devolverPrestamo(clientes, materiales, prestamos);
				break;
			case 5:
				listarMateriales(materiales);
				break;
			case 6:
				mostrarMasPrestado(materiales);
				break;
			}

		} while (opcion != 7);

	}

	public static void insertarMaterial(ArrayList<Material> materiales) {
		Material m; //= null;
		int tipo = Libreria.leerEntre(1, 2, "\n1 para disco y 2 para libro");

		if (tipo == 1) {
			m = new Disco();
			m.leerDatos();
		} else {
			m = new Libro();
			m.leerDatos();
		}

		if (materiales.contains(m)) {
			Pantalla.escribirString("\nEl material ya esta registrado");
		} else {
			materiales.add(m);
		}
	}

	public static void insertarCliente(ArrayList<Cliente> clientes) {
		Cliente c = new Cliente();

		c.leerDatos();

		if (clientes.contains(c)) {
			Pantalla.escribirString("\nEl cliente ya esta registrado");
		} else {
			clientes.add(c);
		}
	}

	public static void solicitarPrestamo(ArrayList<Cliente> clientes, ArrayList<Material> materiales,
		ArrayList<Prestamo> prestamos) {
		boolean exito = false;
		int cliente, material;
		Prestamo p = new Prestamo();

//		¡¡Esta mal!!
//		for (int i = 0; i < clientes.size(); i++) {
//			if (!clientes.get(i).isPrestamo()) {
//				exito = true;
//			} else {
//				exito = false;
//			}
//		}
//		
//		for (int i = 0; i < materiales.size(); i++) {
//			if (!materiales.get(i).isBaja()) {
//				exito = true;
//			} else {
//				exito = false;
//			}
//		}

		for (int i = 0; i < clientes.size(); i++) {
			if (!clientes.get(i).isPrestamo()) {
				Pantalla.escribirString(clientes.get(i).mostrarDatos());
			}
		}
		cliente = Libreria.leerEntre(0, clientes.size(), "\nSeleccione el cliente que realizara el prestamo");

		for (int i = 0; i < materiales.size(); i++) {
			if (!materiales.get(i).isBaja()) {
				Pantalla.escribirString(materiales.get(i).mostrarDatos());
			}
		}
		material = Libreria.leerEntre(0, materiales.size(), "\nSeleccione el material a prestar");

		if (!clientes.get(cliente).isPrestamo()) {
			exito = true;
		} else {
			exito = false;
		}

		if (!materiales.get(material).isBaja()) {
			exito = true;
		} else {
			exito = false;
		}

		if (exito) {

			clientes.get(cliente).setPrestamo(true);
			materiales.get(material).setBaja(true);
			materiales.get(material).setPrestamos(materiales.get(material).getPrestamos() + 1);

			p.leerDatos();
			p.setCodCliente(cliente);
			p.setCodMaterial(material);

			prestamos.add(p);

		} else {
			Pantalla.escribirString("\nNo se ha podido realizar el prestamo");
		}
	}

	public static void devolverPrestamo(ArrayList<Cliente> clientes, ArrayList<Material> materiales,
			ArrayList<Prestamo> prestamos) {
		int prestamo, material, cliente;

		for (int i = 0; i < prestamos.size(); i++) {
			Pantalla.escribirString(prestamos.get(i).mostrarDatos());
		}

		prestamo = Libreria.leerEntre(0, prestamos.size(), "\nSeleccione el prestamo a finalizar");

		if (!prestamos.get(prestamo).isDevuelto()) {

			cliente = prestamos.get(prestamo).getCodCliente();
			material = prestamos.get(prestamo).getCodMaterial();

			clientes.get(cliente).setPrestamo(false);
			materiales.get(material).setBaja(false);

			prestamos.get(prestamo).setDevuelto(true);
		} else {
			Pantalla.escribirString("\nNo se pudo realizar la devolucion");
		}
	}

	public static void listarMateriales(ArrayList<Material> materiales) {
		for (int i = 0; i < materiales.size(); i++) {
			if (!materiales.get(i).isBaja()) {
				Pantalla.escribirString(materiales.get(i).mostrarDatos());
			}
		}
	}

	public static void mostrarMasPrestado(ArrayList<Material> materiales) {

		int pos = buscarMasPrestado(materiales);

		Pantalla.escribirString(materiales.get(pos).mostrarDatos());
		Pantalla.escribirString(" es el mas prestado");
	}

	public static int buscarMasPrestado(ArrayList<Material> materiales) {
		int max, pos = 0;

		max = materiales.get(0).getPrestamos();

		for (int i = 1; i < materiales.size(); i++) {
			if (materiales.get(i).getPrestamos() > max) {
				max = materiales.get(i).getPrestamos();
				pos = i;
			}
		}

		return pos;
	}
}
