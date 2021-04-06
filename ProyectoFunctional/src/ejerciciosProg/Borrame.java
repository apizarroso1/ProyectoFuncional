package ejerciciosProg;
import daw.com.Teclado;
import daw.com.Pantalla;
public class Borrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			Pantalla.escribirString("Hola");
		} while (Teclado.leerString("\nSigo? (s/n)").equals("s"));
	}

}
