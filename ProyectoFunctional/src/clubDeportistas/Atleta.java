package clubDeportistas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

import daw.com.Teclado;

public class Atleta extends Deportista {

	private String lugarPrueba;
	private int distancia;
	private Duration marca;

	public Atleta(String dni, String nombre, String tipo, LocalDate fechaNac, String lugarPrueba, int distancia,
			Duration marca) {
		super(dni, nombre, tipo, fechaNac);
		this.lugarPrueba = lugarPrueba;
		this.distancia = distancia;
		this.marca = marca;
	}

	public Atleta() {
		super("", "", "Atleta", LocalDate.now());
		this.lugarPrueba = "";
		this.distancia = 0;
		this.marca = Duration.ofHours(0);
	}

	public Atleta(String dni) {
		super(dni, "", "Atleta", LocalDate.now());
		this.lugarPrueba = "";
		this.distancia = 0;
		this.marca = Duration.ofHours(0);
	}

	public String getLugarPrueba() {
		return lugarPrueba;
	}

	public void setLugarPrueba(String lugarPrueba) {
		this.lugarPrueba = lugarPrueba;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		if (distancia < 0) {
			distancia = 0;
		}

		this.distancia = distancia;
	}

	public Duration getMarca() {
		return marca;
	}

	public void setMarca(Duration marca) {

		if (marca.getSeconds() <= 0) {
			throw new IllegalArgumentException("Marca temporal incorrecta");
		} else {
			this.marca = marca;
		}
	}

	@Override
	public String toString() {
		return "Atleta [lugarPrueba=" + lugarPrueba + ", distancia=" + distancia + ", marca=" + marca + ", toString()="
				+ super.toString() + "]";
	}

	public void leerDatos() {
		super.leerDatos();
		this.lugarPrueba = Teclado.leerString("\nLugar prueba");
		setDistancia(Teclado.leerInt("\nDistancia"));
		leerMarca();
	}

	public void leerMarca() {
		int horas, minutos, segundos;

		/*
		 * horas = Teclado.leerInt("\nHoras"); minutos = Teclado.leerInt("\nMinutos");
		 * segundos = Teclado.leerInt("\nSegundos");
		 */

		// this.marca = Duration.ofHours(horas).toSeconds() +
		// Duration.ofMinutes(minutos).toSeconds() + Duration.ofSeconds(segundos);
	}

	public void escribirFichero(DataOutputStream Deportistas) throws IOException {

		Deportistas.writeUTF(lugarPrueba);
		Deportistas.writeInt(distancia);
		Deportistas.writeUTF(this.marca.toString());
	}

	public void leerFichero(DataInputStream Deportistas) throws IOException {

		this.lugarPrueba = Deportistas.readUTF();
		this.distancia = Deportistas.readInt();
		this.marca = Duration.parse(Deportistas.readUTF());
	}

}
