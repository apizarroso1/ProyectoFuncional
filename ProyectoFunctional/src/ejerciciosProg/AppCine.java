package ejerciciosProg;
import java.util.ArrayList;
import daw.com.Teclado;
import daw.com.Pantalla;
public class AppCine {

	public static void main(String[] args) {
		ArrayList<Pelicula> pelis;
		Pelicula p;
		
		pelis = new ArrayList<>();
		
		do {
			
			p = new Pelicula();
			do {
				p.leerTitulo();
				
			} while (pelis.contains(p));
			
		} while (Teclado.leerString("Desea continuar (s/n)").equals("s"));

	}
}
