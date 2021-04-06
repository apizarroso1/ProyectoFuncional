package herenciaYPolimorfismo;

import java.time.LocalDate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Protegida extends Vivienda {
	private LocalDate construccion;
	private float pvpMuebles;

	public Protegida(String direccion, int superficie, String descripcion, float PVP, LocalDate construccion,
			float pvpMuebles) {
		super(direccion, superficie, descripcion, PVP);
		this.construccion = construccion;
		this.pvpMuebles = pvpMuebles;
	}

	public Protegida(String direccion) {
		super(direccion, 0, "", 0);
		this.construccion = null;
		this.pvpMuebles = 0;
	}

	public Protegida() {
		super("", 0, "", 0);
		this.construccion = null;
		this.pvpMuebles = 0;
	}

	public LocalDate getConstruccion() {
		return construccion;
	}

	public void setConstruccion(LocalDate construccion) {
		this.construccion = construccion;
	}

	public float getPvpMuebles() {
		return pvpMuebles;
	}

	public void setPvpMuebles(float pvpMuebles) {
		this.pvpMuebles = pvpMuebles;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		leerFecha();
		this.pvpMuebles = Teclado.leerFloat("\nPVP muebles");
	}

	public void leerFecha() {
		int d, m, a;

		do {
			d = Teclado.leerInt("\nDia de construccion");
		} while (d > 31 || d < 1);

		do {
			m = Teclado.leerInt("\nMes de construccion");
		} while (m > 12 || m < 1);

		do {
			a = Teclado.leerInt("\nAnio de construccion");
		} while (a < 1 || a > 2021);
	}

	@Override
	public String toString() {
		return "Protegida [construccion=" + construccion + ", pvpMuebles=" + pvpMuebles + ", toString()="
				+ super.toString() + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

	@Override
	public float calcularPrecio() {
		float pvpFinal;

		pvpFinal = getPVP() + pvpMuebles;

		return pvpFinal;
	}
}
