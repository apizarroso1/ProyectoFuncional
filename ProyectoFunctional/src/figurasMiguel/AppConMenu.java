package ficherosherencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class AppConMenu {
	
	private List <String> opciones ;
	
	public AppConMenu()
	{
		opciones = new ArrayList<>();
	}
	
	public AppConMenu(List <String> opciones)
	{
		this.opciones = opciones;
	}
	
	
	
	
	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public void mostrarOpciones()
	{
		
		for (int i = 0; i < opciones.size(); i++)
			Pantalla.escribirString(opciones.get(i));
	}
	
	public int leerOpcion()
	{
		int opc;
		do{
			opc =Teclado.leerInt("opcion"); 
		}while (opc <1 || opc > opciones.size());
		
		return opc;
	}
	
	
	public void run ()
	{
		int opc;
		
		do
		{
			mostrarOpciones ();
			opc = leerOpcion ();
			evaluarOpcion(opc);
		}while (opc != opciones.size());
		
	}
	
	public abstract  void evaluarOpcion (int opc);

}
