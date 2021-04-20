package ejer1;

import daw.com.Pantalla;

public interface LeerYMostrarDatos {
	
	public default void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}
	
	public void leerClave();
	
	public void leerOtrosDatos();
	
	public default void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}
}
