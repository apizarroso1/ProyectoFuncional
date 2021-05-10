package ficherosherencia;

import java.util.Map;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Insertar implements MenuAction {
	
	private AppFigurasBis app;
	
	public Insertar (AppFigurasBis app)
	{
		this.app = app;
	}

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		Figura figura;
		String tipo;
		String nombre;
		Map <String,Figura> figuras = app.getFiguras();
		
		
		// leer nombre figura
		nombre = Teclado.leerString("\nNombre de la figura");
		
		if (!figuras.containsKey(nombre))
		{
			tipo = Teclado.leerString("tipo de figura: (R o C)");

			if (tipo.equals("R"))
				figura = new Rectangulo();
			else
				figura = new Circulo ();
			
			// Poner nombre a la figura
			figura.setNombre(nombre);
			
			// leer el resto de los datos
			figura.leerOtrosDatos();

			// almacenar figura en el map
			figuras.put(figura.getNombre(), figura);
		}
		else
		{
			Pantalla.escribirString("\nFigura duplicada...");
			Pantalla.escribirString("\nListado de figuras existentes");
			Pantalla.escribirString("\n" + figuras.keySet());
		}
		

	}

}
