package ejer1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;
import libreria.Libreria;

public class Figuras{
	private ArrayList<Figura> figuras = new ArrayList<>();
	
	public void leerFiguras() {
		int tipo;
		
		do {
			Figura f;
			
			tipo = Libreria.leerEntre(1, 2, "\nTipo: 1 para rectángulo y 2 para círculo");
			
			if (tipo == 1) {
				
				f = new Rectangulo();
				
			} else {
				
				f = new Circulo();
				
			}
			
			f.leerDatos();
			
			if (!existeFigura(f)) {
				figuras.add(f);
			}
			
		} while (Teclado.leerString("\nDesea continuar(s/n)").equalsIgnoreCase("s"));
		
		ordenarAlfabeticamente();
	}

	// Continuar
	public void ordenarAlfabeticamente() {
		List<Figura> copia = crearCopia();
		
		//Collections.sort(copia);
	}

	public List<Figura> crearCopia() {
		List<Figura> copia = new ArrayList<>();
		
		for (Figura f : figuras) {
			copia.add(f);
		}
		
		return copia;
	}

	public boolean existeFigura(Figura f) {
		if (figuras.contains(f)) {
			Pantalla.escribirString("\nFigura registrada satisfactoriamente");
			return true;
		} else {
			Pantalla.escribirString("\nLa figura ya está registrada");
			return false;
		}
	}

	public void trasladarFigurasDerecha() {
		ConsumerTrasladar consumer = new ConsumerTrasladar();
		
		figuras.forEach(consumer);
	}

	public void leerFigura() {
		Figura f;
		
		
		
	}

	public void mostrarFigura() {
		Figura f = new Rectangulo();
		String nombre;
		
		nombre = Teclado.leerString("\nNombre de la figura deseada");
		
		f = buscarFigura(nombre);
		
		f.mostrarDatos();
		
	}
	
	public Figura buscarFigura(String nombre) {
		Figura aux = null;
		int i = 0;
		
		for ( i < figuras.size() || (aux != null; i++) {
			if (figuras.get(i).getNombre().equals(nombre)) {
				aux = figuras.get(i);
			}
		}
		
		if (aux == null) {
			Pantalla.escribirString("\nLa figura no existe");
		}
		return aux;
	}

}
