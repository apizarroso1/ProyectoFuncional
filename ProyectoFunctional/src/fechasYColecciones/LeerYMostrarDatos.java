package fechasYColecciones;

public interface LeerYMostrarDatos {

	default public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerOtrosDatos();

	public void leerClave();
	
	default public void mostrarDatos() {
		System.out.println(toString());
	}
}
