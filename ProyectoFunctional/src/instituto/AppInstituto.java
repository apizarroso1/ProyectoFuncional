package instituto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daw.com.Pantalla;
import daw.com.Teclado;
import libreria.AppMenu;

public class AppInstituto extends AppMenu {

	// Datos de la aplicaci�n
	private Instituto instituto;
	
	public AppInstituto ()
	{
		super (); // Crear AppConMenu 
		instituto = new Instituto(); // Crear los datos
		
		// Cargar opciones de menú
		addOpcion("Alta Profe");
		addOpcion("Alta Alumno");
		addOpcion("Baja profesor");
		addOpcion("Localizar Persona");
		addOpcion("Convocar tutoría");
		addOpcion("Comunicación Tutor");
		addOpcion("Leer Correo");
		addOpcion("Enviar Mensaje");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AppInstituto app;
		
		
		
		
		
		// Construir un objeto aplicaci�n
		app = new AppInstituto();
		
		// Cargas Datos iniciales
		app.leerDatosPeronas();

		// Ejecutar la aplicaci�n
		app.run ();

	}
	
	
	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		switch (opc)
		{
			case 1:
					darAlta (2);
					break;
			case 2:
					darAlta (1);
					break;
			case 3:
					darBaja ();
					break;
			case 4:
					localizarPersona();
					break;
			case 5:
					convocarTutoria();
					break;
			case 6:
					comunicarAlTutor();
					break;
			case 7:
					leerMensajes();
					break;
			case 8:
					enviarMensaje();
					break;
			case 9:
					salir();
					break;
					
		}
		
	}
	
	public void leerDatosPeronas()
	{
		String respuesta;
		Persona persona;
		int tipo;
		String nif;
	
		
		do{
			tipo = Teclado.leerInt("1. Alumno - 2. Profesor");
	
			darAlta (tipo);
			
			respuesta = Teclado.leerString("sigo?");
		}while (respuesta.equalsIgnoreCase("S") );
		
	}
	
	public void darAlta (int tipo)
	{
		
		String nif;
		Persona persona;
		String resultado;
		Profesor tutor;
		
				
		if (tipo == 1)
			persona = new Alumno ();
		else 
			persona = new Profesor ();
		
		do {
			persona.leerClave();
		}
		while (instituto.getPersona(persona.getNif())!= null);
		
		persona.leerOtrosDatos();
		
		if (instituto.addPersona(persona))
			Pantalla.escribirString("\nPersona dada de alta correctamente\n");
		else
			Pantalla.escribirString("\nPersona ya existente\n");
		
		// Asignar tutor
		if (tipo == 1)
		{
			// mostrar mensaje en pantalla
			tutor = instituto.asignarTutor((Alumno) persona);
			Pantalla.escribirString("\nTutor asignado "+ tutor.getNombre());
		}
		
	}
	
	public String leerNif ()
	{
		String nif;

		do {
			nif = Teclado.leerString("nif");
		}
		while (instituto.getPersona(nif)== null);
		
		return nif;
	}
	
	public void darBaja ()
	{
		String nif;
	
		nif = leerNif();
		
		instituto.eliminarPersona(nif);
	}
	
	public void localizarPersona ()
	{
		String nif = leerNif();
		
		Pantalla.escribirString("\n"+ instituto.getPersona(nif).getAgenda().toString());
	}
	
	public void convocarTutoria ()
	{
		
		Profesor profe;
		String nif = leerNif();
		// leer fecha
		
		
		profe = (Profesor) instituto.getPersona(nif);
		
		profe.convocarTutoria(LocalDate.now());
	
		
	}
	
	public void comunicarAlTutor ()
	{
		String nif = leerNif();
		String texto = Teclado.leerString("texto a comunicar");
		
		Alumno alumno  = (Alumno) instituto.getPersona(nif);
	
		
		Profesor tutor = instituto.buscarTutor(alumno);
		
		if (tutor != null)
		{
			tutor.addMensaje(new Mensaje (alumno.getNif(), LocalDate.now(), texto));
			Pantalla.escribirString("\nMensaje enviado a " + tutor.getNombre());
		}
		else
			Pantalla.escribirString("\nNo hay tutor asignado");

		
	}
	
	public void leerMensajes() {
		// TODO Auto-generated method stub
		String nif; 
		Persona persona;
		
		nif = leerNif();
		persona = instituto.getPersona(nif);
		
		// Ordenar mensajes
		persona.getBuzon().ordenarBuzon(new ComparadorMensajePorFechas());
		// leer correo
		persona.leerCorreo();
	}
	

	public void enviarMensaje() {
		// TODO Auto-generated method stub
		String nifEmisor, nifReceptor, contenido; 
		Persona persona;
		Mensaje m;
		
		Pantalla.escribirString("\nEmisor");
		nifEmisor = leerNif();
		Pantalla.escribirString("\nReceptor");
		nifReceptor = leerNif();
		contenido = Teclado.leerString("\nContenido del mensaje:");
		
		m = new Mensaje (nifEmisor,LocalDate.now(), contenido);
		
		persona = instituto.getPersona(nifReceptor);
		
		persona.addMensaje(m);
		
		Pantalla.escribirString("\nMensaje enviado correctamente");
	}
	
	public void salir() {
		// TODO Auto-generated method stub
		instituto.getPersonas().forEach(new MostrarIdentificacion ());
	}

}
