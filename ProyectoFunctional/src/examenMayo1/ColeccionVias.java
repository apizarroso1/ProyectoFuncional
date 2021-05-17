package examenMayo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ColeccionVias {

	private Map<String, Via> vias;

	public ColeccionVias() {
		this.vias = new TreeMap<>();
	}

	public Collection<Via> returnAll() {
		return vias.values();
	}

	public Via findByKey(String nombre) {
		return vias.get(nombre);
	}

	public boolean insertVia(Via v) {
		boolean exito;

		if (!vias.containsKey(v.getNombre())) {
			vias.put(v.getNombre(), v);
			exito = true;
		} else {
			exito = false;
		}

		return exito;
	}

	public void listarPorTipo(int tipo, int minLongitud) {
		Collection<Via> copiaCollection = returnAll();
		ArrayList<Via> copia = new ArrayList<Via>();
		copia.addAll(copiaCollection);

		if (tipo == 2) {
			FiltroPorClasica filtro = new FiltroPorClasica();
			copia.removeIf(filtro);
		} else {
			FiltroPorDeportiva filtro = new FiltroPorDeportiva();
			copia.removeIf(filtro);
		}

		FiltroPorLongitud filtro = new FiltroPorLongitud(minLongitud);

		copia.removeIf(filtro);

		if (copia.isEmpty()) {
			System.out.println("No existen vías que cumplan los criterios deseados");
		} else {
			for (Via v : copia) {
				System.out.println("Nombre: " + v.getNombre() + ", longitud:" + v.getLongitud()
						+ ", coste medio de rescate:" + v.calcularRescate());
				System.out.println("Total  del coste de rescate de las vías:" + calcularTotalRescate(copia));
			}
		}
	}

	public float calcularTotalRescate(ArrayList<Via> vias) {
		float acumulador = 0;

		for (Via v : vias) {
			acumulador = +v.calcularRescate();
		}

		return acumulador;
	}

	public void listarTodasVias() {
		ArrayList<Via> copia = (ArrayList<Via>) returnAll();

		System.out.println(copia);
	}

	public void mostrarVia(String nombre) {
		vias.get(nombre).mostrarDatos();
	}

	public boolean contains(String nombre) {
		if (vias.containsKey(nombre)) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return vias.size();
	}

	public ArrayList<Via> returnOrdenadas() {

		Collection<Via> copiaCollection = returnAll();
		ArrayList<Via> copia = new ArrayList<Via>();
		ComparadorPorGrado comparator = new ComparadorPorGrado();

		copia.addAll(copiaCollection);

		Collections.sort(copia, comparator);

		return copia;
	}

}
