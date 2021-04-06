package ejerciciosProg;

import java.util.Arrays;
import java.util.Iterator;

import daw.com.Pantalla;

public class Cine {
	
	private final static int FILAS = 3;
	private final static int COLUMNAS = 3;
	private final static String LIBRE = "O";
	private final static String OCUPADA = "X";

	private Espectador [][] butacas;
	private float precio;
	private Pelicula peli;
	
	public Cine(float precio, Espectador[][] butacas, Pelicula peli) {
		
		setPrecio (precio);
		this.butacas = new Espectador [butacas.length] [];
		for (int i = 0; i < butacas[i].length; i++)
		{
			this.butacas[i] = new Espectador[butacas[i].length];
		}
		
		for (int i = 0; i < butacas.length; i++) 
		{
			for (int j = 0; j < butacas[i].length; j++) 
			{
				this.butacas[i][j] = butacas [i][j];
			}	
		}
		
		this.peli = peli;
	}
	
	public Cine ()
	{
		this (0);
	}
	
	public Cine (float precio)
	{
		this (precio, FILAS, COLUMNAS);
	}
	
	public Cine (float precio, int filas, int columnas)
	{
		setPrecio (precio);
		if (filas < 1)
		{
			filas = 1;		
		}
		
		if (columnas < 1)
		{
			columnas = 1;
		}
		
		butacas = new Espectador[filas][columnas];
		for (int i = 0; i < filas; i++) 
		{
			for (int j = 0; j < columnas; j++) 
			{
				butacas[i][j] = null;
			}
		}
		
		this.peli = new Pelicula();
		
	}
		
	public Cine ( Cine original)
	{
		this (original.precio, original.butacas, original.peli);
	}
	
	public void setPrecio(float precio)
	{
		if (precio < 0)
		{
			precio = 0;
		}
		this.precio = precio;
	}
	
	public void setPeli(Pelicula peli)
	{
		this.peli = peli;
	}
	
	public float getPrecio()
	{
		return precio;
	}
	
	public Pelicula getPeli()
	{
		return peli;
	}
	
	public int getFilas()
	{
		return butacas.length;
	}
	
	public int getColumnas()
	{
		return butacas[0].length;
	}
	
	private int comprobarFila (int fila)
	{
		if (fila < 0)
		{
			fila = 0;
		}
		else if (fila >= butacas.length)
		{
			fila = butacas.length - 1;
		}
		
		return fila;
	}
	
	private int comprobarColumna (int columna)
	{
		if (columna < 0)
		{
			columna = 0;
		}
		
		else if (columna >= butacas[0].length)
		{
			columna = butacas[0].length - 1;
		}
		
		return columna;
	}
	
	public Espectador getButaca (int fila, int columna)
	{
		fila = comprobarFila(fila);
		columna = comprobarColumna (columna);
		
		return butacas[fila][columna];
	}
	
	public void setButaca (int fila, int columna, Espectador espectador)
	{
		butacas[comprobarFila(fila)][comprobarColumna(columna)] = espectador;
	}
	
	public boolean butacaLibre (int fila, int columna)
	{
		fila = comprobarFila(fila);
		columna = comprobarColumna(columna);
		
		return butacas[fila][columna] == null;
	}
	
	public int butacasLibres()
	{
		int libres = 0;
		
		for (int i = 0; i < butacas.length; i++) 
		{
			for (int j = 0; j < butacas[i].length; j++) 
			{
				if (butacaLibre(i,j))
				{
					libres++;
				}
			}
		}
		
		return libres;
		
	}
	
	public int totalButacas()
	{
		int total = 0;
		
		for (int i = 0; i < butacas.length; i++) 
		{
			for (int j = 0; j < butacas.length; j++) 
			{
				total++;
			}
		}
		
		return total;
		
	}
	
	public int butacasOcupadas()
	{
		return totalButacas() - butacasLibres();
	}
	
	public void mostrarButacas ()
	{
		String simbolo;
		
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("\t");
		
		for (int i = 0; i < butacas[0].length; i++) 
		{
			Pantalla.escribirString("\t" + i);
		}
		
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("\t");
		
		for (int i = 0; i < butacas[0].length; i++) 
		{
			Pantalla.escribirString("\t-");
		}
		
		Pantalla.escribirSaltoLinea();
		
		for (int i = butacas.length - 1; i >= 0; i--) 
		{
			Pantalla.escribirString("\t" + i + "|");
			
			for (int j = 0; j < butacas[i].length; j++) 
			{
				simbolo = butacaLibre (i,j) ?LIBRE:OCUPADA;
				Pantalla.escribirString("\t" + simbolo);
			}
			Pantalla.escribirSaltoLinea();
		}
	}

	@Override
	public String toString() {
		return "Cine [precio=" + precio + ", peli=" + peli.getTitulo() + "]";
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirString("\n" + toString());
		mostrarButacas();
	}
	
}
