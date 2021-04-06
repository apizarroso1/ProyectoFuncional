package institutoMio;

import daw.com.Pantalla;

public interface LeerYMostrarDatos {
	
	default public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos();
	}
	
	public void leerClave ();
	public void leerOtrosDatos ();
	
	default public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}

}
