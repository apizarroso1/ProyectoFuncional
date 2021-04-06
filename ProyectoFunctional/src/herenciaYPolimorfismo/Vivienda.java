package herenciaYPolimorfismo;

import daw.com.Teclado;

public abstract class Vivienda {
	private String direccion;
	private int superficie;
	private String descripcion;
	private float PVP;

	public Vivienda(String direccion, int superficie, String descripcion, float PVP) {
		this.direccion = direccion;
		this.superficie = superficie;
		this.descripcion = descripcion;
		PVP = PVP;
	}

	public Vivienda(String direccion) {
		this.direccion = direccion;
		this.superficie = 0;
		this.descripcion = "";
		this.PVP = 0;
	}

	public Vivienda() {
		this("", 0, "", 0);
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
		this.superficie = superficie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPVP() {
		return PVP;
	}

	public void setPVP(float pVP) {
		PVP = pVP;
	}

	public void leerDatos() {
		leerClave();
		this.descripcion = Teclado.leerString("\nDescripcion");
		this.superficie = Teclado.leerInt("\nSuperficie");
		this.PVP = Teclado.leerFloat("\nPVP");
	}

	public void leerClave() {
		this.direccion = Teclado.leerString("\nDireccion");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vivienda other = (Vivienda) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vivienda [direccion=" + direccion + ", superficie=" + superficie + ", descripcion=" + descripcion
				+ ", PVP=" + PVP + "]";
	}

	public abstract float calcularPrecio();
}
