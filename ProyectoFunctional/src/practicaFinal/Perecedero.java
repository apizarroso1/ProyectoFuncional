package practicaFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import daw.com.Teclado;

public class Perecedero extends Producto {

	private LocalDate fechaCad;

	public Perecedero(String ref, String nombre, float precio, int stock, LocalDate fechaCad) {
		super(ref, nombre, precio, stock);
		this.fechaCad = fechaCad;
	}

	public Perecedero() {
		super("", "", 0, 0);
		this.fechaCad = LocalDate.now();
	}
	
	public Perecedero(String ref) {
		super(ref, "", 0, 0);
		this.fechaCad = LocalDate.now();
	}

	public LocalDate getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(LocalDate fechaCad) {
		this.fechaCad = fechaCad;
	}

	public void leerDatos() {
		super.leerDatos();
		leerFechaCad();
	}

	public void leerFechaCad() {
		String formatoString;
		DateTimeFormatter formato;

		formatoString = "dd/mm/yyyy";

		formato = DateTimeFormatter.ofPattern(formatoString);

		setFechaCad(LocalDate.parse(Teclado.leerString("\nFecha de caducidad" + formatoString), formato));
	}

	public void mostrarDatos() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Perecedero [fechaCad=" + fechaCad + ", toString()=" + super.toString() + "]";
	}

	public void escribirFicheroBin(DataOutputStream fichero) throws IOException {

		super.escribirFicheroBin(fichero);
		fichero.writeUTF(fechaCad.toString());
	}

	public void leerFicheroBin(DataInputStream fichero) throws IOException {

		super.leerFicheroBin(fichero);
		this.fechaCad = LocalDate.parse(fichero.readUTF());
	}

	@Override
	public float calcularPvp() {
		Period periodo;
		double bonus;
		periodo = Period.between(fechaCad, LocalDate.now());

		if (periodo.getDays() > 5) {
			bonus = 2;
		} else {
			if (5 >= periodo.getDays() || periodo.getDays() <= 3) {
				bonus = 1.5;
			} else {
				if (periodo.getDays() < 3 && periodo.getDays() > 0) {
					bonus = 1;
				} else {
					bonus = 0;
				}

			}
		}

		super.setPrecio((float) (super.getPrecio() * bonus));

		return super.getPrecio();
	}
}
