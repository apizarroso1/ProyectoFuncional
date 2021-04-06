package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Moto extends Vehiculo {

	private boolean antirrobos = false;

	public Moto(String propietario, String matricula, int potencia, boolean antirrobos) {
		super(propietario, matricula, potencia);
		this.antirrobos = antirrobos;
	}

	public Moto() {
		super(" ", " ", 0);
		this.antirrobos = false;
	}

	public boolean isAntirrobos() {
		return antirrobos;
	}

	public void setAntirrobos(boolean antirrobos) {
		this.antirrobos = antirrobos;
	}

	public void leerDatos() {
		super.leerDatos();
		this.antirrobos = leerAntirrobos();
	}

	public boolean leerAntirrobos() {
		boolean exito = false;
		if (Teclado.leerString("\nSistema antirrobos (s/n)").equalsIgnoreCase("s")) {
			exito = true;
		}

		return exito;
	}
}
