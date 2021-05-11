package ficherosBinario;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

import daw.com.Teclado;

public class PuntoBidimensional implements Serializable {

	private static final long serialVersionUID = 1L;

	public int x;
	public int y;

	public PuntoBidimensional() {
		this(0, 0);
	}

	public PuntoBidimensional(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "PuntoBidimensional [x=" + x + ", y=" + y + "]";
	}

	public void leerDatos() {
		this.x = Teclado.leerInt("\nX");
		this.y = Teclado.leerInt("\nY");
	}

	public void mostrarDatos() {
		System.out.println(toString());
	}

	public void leerFichero(DataInputStream fichero) throws IOException {
		this.x = fichero.readInt();
		this.y = fichero.readInt();
	}

	public void escribirFichero(DataOutputStream fichero) throws IOException {
		fichero.writeInt(this.x);
		fichero.writeInt(this.y);
	}
}
