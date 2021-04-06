package ejerciciosDeMiguel;

import java.time.LocalDate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Visita {
	private Cliente cliente;
	private Vivienda vivienda;
	private LocalDate fechaVisita;
	private int puntuacion;

	public Visita() {
		cliente = null;
		vivienda = null;
		fechaVisita = null;
		puntuacion = 0;
	}

	public Visita(Cliente cliente, Vivienda vivienda, LocalDate fechaVisita, int puntuacion) {
		super();
		this.cliente = cliente;
		this.vivienda = vivienda;
		this.fechaVisita = fechaVisita;
		this.puntuacion = puntuacion;
	}

	public Visita(Visita o) {
		this(o.cliente, o.vivienda, o.fechaVisita, o.puntuacion);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public LocalDate getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(LocalDate fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fechaVisita == null) {
			if (other.fechaVisita != null)
				return false;
		} else if (!fechaVisita.equals(other.fechaVisita))
			return false;
		if (vivienda == null) {
			if (other.vivienda != null)
				return false;
		} else if (!vivienda.equals(other.vivienda))
			return false;
		return true;
	}

	public void leerOtrosDatos() {
		String f;
		f = Teclado.leerString("fecha (yyyy-mm-dd)");
		fechaVisita = LocalDate.parse(f);
		puntuacion = Libreria.leerEntre(1, 10, "puntuación");
	}

	@Override
	public String toString() {
		return "Visita [cliente=" + cliente + ", vivienda=" + vivienda + ", fechaVisita=" + fechaVisita
				+ ", puntuacion=" + puntuacion + "]";
	}

	public void verDatos() {
		Pantalla.escribirString("\n" + this);
	}
}
