package herenciaYPolimorfismoMiguel;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Figura{
	private String nombre;
	private int grosor;
	private int color;
	
	
	public Figura (String nombre)
	{
		this (nombre, 0,0);
	}
	
	public Figura ()
	{
		this ("",0,0);
	}
	
	public Figura(String nombre, int grosor, int color) {

		this.nombre = nombre;
		this.grosor = grosor;
		this.color = color;
	}
	
	public Figura (Figura original)
	{
		this (original.nombre, original.grosor,original.color);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		if (color < 0)
			color = 0;
		else if (color > 255)
			color = 255;
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Figura other = (Figura) obj;
		return nombre.equals(other.nombre);
	}

	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + ", grosor=" + grosor + ", color=" + color + "]";
	}

	public void leerDatos ()
	{
		nombre = Teclado.leerString("nombre");
		grosor = Teclado.leerInt("grosor");
		color = Teclado.leerInt("color");
	}

		
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}

	abstract public int calcularArea ();
	
	abstract public int calcularPerimetro ();
	

}
