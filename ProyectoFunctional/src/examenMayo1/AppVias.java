package examenMayo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import daw.com.Teclado;
import libreria.AppMenu;

public class AppVias extends AppMenu {
	private ColeccionVias vias;
	private final static String FICHERO = "vias.bin";

	public AppVias() {
		vias = new ColeccionVias();

		addOpcion("Dar alta una vía");
		addOpcion("Mostrar información de una vía");
		addOpcion("Listar vías por tipo");
		addOpcion("Abandonar el programa");
	}

	public static void main(String[] args) {
		AppVias app = new AppVias();

		app.cargarDatos();

		app.run();
	}

	@Override
	public void evaluarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			altaVia();
			break;
		case 2:
			mostrarVia();
			break;
		case 3:
			listarPorTipo();
			break;
		case 4:
			fin();
			break;
		}
	}

	public void altaVia() {
		Via v;
		String nombre;
		int tipo;

		nombre = Teclado.leerString("\nNombre de la vía a insertar");

		if (!vias.contains(nombre)) {
			do {
				tipo = Teclado.leerInt("\n 1.Vía clásica - 2.Vía deportiva");
				if (tipo == 1) {
					v = new Clasica(nombre);
				} else {
					v = new Deportiva(nombre);
				}
			} while (tipo != 1 && tipo != 2);

			v.leerOtrosDatos();

			vias.insertVia(v);

		} else {
			System.out.println("La vía ya está insertada");
		}
	}

	public void mostrarVia() {
		String nombre;

		nombre = Teclado.leerString("\nNombre de la vía a mostrar");

		vias.mostrarVia(nombre);
	}

	public void listarPorTipo() {
		int tipo;
		int minLongitud;

		tipo = Teclado.leerInt("\n1.Clásicas - 2.Deportivas");
		minLongitud = Teclado.leerInt("\nLongitud mínima a mostrar");

		if (tipo != 1 && tipo != 2) {
			throw new IllegalArgumentException("Tipo no incluído, el tipo debe ser 1 ó 2");
		} else {
			vias.listarPorTipo(tipo, minLongitud);
		}
	}

	public void fin() {
		guardarDatos();
	}

	public void guardarDatos() {

		File fichero = new File(FICHERO);

		try (FileOutputStream bruto = new FileOutputStream(fichero);
				DataOutputStream filtro = new DataOutputStream(bruto)) {
			ArrayList<Via> viasOrdenadas = vias.returnOrdenadas();

			filtro.writeInt(viasOrdenadas.size());

			for (Via v : viasOrdenadas) {
				v.getClass().getName();
				v.escribirDatosBin(filtro);
			}
		}

		catch (IOException e) {
			System.out.println("Archivo de datos inaccesible o inexistente");
		}

	}

	@SuppressWarnings("deprecation")
	public void cargarDatos() {
		File fichero = new File(FICHERO);
		int cuantos;
		String clase;

		if (fichero.exists()) {
			try (FileInputStream bruto = new FileInputStream(fichero);
					DataInputStream filtro = new DataInputStream(bruto)) {
				cuantos = filtro.readInt();

				for (int i = 0; i < cuantos; i++) {
					Via v;
					clase = filtro.readUTF();
					v = (Via) Class.forName(clase).newInstance();

					v.leerDatosBin(filtro);
					vias.insertVia(v);
				}
			}

			catch (IOException e) {
				System.out.println("El archivo no existe o es inaccesible");
			}

			catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				System.out.println("El objeto no pudo crearse o error al recibir el nombre de la clase");
			}
		}
	}
}
