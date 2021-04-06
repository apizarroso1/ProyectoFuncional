import java.util.ArrayList;
import java.util.Collections;

import daw.com.Pantalla;
import daw.com.Teclado;
import utilidades.Utilidades;

public class AppPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p = new Persona ();
		
		
		Pantalla.escribirString("\n" + p);
		
		//Utilidades.fromFile("prueba.txt");
		
		p.leerDatos();
		
		Pantalla.escribirString("\n" + p);
		
		//Utilidades.fromKeyboard();
		
		
		
		
	}

}
