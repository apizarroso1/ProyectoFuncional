package herenciaYPolimorfismo;

import java.time.LocalDate;

import daw.com.Teclado;

public class Prestamo {
	private LocalDate inicio;
	private boolean devuelto = false;
	private int codCliente;
	private int codMaterial;
	
	public Prestamo(LocalDate inicio, boolean devuelto, int codCliente, int codMaterial) {
		this.inicio = inicio;
		this.devuelto = devuelto;
		this.codCliente = codCliente;
		this.codMaterial = codMaterial;
	}
	
	public Prestamo() {
		this (LocalDate.now(),false, 0, 0);
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodMaterial() {
		return codMaterial;
	}

	public void setCodMaterial(int codMaterial) {
		this.codMaterial = codMaterial;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	
	public void leerDatos() {
		this.inicio = leerFecha();
	}

	public LocalDate leerFecha() {
		int dia, mes, anio;
		
		do {
			dia = Libreria.leerEntre(1, 31, "\nDia");
		} while (dia == 0);
		
		do {
			mes = Libreria.leerEntre(1, 12, "\nMes");
		} while (mes == 0);
		
		do {
			anio = Teclado.leerInt("\nAño");
		} while (anio == 0);
		
		return LocalDate.of(anio, mes, dia);
	}
	
	@Override
	public String toString() {
		return "Prestamo [inicio=" + inicio + ", devuelto=" + devuelto + ", codCliente=" + codCliente + ", codMaterial="
				+ codMaterial + "]";
	}

	public String mostrarDatos() {
		return "\n" + toString();
	}
	
	

}
