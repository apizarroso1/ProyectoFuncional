import daw.com.Pantalla;
import daw.com.Teclado;

public class Espectador {
	private String nombre;
	private int edad;
	private float saldo;
	
	public Espectador(String nombre, int edad, float saldo) {
	
		this.nombre = nombre;
		setEdad (edad);
		setSaldo (saldo);
	}
	
	public Espectador ()
	{
		this ("",0,0);
	}
	
	public Espectador (String nombre)
	{
		this (nombre, 0, 0);
	}
	
	public Espectador (Espectador original)
	{
		this (original.nombre, original.edad, original.saldo);
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
		if (edad < 0)
			edad = 0;
		this.edad = edad;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		if (saldo < 0)
			saldo = 0;
		this.saldo = saldo;
	}

	@Override
	public boolean equals(Object obj) {
		Espectador other = (Espectador) obj;
		return nombre.equals(other.nombre);
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", edad=" + edad + ", saldo=" + saldo + "]";
	}
	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerClave ()
	{
		nombre = Teclado.leerString("\nnombre espectador ");
	}
	
	public void leerOtrosDatos ()
	{
		do
		{
			edad = Teclado.leerInt("Edad espectador ");
		}while (edad < 0);
		
		do 
		{
			saldo = Teclado.leerFloat("Saldo espectador ");
			
		}while (saldo < 0);
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}

}
