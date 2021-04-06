package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import daw.com.Pantalla;
import daw.com.Teclado;
import interfacesMiguel.Entregable;
import interfacesMiguel.Serie;
import interfacesMiguel.VideoJuego;

public class Tienda {
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();

	public void ingresarCliente() {
		Cliente c = new Cliente();

		c.leerDatos();

		if (!clientes.contains(c)) {
			clientes.add(c);
		} else {
			Pantalla.escribirString("\nEl cliente ya esta ingresado");
		}
	}

	public void ingresarElectrodomestico() {
		Electrodomestico e = null;

		if (Teclado.leerInt("\n1 para lavadora y 2 para television") == 1) {
			Lavadora l = new Lavadora();

			l.leerDatos();
			e = l;

		} else {
			Television t = new Television();

			t.leerDatos();
			e = t;
		}

		if (!existeElectrodomestico(e)) {

		}
	}

	public boolean existeElectrodomestico(Electrodomestico e) {
		String identificador;
		boolean existe = false;

		if (e instanceof Lavadora) {

			identificador = ((Lavadora) e).getIdentificador();
		} else {

			identificador = ((Television) e).getIdentificador();
		}

		if (electrodomesticos.contains(localizaPorIdentificador(identificador))) {
			existe = true;
		}

		return existe;
	}

	public Electrodomestico localizaPorIdentificador(String identificador) {

		Electrodomestico e, aux;
		e = null;

		for (int i = 0; i < electrodomesticos.size() && e == null; i++) {
			if (electrodomesticos.get(i) instanceof Lavadora)
				aux = new Lavadora(identificador);
			else
				aux = new Television(identificador);

			if (aux.equals(electrodomesticos.get(i)))
				e = electrodomesticos.get(i);
		}

		return e;
	}

	public void mostrarInventario() {
		ArrayList<Electrodomestico> electrodomesticosOrdenado = ordenarInventario();

		for (Electrodomestico e : electrodomesticosOrdenado) {
			mostrarAlgunosDatos(e);
		}

		Pantalla.escribirFloat("\nTotal inventario = ", calcularTotalInventario());
	}

	public void mostrarAlgunosDatos(Electrodomestico e) {
		String mensaje = ("\n Identificador = " + e.getIdentificador() + ", stock = " + e.getStock()
				+ ", precio final = " + e.calcularPrecio());
		Pantalla.escribirString(mensaje);
	}

	public ArrayList<Electrodomestico> ordenarInventario() {
		ArrayList<Electrodomestico> electrodomesticos2 = crearCopia();

		Collections.sort(electrodomesticos2);

		return electrodomesticos2;
	}

	public float calcularTotalInventario() {
		float total = 0;
		for (Electrodomestico e : electrodomesticos) {
			total = +e.calcularPrecio();
		}

		return total;
	}

	public ArrayList<Electrodomestico> crearCopia() {
		ArrayList<Electrodomestico> electrodomesticosCopia = new ArrayList<Electrodomestico>();

		electrodomesticosCopia.addAll(electrodomesticos);

		return electrodomesticosCopia;
	}

	public void realizarPedido() {
		ArrayList<Electrodomestico> cesta = new ArrayList<>();
		Cliente c = null;
		String identificador, nif = Teclado.leerString("\nNIF de cliente");
		Electrodomestico e;
		float totalCesta;

		c = new Cliente(nif);

		if (clientes.contains(c)) {

			c = getCliente(nif);

			do {

				mostrarInventario();

				identificador = Teclado
						.leerString("\nSeleccione el producto a introducir en la cesta mediante su identificador");

				e = getElectrodomestico(identificador);

				if (e.getStock() >= 1) {

					cesta.add(e);

					e.setStock(e.getStock() - 1);
				}

			} while (Teclado.leerString("\nContinuar (s/n)").equalsIgnoreCase("s"));

			totalCesta = TotalCesta(cesta);

			Pantalla.escribirString("\nTotal de la cesta = " + totalCesta);
			
			mostrarPedido(cesta);

			if (!(totalCesta > c.getSaldo())) {

				c.setSaldo(c.getSaldo() - totalCesta);

			} else {
				Pantalla.escribirString("\nNo tiene suficiente saldo para pagar la cesta. Fin de la operacion");

				devolverStock(cesta);
			}

		} else {
			Pantalla.escribirString("\nEl cliente no esta registrado en el sistema");
		}

	}

	public Cliente getCliente(String nif) {
		Cliente aux = null;

		for (int i = 0; i < clientes.size() && aux == null; i++) {
			if (clientes.get(i).getCif().equalsIgnoreCase(nif)) {
				aux = clientes.get(i);
			}
		}

		return aux;
	}

	public Electrodomestico getElectrodomestico(String identificador) {
		Electrodomestico aux = null;

		for (int i = 0; i < electrodomesticos.size() && aux == null; i++) {
			if (electrodomesticos.get(i).getIdentificador().equalsIgnoreCase(identificador)) {
				aux = electrodomesticos.get(i);
			}
		}

		return aux;
	}

	public float TotalCesta(ArrayList<Electrodomestico> cesta) {
		float acumulador = 0;

		for (Electrodomestico e : cesta) {
			acumulador = +e.calcularPrecio();
		}

		return acumulador;
	}

	public void devolverStock(ArrayList<Electrodomestico> cesta) {
		for (Electrodomestico e : electrodomesticos) {
			if (cesta.contains(e)) {
				e.setStock(e.getStock() + 1);
			}
		}
	}

	public void mostrarPedido(ArrayList<Electrodomestico> cesta) {
		String mensaje;

		for (Electrodomestico e : cesta) {

			mensaje = "\nProducto" + cesta.indexOf(e) + " " + e.getIdentificador() + " " + e.getColor() + " "
					+ e.getConsumo();
			Pantalla.escribirString(mensaje);
		}
	}
}
