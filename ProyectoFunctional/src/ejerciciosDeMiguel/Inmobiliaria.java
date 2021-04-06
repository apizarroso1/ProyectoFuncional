package ejerciciosDeMiguel;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Vivienda> viviendas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Visita> visitas;

	private String nombre;

	public Inmobiliaria() {
		nombre = "";
		viviendas = new ArrayList<>();
		clientes = new ArrayList<>();
		visitas = new ArrayList<>();
	}

	public Inmobiliaria(String nombre) {
		this.nombre = nombre;
		viviendas = new ArrayList<>();
		clientes = new ArrayList<>();
		visitas = new ArrayList<>();
	}

	public Inmobiliaria(Inmobiliaria original) {
		this.nombre = original.nombre;

		viviendas = new ArrayList<>();

		for (Vivienda v : original.viviendas)
			if (v instanceof ViviendaLibre)
				viviendas.add(new ViviendaLibre((ViviendaLibre) v));
			else
				viviendas.add(new ViviendaProtegida((ViviendaProtegida) v));

		clientes = new ArrayList<>();
		for (Cliente c : original.clientes)
			clientes.add(new Cliente(c));

		visitas = new ArrayList<>();
		for (Visita v : original.visitas)
			visitas.add(new Visita(v));
	}

	public Vivienda getVivienda(int cual) {
		if (cual < 0)
			cual = 0;
		else if (cual > viviendas.size() - 1)
			cual = viviendas.size() - 1;

		return viviendas.get(cual);
	}

	public int getNViviendas() {
		return viviendas.size();
	}

	public void setVivivenda(int cual, Vivienda v) {
		if (cual < 0)
			cual = 0;
		else if (cual > viviendas.size() - 1)
			cual = viviendas.size() - 1;

		viviendas.set(cual, v);
	}

	public Vivienda getVivienda(String direccion) {
		Vivienda v = null;
		int cual;

		cual = viviendas.indexOf(new ViviendaLibre(direccion));

		if (cual >= 0)
			v = viviendas.get(cual);

		return v;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean insertarVivienda(Vivienda v) {
		boolean exito = false;

		if (!viviendas.contains(v)) {
			viviendas.add(v);
			exito = true;
		}

		return exito;
	}

	public boolean eliminarVivienda(String direccion) {
		boolean exito = false;
		Vivienda v = getVivienda(direccion);

		if (v != null) {
			viviendas.remove(v);
			exito = true;
		}

		return exito;
	}

	@Override
	public String toString() {
		return "Inmobiliaria [viviendas=" + viviendas + ", nombre=" + nombre + "]";
	}

}
