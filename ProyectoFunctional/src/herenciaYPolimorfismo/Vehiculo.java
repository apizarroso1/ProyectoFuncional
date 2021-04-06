package herenciaYPolimorfismo;

import daw.com.Teclado;
import daw.com.Pantalla;

public class Vehiculo {

	private String propietario;
	private String matricula;
	private int potencia;

	public Vehiculo(String propietario, String matricula, int potencia) {
		this.propietario = propietario;
		this.matricula = matricula;
		this.potencia = potencia;
	}

	public Vehiculo() {
		this(" ", "1", 0);
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		if (potencia < 0) {
			potencia = 0;
		}
		this.potencia = potencia;
	}

	public void leerDatos() {
		this.propietario = Teclado.leerString("\nPropietario");
		this.matricula = Teclado.leerString("\nMatrícula");
		this.potencia = Teclado.leerInt("\nPotencia");
	}

	@Override
	public boolean equals(Object obj) {
		Vehiculo other = (Vehiculo) obj;
		return this.matricula.equals(other.matricula);
	}

	@Override
	public String toString() {
		return "Vehiculo [propietario=" + propietario + ", matricula=" + matricula + ", potencia=" + potencia + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}
}
