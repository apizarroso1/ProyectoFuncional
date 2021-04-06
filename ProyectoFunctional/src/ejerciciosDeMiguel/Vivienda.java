package ejerciciosDeMiguel;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Vivienda {
	private String direccion;
	private int superficie;
	private String descripcion;
	private float pvp;

	public Vivienda(String direccion, int superficie, String descripcion, float pvp) {

		this.direccion = direccion;
		setSuperficie(superficie);
		this.descripcion = descripcion;
		setPvp(pvp);
	}

	public Vivienda() {
		this("", 0, "", 0);
	}

	public Vivienda(String direccion) {
		this(direccion, 0, "", 0);
	}

	public Vivienda(Vivienda original) {
		this(original.direccion, original.superficie, original.descripcion, original.pvp);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		if (superficie < 0)
			superficie = 0;

		this.superficie = superficie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		if (pvp < 0)
			pvp = 0;
		this.pvp = pvp;
	}

	@Override
	public boolean equals(Object obj) {
		Vivienda otro = (Vivienda) obj;

		return direccion.equalsIgnoreCase(otro.direccion);
	}

	public void leerClave() {
		direccion = Teclado.leerString("direccion");

	}

	public void leerOtroDatos() {
		setSuperficie(Teclado.leerInt("superficie"));
		this.descripcion = Teclado.leerString("descripcion");
		setPvp(Teclado.leerFloat("pvp"));
	}

	public void leerDatos() {
		leerClave();
		leerOtroDatos();
	}

	public float getPrecioFinal() {
		return pvp + getExtra();
	}

	abstract public float getExtra();

	@Override
	public String toString() {
		return "Vivienda [direccion=" + direccion + ", superficie=" + superficie + ", descripcion=" + descripcion
				+ ", pvp=" + pvp + ", precio final = " + getPrecioFinal() + "]";
	}

	public void verDatos() {
		Pantalla.escribirString("\n" + this);
	}

}
