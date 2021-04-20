package ejer1;

import libreria.Libreria;

public class Rectangulo extends Figura{
	private float base;
	private float altura;
	
	public Rectangulo(int grosor, Color color, String nombre, float base, float altura, Punto centro) {
		super(grosor, color, nombre, centro);
		this.base = base;
		this.altura = altura;
	}
	
	public Rectangulo(String nombre) {
		super(0, null, nombre, new Punto());
		this.base = 0;
		this.altura = 0;
	}
	
	public Rectangulo() {
		super(0, null, "", new Punto());
		this.base = 0;
		this.altura = 0;
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	@Override
	public void leerDatos() {
		super.leerDatos();
		this.altura = Libreria.leerPositivo("\nAltura");
		this.base = Libreria.leerPositivo("\nBase");
	}

	@Override
	public String toString() {
		return "Rectangulo [base=" + base + ", altura=" + altura + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public double calcularArea() {
		float area;
		area = base * altura;
		
		return area;
	}
}
