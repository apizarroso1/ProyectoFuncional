package herenciaYPolimorfismo;

import daw.com.Teclado;
import daw.com.Pantalla;

public class Coche extends Vehiculo {

	private int nPlazas;

	public Coche(String propietario, String matricula, int potencia, int nPlazas) {
		super(propietario, matricula, potencia);
		this.nPlazas = nPlazas;
	}

	public Coche() {
		super(" ", " ", 0);
		this.nPlazas = 0;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		if (nPlazas < 0) {
			nPlazas = 0;
		}
		this.nPlazas = nPlazas;
	}

	public void leerDatos() {
		super.leerDatos();
		this.nPlazas = Teclado.leerInt("\nNúmero de plazas");
	}

}
