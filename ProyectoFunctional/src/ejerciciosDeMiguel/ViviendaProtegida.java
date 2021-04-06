package ejerciciosDeMiguel;

import java.time.LocalDate;

import daw.com.Teclado;

public class ViviendaProtegida extends Vivienda {

	private LocalDate fecha;
	private int valorMuebles;

	public ViviendaProtegida() {
		super();
		// TODO Auto-generated constructor stub

	}

	public ViviendaProtegida(String direccion, int superficie, String descripcion, float pvp, LocalDate fecha,
			int valorMuebles) {
		super(direccion, superficie, descripcion, pvp);
		// TODO Auto-generated constructor stub
		setFecha(fecha);
		setValorMuebles(valorMuebles);
	}

	public ViviendaProtegida(String direccion) {
		super(direccion);
		// TODO Auto-generated constructor stub
		fecha = LocalDate.now();
		valorMuebles = 0;
	}

	public ViviendaProtegida(ViviendaProtegida original) {
		super(original);
		// TODO Auto-generated constructor stub
		this.fecha = original.fecha;
		valorMuebles = original.valorMuebles;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {

		this.fecha = fecha;
	}

	public int getValorMuebles() {
		return valorMuebles;
	}

	public void setValorMuebles(int valorMuebles) {
		if (valorMuebles < 0)
			valorMuebles = 0;
		this.valorMuebles = valorMuebles;
	}

	public void leerOtroDatos() {
		String f;
		super.leerOtroDatos();
		f = Teclado.leerString("fecha (yyyy-mm-dd)");
		fecha = LocalDate.parse(f);
		setValorMuebles(Teclado.leerInt("valor muebles"));

	}

	@Override
	public float getExtra() {
		// TODO Auto-generated method stub
		return valorMuebles;
	}

	@Override
	public String toString() {
		return "ViviendaProtegida [fecha=" + fecha + ", valorMuebles=" + valorMuebles + ", toString()="
				+ super.toString() + "]";
	}

}
