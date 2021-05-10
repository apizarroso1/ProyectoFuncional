package ficherosBinario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

import daw.com.Pantalla;
import daw.com.Teclado;

abstract public class Figura implements Serializable {
	
	/**
	 * seguir
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int color;

	private Punto2D centro;
	
	public Figura() {
		nombre ="";
		color = 0;
		
		centro = new Punto2D();
	}


	public Figura (Figura original)
	{
		this.nombre = original.nombre;
		this.color = original.color;
		
		this.centro = new Punto2D (original.centro);
		
	}


	public int getColor() {
		return color;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setColor(int color) {
		if (color < 0 || color > 254)
			throw new IllegalArgumentException ("color no v�lido");

		this.color = color;
	}


	public Punto2D getCentro() {
		return centro;
	}


	public void setCentro(Punto2D centro) {
		this.centro = new Punto2D(centro);
	}
	
	public void leerClave ()
	{
		nombre = Teclado.leerString("\nNombre");
	}
	
	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerOtrosDatos ()
	{
		boolean valido;
		
		do
		{
			valido = true;

			try {
				setColor (Teclado.leerInt("color:"));
			}
			catch (IllegalArgumentException e)
			{
				Pantalla.escribirString("\n" + e.getMessage());
				valido = false;
			}
		}while (!valido);
			
		// leer el centro del teclado
		centro.leerPunto();
		
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirString("\nnombre :", nombre);
		
		Pantalla.escribirInt("\nbgcolor :" , color);
		
		centro.mostrarPunto();
	}
	
	public void leerFichero (DataInputStream fichero) throws IOException
	{
		nombre = fichero.readUTF();
		
		try {
			setColor (fichero.readInt());
		}
		catch (IllegalArgumentException e)
		{
			color = 0;
		}
		

		centro.leerFichero(fichero);
	}
	
	public void escribirFichero (DataOutputStream fichero) throws IOException
	{
		fichero.writeUTF(nombre);
		
		fichero.writeInt(color);
		
		
		centro.escribirFichero(fichero);
		
	}
	
	@Override
	public String toString() {
		return "nombre=" + nombre + ", color=" + color + ", " + centro ;
	}


	abstract public float getArea();
	


}
