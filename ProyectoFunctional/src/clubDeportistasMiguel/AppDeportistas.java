package clubDeportistasMiguel;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;
import libreria.AppMenu;


public class AppDeportistas extends AppMenu {

	private final static String FICHERO = "deportistas.dat";
	private final static String FICHEROCSV = "deportistas.csv";
	private final static String FICHEROSERIALIZADO = "deportistas.bin";
	
	private ColeccionDeportistas deportistas;
	
	
	
	
	public AppDeportistas() {

		super ();
		// Cargar menú
		addOpcion("Insertar deportista");
		addOpcion("Eliminar deportista");
		addOpcion("Modificar deportista");
		addOpcion("Listar deportistas por tipo");
		
		deportistas = new ColeccionDeportistas ();
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppDeportistas app;
		Instant inicio, fin;
		
		inicio = Instant.now(); // instante inicial
		
			
		app = new AppDeportistas ();
		
		app.cargarDatosCSV();
		//app.cargarDatosSerializados();
		//app.cargarDatosBinario ();
		
		
		
		app.run ();
		
		app.guardarDatosCSV (app.ordenarDatosPorFecha());
		//app.guardarDatosSerializados(app.ordenarDatosPorFecha());
		//app.guardarDatosBinario (app.ordenarDatosPorFecha());
		
		
		
		fin = Instant.now(); // instante final

		Duration duracion = Duration.between(inicio, fin); //intervalo
		
		
		System.out.println("Tiempo usado " + Tiempo.tiempoToString(duracion));	
	}
	
	public void cargarDatosBinario ()
	{
		String tipo;
		Deportista deportista;
		int cuantos;
		
		File fichero = new File (FICHERO);
		
		if (fichero.exists())
		{
			try (FileInputStream bruto = new FileInputStream (fichero);
					DataInputStream filtro = new DataInputStream (bruto)) 
			{
				
				cuantos = filtro.readInt();
				
				for (int i = 0; i < cuantos; i++ )
				{
					tipo = filtro.readUTF();
					
					deportista = (Deportista) Class.forName(tipo).newInstance();
					deportista.leerFichero(filtro);
					deportistas.insert(deportista);
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Pantalla.escribirString("\nError accediendo al fichero...");
			} catch (InstantiationException | 
					IllegalAccessException |
					ClassNotFoundException e) {
					
				Pantalla.escribirString("\nNo se pueden cargar los datos ...");
				
			}
			
		}
	}
	
		
	public void guardarDatosBinario (List<Deportista> deportistasOrdenados)
	{
		
		String tipo;
		
		File fichero = new File (FICHERO);
		
		
		
		
		try (FileOutputStream bruto = new FileOutputStream (fichero);
				DataOutputStream filtro = new DataOutputStream (bruto))
		{
			filtro.writeInt(deportistasOrdenados.size());
			
			for (Deportista deportista: deportistasOrdenados)
			{
				tipo = deportista.getClass().getName();
				filtro.writeUTF(tipo);
				deportista.escribirFichero(filtro);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void cargarDatosCSV ()
	{
		String tipo;
		String linea;
		Deportista deportista;
		
		File fichero = new File (FICHEROCSV);
		
		if (fichero.exists())
		{
			try (FileReader bruto = new FileReader (fichero);
					BufferedReader filtro = new BufferedReader (bruto)) 
			{
				
				while (filtro.ready())
				{
					
					linea = filtro.readLine();
					tipo = linea.split(":")[0];
					linea = linea.substring(linea.indexOf(":")+1);
					deportista = (Deportista) Class.forName(tipo).newInstance();
					deportista.fromCsv(linea);
					deportistas.insert(deportista);
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Pantalla.escribirString("\nError accediendo al fichero...");
			} catch (InstantiationException | 
					IllegalAccessException |
					ClassNotFoundException e) {
					
				Pantalla.escribirString("\nNo se pueden cargar los datos ...");
				
			}
			
		}
	}
	
	public void guardarDatosCSV (List<Deportista> deportistasOrdenados )
	{
		
		String tipo;
		
		File fichero = new File (FICHEROCSV);
		
		
		
		
		try (FileWriter bruto = new FileWriter (fichero);
				PrintWriter filtro = new PrintWriter (bruto))
		{
			for (Deportista deportista: deportistasOrdenados)
			{
				tipo = deportista.getClass().getName();
				filtro.print(tipo + ":");
				filtro.println(deportista.toCSV());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void cargarDatosSerializados ()
	{

		File fichero = new File (FICHEROSERIALIZADO);
		
		if (fichero.exists())
		{
			try (FileInputStream bruto = new FileInputStream (fichero);
					ObjectInputStream filtro = new ObjectInputStream (bruto)) 
			{
				// leer como un arraylist
				ArrayList<Deportista> listaDeportistas = (ArrayList<Deportista>)filtro.readObject();
				
				// Insertar arraylist en el contenedor
				listaDeportistas.forEach((d)->deportistas.insert(d));
				
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				Pantalla.escribirString("\nError accediendo al fichero...");
			}
			
		}
	}
	
	public void guardarDatosSerializados (List<Deportista> deportistas)
	{

		File fichero = new File (FICHEROSERIALIZADO);
		
		
			try (FileOutputStream bruto = new FileOutputStream (fichero);
					ObjectOutputStream filtro = new ObjectOutputStream (bruto)) 
			{
				// Se escribe como un arraylist
				filtro.writeObject(deportistas);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Pantalla.escribirString("\nError escribiendo fichero...");
			}
			
		
	}
	
	public List<Deportista> ordenarDatosPorFecha ()
	{
		ArrayList<Deportista> deportistasOrdenados = new ArrayList<>();
		
		
		
		 
		Iterator<Deportista> iterador = deportistas.findAll();
		while (iterador.hasNext())
		  deportistasOrdenados.add(iterador.next());
		  
		
		
		/*
		Consumer<Deportista>  insertarEnArrayList = (d)->deportistasOrdenados.add(d); 
		deportistas.findAll().forEachRemaining(insertarEnArrayList);
		*/
		
		  
		// Comparar por fechas
		Comparator<Deportista> porFechas = (d1,d2) -> d1.getFechaNacimiento().compareTo(d2.getFechaNacimiento()); 
		
		deportistasOrdenados.sort(porFechas);
		
		return deportistasOrdenados;
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
					editar ();
					break;
			case 4:
					listar ();
					break;
		
			default:
					salir();
		}
		
	}
	
	public void insertar ()
	{
		String dni;
		Deportista deportista;
		int tipo;
		
		dni = Teclado.leerString("DNI ");
		
		if (deportistas.findByKey(dni) == null)
		{
			
			tipo = Teclado.leerInt("1. Atleta - 2. Ciclista");
			
			if (tipo == 1)
				deportista = new Atleta (dni);
			else
				deportista = new Ciclista (dni);
			
			deportista.leerDatos();
			
			deportistas.insert(deportista);
		}
		else
			Pantalla.escribirString("\nDeportista ya existente");
		
	}
	
	public void eliminar ()
	{
		String dni;
		
		dni = Teclado.leerString("DNI del deportista a eliminar");
		
		if (deportistas.delete(dni))
			Pantalla.escribirString("\nDeportista eliminado correctamente");
		else
			Pantalla.escribirString("\nDeportista no existente");
	}
	
	
	public void editar ()
	{
		String dni;
		Deportista deportista;
		
		dni = Teclado.leerString("DNI del deportista a modificar");
		
		deportista = deportistas.findByKey(dni);
		if (deportista != null)
		{
			Pantalla.escribirString("\nDatos actuales");
			deportista.mostrarDatos();
			Pantalla.escribirString("\nIntroducir los nuevos datos");
			deportista.leerDatos();
			
			deportistas.update(deportista);
		}
		else
			Pantalla.escribirString("\nDeportista no existente");
	}
	
	public void listar ()
	{
		int tipo;
		Class clase = null;
		ArrayList<Deportista> ordenados = new ArrayList<>();
		Deportista deportista;
		
		
		tipo = Teclado.leerInt("1. Atleta - 2. Ciclista");
		
		try {
			if (tipo == 1)

				clase = Class.forName("deportistas.Atleta");
			else
				clase = Class.forName("deportistas.Ciclista");
		} catch (ClassNotFoundException e) {
			Pantalla.escribirString("\nError...");
		}
		
		Iterator<Deportista> iterador = deportistas.findAll(); 

		while (iterador.hasNext())
		{
			deportista = iterador.next();
			if (deportista.getClass().equals(clase))
				ordenados.add(deportista);
		}

		// Comparar por nombre
		ordenados.sort((d1,d2) -> d1.getNombre().compareTo(d2.getNombre()));
		
		ordenados.forEach( (d) -> d.mostrarDatos());
	}
	
	public void salir ()
	{
		Pantalla.escribirString("\nGuardando datos...");
	}
	


}
