package ejer1;

import libreria.Libreria;

public class Circulo extends Figura{
	private float radio;

	public Circulo(int grosor, Color color, String nombre, Punto centro, float radio) {
		super(grosor, color, nombre, centro);
		this.radio = radio;
	}
	
	public Circulo(String nombre) {
		super(0, null, nombre, new Punto());
		this.radio = 0;
	}
	
	public Circulo() {
		super(0, null, "", new Punto());
		this.radio = 0;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}
	
	public void leerDatos() {
		super.leerDatos();
		this.radio = Libreria.leerPositivo("\nRadio");
	}

	@Override
	public double calcularArea() {
		double area;
		
		area = Math.PI * radio * radio;
		
		return area;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", toString()=" + super.toString() + "]";
	}
}
