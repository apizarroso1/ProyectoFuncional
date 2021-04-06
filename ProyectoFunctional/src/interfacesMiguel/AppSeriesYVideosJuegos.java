package seriesYvideojuegos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppSeriesYVideosJuegos {

	private ArrayList <Entregable> entregables;
	
	
	public AppSeriesYVideosJuegos() {
		entregables = new ArrayList<>();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppSeriesYVideosJuegos app = new AppSeriesYVideosJuegos();
		app.cargarDatos ();
		
		
		app.entregar ();
		
		app.contar ();
		
		app.devolver ();
		
		app.mostrarMaximos ();
		
	}
	
	public void cargarDatos ()
	{
		Entregable entregable;
		int tipo;
		
		for (int i = 0; i < 4; i++)
		{
			tipo = Teclado.leerInt("1. Serie 2. VideoJuego");
			
			if (tipo == 1)
			{
				/*
				entregable = new Serie ();
				((Serie)entregable).leerDatos();
				*/
				
				Serie s = new Serie ();
				s.leerDatos();
				entregable = s;
			}
			else
			{
				VideoJuego v = new VideoJuego ();
				v.leerDatos();
				entregable = v;
				
			}
			
			// No compruebo si ya está otro con el mismo título
			if (!existeEntregable(entregable))
				entregables.add(entregable);
			else
				Pantalla.escribirString("\nYa existe");
		}
		
	}
	
	public boolean existeEntregable (Entregable e)
	{
		boolean existe = false;
		String titulo;
		
		if (e instanceof Serie)
			titulo = ((Serie)e).getTitulo();
		else
			titulo = ((VideoJuego)e).getTitulo();
		
		if (buscarPorTituloBueno(titulo) != null)
			existe = true;
		
		return existe;
	}
	
	public void entregar ()
	{
		
		String titulo;
		Entregable e;
		do
		{
			
			titulo = Teclado.leerString("t�tulo a entregar");
			e = buscarPorTituloBueno (titulo);
			if (e!= null)
			{
				e.entregar();
				Pantalla.escribirString("\nEntregado un " + e.getClass().getSimpleName() );
			}
			else
				Pantalla.escribirString("\nNo existe " + titulo);
		}while (Teclado.leerString("\nSeguir? (s/n)").equals("s"));
	}
	
	public Entregable buscarPorTitulo (String titulo)
	{
		// No funciona
		Entregable e = null;
		int lugar;
		lugar = entregables.indexOf (new Serie (titulo,""));
		if (lugar >= 0)
			e = entregables.get(lugar);
		
		return e;
	}
	
	public Entregable buscarPorTituloBueno (String titulo)
	{
		
		Entregable e, aux;
		e = null;
		
		
		for (int i = 0; i < entregables.size() && e == null; i++)
		{
			if (entregables.get(i) instanceof Serie)
				aux = new Serie (titulo,"");
			else
				aux = new VideoJuego(titulo,0);
				
			if (aux.equals(entregables.get(i)))
				e = entregables.get(i);
		}
		
		return e;
	}
	
		
	public void contar ()
	{
		int cuantos = 0;
		
		for (Entregable e: entregables)
		{
			if (e.isEntregado())
				cuantos++;
		}
		
		
		Pantalla.escribirString("\n\nHay entregados " + cuantos + " productos");
		Pantalla.escribirString("\nListado de productos");
		for (Entregable e : entregables)
			Pantalla.escribirString("\n"+ e);
		
		
	}
	
	public void devolver ()
	{
		for (Entregable e: entregables)
			if (e.isEntregado())
				e.devolver();
		
		Pantalla.escribirString("\n\nSe han devuelto todos los no entregados");
	}
	
	public void mostrarMaximos ()
	{
		List<Entregable> series, videojuegos;
		Predicate <Entregable> esSerie, esVideoJuego;
		Serie serie;
		VideoJuego videojuego;
		
		// Copiar entregables en series
		series = new ArrayList<> ();
		series.addAll(entregables);
		
		// Copiar entregables en videojuegos
		videojuegos = new ArrayList<>();
		videojuegos.addAll(entregables);
		
		// Filtro de series
		esSerie = new EsSerie ();
		
		// Filtro de Videojuegos
		esVideoJuego = new EsVideoJuego ();
		
		
		series.removeIf(esVideoJuego); // borrar todos los videojuegos
		videojuegos.removeIf(esSerie); // borrar todas las series
		
		serie = (Serie) Collections.max(series,new ComparadorPorTemporadas());
		videojuego = (VideoJuego) Collections.max(videojuegos,new ComparadorHoras());
		
	
		Pantalla.escribirString("\nLa serie con m�s temporadas es " + serie);
		Pantalla.escribirString("\nEl videojuego con m�s horas es " + videojuego);
	}
	

}
