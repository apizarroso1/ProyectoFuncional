package ed1;
//Libreria de Miguel
import daw.com.Pantalla;
import daw.com.Teclado;

public class Coche {
	
	//Atributos
	private String color;
	private String fabricante;
	private String matricula;
	private int edad;
	
	//Constructor 1: por defecto
	public Coche() {
		this.color = "Blanco";
		this.fabricante = "Ninguno";
		this.matricula = "0000 AAA";
		this.edad = 0;
	}
	
	//Constructor 2: por 2 par�metros
	public Coche(String color, int edad) {
		this.color = color;
		this.edad = edad;
	}
	
	//Constructor 3: por todos los par�metros posibles
	public Coche(String color,String fabricante, String matricula, int edad) {
		this.color = color;
		this.fabricante = fabricante;
		this.matricula = matricula;
		this.edad = edad;
	}
	
	//M�todos getters
	public String getColor() {
		return this.color;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	//M�todos setters
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//M�todos de opciones
	public int valorarCoche(int edad) {
		int valor = 0;
		
		if (edad > 25) {
			valor = 10000;
		}
		else {
			if (edad > 20) {
				valor = 5000;
			}
			else {
				if (edad > 15) {
					valor = 500;
				}
				else {
					if (edad > 10) {
						valor = 1000;
					}
					else { 
						valor = 10000;
					}
				}
			}
		}
		return valor;
	}
	
	public void conducirCoche() {
		Pantalla.escribirString("Sonidos de conducción");
	}
	
	public void venderCoche(int valor) {
		Pantalla.escribirInt("Te pagan", valor);
	}
}
