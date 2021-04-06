package institutosimple;

import java.util.ArrayList;
import java.util.List;

public enum TipoEstudios {
	ESO(4),
	BACHILLERATO(2){public String toString () {return "Bachillerato";}},
	CFGM(2){public String toString () {return "Ciclo Formativo de Grado Medio";}},
	CFGS(2){public String toString () {return "Ciclo Formativo de Grado Superior";}};
	
	private int cursos;
	
	private TipoEstudios (int cursos)
	{
		this.cursos = cursos;
	}
	
	public int getCursos () { return cursos;}
	
	public static List<String> valuesAsString ()
	{
		ArrayList<String> lista = new ArrayList<>();
		
		for (TipoEstudios t: values ())
			lista.add(t.name());
		
		return lista;
	}
}
