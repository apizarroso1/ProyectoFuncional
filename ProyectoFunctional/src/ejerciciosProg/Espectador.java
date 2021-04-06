package ejerciciosProg;
import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;

import ejerciciosDeMiguel.Libro;
public class Espectador {
	
	private String nombre;
	private int edad;
	private float cartera;
	
	//constructor
	public Espectador(String nombre, int edad, float cartera) {
		this.nombre = nombre;
		this.edad = edad;
		this.cartera = cartera;
	}
	
	public Espectador() {
		this (" ", 0, 0);
	}
	
	public Espectador (Espectador original) {
		this (original.nombre, original.edad, original.cartera);
	}
	
	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		if (edad<0) 
		{
			this.edad=0;
		}
		this.edad = edad;
	}
	
	public void setCartera(float cartera) {
		this.cartera = cartera;
	}
	
	//getters
	public String getNombre() {
		return this.nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public float getCartera() {
		return this.cartera;
	}
	
	//Métodos adicionales
	
	@Override
	public boolean equals(Object Espec) {
		
		Espectador other = (Espectador) Espec;
		return nombre.equals(other.nombre);
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", edad=" + edad + ", cartera=" + cartera + "]";
	}
	
	public void leerClave() {
		nombre = Teclado.leerString("\nNombre del espectador");
	}
	
	public void leerOtrosDatos() {
		do {
			
			edad = Teclado.leerInt("\nEdad del espectdor");
			
		} while (edad<0);
		
		do {
			
			cartera = Teclado.leerFloat("Cartera del espectador");
			
		} while (cartera<0);
	}
	
	public void mostrarDatos() {
		
		Pantalla.escribirString("\n" + toString());
		
	}
	

}
