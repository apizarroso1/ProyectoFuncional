package examen;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejercicio1 {

	public static void main(String[] args) {
		int matriz[][];
		int n, m;

		n = Libreria.leerPositivo("Introduzca el número de filas");
		m = Libreria.leerPositivo("Introduzca el número de columnas");

		matriz = new int[n][m];

		construirMatriz(matriz, n, m);

		boolean relleno = false;
		int anterior, actual, valorEfecto;
		valorEfecto = 0;
		anterior = matriz[1][1];

		for (int i = 1; i < n - 1; i++) {
			for (int j = 2; j < m - 1; j++) {
				actual = matriz[i][j];

				if (actual == anterior) {
					relleno = true;
					valorEfecto = anterior;
				}

			}
		}
		if (relleno) {
			Pantalla.escribirString("Su matriz tiene efecto de relleno y es de factor " + valorEfecto);

		} else {
			Pantalla.escribirString("Su matriz no tiene efecto de relleno");
		}
	}

	public static void construirMatriz(int[][] matriz, int n, int m) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matriz[i][j] = Teclado.leerInt("Introduzca un número");

			}
		}
	}
}
