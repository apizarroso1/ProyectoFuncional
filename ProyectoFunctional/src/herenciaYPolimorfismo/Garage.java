package herenciaYPolimorfismo;

import daw.com.Teclado;

public class Garage {
	private int nPlazas;

	public Garage(int nPlazas) {
		this.nPlazas = Teclado.leerInt("\nN�mero de plazas");
	}
	
	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	public Garage () {
		this.nPlazas = 0;
	}
	

}
