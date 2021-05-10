package bibliotecaReche;
import java.util.Scanner;

public class Lector {
	private String dni, nombre;
	private int edad;
	
	

	public Lector(String dni, String nombre, int edad) {
		
		this.dni = dni;
		this.nombre = nombre;
		setEdad(edad);
	}
	
	public Lector (String dni) {
		
		this (dni,"",18);
	}

	public Lector () {
		this ("","",18);
	}


	public Lector (Lector original) {
		
		this (original.dni, original.nombre, original.edad);
	}
	
	

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
	
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 18)
			edad=18;
		if (edad > 120) 
			edad =120;
		
		this.edad = edad;
	}


	public String toString() {
		return "Lector [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	public void leerDni () {
		Scanner sc = new Scanner(System.in);
			dni = sc.next("Por favor Introduzca el dni:");
	}
	public void leerOtrosDatos () {
		Scanner sc = new Scanner(System.in);
			nombre = sc.next("Por favor Introduzca el nombre:");
			setEdad(Libreria2.leerEntre(18, 120, "Por favor itroduzca su edad"));
		}
	
	public void leerDatos () {
			leerDni();
			leerOtrosDatos();
		}
		

	public void mostrarDatos () {
			System.out.println("\n" + toString ());
		}


	public boolean equals(Object obj) {
		Lector l = (Lector) obj;
			
		return this.dni.equals(l.getDni());
	}
}
