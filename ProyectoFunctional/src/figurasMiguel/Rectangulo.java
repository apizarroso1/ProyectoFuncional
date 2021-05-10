package ficherosherencia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Rectangulo extends Figura {
	
	private int base;
	private int altura;
	
	public Rectangulo() {
		super();
		base = 0;
		altura = 0;
	
	}



	public Rectangulo (Rectangulo original)
	{
		super(original);
		this.base = original.base;
		this.altura = original.altura;

	}

	public int getBase() {
		return base;
	}



	public void setBase(int base) {
		if (base < 0)
			base = 0;
		
		this.base = base;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int altura) {
		if (altura < 0)
			altura = 0;
		this.altura = altura;
	}



		public void leerOtrosDatos ()
	{
		super.leerOtrosDatos();	
		setBase (Teclado.leerInt("base:"));
		setAltura (Teclado.leerInt("altura:"));
			
	}
	
		
		
	@Override
		public String toString() {
			return "Rectangulo [base=" + base + ", altura=" + altura + ", toString()=" + super.toString() + "]";
		}



	public void mostrarDatos()
	{
		super.mostrarDatos();
		Pantalla.escribirInt("\nbase :" , base);
		Pantalla.escribirInt("\naltura :" , altura);

		
	}
	
	public float getArea()
	{
		return base * altura;
	}
	

	public void leerFichero (DataInputStream fichero) throws IOException
	{
		super.leerFichero(fichero);
		setBase (fichero.readInt());
		setAltura (fichero.readInt());
	}
	
	public void escribirFichero (DataOutputStream fichero) throws IOException
	{
		super.escribirFichero(fichero);
		fichero.writeInt(base);
		fichero.writeInt(altura);
		
	}

}
