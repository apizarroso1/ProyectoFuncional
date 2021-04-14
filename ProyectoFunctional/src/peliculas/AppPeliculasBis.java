package peliculas;

import java.util.HashSet;
import daw.com.Teclado;

public class AppPeliculasBis {
	static HashSet <Pelicula> peliculas = new HashSet<>();
	
	public static void main(String[] args) {
		String cod;
		Pelicula p;
		
		do {
			cod = Teclado.leerString("\nCodigo de la pelicula");
			p = new Pelicula(cod);
			
			if (peliculas.add(p)) {
				p.leerOtrosDatos();
			}
		} while (Teclado.leerString("\nContinuar: (s/n)").equalsIgnoreCase("s"));

		System.out.println("Las peliculas cuyo precio es mayor que 10");
		precioMayorQue10();
		System.out.println("Las peliculas cuyo genero es aventuras");
		generoAventura();
		System.out.println("Las peliculas clasificadas como divertidas");
		etiquetaDivertida();
		System.out.println("Las peliculas cuyo estreno fue hace mas de 6 meses");
		seisMesesDesdeEstreno();
		System.out.println("Las peliculas cuyo precio es mayor que 50");
		precioMayorQue50();
	}
	
	public static HashSet<Pelicula> realizarCopia(){
		HashSet<Pelicula> copia = new HashSet<>();
		
		copia.addAll(peliculas);
		
		return copia;
	}

	public static void precioMayorQue10() {
		HashSet<Pelicula> peliculasCopia;
		FiltroPrecioMayor10 filtro1 = new FiltroPrecioMayor10();
		MostrarTodos consumer = new MostrarTodos();
		
		peliculasCopia = realizarCopia();
		
		peliculasCopia.removeIf(filtro1);
		
		peliculasCopia.forEach(consumer);
		
		// Para comprobar si funciona bien
		peliculas.forEach(consumer);
	}
	
	public static void generoAventura() {
		HashSet<Pelicula> peliculasCopia;
		FiltroPorGenero filtro2 = new FiltroPorGenero();
		MostrarTodos consumer = new MostrarTodos();
		
		peliculasCopia = realizarCopia();
		
		peliculasCopia.removeIf(filtro2);
		
		peliculasCopia.forEach(consumer);
		
		// Para comprobar si funciona again
		peliculas.forEach(consumer);
	}
	
	public static void etiquetaDivertida() {
		HashSet<Pelicula> peliculasCopia;
		FiltroPorEtiquetas filtro3 = new FiltroPorEtiquetas();
		MostrarTodos consumer = new MostrarTodos();
		
		peliculasCopia = realizarCopia();
		
		peliculasCopia.removeIf(filtro3);
		
		peliculasCopia.forEach(consumer);
		
		// Para comprobar si funciona again
		peliculas.forEach(consumer);
	}
	
	public static void seisMesesDesdeEstreno() {
		HashSet<Pelicula> peliculasCopia;
		FiltroDesdeEstreno filtro4 = new FiltroDesdeEstreno();
		MostrarTodos consumer = new MostrarTodos();
		
		peliculasCopia = realizarCopia();
		
		peliculasCopia.removeIf(filtro4);
		
		peliculasCopia.forEach(consumer);
		
		// Para comprobar si funciona again
		peliculas.forEach(consumer);
	}
	
	public static void precioMayorQue50() {
		HashSet<Pelicula> peliculasCopia;
		FiltroPorPrecio50 filtro5 = new FiltroPorPrecio50();
		MostrarTodos consumer = new MostrarTodos();
		
		peliculasCopia = realizarCopia();
		
		peliculasCopia.removeIf(filtro5);
		
		peliculasCopia.forEach(consumer);
		
		// Para comprobar si funciona bien
		peliculas.forEach(consumer);
	}
}
