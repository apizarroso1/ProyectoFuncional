package ejercicioExtraInterfaces;

import java.util.ArrayList;

import daw.com.Teclado;

public class Empleado implements LeerYMostrarDatos {
	private DatosPersonales datosPersonales;
	private int antiguedad;
	private String telefono;
	private float salario;
	private Empleado supervisor;
	private float BONUS = (float) 1.05;

	public Empleado(int antiguedad, String telefono, float salario, Empleado supervisor) {
		this.datosPersonales = new DatosPersonales();
		this.antiguedad = antiguedad;
		this.telefono = telefono;
		this.salario = salario;
		this.supervisor = null;
	}

	public Empleado(DatosPersonales datosPersonales, String nif) {
		this.datosPersonales = new DatosPersonales(nif);
		this.antiguedad = 0;
		this.telefono = "";
		this.salario = 0;
		this.supervisor = null;
	}

	public Empleado() {
		this.antiguedad = 0;
		this.telefono = "";
		this.salario = 0;
		this.supervisor = null;
		}

	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Empleado getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}

	public float getBONUS() {
		return BONUS;
	}

	public void setBONUS(float bONUS) {
		BONUS = bONUS;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Empleado other = (Empleado) obj;
		if (Float.floatToIntBits(BONUS) != Float.floatToIntBits(other.BONUS))
			return false;
		if (antiguedad != other.antiguedad)
			return false;
		if (datosPersonales == null) {
			if (other.datosPersonales != null)
				return false;
		} else if (!datosPersonales.equals(other.datosPersonales))
			return false;
		if (Float.floatToIntBits(salario) != Float.floatToIntBits(other.salario))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [datosPersonales=" + datosPersonales + ", antiguedad=" + antiguedad + ", telefono=" + telefono
				+ ", salario=" + salario + ", supervisor=" + supervisor + ", BONUS=" + BONUS + "]";
	}

	@Override
	public void leerClave() {
		this.datosPersonales.leerDatos();
	}

	@Override
	public void leerOtrosDatos() {
		this.antiguedad = Teclado.leerInt("\nAntiguedad");
		this.telefono = Teclado.leerString("\nTelefono");
		this.salario = Teclado.leerFloat("\nSalario");	
	}

	private Empleado asignarSupervisor(ArrayList <Empleado> empleados) {
		Empleado e;
		String nif;
		FunkyConsumer consumer = new FunkyConsumer();
		
		empleados.forEach(consumer);
		
		nif = Teclado.leerString("\nNif de supervisor");
		
		e = getEmpleado(nif, empleados);
		
		return null;
	}
	
	public Empleado getEmpleado(String nif, ArrayList<Empleado> empleados) {
		
		
		
		
		return null;
	}
	
	public void eliminarSueldosBajos(ArrayList<Empleado> empleados) {
		FunkyFilter filter = new FunkyFilter();
		
		empleados.removeIf(filter);
	}
	
	
	
	

	
}
