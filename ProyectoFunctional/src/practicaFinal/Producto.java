package practicaFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Teclado;

public abstract class Producto {

	private String ref;
	private String nombre;
	private float precio;
	private int stock;

	public Producto(String ref, String nombre, float precio, int stock) {
		super();
		this.ref = ref;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public Producto() {
		this("", "", 0, 0);
	}

	public Producto(String ref) {
		this(ref, "", 0, 0);
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		
		if (precio < 0) {
			throw new IllegalArgumentException("Precio no puede ser negativo");
		}
		
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		
		if (stock < 0) {
			throw new IllegalArgumentException("Stock no puede ser negativo");
		}
		
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [ref=" + ref + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
	
	public void mostrarDatos() {
		System.out.println(toString());
	}
	
	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}
	
	public void leerClave() {
		this.ref = Teclado.leerString("\nNumero de referencia");
	}
	
	public void leerOtrosDatos() {
		this.nombre = Teclado.leerString("\nNombre del producto");
		setPrecio(Teclado.leerFloat("\nPrecio del producto"));
		setStock(Teclado.leerInt("\nStock del producto"));
	}
	
	public void escribirFicheroBin(DataOutputStream fichero) throws IOException {
		
		fichero.writeUTF(ref);
		fichero.writeUTF(nombre);
		fichero.writeFloat(precio);
		fichero.writeInt(stock);
	}
	
	public void leerFicheroBin(DataInputStream fichero) throws IOException {
		
		this.ref = fichero.readUTF();
		this.nombre = fichero.readUTF();
		this.precio = fichero.readFloat();
		this.stock = fichero.readInt();
	}
	
	public abstract float calcularPvp();	
}
