package herenciaYPolimorfismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import daw.com.Teclado;
import ejerciciosDeMiguel.Libreria;
import daw.com.Pantalla;

public class AppEmpleados {

	public static void main(String[] args) {
		int pos = 0;

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		do {
			
			leerEmpleado(empleados);

		} while (Teclado.leerString("\n¿Desea seguir? (s/n)").equals("s"));
		
		pos = calcularMax(empleados, pos);

		Pantalla.escribirString("El empleado que más cobra es el " + pos);
	}

	public static int calcularMax(ArrayList<Empleado> empleados, int pos) 
	{
		int max = empleados.get(0).calcularSueldo();

		for (int i = 1; i < empleados.size(); i++) 
		{
			if (empleados.get(i).calcularSueldo() > max) 
			{
				pos = i;
			}
		}
		
		return pos;
	}

	public static void leerEmpleado(ArrayList <Empleado> empleados)
	{
		Empleado e = null;
		int tipo = Libreria.leerEntre(1,3,"1 para administrativo, 2 para profesor y 3 para auxiliar");
		
		switch (tipo)
		{
		case 1:
			e = new Administrativo();
		break;
		
		case 2: 
			e = new Profesor();
		break;
		
		case 3:
			e =  new Auxiliar();
		break;
		
		default:
			Pantalla.escribirString("Error: datos mal introducidos");
		}
		
		e.leerDatos();

		if (empleados.contains(e)) 
		{
			Pantalla.escribirString("El empleado ya está registrado");	
		} 
		else 
		{
			e.calcularSueldo();
			empleados.add(e);
		}
	}
	
	public static void mostrarEmpleados(ArrayList<Empleado> empleados)
	{
		for (int i = 0; i < empleados.size() -1; i++)
		{
			for (int j = 0; j < empleados.size(); j++)
			{
				if (empleados.get(j).getNombre().compareTo(empleados.get(i).getNombre()) < 0)
				{
					empleados.set(i, empleados.set(i, empleados.get(j)));
				}
			}
		}
		
		for (Empleado empleado : empleados)
		{
			empleado.mostrarDatos();
		}
	}
}
