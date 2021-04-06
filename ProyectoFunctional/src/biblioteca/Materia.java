package biblioteca;

import java.util.Scanner;

public class Materia {
	//Atributo de la clase Materia
	private String nombre;
	
	//Constructor por defecto
	public Materia()
	{
		this.nombre = " ";
	}
	
	//Constructor por parametro
	public Materia (String nombre)
	{
		this.nombre = nombre;
	}
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Funcion para la lectura del nombre de la materia
	public void leerDatos()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNombre");
		
		this.nombre = sc.nextLine();
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		Materia other = (Materia) obj;
		return this.nombre.equals(other.nombre);
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + "]";
	}
	
	//Funcion para mostrar la materia con salto de linea
	public String mostrarMateria() {
		return "\n" + toString();
	}
	

}
