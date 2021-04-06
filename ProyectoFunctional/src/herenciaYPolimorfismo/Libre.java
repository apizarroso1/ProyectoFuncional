package herenciaYPolimorfismo;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Libre extends Vivienda {
	private float comision;

	public Libre(String direccion, int superficie, String descripcion, float PVP, float comision) {
		super(direccion, superficie, descripcion, PVP);
		this.comision = comision;
	}

	public Libre(String direccion) {
		super(direccion, 0, "", 0);
		this.comision = 0;
	}

	public Libre() {
		super("", 0, "", 0);
		this.comision = 0;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		this.comision = Teclado.leerFloat("\nComision");
	}

	@Override
	public String toString() {
		return "Libre [comision=" + comision + ", toString()=" + super.toString() + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

	@Override
	public float calcularPrecio() {
		float pvpFinal;

		pvpFinal = getPVP() + comision;

		return pvpFinal;
	}
}
