package practicaFinal;

import java.util.List;

import daw.com.Teclado;

public class NoPerecedero extends Producto {

	private static final String LOCAL = "Espania";
	private Tipo tipo;
	private String procedencia;

	public NoPerecedero(String ref, String nombre, float precio, int stock, Tipo tipo, String procedencia) {
		super(ref, nombre, precio, stock);
		this.tipo = tipo;
		this.procedencia = procedencia;
	}

	public NoPerecedero() {
		super("", "", 0, 0);
		this.tipo = null;
		this.procedencia = "Sin procedencia";
	}

	public NoPerecedero(String ref) {
		super(ref, "", 0, 0);
		this.tipo = null;
		this.procedencia = "Sin procedencia";
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public static String getLocal() {
		return LOCAL;
	}

	public void leerDatos() {
		super.leerDatos();
		leerTipo();
		this.procedencia = Teclado.leerString("\nProcedencia del producto");
	}

	public void leerTipo() {
		List<String> tipos = Tipo.getValuesAsStringArrayList();
		String tipo = "";
		System.out.println(tipos);

		while (!tipos.contains(tipo)) {
			tipo = Teclado.leerString("\nIntroduzca uno de los tipos");
		}

		this.tipo = Tipo.valueOf(tipo);
	}

	@Override
	public float calcularPvp() {
		double bonus = this.tipo.getBonus();

		if (!this.procedencia.equalsIgnoreCase(LOCAL)) {
			super.setPrecio((float) (super.getPrecio() * bonus));
		}

		return super.getPrecio();
	}

}
