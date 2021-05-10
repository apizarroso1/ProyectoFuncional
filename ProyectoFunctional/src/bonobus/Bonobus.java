package bonobus;

import daw.com.Teclado;

public class Bonobus implements LeerYMostrarDatos{

	private String nombre;
	private int saldo;
	
	public Bonobus(String nombre, int saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	public Bonobus() {
		this("",0);
	}
	
	public Bonobus(String nombre) {
		this(nombre, 0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		
		try {
			if (saldo < 0) {
				throw (new IllegalArgumentException("Saldo negativo"));
			}
		}
		
		finally {
			this.saldo = saldo;
		}
	}

	@Override
	public void leerOtrosDatos() {
		setSaldo(Teclado.leerInt("\nSaldo del bonobus"));
	}

	@Override
	public void leerClave() {
		this.nombre = Teclado.leerString("\nNombre del usuario");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + saldo;
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
		Bonobus other = (Bonobus) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bonobus [nombre=" + nombre + ", saldo=" + saldo + "]";
	}
	
	public void insertarSaldo(int saldoExtra) {
		setSaldo(this.getSaldo() + saldoExtra);
	}
	
	public void picar() throws FunkyException {
		
		if (this.getSaldo() == 0) {
			throw new FunkyException();
		}
		
		saldo--;
	}
	
	
	
}
