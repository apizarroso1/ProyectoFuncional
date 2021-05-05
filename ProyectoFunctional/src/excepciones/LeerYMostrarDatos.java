package excepciones;

public interface LeerYMostrarDatos {

	public default void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerOtrosDatos();

	public void leerClave();
	
	public default void mostrarDatos() {
		System.out.println(toString());
	}
}
