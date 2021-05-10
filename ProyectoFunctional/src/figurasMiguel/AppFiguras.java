package ficherosherencia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import daw.com.Pantalla;
import daw.com.Teclado;



public class AppFiguras extends AppConMenu {
	
	private TreeMap <String,Figura> figuras;
 	
	public AppFiguras ()
	{
		super();
		
		getOpciones().add("\n1. Insertar Figura");
		getOpciones().add("\n2. Eliminar Figura");
		getOpciones().add("\n3. Listar");
		getOpciones().add("\n4. Salir\n");
		
		figuras = new TreeMap <String,Figura>();
	}

	public  static void main (String args[])
	{
		AppFiguras app;
		
		
		app = new AppFiguras();
		
		app.leerDatosFichero();
	
		app.run ();
		
		app.escribirDatosFichero();
		
	}
	
	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub

		switch (opc)
		{
			case 1:
					insertar();
					break;
			case 2:
					eliminar ();
					break;
			case 3:
					listar ();
					break;
			default:
					salir();
		}
		
	}
	
	public void insertar ()
	{
		Figura figura;
		String tipo;
		String nombre;
		
		
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
	
	public void eliminar ()
	{
		String nombre = Teclado.leerString("Figuras a eliminar");
		
		if (figuras.remove(nombre) == null)
			Pantalla.escribirString("\nFigura no existente");
		else
			Pantalla.escribirString("\nFigura eliminada correctamente");
	}
	
	public void listar ()
	{
		List <Figura> figurasOrdenadas = new ArrayList<> (figuras.values());
		
		figurasOrdenadas.sort(new ComparadorPorArea());
		
		//figurasOrdenadas.forEach(new EscribirFiguraPorPantalla());
		
		
		for (Figura figura:figurasOrdenadas)
			Pantalla.escribirString("\n" + figura);
		
	}
	
	public void salir ()
	{
		
		Pantalla.escribirString("\nBye");
	}
	
	public void escribirDatosFichero ()
	{
		Figura figura;
		String tipo;
		
		try (DataOutputStream filtro = new DataOutputStream (new FileOutputStream ("figuras.dat")))
		{
			Iterator<Figura> todas = figuras.values().iterator();
			
			// Escribir el número de figuras
			filtro.writeInt(figuras.size());
			
			// Escribir las fituras
			while (todas.hasNext())
			{
				figura = todas.next();
				
				// Escribir el tipo de figura
				//filtro.writeUTF(figura.getClass().getSimpleName());
				//filtro.writeUTF(figura.getClass().getName());
				tipo = figura instanceof Circulo ?"Circulo":"Rectangulo"; 
				filtro.writeUTF(tipo);
				
				// Escribir la figura
				figura.escribirFichero(filtro);
			}
 		}
		catch (IOException e)
		{
			System.err.println("Error en escritura de fichero...");
		}
		
	}
	
	public void leerDatosFichero ()
	{
		File file = new File ("figuras.dat");
		String tipo ;
		Figura figura;
		int cuantasFiguras;
		
		if (file.exists())
		{
			try(DataInputStream filtro = new DataInputStream (new FileInputStream (file)))
			{
				cuantasFiguras = filtro.readInt();
				
				for (int i = 0; i < cuantasFiguras; i++)
				{
					// leer tipo de figura
					tipo = filtro.readUTF();
					
					// Construir figura según su tipo
					if ( tipo.contains("Rectangulo"))
						figura = new Rectangulo();
					else
						figura = new Circulo ();
					
					//Construir objeto al vuelo
					//figura = (Figura)Class.forName(tipo).newInstance();

					// Leer figura del fichero
					figura.leerFichero(filtro);

					// Guardar figura en el map
					figuras.put(figura.getNombre(), figura);
				}

			}
			catch (IOException e)
			{
				System.err.println("No hay datos para cargar...");
			}
			catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
		}
	}

}
