package fechaYHorasMiguel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer1Fechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String formatoString1, formatoString2;
		DateTimeFormatter formato1,formato2, formato3;
		LocalDate fechaInicial, fechaFinal,fechaAux;
		
		formatoString1 = "dd/MM/yy";
		formatoString2 = "MM/dd/yyyy";
		
		
		formato1 = DateTimeFormatter.ofPattern(formatoString1);
		formato2 = DateTimeFormatter.ofPattern(formatoString2);
		
		// Leer dos fechas del teclado (elije t� el formato) 
		fechaInicial = LocalDate.parse(Teclado.leerString(formatoString1),formato1);
		fechaFinal = LocalDate.parse(Teclado.leerString(formatoString2),formato2);
		
		// Mostrar La fecha posterior con el formato : � 2 de abril de 2019�
		formato3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		// Comprobar fechas 
		if (fechaInicial.isAfter(fechaFinal))
		{
			fechaAux = fechaFinal;
			fechaFinal = fechaInicial;
			fechaInicial = fechaAux;		
		}
		Pantalla.escribirString("\n" + fechaFinal.format(formato3));
		
		
		
		//Si la diferencia de d�as entre ambas es superior a 9 meses mostrar �ya deber�a haber nacido�,
		//en caso contrario mostrar �todav�a quedan x d�as�, donde x el n�mero de d�as que quedan.
		Period intervalo = Period.between(fechaInicial, fechaFinal);
		
		Pantalla.escribirString("\nHan pasado " + intervalo.getDays() + " dias");
		Pantalla.escribirString("\nHan pasado " + intervalo.getMonths() + " meses");
		Pantalla.escribirString("\nHan pasado " + intervalo.getYears() + " anios");
		
		intervalo = intervalo.minusMonths(9);
		if (intervalo.isNegative())
			Pantalla.escribirString("\nTodav�a quedan " + ChronoUnit.DAYS.between(fechaInicial, fechaFinal)+" d�as");
		else
			Pantalla.escribirString("\nYa deber�a de haber nacido");
		
		// Si hay alguna fecha cuyo a�o sea bisiesto.
		if (fechaInicial.isLeapYear() || fechaFinal.isLeapYear())
			Pantalla.escribirString("\nHay fechas con a�o bisiesto");

		// El n�mero de domingos que hay entre las dos fechas.
		/*
		fechaAux = fechaInicial;
		int contadorDomingos = 0;
		while (fechaAux.isBefore(fechaFinal) || fechaAux.isEqual(fechaFinal))
		{
			if (fechaAux.getDayOfWeek() == DayOfWeek.SUNDAY)
				contadorDomingos ++;
			
			fechaAux = fechaAux.plusDays(1); //fechaAux++;
		}
		
		*/
		
		int contadorDomingos = 0;
		
		if (fechaInicial.getDayOfWeek() != DayOfWeek.SUNDAY)
			fechaAux = fechaInicial.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		else 
			//fechaAux = LocalDate.from(fechaInicial); // Hacer copia de fecha
			fechaAux = fechaInicial;
		
		
		while (fechaAux.isBefore(fechaFinal) || fechaAux.isEqual(fechaFinal))
		{
			contadorDomingos++;
			fechaAux = fechaAux.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		}
		
		Pantalla.escribirString("\nN� de domingos " + contadorDomingos);

		
		Pantalla.escribirString("\nN� de semanas " + ChronoUnit.WEEKS.between(fechaInicial, fechaFinal));
		Pantalla.escribirString("\nN� de meses " + ChronoUnit.MONTHS.between(fechaInicial, fechaFinal));
		
	}

}
