package clubDeportistas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import daw.com.Teclado;

public class Cicilista extends Deportista {

	private String nombrePrueba;
	private int nEtapas, clasificacion, etapasGanadas;

	public Cicilista(String dni, String nombre, String tipo, LocalDate fechaNac, String nombrePrueba, int nEtapas,
			int clasificacion, int etapasGanadas) {
		super(dni, nombre, tipo, fechaNac);
		this.nombrePrueba = nombrePrueba;
		this.nEtapas = nEtapas;
		this.clasificacion = clasificacion;
		this.etapasGanadas = etapasGanadas;
	}

	public Cicilista() {
		super("", "", "Atleta", LocalDate.now());
		this.nombrePrueba = "";
		this.nEtapas = 0;
		this.clasificacion = 0;
		this.etapasGanadas = 0;
	}

	public Cicilista(String dni) {
		super(dni, "", "Atleta", LocalDate.now());
		this.nombrePrueba = "";
		this.nEtapas = 0;
		this.clasificacion = 0;
		this.etapasGanadas = 0;
	}

	public String getNombrePrueba() {
		return nombrePrueba;
	}

	public void setNombrePrueba(String nombrePrueba) {
		this.nombrePrueba = nombrePrueba;
	}

	public int getnEtapas() {
		return nEtapas;
	}

	public void setnEtapas(int nEtapas) {

		if (nEtapas < 0) {
			throw new IllegalArgumentException("Numero de etapas incorrecto");
		}

		this.nEtapas = nEtapas;
	}

	public int getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(int clasificacion) {

		if (clasificacion < 0) {
			throw new IllegalArgumentException("Clasificacion incorrecta");
		}

		this.clasificacion = clasificacion;
	}

	public int getEtapasGanadas() {
		return etapasGanadas;
	}

	public void setEtapasGanadas(int etapasGanadas) {

		if (etapasGanadas > this.nEtapas || etapasGanadas < 0) {
			throw new IllegalArgumentException("Numero de etapas ganadas incorrecto");
		}

		this.etapasGanadas = etapasGanadas;
	}

	@Override
	public String toString() {
		return "Cicilista [nombrePrueba=" + nombrePrueba + ", nEtapas=" + nEtapas + ", clasificacion=" + clasificacion
				+ ", etapasGanadas=" + etapasGanadas + ", toString()=" + super.toString() + "]";
	}

	public void mostrarDatos() {
		System.out.println(toString());
	}

	public void leerDatos() {
		super.leerDatos();
		this.nombrePrueba = Teclado.leerString("\nNombre de la prueba");
		setnEtapas(Teclado.leerInt("\nNumero de etapas"));
		setClasificacion(Teclado.leerInt("\nClasificacion"));
		setEtapasGanadas(Teclado.leerInt("\nEtapas ganadas"));
	}

	public void escribirFichero(DataOutputStream Deportistas) throws IOException {

		Deportistas.writeUTF(nombrePrueba);
		Deportistas.writeInt(nEtapas);
		Deportistas.writeInt(clasificacion);
		Deportistas.writeInt(etapasGanadas);
	}

	public void leerFichero(DataInputStream Deportistas) throws IOException {

		this.nombrePrueba = Deportistas.readUTF();
		this.nEtapas = Deportistas.readInt();
		this.clasificacion = Deportistas.readInt();
		this.etapasGanadas = Deportistas.readInt();
	}

}
