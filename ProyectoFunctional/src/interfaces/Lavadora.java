package interfaces;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Lavadora extends Electrodomestico {
	private int carga;

	public Lavadora(String identificador, int stock, int precioBase, Color color, Consumo consumo, int masa,
			int carga) {
		super(identificador, stock, precioBase, color, consumo, masa);
		this.carga = carga;
	}

	public Lavadora() {
		super("", 0, 100, Color.BLANCO, Consumo.F, 5);
		this.carga = 5;
	}

	public Lavadora(String identificador) {
		super(identificador, 0, 100, Color.BLANCO, Consumo.F, 5);
		this.carga = 5;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		if (carga < 0) {
			carga = 0;
		}
		this.carga = carga;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		this.carga = Teclado.leerInt("\nCarga");
	}

	@Override
	public String toString() {
		return "Lavadora [carga=" + carga + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

	@Override
	public float calcularPrecio() {
		float precioFinal;

		precioFinal = super.calcularPrecio();

		if (carga > 30) {
			precioFinal = +50;
		}

		return precioFinal;
	}
}
