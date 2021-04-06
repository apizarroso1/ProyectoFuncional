package herenciaYPolimorfismo;

import java.time.LocalDate;

import daw.com.Pantalla;

public class Visita {
	private LocalDate fecha;
	private Vivienda vivienda;
	private ClienteVivienda cliente;
	private int valoracion;

	public Visita(LocalDate fecha, Vivienda vivienda, ClienteVivienda cliente, int valoracion) {
		this.fecha = fecha;
		this.vivienda = vivienda;
		this.cliente = cliente;
		this.valoracion = valoracion;
	}

	public Visita(LocalDate fecha, Vivienda vivienda, ClienteVivienda cliente) {
		this.fecha = fecha;
		this.vivienda = vivienda;
		this.cliente = cliente;
		this.valoracion = 0;
	}

	public Visita() {
		this(null, null, null, 0);
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public ClienteVivienda getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVivienda cliente) {
		this.cliente = cliente;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
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
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (valoracion != other.valoracion)
			return false;
		if (vivienda == null) {
			if (other.vivienda != null)
				return false;
		} else if (!vivienda.equals(other.vivienda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visita [fecha=" + fecha + ", vivienda=" + vivienda + ", cliente=" + cliente + ", valoracion="
				+ valoracion + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

}
