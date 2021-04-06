/**
 * 
 */
package ed1;

/**
 * @author anmar
 *
 */
public class Persona {

	//Atributos --> Estructura
	private String nombre;
	private String apellidos;
	private int edad;
	private float altura;
	private float peso;
	
	// Constructor vac�o
	public void Persona() {
		this.nombre = "Desconocido";
		this.apellidos = "Desconocidos";
		this.edad = 0;
		this.altura = 0;
		this.peso = 0;		
	}
	
	// Constructor con par�metros
	public void Persona(String nombre , String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;		
	}
	
	//Constructor con m�s par�metros
	public void Persona(String nombre, String apellidos, int edad, float peso) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.peso = peso;
	}
	
	//M�todos getter
	public String getnombre() {
		return this.nombre;
	}
	
	public String getapellidos() {
		return this.apellidos;
	}
	
	public int getedad() {
		return this.edad;
	}
	
	public float getpeso() {
		return this.peso;
	}
	
	public float getaltura() {
		return this.altura;
	}
	
	//M�todos setter
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellidos (String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void seteEad(int edad) {
		this.edad = edad;
	} 
	
	public void setAltura (float altura) {
		this.altura = altura;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
	
	//M�todos --> comportamiento
	//M�todo caminar
	public void caminar() {
		System.out.println("Estoy caminando");
	}
	
	//M�todo hablar
	public void hablar() {
		System.out.println("Estoy hablando");
	}
	 //M�todo nacer
	public void nacer() {
		System.out.println("Hola. Acabo de nacer");
	}
	
	//M�todo morir
	public void morir() {
		System.out.println("Adi�s. Muy buenas");
	}
	
	//M�todo presentaci�n
	public void presentacion() {
		System.out.println("Mi nombre es " + this.nombre + " " + this.apellidos + "y tengo " + this.edad + 
			"a�os, y peso " + this.peso + "kilos.");
	}
	
	//M�todo saludo
	public void saludo(String mensaje) {
		System.out.println("Hola, soy" + this.nombre + " " + this.apellidos + "y quiero darte el siguiente"
			+ "mensaje: " + mensaje);
	}
	//M�todo obtener nombre completo
	public String obtenerNombreCompleto() {
		return this.nombre + " " + this.apellidos;
	}
}
