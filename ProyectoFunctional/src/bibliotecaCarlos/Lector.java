
public class Lector {

	private String dni, nombre;
	private int edad;
	
	
	//Usamos par�metros en el constructor
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
			edad = 18;
		if (edad > 120) 
			edad = 120;
		
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Lector [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
    //Leemos DNI y otros datos
	public void leerDni () {
			System.out.println("Introduce el dni:");
	}
	
	public void leerOtrosDatos () {
			System.out.println("Introduce el nombre:");
			setEdad(Libreria.leerEntre(18, 120, "Introduce edad:"));
		}
	
	
	public void leerDatos () {
			leerDni();
			leerOtrosDatos();
		}
		
	//Mostramos Datos
	public void mostrarDatos () {
			System.out.println(toString());
		}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lector other = (Lector) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	
	
}