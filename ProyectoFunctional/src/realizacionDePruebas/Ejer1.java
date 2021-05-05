package realizacionDePruebas;

import java.util.Scanner;

public class Ejer1 {

	public static void main(String[] args) {

		/*
		 * Implementa un programa en java que lea por teclado 10 numeros entre el 0 y el
		 * 100, ambos inclusive, y devuelva por pantalla la media de los números. Se
		 * puede introducir cualquier valor pero los que no estén en el rango no se
		 * tendrán en cuenta ni para contabilizar los 10 números ni para calcular la
		 * media. Realiza su grafo de flujo y calcula su complejidad ciclomática.
		 */

		int[] numeros = new int[10];

		leerNumeros(numeros);

		System.out.println(calcularMedia(numeros));

	}

	public static void leerNumeros(int[] numeros) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = sc.nextInt();
		}

		sc.close();
	}

	public static float calcularMedia(int[] numeros) {
		int contador = 0;
		int acumulador = 0;

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] >= 0 && numeros[i] <= 100) {
				contador++;
				acumulador = +numeros[i];
			}
		}

		return acumulador / contador;
	}

}
