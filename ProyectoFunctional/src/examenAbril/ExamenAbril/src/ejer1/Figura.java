package ejer1;

import java.util.ArrayList;

import daw.com.Teclado;

public abstract class Figura implements LeerYMostrarDatos{
	private int grosor;
	private Color color;
	private String nombre;
	private Punto centro;
	
	public Figura(int grosor, Color color, String nombre, Punto centro) {
		this.grosor = grosor;
		this.color = color;
		this.nombre = nombre;
		this.centro = centro;
	}

	public Figura(String nombre) {
		this.grosor = 0;
		this.color = null;
		this.nombre = nombre;
		this.centro = new Punto();
	}
	
	public Figura() {
		this.grosor = 0;
		this.color = null;
		this.nombre = "";
		this.centro = new Punto();
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public int getGrosor() {
		return grosor;
	}

	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Figura [grosor=" + grosor + ", color=" + color + ", nombre=" + nombre + ", centro=" + centro + "]";
	}

	@Override
	public void leerClave() {
		this.nombre = Teclado.leerString("\nNombre");
		
	}

	@Override
	public void leerOtrosDatos() {
		this.grosor = Teclado.leerInt("\nGrosor");
		this.color = leerColor();
		this.centro.leerDatos();
	}

	public Color leerColor() {
		String color = "";
		ArrayList <String> colores = Color.asString();
		
		do {
			Color.mostrarDatos();
			
			color = Teclado.leerString("\nEscoja su color");
			
		} while (!colores.contains(color));
	
		return Color.valueOf(color);
	}

	@Override
	public boolean equals(Object obj) {	
		Figura other = (Figura) obj;
	
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public abstract double calcularArea();
	
	public void trasladarCentro() {
		Punto nuevoCentro = new Punto();
		
		nuevoCentro.leerDatos();
		
		setCentro(nuevoCentro);
	}
}
