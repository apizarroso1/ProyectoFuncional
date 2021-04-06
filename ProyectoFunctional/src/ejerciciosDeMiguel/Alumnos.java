import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Datos de los alumnos
		String[] nombre;
		int[] edad;
		float[] nota;
		
		int cuantos;
		
		// Leer cuantos
		cuantos = Teclado.leerInt("Cuántos?");
		
		// Reservar espacio para los datos de los alumnos
		nombre = new String[cuantos];
		edad = new int[cuantos];
		nota = new float[cuantos];
		
		// Leer datos de los alumnos
		leerDatos (nombre, edad, nota);
		
		// ordenar por nota decreciente 
		ordenarPorNota(nombre, edad, nota);
		
		// mostrar datos 
		mostrarDatos(nombre, edad, nota);
		
	}

	public static void mostrarDatos(String[] nombre, int[] edad, float[] nota) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nombre.length; i++)
		{
			Pantalla.escribirString("\nNombre " + nombre[i] + 
									"\tedad " + edad[i] + 
									"\tnota "  + nota[i]);
		}
		
	}

	public static void ordenarPorNota(String[] nombre, int[] edad, float[] nota) {
		// TODO Auto-generated method stub
		String auxNombre;
		int auxEdad;
		float auxNota;
		
		for (int i = 0; i < nombre.length -1 ; i ++)
			for (int j = i + 1 ; j < nombre.length; j++)
			{
				if (nota[j] > nota[i])
				{
					auxNombre = nombre[i];
					nombre[i] = nombre[j];
					nombre[j] = auxNombre;
					
					auxEdad = edad[i];
					edad[i] = edad[j];
					edad[j] = auxEdad;
					
					auxNota = nota[i];
					nota[i] = nota[j];
					nota[j] = auxNota;
				}
			}
		
	}

	public static void leerDatos(String[] nombre, int[] edad, float[] nota) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < nombre.length; i++)
		{
			nombre[i] = Teclado.leerString("nombre?");
			edad[i] = Teclado.leerInt("edad?");
			nota[i] = Teclado.leerFloat("nota?");
 		}
		
	}
		

	

}
