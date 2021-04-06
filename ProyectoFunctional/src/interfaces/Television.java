package interfaces;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Television extends Electrodomestico {
	private int resolucion;
	private boolean tdt = false;

	public Television(String identificador, int stock, int precioBase, Color color, Consumo consumo, int masa,
			int resolucion, boolean tdt) {
		super(identificador, stock, precioBase, color, consumo, masa);
		this.resolucion = resolucion;
		this.tdt = tdt;
	}

	public Television() {
		super("", 0, 100, Color.BLANCO, Consumo.F, 5);
		this.resolucion = 20;
	}

	public Television(String identificador) {
		super(identificador, 0, 100, Color.BLANCO, Consumo.F, 5);
		this.resolucion = 20;
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		if (resolucion < 0) {
			resolucion = 0;
		}
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		this.resolucion = Teclado.leerInt("\nResolucion");
		this.tdt = tieneTdt();
	}

	public boolean tieneTdt() {
		if (Teclado.leerString("\n¿Tiene TDT?(s/n)").equalsIgnoreCase("s")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Television [resolucion=" + resolucion + ", tdt=" + tdt + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

	@Override
	public float calcularPrecio() {
		double precioFinal = super.calcularPrecio();

		if (this.resolucion > 40) {
			precioFinal = precioFinal + precioFinal * 1.30;
		}

		if (isTdt()) {
			precioFinal = +50;
		}

		return (float) precioFinal;
	}
}
