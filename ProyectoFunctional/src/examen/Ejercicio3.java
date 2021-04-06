package examen;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejercicio3 {

	public static void main(String[] args) {
		String nombres[];
		int cantidades[];

		nombres = new String[10];
		cantidades = new int[10];

		int i = 0;
		int opcion = 0;

		while (opcion != 4) {

			Pantalla.escribirString("Pulse 1 para AÃ±adir un producto, 2 para Eliminar un producto, 3 para mostrar el total de productos, 4 para abandonar el programa");
			Pantalla.escribirSaltoLinea();
			opcion = Libreria.leerEntre(1, 4, "Seleccione su opciÃ³n de la 1 a la 4");

			if (opcion == 1) {
				añadirProducto(nombres, cantidades, i);
			} else {
				if (opcion == 2) {
					eliminarProducto(nombres, cantidades, i);
				} else {
					if (opcion == 3) {
						calcularCantidad(cantidades);
					} else {
						salir(nombres, cantidades);
					}
				}
			}
			i = i + 1;
		}

	}

	public static void salir(String[] nombres, int[] cantidades) {

		for (int i = 0; i < cantidades.length; i++) {
			Pantalla.escribirString(nombres[i]);
			Pantalla.escribirSaltoLinea();
			Pantalla.escribirInt(cantidades[i]);
			Pantalla.escribirSaltoLinea();
		}

	}

	public static void eliminarProducto(String[] nombres, int[] cantidades, int i) {
		String nombreABorrar = Teclado.leerString("Introduzca el nombre del producto a eliminar");

		for (int j = 0; j < nombres.length; j++) {

			if (nombreABorrar == nombres[j]) {
				nombres[j] = "";
				cantidades[j] = 0;
			}

		}

	}

	public static void calcularCantidad(int[] cantidades) {
		int cantidad = 0;
		for (int i = 0; i < cantidades.length; i++) {
			cantidad = cantidad + cantidades[i];
		}
		Pantalla.escribirInt(cantidad);
	}

	public static void añadirProducto(String[] nombres, int[] cantidades, int i) {
		nombres[i] = Teclado.leerString("Introduzca el nombre del producto");
		cantidades[i] = Teclado.leerInt("Introduzca la cantidad del producto");

	}

}
