package examenMayo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Teclado;

public class Clasica extends Via{
	
	private int nLargos;

	
	public Clasica(String nombre, int grado, int longitud, int nLargos) {
		super(nombre, grado, longitud);
		this.nLargos = nLargos;
	}


	public Clasica ()
	{
		super("", 1, 0);
		this.nLargos = 0;
	}
	
	public Clasica(String nombre) {
		super(nombre, 1, 0);
		this.nLargos = 0;
	}
	
	public int getnLargos() {
		return nLargos;
	}


	public void setnLargos(int nLargos) {
		if (nLargos < 1) {
			throw new IllegalArgumentException("El número de largos debe seer como mínimo 1");
		} else {
			this.nLargos = nLargos;
		}
	}

	@Override
	public String toString() {
		return "Clasica [nLargos=" + nLargos + ", toString()=" + super.toString() + ", coste de rescate:"
				+ calcularRescate() + "]";
	}
	
	public void leerDatos() {
		super.leerNombre();
		leerOtrosDatos();
	}
	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setnLargos(Teclado.leerInt("\nNúmero de largos de la vía"));
	}
	
	public void mostrarDatos() {
		System.out.println(toString());
	}
	
	public void escribirDatosBin(DataOutputStream fichero) throws IOException {
		super.escribirDatosBin(fichero);
		fichero.writeInt(this.nLargos);
	}
	
	public void leerDatosBin(DataInputStream fichero) throws IOException{
		super.leerDatosBin(fichero);
		this.nLargos = fichero.readInt();
	}

	@Override
	public float calcularRescate() {
		float producto;
		
		producto = 250 * this.nLargos;
		
		return super.getDesplazamiento() + producto;
	}

}
