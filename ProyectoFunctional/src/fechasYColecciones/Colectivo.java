package fechasYColecciones;

import java.util.ArrayList;
import java.util.Iterator;

public enum Colectivo {
	PROFESOR,ALUMNO,EMPRESA,EXALUMNO;
	
	public static ArrayList <String> getValuesAsString(){
		ArrayList<String> colectivos = new ArrayList<>();
		
		Colectivo[] colectivosArray = Colectivo.values();
		
		for (int i = 0; i < colectivosArray.length; i++) {
			colectivos.add(colectivosArray[i].name());
		}
		
		return colectivos;
	}
}
