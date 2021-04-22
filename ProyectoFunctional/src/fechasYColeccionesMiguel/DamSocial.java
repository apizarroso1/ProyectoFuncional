package ejerciciocompleto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DamSocial {
	private Map<String,Persona> personas;
	private String nombre;
	
	
	public DamSocial(Map<String,Persona> personas, String nombre) {
		this.personas = personas;
		this.nombre = nombre;
		
	}
	
	public DamSocial (String nombre)
	{
		this (new TreeMap<>(), nombre);
	}

	public DamSocial ()
	{
		this ("");
	}

	public Map<String, Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Map<String, Persona> personas) {
		this.personas = personas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "DamSocial [personas=" + personas + 
				", nombre=" + nombre + "]";
	}
	
	public boolean insertarPersona (Persona persona)
	{
		boolean exito = false;
		
		if (!tienePersona(persona.getDni()))
		{
			personas.put(persona.getDni(), persona);
			exito = true;
		}
		
		return exito;
	}
	
	public boolean tienePersona (String dni)
	{
		return personas.containsKey(dni);
	}
	
	public boolean eliminarPersona (String dni)
	{
		return personas.remove(dni) != null;
	}
	
	public List<Persona> obtenerTodasPersonas ()
	{
		List<Persona> todas = new ArrayList<> (personas.values());
		Comparator<Persona> comparador; 
		
		//comparador = (p1,p2) -> p1.getNombre().compareTo(p2.getNombre()); 
		comparador = new ComparadorPorNombre ();
		
		todas.sort(comparador);
		
		return todas;
	}
	
	public List<Persona> obtenerPersonasPorAficion (String aficion)
	{
		List<Persona> porAficion = new ArrayList<> (personas.values());
		
		Comparator<Persona> comparador;
		Predicate <Persona> predicado;
		
		//comparador = (o1,o2) -> o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento()); 
		comparador = new ComparadorPorFechaNacimiento ();
		
		predicado = new FiltroAficion (aficion);
		
		porAficion.removeIf(predicado.negate());
		
		porAficion.sort(comparador);
		
		/*
		return personas.values().stream().
						filter(predicado).
						sorted(comparador).
						collect(Collectors.toList());
		*/
		
		return porAficion;
	}
	
	public List<Persona> obtenerPersonasCumple ()
	{
		List<Persona> personasCumple = new ArrayList<> (personas.values());
		
		Predicate <Persona> predicado;
		Comparator <Persona> comparador;
		
		//predicado = Persona::esSuCumpleHoy;
		predicado = new FiltroCumpleAnios ();
		
		//comparador = (p1,p2) ->  Float.compare(p2.getAfecto(), p1.getAfecto());
		comparador = new ComparadorPorAprecio ();
		
		personasCumple.removeIf(predicado.negate());
		
		personasCumple.sort(comparador);
		
		/*
		return personas.values().stream().
							filter(Persona::esSuCumpleHoy).
							sorted((p1,p2) ->  Float.compare(p2.getAfecto(), p1.getAfecto())).
							collect(Collectors.toList());
		*/
		
		return personasCumple;
	}
	
	public Iterator<String> obtenerAficiones (Colectivo colectivo)
	{
		List<Persona> personasAficion = new ArrayList<> (personas.values());
		Set <String> aficiones = new HashSet <>();
		
		Predicate <Persona> predicado;
		Comparator <Persona> comparador;
		Consumer <Persona> accion;
		Consumer <String> insertarAficion;
		
		
		//predicado = p -> p.getColectivo().equals(colectivo);
		predicado = new FiltroColectivo (colectivo);
		personasAficion.removeIf(predicado.negate());

		
		// forma 1
		//insertarAficion = a -> aficiones.add(a);
		//accion = p-> p.getAficiones().forEachRemaining(insertarAficion);
		
		// forma 2
		//accion = p -> p.getAficiones().forEachRemaining(a -> aficiones.add(a));
		
		// forma normal
		insertarAficion = new InsertarAficion (aficiones);
		accion =  new ObtenerAficones(insertarAficion);
		personasAficion.forEach(accion);
		
		return aficiones.iterator();	
	}
	
	public int aumentarAprecio (float afecto)
	{
		List<Persona> listaPersonas = new ArrayList<>(personas.values());
		Predicate <Persona> predicado;
		Consumer <Persona> incrementar1Afecto;
		
		//predicado = p -> p.getAfecto() < afecto;
		predicado = new FiltroAfecto (afecto);
		listaPersonas.removeIf(predicado.negate());
		
		//incrementar1Afecto = p -> p.setAfecto(p.getAfecto() + 1);
		incrementar1Afecto = new Incrementar1Afecto ();
		listaPersonas.forEach(incrementar1Afecto);
		
		return listaPersonas.size();
	}
}
