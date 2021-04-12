package fechaYHoras;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import daw.com.Teclado;

public class Ejer2 {

	public static void main(String[] args) {
		String formato;
		DateTimeFormatter formato1;
		LocalTime hora, salida;
		
		formato = "hh:mm:ss";
		
		formato1 = DateTimeFormatter.ofPattern(formato);
		
		hora = LocalTime.parse(Teclado.leerString(formato), formato1);
		
		salida = LocalTime.of(21, 15, 00);
		
		
	}

}
