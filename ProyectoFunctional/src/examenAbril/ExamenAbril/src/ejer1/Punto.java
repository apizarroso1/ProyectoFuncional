package ejer1;

import daw.com.Teclado;

public class Punto implements LeerYMostrarDatos{
	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
		this(0,0);
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
	public void leerOtrosDatos() {
		this.x = Teclado.leerInt("\nPunto x");
		this.y = Teclado.leerInt("\nPunto y");
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	@Override
	public void leerClave() {
		// TODO Auto-generated method stub
		
	}	
}
