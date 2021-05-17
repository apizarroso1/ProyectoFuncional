package practicaFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ColeccionProductos {

	private Map<String, Producto> productos;

	public ColeccionProductos() {
		this.productos = new TreeMap();
	}

	public Collection<Producto> returnAll() {
		return productos.values();
	}

	public Producto findByKey(String ref) {
		return productos.get(ref);
	}

	public boolean insert(Producto p) {
		if (!productos.containsKey(p.getRef())) {
			productos.put(p.getRef(), p);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(Producto p) {
		return productos.remove(p.getRef()) != null;
	}
	
	public void eliminarCaducados() {
		for (Producto p : productos.values()) {
			if (p instanceof Perecedero) {
				if (((Perecedero) p).getFechaCad().isBefore(LocalDate.now())) {
					productos.remove(p.getRef());
				}
			}
		}
	}

	// public boolean eliminarEnMasa() {
	// }
}
