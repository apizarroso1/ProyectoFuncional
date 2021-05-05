package fechasYColecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class DamSocial {

	private TreeMap <String, Persona> personas;
	private String nombre;
	
	public DamSocial(TreeMap<String, Persona> personas, String nombre) {
		this.personas = personas;
		this.nombre = nombre;
	}
	
	public DamSocial() {
		this("");
	}
	
	public  DamSocial(String nombre) {
		this(new TreeMap<>(), nombre);
	}

	public TreeMap<String, Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(TreeMap<String, Persona> personas) {
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
		return "DamSocial [personas=" + personas + ", nombre=" + nombre + "]";
	}
	
	public boolean insertarPersona(Persona persona) {
		
		// null si la clave no existia
		if (personas.put(persona.getDni(), persona) == null) {
			return true;
		} else {
			return false;
		}
		
		/*
		if (!personas.containsKey(persona.getNombre())) {
			personas.put(persona.getDni(), persona);
			return true;
		} else {
			return false;
		}
		*/
	}
	
	public boolean tienePersona(String dni) {
		if (personas.containsKey(dni)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean eliminarPersona(String dni) {
		return personas.remove(dni) != null;
	}
	
	public List<Persona> obtenerTodasPersonas(){
		List <Persona> todasPersonas = new ArrayList<>(personas.values());
		ComparadorPorNombre funkyComparator = new ComparadorPorNombre();
		
		todasPersonas.sort(funkyComparator);
		
		return todasPersonas;
	}
	
	public List<Persona> obtenerPersonasPorAficion(String aficion){
		List<Persona> personasLista = new ArrayList<> (personas.values());
		FiltroPorAficion filter = new FiltroPorAficion(aficion);
		ComparadorPorEdad comparator = new ComparadorPorEdad();
		
		personasLista.removeIf(filter);
		
		personasLista.sort(comparator);
		
		return personasLista;
	}
	
	public List<Persona> obtenerPersonaCumple(){
		List <Persona> personasLista = new ArrayList<> (personas.values());
		FiltroPorCumple funkyFilter = new FiltroPorCumple();
		ComparadorPorAfecto funkyComparer = new ComparadorPorAfecto();
		
		personasLista.removeIf(funkyFilter);
		
		personasLista.sort(funkyComparer);
		
		return personasLista;
	}
	
	public 	Iterator<String> obtenerAficiones(Colectivo colectivo){
		List <Persona> personasLista = new ArrayList<>(personas.values());
		Set <String> aficiones = new HashSet<>();
		FiltroPorColectivo funkyFilter = new FiltroPorColectivo(colectivo);
		
		personasLista.removeIf(funkyFilter);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
