package examenMayo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Teclado;

public abstract class Via {
	private String nombre;
	private int grado;
	private int longitud;
	
	private static final float DESPLAZAMIENTO = 2000;

	public Via(String nombre, int grado, int longitud) {
		this.nombre = nombre;
		this.grado = grado;
		this.longitud = longitud;
	}
	
	public Via () {
		this("", 1, 0);
	}
	
	public static float getDesplazamiento() {
		return DESPLAZAMIENTO;
	}
	
	public Via(String nombre) {
		this(nombre, 1, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		
		if (grado < 1 || grado > 10) {
			throw new IllegalArgumentException("Grado introducido no comprendido entre 1 y 10");
		} else {
			this.grado = grado;
		}
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		
		if (longitud <= 0) {
			throw new IllegalArgumentException("La longitud debe ser un número positivo y mayor que 0");
		}else {
			this.longitud = longitud;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Via other = (Via) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Via [nombre=" + nombre + ", grado=" + grado + ", longitud=" + longitud + "]";
	}
	
	public void leerDatos() {
		leerNombre();
		leerOtrosDatos();
	}
	
	public void leerNombre() {
		this.nombre = Teclado.leerString("\nNombre de la vía");
	}
	
	public void leerOtrosDatos() {
		setGrado(Teclado.leerInt("\nGrado de la vía"));
		setLongitud(Teclado.leerInt("\nLongitud de la vía en metros"));
	}
	
	public void mostrarDatos() {
		System.out.println(toString());
	}
	
	public void escribirDatosBin(DataOutputStream fichero) throws IOException {
		
		fichero.writeUTF(nombre);
		fichero.writeInt(grado);
		fichero.writeInt(longitud);
	}
	
	public void leerDatosBin(DataInputStream fichero) throws IOException{
		this.nombre = fichero.readUTF();
		this.grado = fichero.readInt();
		this.longitud = fichero.readInt();
	}
	
	public abstract float calcularRescate();
}
