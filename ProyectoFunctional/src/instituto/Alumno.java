package institutosimple;


import java.time.LocalDate;
import java.util.List;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Alumno extends Persona {
	private static final int CURSO = 1;
	private static final String GRUPO = "";
	private static final TipoEstudios TIPOESTUDIOS = TipoEstudios.ESO;
	
	private int curso;
	private String grupo;
	private TipoEstudios tipoEstudios;
	
		
	public Alumno() {
		this("");
	}

	public Alumno(String nif) {
		super(nif);
		curso = CURSO;
		grupo = GRUPO;
		tipoEstudios = TIPOESTUDIOS;
	}
	
	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		if (curso < CURSO)
			curso = CURSO;
		else if (curso > tipoEstudios.getCursos())
			curso = tipoEstudios.getCursos();
		
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public TipoEstudios getTipoEstudios() {
		return tipoEstudios;
	}

	public void setTipoEstudios(TipoEstudios tipoEstudios) {
		this.tipoEstudios = tipoEstudios;
		// Corregir el curso si procede
		if (curso > tipoEstudios.getCursos())
			curso = tipoEstudios.getCursos();
	}

	
	
	@Override
	public String toString() {
		return "Alumno [curso=" + curso + ", grupo=" + grupo + ", tipoEstudios=" 
					+ tipoEstudios + super.toString() + "]";
	}

	public void leerOtrosDatos ()
	{
		super.leerOtrosDatos();
		leerTipoEstudios();
		setCurso (Teclado.leerInt("Curso "));
		grupo = Teclado.leerString("grupo");
	}
	
	public void leerTipoEstudios ()
	{
		String tipo;
		do
		{
			Pantalla.escribirString("\n" + TipoEstudios.valuesAsString());
			tipo = Teclado.leerString("\nElegir tipo de estudios").toUpperCase();
		}while (!TipoEstudios.valuesAsString().contains(tipo));
		
		setTipoEstudios (TipoEstudios.valueOf(tipo));
	}

	@Override
	public String getTipoPersona() {
		// TODO Auto-generated method stub
		return "alumno del curso " + curso + " de " + grupo + " de " + tipoEstudios ;
		
	}
}
