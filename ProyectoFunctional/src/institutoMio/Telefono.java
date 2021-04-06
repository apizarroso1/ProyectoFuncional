package institutoMio;

import daw.com.Teclado;

public class Telefono {
	private String tipo;
	private String numero;
	
	public Telefono() {
		this("", "");
	}
	
	public Telefono(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void leerDatos() {
		this.tipo = Teclado.leerString("\nTipo de telefono");
		this.numero = Teclado.leerString("\nNumero de telefono");
	}

	@Override
	public String toString() {
		return "Telefono [tipo=" + tipo + ", numero=" + numero + "]";
	}
}
