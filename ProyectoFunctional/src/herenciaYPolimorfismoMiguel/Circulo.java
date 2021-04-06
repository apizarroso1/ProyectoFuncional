package herenciaYPolimorfismoMiguel;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Circulo extends Figura {
	
	private int radio;
	
	public Circulo ()
	{
		this ("",0,0,0);
	
	}
	
	public Circulo (String nombre)
	{
		this (nombre,0,0,0);
	}
	
	public Circulo(String nombre, int radio, int grosor, int color) {

		super (nombre,grosor,color);
		
	}
	
	public Circulo (Circulo r)
	{
		super (r);
		this.radio = r.radio;
	}


	public int getradio() {
		return radio;
	}

	public void setradio(int radio) {
		this.radio = radio;
	}

	

	@Override
	public String toString() {
		return super.toString() +
				"Circulo [" + 
				", radio=" + radio + 
				"area = " + calcularArea() + "]";
	}
	
	public int calcularArea() 
	{
		return (int) (Math.PI * radio* radio);
	}
	
	public int calcularPerimetro ()
	{
		return (int) (2 * Math.PI *radio) ;
	}
	
	
	public void leerDatos ()
	{
		super.leerDatos();
		radio = Teclado.leerInt("radio");
		
	}
	
	
}
