package Objetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class BlackJack1 {

	public static void main(String[] args) {

		int[][] jugadores;
		int[] cartasBanca;
		int[] apuesta;
		int[] suma;
		int ganador;

		Pantalla.escribirString("Bienvenido al BlackJack americano");
		Pantalla.escribirSaltoLinea();
		int nJugadores = Teclado.leerInt("Introduzca el número de jugadores");

		jugadores = new int[nJugadores][10];
		suma = new int[nJugadores + 1];

		for (int i = 0; i < nJugadores; i++) {

		}

		apuesta = new int[nJugadores + 1];
		cartasBanca = new int[3];

		pedirApuestas(apuesta);

		generarCartasBanca(cartasBanca);

		generarCartasJugadores(jugadores);

		comprobarGanador(jugadores, cartasBanca, suma);

		menu(jugadores, apuesta);

		comprobarGanador(jugadores, cartasBanca, suma);

		ganador = juego(suma, cartasBanca);

		resultado(ganador, suma, apuesta);

	}

	public static void resultado(int ganador, int[] suma, int[] apuesta) {

		for (int i = 0; i < suma.length; i++) {

			if (suma[i] == ganador) {

				if (i == 0) {

					Pantalla.escribirString("Gana la banca");

				} else {

					if (i != 0) {

						String mensaje = "Gana el jugador " + i;
						Pantalla.escribirString(mensaje);
						Pantalla.escribirSaltoLinea();
						Pantalla.escribirInt("El jugador gana ", apuesta[i - 1] * 2);
					}

				}

			}
		}
	}

	public static int juego(int[] suma, int[] cartasBanca) {
		int max = 0;

		for (int i = 0; i < suma.length; i++) {

			if ((suma[i] > max) && (suma[i] <= 21))
				max = suma[i];

		}

		return max;

	}

	public static void menu(int[][] jugadores, int[] apuesta) {

		int opcion;
		int cartaNueva;

		for (int i = 0; i < jugadores.length; i++) {

			do {
				opcion = Teclado.leerInt("Introduzca 1 para plantarse y 2 para doblar la apuesta y recibir otra carta");
			} while (opcion != 1 && opcion != 2);

			if (opcion == 2) {

				apuesta[i] = apuesta[i] * 2;

				cartaNueva = Libreria.aleatorio(1, 13);
				if ((cartaNueva == 11) || (cartaNueva == 12) || (cartaNueva == 13))
					cartaNueva = 10;
				if (cartaNueva == 1) {
					int opcion2;
					do {
						opcion2 = Teclado.leerInt("Introduzca 1 para que el as tenga un valor de 1 o 11 para 11");
					} while (opcion2 != 1 && opcion2 != 11);

					if (opcion2 == 11)
						cartaNueva = 11;
				}

				Pantalla.escribirString("Carta nueva: ");
				Pantalla.escribirInt(cartaNueva);
				Pantalla.escribirSaltoLinea();
				jugadores[i][2] = cartaNueva;
			}

		}

	}

	public static void comprobarGanador(int[][] jugadores, int[] cartasBanca, int[] suma) {

		int sumaBanca = cartasBanca[0] + cartasBanca[1] + cartasBanca[2];

		Pantalla.escribirSaltoLinea();
		Pantalla.escribirInt("Suma banca: ", sumaBanca);
		Pantalla.escribirSaltoLinea();

		suma[0] = sumaBanca;

		for (int i = 0; i < jugadores.length; i++) {

			suma[i + 1] = jugadores[i][0] + jugadores[i][1] + jugadores[i][2];

			String mensaje = "Jugador: " + (i + 1);

			Pantalla.escribirInt(mensaje, suma[i + 1]);
			Pantalla.escribirSaltoLinea();

		}

	}

	public static void pedirApuestas(int[] apuesta) {

		for (int i = 0; i < (apuesta.length - 1); i++) {

			apuesta[i] = Teclado.leerInt("Introduzca su apuesta inicial");

		}
	}

	public static void generarCartasBanca(int[] cartasBanca) {
		for (int i = 0; i < cartasBanca.length; i++) {

			cartasBanca[i] = Libreria.aleatorio(1, 13);
			if ((cartasBanca[i] == 11) || (cartasBanca[i] == 12) || (cartasBanca[i] == 13))
				cartasBanca[i] = 10;
			if (cartasBanca[i] == 1)
				cartasBanca[i] = 11;
		}

		Pantalla.escribirInt("Carta descubierta de la banca:", cartasBanca[1]);
		Pantalla.escribirSaltoLinea();

		if (cartasBanca[0] == 11 && cartasBanca[1] == 11)
			cartasBanca[1] = 1;

		if ((cartasBanca[0] + cartasBanca[1]) < 12) {
			cartasBanca[2] = Libreria.aleatorio(1, 13);
			Pantalla.escribirString("Banca roba otra carta");
			Pantalla.escribirSaltoLinea();

		}

	}

	public static void generarCartasJugadores(int[][] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			for (int j = 0; j < 2; j++) {

				int carta = Libreria.aleatorio(1, 13);

				if ((carta == 11) || (carta == 12) || (carta == 13))
					carta = 10;

				if (carta == 1) {
					int opcion;
					do {
						opcion = Teclado.leerInt("Introduzca 1 para que el as tenga un valor de 1 o 11 para 11");
					} while (opcion != 1 && opcion != 11);

					if (opcion == 11)
						carta = 11;
				}
				String mensaje = "Carta jugador " + (i + 1);
				Pantalla.escribirInt(mensaje, carta);
				Pantalla.escribirSaltoLinea();
				jugadores[i][j] = carta;
			}
		}

	}

}
