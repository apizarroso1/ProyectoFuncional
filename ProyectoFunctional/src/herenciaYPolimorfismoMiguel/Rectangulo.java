package herenciaYPolimorfismoMiguel;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Rectangulo extends Figura {
	
	private int base;
	private int altura;


	public Rectangulo ()
	{
		//this ("",0,0,0,0);
		super ();
		base = 0;
		altura = 0;
	
	}
	
	public Rectangulo (String nombre)
	{
		this (nombre,0,0,0,0);
	}
	
	public Rectangulo(String nombre, int base, int altura, int grosor, int color) {

		super (nombre,grosor,color);
		this.base = base;
		this.altura = altura;
		
		
	}
	
	public Rectangulo (Rectangulo r)
	{
		super (r); // Constructor copia del padre
		this.altura = r.altura;
		this.base = r.base;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}


	@Override
	public String toString() {
		return super.toString() +
				"Rectangulo [" + 
				", base=" + base + 
				", altura=" + altura +   
				"area = " + calcularArea() + "]";
	}
	
	public int calcularArea() 
	{
		return base* altura;
	}
	
	public int calcularPerimetro ()
	{
		return 2*(base + altura);
	}
	
	@Override
	public void leerDatos ()
	{
		super.leerDatos();
		base = Teclado.leerInt("base");
		altura = Teclado.leerInt("altura");
	}

}
