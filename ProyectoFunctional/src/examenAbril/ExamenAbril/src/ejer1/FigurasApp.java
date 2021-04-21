package ejer1;

import libreria.AppMenu;

public class FigurasApp extends AppMenu {

	public Figuras f = new Figuras();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	
	
	@Override
	public void evaluarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			//listarFigurasAreaYGrosor();
			break;
		case 2:
			f.mostrarFigura();
			break;
		case 3:
			f.leerFigura();
			break;
		case 4:
			//comprobarConcentrecismo();
			break;
		case 5:
			f.trasladarFigurasDerecha();
			break;
		}
		
		
	}

}
