package ed1;

import java.util.Scanner;

public class InterfazUsuario {
	public static void mostrarInicio() {
		System.out.println("--------------------------------");
		System.out.println("\nINICIO DEL PROGRAMA CALCULADORA");
		System.out.println("\n--------------------------------");
	}

	public static void mostrarFin() {
		System.out.println("\n--------------------------------");
		System.out.println("\nFIN DEL PROGRAMA CALCULADORA");
		System.out.println("\n--------------------------------");
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void mostrarMenu()
	{
		int seleccion = 0;
		do
		{
			System.out.println("\n[1] Suma");
			System.out.println("\n[2] Resta");
			System.out.println("\n[3] Multiplicaci�n");
			System.out.println("\n[4] Divisi�n");
			System.out.println("\n[5] Potencia");
			System.out.println("\n[6] M�ximo");
			System.out.println("\n[7] M�nimo");
			System.out.println("\n[8] Ra�z");
			System.out.println("\n[9] Salir");
			
			seleccion = leerOpcion(seleccion);
			
			switch (seleccion)
			{
			case 1: Operaciones.sumar();
			break;
			case 2: Operaciones.restar();
			break;
			case 3: Operaciones.multiplicar();
			break;
			case 4: Operaciones.dividir();
			break;
			case 5: Operaciones.potencia();
			break;
			case 6: Operaciones.maximo();
			break;
			case 7: Operaciones.minimo();
			break;
			case 8: Operaciones.raiz();
			break;
			case 9: mostrarFin();
			break;
			default: System.out.println("\nSelecci�n inv�lida");
			}
			
		} while (seleccion != 9);

	}

	public static int leerOpcion(int seleccion)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nIntroduzca su selecci�n");
		
		seleccion = sc.nextInt();
		
		Validacion.validarOpcion(seleccion);
		
		return seleccion;
	}

	public static float leerNumero()
	{
		float num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nIntroduzca un n�mero");
		num = sc.nextFloat();
		
		return num;
		
	}

	public static void escribirResultado(float resultado)
	{
		System.out.println("El resultado de la operaci�n es: " + resultado);
	}

	public static void solicitarConfirmacion()
	{
		
	}
}
