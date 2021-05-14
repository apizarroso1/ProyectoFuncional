package practicaFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import daw.com.Teclado;
import libreria.AppMenu;

public class AppProductos extends AppMenu {

	private final static String fichero = "productos.dat";

	private ColeccionProductos productos;

	public AppProductos() {

		addOpcion("1.Aniadir un producto");
		addOpcion("2.Modificar stock de un producto");
		addOpcion("3.Realizar un pedido");
		addOpcion("4.Mostrar precios");
		addOpcion("5.Finalizar programa");

		productos = new ColeccionProductos();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evaluarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			insertarProducto();
			break;

		case 2:
			modificarStock();
			break;
		case 3:
			servirPedido();
			break;
		case 4:
			mostrarPrecios();
			break;
		case 5: 
			eliminarCaducados();
			break;
		}

	}

	public void insertarProducto() {
		Producto p;
		String ref;
		String tipo;

		ref = Teclado.leerString("\nCodigo de referencia");

		if (productos.findByKey(ref) == null) {
			tipo = Teclado.leerString("\nTipo de producto: 1.Perecedero - 2.No Perecedero");

			if (tipo.equals("1")) {
				p = new Perecedero(ref);

			} else {
				p = new NoPerecedero(ref);
			}

			p.leerOtrosDatos();

			if (productos.insert(p)) {
				System.out.println("Producto insertado satisfactoriamente");
			} else {
				System.out.println("No se ha podido insertar el producto");
			}
		}

	}
	
	public void modificarStock() {
		String ref;
		Producto p;

		ref = Teclado.leerString("\nIntroduzca el codigo de referencia del producto a modificar");

		p = productos.findByKey(ref);

		if (p != null) {
			System.out.println("Datos registrados:");
			p.mostrarDatos();
			System.out.println("Introduzca nuevos datos:");
			p.leerOtrosDatos();
		}

		if (productos.findByKey(ref) != null) {
			productos.insert(p);
			System.out.println("Datos actualizados satisfactoriamente");
		} else {
			System.out.println("No ha sido posible actualizar los datos");
		}
	}

	public void servirPedido() {
		String ref;
		Producto p;
		int cant;
		float importe = 0;
		Set<Producto> pedido = new HashSet<>();

		do {
			ref = Teclado.leerString("\nCodigo de referencia del producto a comprar");

			p = productos.findByKey(ref);

			if (p != null) {
				if (p.getStock() > 0) {
					cant = Teclado.leerInt("\nCantidad del producto");

					if (cant < p.getStock()) {

						p.setStock(cant);
						pedido.add(p);

						System.out.println("Producto insertado satisfactoriamente");
					} else {
						System.out.println("No hay existencias suficientes para cubrir el pedido");
					}
				}
			} else {
				System.out.println("El producto no se encuentra en la base de datos");
			}

		} while (Teclado.leerString("\nS/N para continuar").equalsIgnoreCase("s"));
		
		if (!pedido.isEmpty()) {
			for (Producto q : pedido) {
				importe =+ q.calcularPvp() * p.getStock();
			}
			
			System.out.println("El importe a pagar por el pedido realizado es de :");
			System.out.print(importe);
		}
	}
	
	public void mostrarPrecios() {
		ArrayList <Producto> copia = new ArrayList<>(productos.returnAll());
		ComparadorPrecio comparator = new ComparadorPrecio();
		ConsumerMostrar consumer = new ConsumerMostrar();
		
		Collections.sort(copia, comparator);
		
		copia.forEach(consumer);
	}
	
	public void eliminarCaducados() {
		
	}
	
	
}
