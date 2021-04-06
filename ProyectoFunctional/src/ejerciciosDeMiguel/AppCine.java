import java.util.ArrayList;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppCine {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Espectador> espectadores;
		ArrayList<Pelicula> pelis;
		Cine cine;
		
		espectadores = leerEspectadores ();
		pelis = leerPeliculas ();
		
		cine = leerCine (pelis);
		
		venderEntradas (cine, espectadores);
		
		cine.mostrarButacas();
		

	}

	public static void venderEntradas(Cine cine, ArrayList<Espectador> espectadores) {
		// TODO Auto-generated method stub
		boolean seguir = true;
		Espectador espectador;
		int fila, columna;
		
		while (cine.butacasLibres()> 0 && seguir)
		{
			espectador = leerEspectador (espectadores);
			if (espectador.getSaldo() > cine.getPrecioEntrada() &&
					espectador.getEdad() >= cine.getPelicula().getEdad())
			{
				do
				{
					cine.mostrarDatos();
					fila = Teclado.leerInt("fila? ");
					columna = Teclado.leerInt("columna? ");
				}while (!cine.butacaLibre(fila, columna));
				
				cine.setButaca(fila, columna, espectador);
				
				espectador.setSaldo(espectador.getSaldo() - cine.getPrecioEntrada());
				
				Pantalla.escribirString("\nEntrada vendida en fila " + fila  
								+ " y columna " + columna);
			}
			else
				Pantalla.escribirString("\nEl espectador no cumple condiciones de entrada");
				
			seguir = Teclado.leerString("\nContinuar?(s/n)").equals("s");
		}
		
	}

	public static Cine leerCine(ArrayList<Pelicula> pelis) {
		// TODO Auto-generated method stub
		
		int filas, columnas;
		float precio;
		Pelicula peli;
		Cine cine;
		
		
		filas = Libreria.leerPositivo("\nFilas del cine ");
		columnas = Libreria.leerPositivo("\nColumnas del cine ");
		
		precio = Teclado.leerFloat("\nPrecio de la entrada ");
		
		peli = leerPelicula (pelis);
		
		
		cine = new Cine (precio, filas, columnas);
		cine.setPelicula(peli);
		
		return cine;
	}

	public static Pelicula leerPelicula (ArrayList<Pelicula> pelis)
	{
		Pelicula peli;
		int cual;
		
		do
		{
			peli = new Pelicula ();
			for (Pelicula p: pelis)
				Pantalla.escribirString("\n" + p.getTitulo());
			peli.leerClave();
			cual = pelis.indexOf(peli);
		}while ( cual < 0);
		
		return pelis.get(cual);
	}
	
	public static Espectador leerEspectador (ArrayList<Espectador> espectadores)
	{
		Espectador espectador;
		int cual;
		
		do
		{
			espectador = new Espectador ();
			for (Espectador e: espectadores)
				Pantalla.escribirString("\n" + e.getNombre());
			espectador.leerClave();
			cual = espectadores.indexOf(espectador);
		}while ( cual < 0);
		
		return espectadores.get(cual);
	}
	
	public static ArrayList<Pelicula> leerPeliculas() {
		// TODO Auto-generated method stub
		ArrayList<Pelicula> pelis = new ArrayList<>();
		Pelicula p;
		
		do
		{
			p = new Pelicula();
			do {
				p.leerClave();
			} while (pelis.contains(p));
			p.leerOtrosDatos();
			pelis.add(p);
		}while (Teclado.leerString("\nSigo?(s/n)").equals("s"));
		
		
		
		return pelis;
	}

	public static ArrayList<Espectador> leerEspectadores() {
		// TODO Auto-generated method stub
		ArrayList<Espectador> espectadores = new ArrayList<>();
		Espectador e;
		
		do
		{
			e = new Espectador();
			do {
				e.leerClave();
			} while (espectadores.contains(e));
			e.leerOtrosDatos();
			espectadores.add(e);
		}while (Teclado.leerString("\nSigo?(s/n)").equals("s"));
		
		
		
		return espectadores;
	}

	
	
}
