package biblioteca;

import java.util.Scanner;

// Funcion para leer un numero entero
public class Validacion {
	public static int leerNum() {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		return num;
	}

	// Funcion para leer la opcion de los menus
	public static String leerOpcion() {
		Scanner sc = new Scanner(System.in);

		String c = sc.nextLine();

		return c;
	}

	// Funcion que solicitara una confirmacion para continuar
	public static boolean validarRespuesta() {
		Scanner sc = new Scanner(System.in);
		String respuesta;
		boolean confirmacion = false;

		do {
			System.out.println("\nConfirme la operación: (s/n) ");
			respuesta = sc.nextLine();
		} while (respuesta.equalsIgnoreCase(" "));

		if (respuesta.equalsIgnoreCase("s")) {
			solicitarIntro();

			confirmacion = true;
		} else {
			if (respuesta.equalsIgnoreCase("n")) {
				confirmacion = false;
			}
		}

		return confirmacion;
	}

	// Funcion para solicitar intro
	public static void solicitarIntro() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\nPulse intro para continuar");
		sc.nextLine();

	}

	// Funcion para leer un String enviando un mensaje
	public static String leerString(String mensaje) {
		Scanner sc = new Scanner(System.in);
		String string = " ";

		System.out.println(mensaje);
		string = sc.nextLine();

		return string;
	}

	// Funcion para leer un entero enviando un mensaje
	public static int leerInt(String mensaje) {
		Scanner sc = new Scanner(System.in);
		int i = 0;

		System.out.println(mensaje);
		i = sc.nextInt();

		return i;
	}
}
