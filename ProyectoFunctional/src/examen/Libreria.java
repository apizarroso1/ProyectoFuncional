package examen;
import java.time.LocalDate;

import daw.com.Teclado;

public class Libreria {
	
	public static int leerPositivo (String mensaje)
	{
		int valor;
		
		do
		{
			valor = Teclado.leerInt(mensaje);
		}while (valor <= 0);
		
		return valor;
	}
	
	public static int aleatorio (int minimo, int maximo)
	{
		int valor;
		int intervalo;
		
		intervalo = maximo  - minimo;
		
		valor = (int)(Math.random() * (intervalo+1)) + minimo;
		
		return valor;
	}
	
	public static int leerEntre (int minimo, int maximo, String mensaje)
	{
		int valor;
		
		do
		{
			valor = Teclado.leerInt(mensaje);
		}while (valor < minimo || valor > maximo);
		
		
		return valor;
	}
	
	public static void esperar1Segundo ()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean esBisiesto (int year)
	{
		boolean bisiesto = false;
		
		if (((year % 4 == 0)&& (year % 100 != 0)) 
				|| (year % 400 == 0))
			bisiesto = true;
		
		return bisiesto;
		
	}
	
	public static int diaDeLaSemana(int anio, int mes, int dia)
	{
		int diaDeLaSemana;
		LocalDate fecha = LocalDate.of(anio, mes, dia);
		
		diaDeLaSemana = fecha.getDayOfWeek().getValue();
		
		return diaDeLaSemana;
	}

}
