package institutoMio;

import java.util.ArrayList;
import java.util.Comparator;

import daw.com.Pantalla;

public class Buzon {
	private ArrayList<Mensaje> mensajes;
	
	public Buzon() {
		mensajes = new ArrayList<Mensaje>();
	}
	
	public Buzon(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	public void addMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
	
	public void leerBuzon() {
		if (mensajes.isEmpty()) {
			Pantalla.escribirString("\nNo hay mensajes en el buzon");
		} else {
			while (!mensajes.isEmpty()) {
				Mensaje m = mensajes.remove(mensajes.size() - 1);
				
				Pantalla.escribirString("\n" + m.toString());
			}
		}
	}
	
	public void ordenarBuzon(Comparator <Mensaje> comparator) {
		mensajes.sort(comparator);
	}
}
