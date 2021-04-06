package institutoMio;

import daw.com.Teclado;

public class Direccion {
	private String calle;
	private String ciudad;
	private String cp;
	private String pais;
	
	public Direccion () {
		this("", "", "", "");
	}

	public Direccion(String calle, String ciudad, String cp, String pais) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.cp = cp;
		this.pais = pais;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public void leerDatos() {
		this.calle = Teclado.leerString("\nCalle");
		this.ciudad = Teclado.leerString("\nCiudad");
		this.cp = Teclado.leerString("\nCodigo postal");
		this.pais = Teclado.leerString("\nPais");
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", ciudad=" + ciudad + ", cp=" + cp + ", pais=" + pais + "]";
	}
}
