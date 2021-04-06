package interfaces;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Cliente {
	private String cif;
	private String nombre;
	private String telefono;
	private float saldo;

	public Cliente(String cif, String nombre, String telefono, float saldo) {
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		this.saldo = saldo;
	}

	public Cliente(String cif) {
		this.cif = cif;
		this.nombre = "";
		this.telefono = "";
		this.saldo = 0;
	}

	public Cliente() {
		this("", "", "", 0);
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		if (saldo < 0) {
			saldo = 0;
		}
		this.saldo = saldo;
	}

	public void leerDatos() {
		this.cif = leerClave();
		this.nombre = Teclado.leerString("\nNombre");
		this.telefono = Teclado.leerString("\nTelefono");
		this.saldo = Teclado.leerFloat("\nSaldo");
	}

	public String leerClave() {
		String cif = Teclado.leerString("\nCIF");
		return cif;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", telefono=" + telefono + ", saldo=" + saldo + "]";
	}

	public void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

}
