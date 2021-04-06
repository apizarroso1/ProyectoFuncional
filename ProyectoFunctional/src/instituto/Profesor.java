package institutosimple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Profesor extends Persona {
	
	private String departamento;
	private String despacho;
	private ArrayList<Alumno> tutorandos;
	
	public Profesor ()
	{
		this ("");
	}
	
	public Profesor (String nif)
	{
		super(nif);
		departamento ="";
		despacho = "";
		tutorandos = new ArrayList<>();
	}

	
	
	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public String getDespacho() {
		return despacho;
	}



	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}



	public ArrayList<Alumno> getTutorandos() {
		return tutorandos;
	}



	public void setTutorandos(ArrayList<Alumno> tutorandos) {
		this.tutorandos = tutorandos;
	}

	public boolean isFull ()
	{
		return tutorandos.size() >= 9;
	}
	
	public boolean contieneTutorando (Alumno alumno)
	{
		return tutorandos.contains(alumno);
	}

	public boolean addTutorando (Alumno alumno)
	{
		boolean exito = false;
		
		if (!isFull())
		{
			tutorandos.add(alumno);
			alumno.addMensaje(new Mensaje (getNif(),  LocalDate.now(), "Bienvenido al instituto"));
			exito = true;
		}
		
		return exito;
	}
	
	public void convocarTutoria (LocalDate fecha)
	{
		String texto;
		Mensaje m;
		texto = "Queda convocado a la sesión de tutoria en el despacho ";
		texto += despacho;
		texto += " con fecha ";
		texto += fecha;
		
		Iterator<Alumno> iterator = tutorandos.listIterator();
		
		while (iterator.hasNext())
		{
			m = new Mensaje (getNif(),LocalDate.now(), texto);
			iterator.next().addMensaje(m);
			
		}
		
	}

		
	public void leerDatos ()
	{
		Pantalla.escribirString("\nLeyendo Profesor..");
		super.leerDatos();
		departamento = Teclado.leerString("departamento");
		despacho = Teclado.leerString("despacho");
	}
	
	@Override
	public String getTipoPersona() {
		// TODO Auto-generated method stub
		return "profesor del departamento " + departamento;
	}

}
