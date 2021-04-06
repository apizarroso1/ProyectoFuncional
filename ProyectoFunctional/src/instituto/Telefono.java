package institutosimple;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Telefono {
	private String tipo;
	private String numero;
	
	
	public Telefono(String tipo, String numero) {
	
		this.tipo = tipo;
		this.numero = numero;
	}

	public Telefono clone ()
	{
		return new Telefono (tipo, numero);
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


	@Override
	public String toString() {
		return "Telefono [tipo=" + tipo + ", numero=" + numero + "]";
	}
	
	public void leerDatos ()
	{
		this.tipo = Teclado.leerString("tipo telef");
		this.numero = Teclado.leerString("numero telef.");
	}
	
	

}
