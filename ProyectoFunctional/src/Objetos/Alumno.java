package Objetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumno {

	private String nombre;
	private int edad;
	private float nota;


	// Constructor por defecto
	public Alumno()
	{
		nombre = "indefinido";
		edad = 18;
		nota = 1;
	}

	public Alumno(String name, int age, float mark) // Constructor con par�metros
	{
		nombre = name;
		setEdad(age); 
		setNota(mark); 
	}

	public Alumno(String name) {
		nombre = name;
		edad = 18;
		nota = 1;
	}

	// Modificador de nombre
	public void setNombre(String name)
	{
		nombre = name;
	}

	// Selector de nombre
	public String getNombre() 
	{
		return nombre;
	}

	public void setEdad(int age) {
		if (age > 80)
			age = 80;
		else if (age < 18)
			age = 18;

		edad = age;
	}

	public int getEdad() {
		return edad;
	}

	public void setNota(float mark) {
		if (mark > 10)
			mark = 10;
		else if (mark < 1)
			mark = 1;

		nota = mark;
	}

	public float getNota() {
		return nota;
	}

	public void mostrarDatos() {
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("nombre " + nombre);
		Pantalla.escribirString("\tnota " + nota);
		Pantalla.escribirString("\tedad " + edad);
		Pantalla.escribirSaltoLinea();
	}

	public void leerDatos() {
		nombre = Teclado.leerString("nombre ");
		setEdad(Teclado.leerInt("edad "));
		setNota(Teclado.leerFloat("nota "));
	}

	public boolean estaAprobado() {
		boolean aprobado = false;
		if (nota >= 4.5)
			aprobado = true;
		return aprobado;
	}
}

