package ejerciciosDeMiguel;

import java.util.Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Libro {
	
	
	private String isbn;
	private String titulo;
	private String autor;
	private int nPaginas;
	
	public Libro ()
	{
		this ("", "", "", 0);
	}
	

	public Libro (String isbn)
	{
		this (isbn, "", "", 0);
	}
	
	public Libro(String isbn, String titulo, String autor, int nPaginas) {
		
		setIsbn (isbn);
		this.titulo = titulo;
		this.autor = autor;
		setnPaginas (nPaginas);
	}

	public Libro (Libro original)
	{
		this (original.isbn, original.titulo,
				original.autor, original.nPaginas);
	}



	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		
		if (isbn.length() > 13)
			isbn = isbn.substring(0, 12);
		else if (isbn.length() < 13)
		{
			while (isbn.length()< 13)
				isbn = "0" + isbn;
		}
			
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
		
				
	}

		
	public int getnPaginas() {
		return nPaginas;
	}


	public void setnPaginas(int nPaginas) {
		if (nPaginas < 50)
			nPaginas = 50;
		
		this.nPaginas = nPaginas;
	}
	
	
	
	@Override
	public String toString() {
		return "El libro " + titulo + 
				" con isbn " + isbn + 
				" creado por " + autor + 
				" tiene " + nPaginas + " paginas";
	}


	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}

	public void leerIsbn ()
	{
		setIsbn (Teclado.leerString("isbn"));
	}
	
	public void leerRestoDatos ()
	{
		
		
		titulo = Teclado.leerString("titulo");
		
		autor = Teclado.leerString("autor");
		
		setnPaginas(Teclado.leerInt("n paginas"));
	}
	
	public void leerDatos ()
	{
		leerIsbn ();
		leerRestoDatos();
	}




	@Override
	public boolean equals(Object obj) {
		Libro other = (Libro) obj;
		
		return isbn.equals(other.isbn);
			
	}
	
	
	
}
