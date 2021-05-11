package ficherosBinario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Figura implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private int grosor;
	private int color;
	private PuntoBidimensional centro;

	public Figura(String nombre, int grosor, int color, PuntoBidimensional centro) {
		this.nombre = nombre;
		this.grosor = grosor;
		this.color = color;
		this.centro = centro;
	}

	public Figura() {
		this("", 0, 0, new PuntoBidimensional());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGrosor() {
		return grosor;
	}

	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		if (color < 0 || color > 254)
			throw new IllegalArgumentException("color no válido");

		this.color = color;
	}

	public PuntoBidimensional getCentro() {
		return centro;
	}

	public void setCentro(PuntoBidimensional centro) {
		this.centro = centro;
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
		Figura other = (Figura) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + ", grosor=" + grosor + ", color=" + color + ", centro=" + centro + "]";
	}

	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}

	public void leerClave() {
		this.nombre = Teclado.leerString("\nNombre");
	}

	public void leerOtrosDatos() {
		boolean valido;

		do {
			valido = true;

			try {
				setColor(Teclado.leerInt("color:"));
			} catch (IllegalArgumentException e) {
				Pantalla.escribirString("\n" + e.getMessage());
				valido = false;
			}
		} while (!valido);

		this.centro.leerDatos();
		setColor(Teclado.leerInt("\nColor"));
		setGrosor(Teclado.leerInt("\nGrosor"));
	}

	public void mostrarDatos() {
		System.out.println(toString());
	}

	public void leerFichero(DataInputStream fichero) throws IOException {
		this.nombre = fichero.readUTF();
		this.centro.leerFichero(fichero);
		this.color = fichero.readInt();
		this.grosor = fichero.readInt();
	}
	
	public void escribirFichero(DataOutputStream fichero) throws IOException{
		fichero.writeUTF(nombre);
		this.centro.escribirFichero(fichero);
		fichero.writeInt(color);
		fichero.writeInt(grosor);
	}
	
	public abstract float calcularArea();
}
