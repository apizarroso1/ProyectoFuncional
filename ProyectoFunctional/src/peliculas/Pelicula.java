package peliculas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

import daw.com.Teclado;
import institutoMio.LeerYMostrarDatos;

public class Pelicula implements LeerYMostrarDatos{
	
	private static final Genero GENERO = Genero.AVENTURA;
	
	private String cod;
	private String titulo;
	private Genero genero;
	private HashSet<String> etiquetas;
	private float precio;
	private LocalDate creacion;
	private LocalDate estreno;
	
	public Pelicula(String cod, String titulo, Genero genero, float precio, LocalDate creacion, LocalDate estreno, HashSet<String> etiquetas) {
		this.cod = cod;
		this.titulo = titulo;
		this.genero = genero;
		this.precio = precio;
		this.creacion = creacion;
		this.estreno = estreno;
		this.etiquetas = etiquetas;
	}
	
	public Pelicula() {
		this("", "", GENERO, 0, LocalDate.now().minusDays(3), LocalDate.now(), new HashSet<>());
	}
	
	public Pelicula(String cod) {
		this(cod,"", GENERO, 0, LocalDate.now().minusDays(3), LocalDate.now(), new HashSet<>());
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public HashSet<String> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(HashSet<String> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getCreacion() {
		return creacion;
	}

	public void setCreacion(LocalDate creacion) {
		this.creacion = creacion;
	}

	public LocalDate getEstreno() {
		return estreno;
	}

	public void setEstreno(LocalDate estreno) {
		
		if (estreno.isBefore(creacion)){	
			estreno = creacion.plusDays(1);
		}
		
		this.estreno = estreno;
	}

	@Override
	public void leerClave() {
		this.cod = Teclado.leerString("\nCodigo de la pelicula");
		
	}

	@Override
	public void leerOtrosDatos() {
		this.titulo = Teclado.leerString("\nTitulo de la pelicula");
		this.genero = leerGenero();
		this.precio = Teclado.leerFloat("\nPrecio");
		this.etiquetas = leerEtiquetas();
		leerFechas();
		
	}
	
	public void leerFechas() {
		LocalDate fechaCreacion, fechaEstreno;
		String formatoEnString;
		DateTimeFormatter formato;
		
		formatoEnString = "dd/mm/yyyy";
		
		formato = DateTimeFormatter.ofPattern(formatoEnString);
		
		System.out.println("Fecha de creacion");
		fechaCreacion = LocalDate.parse(Teclado.leerString(formatoEnString), formato);
		
		do {
			System.out.println("Fecha de estreno");
			fechaEstreno = LocalDate.parse(Teclado.leerString(formatoEnString), formato);
		} while (fechaCreacion.isAfter(fechaEstreno));
				
		this.creacion = fechaCreacion;
		this.estreno = fechaEstreno;
	}
	
	public HashSet<String> leerEtiquetas(){
		HashSet<String> etiquetas = new HashSet<>();
		String etiqueta;
		
		do {
			etiqueta = Teclado.leerString("\nEtiqueta");
			
			etiquetas.add(etiqueta);
			
		} while (Teclado.leerString("\nContinuar: (s/n)").equalsIgnoreCase("s"));
		
		return etiquetas;
	}
	
	public Genero leerGenero() {
		String genero = "";
		ArrayList<String> generos = Genero.getValuesAsStringArrayList();
		
		do {
			for (String s : generos) {
				System.out.println(s);
			}
			
			genero = Teclado.leerString("\nSeleccione el genero").toUpperCase();
			
		} while (!generos.contains(genero));
		
		return Genero.valueOf(genero);
	}

	@Override
	public String toString() {
		return "Pelicula [cod=" + cod + ", titulo=" + titulo + ", genero=" + genero + ", etiquetas=" + etiquetas
				+ ", precio=" + precio + ", creacion=" + creacion + ", estreno=" + estreno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}	
}
