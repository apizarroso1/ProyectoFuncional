
public class Lector {

	private String dni, nombre;
	private int edad;
	
	
	//Usamos parámetros en el constructor
	public Lector(String dni, String nombre, int edad) {
		
		this.dni = dni;
		this.nombre = nombre;
		setEdad(edad);
	}
	
	//Para el Dni
	public Lector (String dni) {
		
		this (dni,"",18);
	}
	
	//Costructor por defecto 
	
	public Lector () {
		this ("","",18);
	}

	//Costructor copia
	public Lector (Lector original) {
		
		this (original.dni, original.nombre, original.edad);
															}
	
	
	//Selectores y modificadores
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

	//Usamos este método para evitar errores en la ejecución del programa
	@Override
	public String toString() {
		return "Lector [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
    //Leemos DNI y otros datos
	public void leerDni () {
			System.out.println("\n Introduce el dni:");
	}
	
	public void leerOtrosDatos () {
			System.out.println("\n Introduce el nombre:");
			setEdad(Libreria2.leerEntre(18, 120, "\n Introduce edad:"));
		}
	
	
	public void leerDatos () {
			leerDni();
			leerOtrosDatos();
		}
		
	//Mostramos Datos
	public void mostrarDatos () {
			System.out.println("\n" + toString ());
		}

	@Override
	public boolean equals(Object obj) {
		Lector l = (Lector) obj;
			
		return this.dni.equals(l.getDni());
	}
	
	
	
	
}