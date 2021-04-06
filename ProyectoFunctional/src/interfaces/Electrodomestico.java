package interfaces;

import java.util.ArrayList;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Electrodomestico implements Comparable<Electrodomestico>{
	private String identificador;
	private int stock;
	private float precioBase;
	private Color color;
	private Consumo consumo;
	private int masa;

	public Electrodomestico(String identificador, int stock, float precioBase, Color color, Consumo consumo, int masa) {
		this.identificador = identificador;
		this.stock = stock;
		this.precioBase = precioBase;
		this.color = color;
		this.consumo = consumo;
		this.masa = masa;
	}

	public Electrodomestico() {
		this("", 0, 100, Color.BLANCO, Consumo.F, 5);
	}

	public Electrodomestico(String identificador) {
		this.identificador = identificador;
		this.stock = 0;
		this.precioBase = 100;
		this.color = Color.BLANCO;
		this.consumo = Consumo.F;
		this.masa = 5;
	}

	public int getMasa() {
		return masa;
	}

	public void setMasa(int masa) {
		if (masa < 0) {
			masa = 0;
		}

		this.masa = masa;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			stock = 0;
		}

		this.stock = stock;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		if (precioBase < 0) {
			precioBase = 0;
		}

		this.precioBase = precioBase;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public void leerDatos() {
		this.identificador = leerClave();
		this.stock = Teclado.leerInt("\nStock");
		this.precioBase = Teclado.leerFloat("\nPrecio base");
		this.color = leerColor();
		this.consumo = leerConsumo();
		this.masa = Teclado.leerInt("\nMasa");
	}

	public String leerClave() {
		String identificador = Teclado.leerString("\nIdentificador");

		return identificador;
	}

	public Color leerColor() {
		String color;
		ArrayList<String> colores = new ArrayList();

		colores = Color.getValuesAsStringArrayList();

		do {
			Pantalla.escribirString("\nSeleccione un color");
			Pantalla.escribirString("\n" + colores);
			color = Teclado.leerString("\nColor").toUpperCase();
		} while (!colores.contains(color));

		return Color.valueOf(color);
	}

	public Consumo leerConsumo() {
		String consumo;
		ArrayList<String> consumos = new ArrayList();

		consumos = Consumo.getValuesAsStringArrayList();

		do {
			Pantalla.escribirString("\nSeleccione un consumo");
			Pantalla.escribirString("\n" + consumos);
			consumo = Teclado.leerString("\nConsumo").toUpperCase();
		} while (!consumos.contains(consumo));

		return Consumo.valueOf(consumo);
	}

	@Override
	public String toString() {
		return "Electrodomestico [identificador=" + identificador + ", stock=" + stock + ", precioBase=" + precioBase
				+ ", color=" + color + ", consumo=" + consumo + ", masa=" + masa + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

	public float calcularPrecio() {
		float precioFinal, bonus = 0;

		switch (consumo) {
		case A:
			bonus = 100;
			break;
		case B:
			bonus = 80;
			break;
		case C:
			bonus = 60;
			break;
		case D:
			bonus = 50;
			break;
		case E:
			bonus = 30;
			break;
		case F:
			bonus = 10;
			break;
		}

		if (masa < 20) {
			bonus = +10;
		} else {
			if (masa < 50) {
				bonus = +50;
			} else {
				if (masa < 80) {
					bonus = +80;
				} else {
					bonus = +100;
				}
			}
		}

		precioFinal = this.precioBase + bonus;

		return precioFinal;
	}

	@Override
	public int compareTo(Electrodomestico e) {
		return identificador.compareTo(e.identificador);
	}

}
