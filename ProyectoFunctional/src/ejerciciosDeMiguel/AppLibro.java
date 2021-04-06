package ejerciciosDeMiguel;

import java.util.ArrayList;

import daw.com.Teclado;
public class AppLibro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Libro> libros;
		Libro l, mayor;
		
		
		libros = new ArrayList<>();
		
		do
		{
			l = new Libro ();
			do 
			{
				l.leerIsbn();
			}while (libros.contains(l));
			l.leerRestoDatos();
			
			libros.add(l);
			
		}while (Teclado.leerString("sigo?(s/n)").equals("s"));
		
		
		mayor = libros.get(0);
		
		for (int i = 0; i < libros.size(); i++)
			if (mayor.getnPaginas() < libros.get(i).getnPaginas())
				mayor = libros.get(i);
		
		
		mayor.mostrarDatos();
		
		ordenar (libros);
		
		for (Libro b: libros)
			b.mostrarDatos();
		
	}
	
	public static void ordenar (ArrayList<Libro> libros)
	{
		Libro aux;
		
		for (int i = 0; i < libros.size()-1; i++)
			for (int j = i + 1; j < libros.size(); j++)
				if (libros.get(j).getTitulo(). //libros[j].getTitulo()
						compareTo(libros.get(i).getTitulo())> 0)
				{
					aux = libros.get(j); //aux = libros[j]
					libros.set(j,libros.get(i)); // libros[j] = libros[i]
					libros.set(i, aux); //libros[i] = aux
				}
				
			
	}

}
