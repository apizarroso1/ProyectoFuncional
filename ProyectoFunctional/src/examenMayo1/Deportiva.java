package examenMayo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import daw.com.Teclado;

public class Deportiva extends Via {

	private int nSeguros;
	private LocalDate fechaRevision;

	public Deportiva(String nombre, int grado, int longitud, int nSeguros, LocalDate fechaRevision) {
		super(nombre, grado, longitud);
		this.nSeguros = nSeguros;
		this.fechaRevision = fechaRevision;
	}

	public Deportiva() {
		super("", 1, 0);
		this.nSeguros = 0;
		this.fechaRevision = null;
	}

	public Deportiva(String nombre) {
		super(nombre, 1, 0);
		this.nSeguros = 0;
		this.fechaRevision = null;
	}

	public int getnSeguros() {
		return nSeguros;
	}

	public void setnSeguros(int nSeguros) {
		if (nSeguros < 0) {
			throw new IllegalArgumentException("El número de seguros no puede ser menor que cero");
		} else {
			this.nSeguros = nSeguros;
		}
	}

	public LocalDate getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(LocalDate fechaRevision) {
		if (fechaRevision.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de la última revisión no puede ser en el futuro");
		} else {
			this.fechaRevision = fechaRevision;
		}
	}

	@Override
	public String toString() {
		return "Deportiva [nSeguros=" + nSeguros + ", fechaRevision=" + fechaRevision + ", toString()="
				+ super.toString() + ", coste de rescate:" + calcularRescate() + "]";
	}

	public void mostrarDatos() {
		System.out.println(toString());
	}

	public void leerDatos() {
		super.leerNombre();
		super.leerOtrosDatos();
	}

	@Override
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		setnSeguros(Teclado.leerInt("\nNúmero de seguros contratados en la vía"));
		leerFechaRevision();
	}

	public void leerFechaRevision() {
		String formatoString;
		DateTimeFormatter formato;
		LocalDate fecha;

		formatoString = "dd/MM/yyyy";

		formato = DateTimeFormatter.ofPattern(formatoString);

		fecha = LocalDate.parse(Teclado.leerString("\nFecha de la última revisión en formato dd/mm/yyyy"), formato);

		setFechaRevision(fecha);
	}

	public void escribirDatosBin(DataOutputStream fichero) throws IOException {
		super.escribirDatosBin(fichero);
		fichero.writeInt(nSeguros);
		fichero.writeUTF(fechaRevision.toString());
	}

	public void leerDatosBin(DataInputStream fichero) throws IOException {
		super.leerDatosBin(fichero);
		this.nSeguros = fichero.readInt();
		this.fechaRevision = LocalDate.parse(fichero.readUTF());
	}

	@Override
	public float calcularRescate() {

		return (super.getDesplazamiento() + super.getLongitud() * calcularDias()) / nSeguros;
	}

	public int calcularDias() {
		Period periodo;

		periodo = Period.between(fechaRevision, LocalDate.now());

		return periodo.getDays();
	}
}
