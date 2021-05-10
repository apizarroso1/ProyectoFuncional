package ficherosBinario;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class LeerBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre;
		int nota[],cuantas;
		
		
		FileInputStream bentrada ;
		DataInputStream fentrada ;
		
		try 
		{
			bentrada = new FileInputStream ("borrame.dat"); 
			fentrada = new DataInputStream (bentrada);
			
			
			//Leer un string en binario
			nombre = fentrada.readUTF();
			
			
			// No sabemos cuantas notas
			cuantas = fentrada.readInt();
			
			// Leer un entero en binario
			nota = new int[cuantas];
			
			for (int i= 0; i< cuantas; i++)
				nota[i] = fentrada.readInt();
		

			Pantalla.escribirString("\nnombre " + nombre + " nota " + Arrays.toString(nota));
			
			fentrada.close();
			bentrada.close();
			
		}
		catch (IOException e)
		{
			Pantalla.escribirString("\nError intentado leer fichero");
			e.printStackTrace();
		}
	}

}
