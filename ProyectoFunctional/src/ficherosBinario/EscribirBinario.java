package ficherosBinario;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EscribirBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		int nota[],cuantas;
		FileOutputStream bsalida;
		DataOutputStream fsalida;
		
		
		nombre = "miguel";
	
		// Escribir fichero en binario
		try {
			bsalida = new FileOutputStream ("borrame.dat"); 
			fsalida = new DataOutputStream (bsalida);
			
			// Escribir un String en un fichero en binario
			fsalida.writeUTF(nombre);
			
			cuantas = Teclado.leerInt("\nCuantas");
			nota = new int[cuantas];
			
			// Escribir un entero
			fsalida.writeInt(cuantas);
			
			
			//Escribir un array en un fichero en binario
			for (int i = 0; i < cuantas; i++)
			{
				nota[i] = Teclado.leerInt("nota");
				fsalida.writeInt(nota[i]);
			}
			
			fsalida.close();
			bsalida.close();
			
			Pantalla.escribirString("\nFichero escrito correctamente");
		}
		catch (IOException e)
		{
			Pantalla.escribirString("\nError intentado escribir fichero");
		}
		
		

	}

}
