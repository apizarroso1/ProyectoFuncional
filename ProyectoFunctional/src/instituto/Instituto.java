package instituto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import daw.com.Pantalla;


public class Instituto {
	
	private List<Persona> personas;
	
	public Instituto ()
	{
		personas = new ArrayList<>();
	}
		
	// Borrame
	public List<Persona> getPersonas() {
		return new ArrayList <> (personas);
	}

	public boolean addPersona (Persona persona)
	{
		boolean exito = false;
		
		if (!personas.contains(persona))
		{
			personas.add(persona);
			
			exito = true;
		}
		
		return exito;
	}
	
	
	
	public Persona getPersona (String nif)
	{
		Persona persona = null;
		int lugar;
		
		lugar = personas.indexOf(new Alumno (nif)); // Chapuza
		
		if (lugar >= 0)
			persona = personas.get(lugar);
		
		return persona;
	}
	
	public Profesor asignarTutor (Alumno alumno)
	{
		Profesor tutor = buscarTutor (alumno);
		List<Profesor> profesores = getProfesores ();
		
		// comprobar si hay tutores libres y a�adir tutorando
		for (int i = 0; i < profesores.size() && tutor == null; i++)
			if (!profesores.get(i).isFull())
				if (profesores.get(i).addTutorando(alumno))
					tutor = profesores.get(i);
			

		return tutor;
	}
	
	
	public List<Profesor> getProfesores ()
	{
		// Lista de profesores
		
		List<Profesor> profesores = new ArrayList<>();
		
		for (Persona p: personas)
			if (p instanceof Profesor)
				profesores.add((Profesor)p);
		
		return profesores;
	}
	
	
	
	
	public void eliminarPersona (String nif)
	{
		Persona persona = getPersona(nif);
		
		if (persona !=  null && persona instanceof Profesor)
		{
			reasignarTutor((Profesor)persona);
			personas.remove(persona);
		}
		
			
	}
	
	public void reasignarTutor(Profesor profesor)
	{
		Alumno a;
		List <Alumno> alumnos = profesor.getTutorandos(); 
		
		for (int i = 0; i < alumnos.size(); i++)
		{
			a = alumnos.get(i);
			asignarTutor (a);
		}
	}
	
	
	public Profesor buscarTutor (Alumno alumno)
	{
		Profesor tutor = null;
		List<Profesor> profesores = getProfesores();
		
		// Buscar tutor del alumno		
		for (int i = 0; i < profesores.size() && tutor == null; i++)
				if (profesores.get(i).contieneTutorando(alumno))
					tutor = profesores.get(i);
				
		return tutor;
	}
	
	
	

}
