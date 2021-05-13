package clubDeportistasMiguel;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ColeccionDeportistas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map <String, Deportista> deportistas;
	
	
	public ColeccionDeportistas ()
	{
		deportistas = new TreeMap <>();
	}
	
	
	public Iterator<Deportista> findAll ()
	{
		return deportistas.values().iterator();
	}
	
	public Deportista findByKey (String dni)
	{
		return deportistas.get(dni);
	}
	
	public boolean insert (Deportista deportista)
	{
		boolean exito = true;
		
		if (deportistas.get(deportista.getDni())== null)
			deportistas.put(deportista.getDni(), deportista);
		else
			exito = false;
		
		return exito;
	}
	
	public boolean delete (String dni)
	{

		return deportistas.remove(dni) != null;
	}
	
	public boolean update (Deportista deportista)
	{
		boolean exito = true;
		
		if (deportistas.get(deportista.getDni()) != null)
			deportistas.put(deportista.getDni(), deportista);
		else
			exito = false;
		
		return exito;
	}
	
}


