package ejerciciosProg;

import java.util.Iterator;

public class Agenda {
	private static final int SIZE = 10;
	private Contacto [] Contactos;
	
	private Agenda () {
		Contactos = new Contacto[SIZE];
		for (int i = 0; i < SIZE; i++) {
			Contactos [i] = new Contacto();
		}
		
	}
	
	
	

}
