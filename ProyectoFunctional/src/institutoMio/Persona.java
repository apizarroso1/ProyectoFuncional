package institutoMio;

import java.util.ArrayList;

import instituto.Buzon;
import instituto.Direccion;

public class Persona {
	private String nombre;
	private String nif;
	private int anio;
	private String poblacion;
	private Direccion direccion;
	private Buzon buzon;
	private ArrayList<Telefono> agenda;
	
	public Persona(String nombre, String nif, int anio, String poblacion, Direccion direccion, Buzon buzon,
			ArrayList<Telefono> agenda) {
		this.nombre = nombre;
		this.nif = nif;
		this.anio = anio;
		this.poblacion = poblacion;
		this.direccion = direccion;
		this.buzon = buzon;
		this.agenda = agenda;
	}
	
	public Persona() {
		
		this("");

	}
	
	public Persona(String nif) {
		this.nif = nif;
		this.nombre = "";
		this.poblacion = "";
		this.anio = 1999;
		this.buzon = new Buzon();
		this.direccion = new Direccion();
		this.agenda = new ArrayList<>();
	}
	
	

}
