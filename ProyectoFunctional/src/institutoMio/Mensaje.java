package institutoMio;

import java.time.LocalDate;

public class Mensaje {
	private String emisor;
	private LocalDate fecha;
	private String contenido;
	
	public Mensaje(String emisor, LocalDate fecha, String contenido) {
		this.emisor = emisor;
		this.fecha = fecha;
		this.contenido = contenido;
	}
	
	public Mensaje() {
		this("",null, "");
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Mensaje [emisor=" + emisor + ", fecha=" + fecha + ", contenido=" + contenido + "]";
	}
}
