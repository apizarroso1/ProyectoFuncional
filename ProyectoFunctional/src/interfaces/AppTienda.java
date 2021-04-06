package interfaces;

import daw.com.Pantalla;
import libreria.AppMenu;

public class AppTienda extends AppMenu {
	static Tienda app = new Tienda();

	public AppTienda() {
		addOpcion("\n[1] Ingresar cliente");
		addOpcion("\n[2] Ingresar electrodomestico");
		addOpcion("\n[3] Realizar pedido");
		addOpcion("\n[4] Mostrar inventario");
		addOpcion("\n[5] Salir");
	}

	@Override
	public void evaluarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			app.ingresarCliente();
			break;
		case 2:
			app.ingresarElectrodomestico();
			break;
		case 3:
			app.realizarPedido();
			break;
		case 4:
			app.mostrarInventario();
			break;
		default:
			Pantalla.escribirString("\nOpcion equivocada");
		}

	}

	public static void main(String[] args) {

	}

}
