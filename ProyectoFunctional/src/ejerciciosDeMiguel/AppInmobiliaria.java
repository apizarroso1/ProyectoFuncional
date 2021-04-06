package inmobiliaria;

import java.time.LocalDate;
import java.util.ArrayList;

import daw.com.Pantalla;
import daw.com.Teclado;
import libreria.AppMenu;
import libreria.Libreria;

public class AppInmobiliaria extends AppMenu {

	private Inmobiliaria inmo;
	
 	public AppInmobiliaria() {
		super ();
		
		// Cargar opciones de menú
		addOpcion ("Insertar Cliente");
		addOpcion ("Insertar Vivienda");
		addOpcion ("Insertar Visita");
		addOpcion ("Listar clientes que han visitado viviendas");
		addOpcion ("Listar viviendas por precio");
		addOpcion ("Vivienda mejor valorada");
		
		// Crear datos de la clase
		this.inmo = new Inmobiliaria();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppInmobiliaria app = new AppInmobiliaria();
		
		app.inmo.setNombre(Teclado.leerString("\nNombre Inmo"));

		app.run();
	}

	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		
		switch (opc)
		{
			case 1:
				insertarCliente ();
				break;
			case 2:
				insertarVivienda ();
				break;
			case 3:
				insertarVisita ();
				break;
			case 4:
				listarClientesVisitadores ();
				break;
			case 5:
				listarViviendasPorPrecio ();
				break;
			case 6:
				viviendaMejorValorada ();
				break;
		}
		
	}

	public void viviendaMejorValorada() {
		// TODO Auto-generated method stub
		ArrayList<Float> valoraciones = new ArrayList<>();
		
		for (Vivienda v : inmo.getViviendas())
			 valoraciones.add(inmo.getValoracion(v));
		
		
	}

	public void listarViviendasPorPrecio() {
		// TODO Auto-generated method stub
		ArrayList<Vivienda> vs = new ArrayList<>(inmo.getViviendas());
		
		for (int i = 0; i < vs.size() - 1; i++)
			for (int j = i + 1; j < vs.size(); j++)
				if (vs.get(i).getPrecioFinal() > 
						vs.get(j).getPrecioFinal())
				{
					vs.set(j,vs.set(i, vs.get(j)));
				}
						
	}

	public void listarClientesVisitadores() {
		// TODO Auto-generated method stub
		for (Cliente c : inmo.getClientes())
			if (inmo.estaClienteEnVisitas(c))
				c.verDatos();
	}

	public void insertarVisita() {
		// TODO Auto-generated method stub
		Cliente c;
		Vivienda v;
		Visita visita;
		int status;
		String mensaje ="visita insertada correctamente";
		
		// solicitar cliente
		c = solictarCliente ();
		
		// solicitar vivienda
		v = solicitarVivienda ();
		
		
		visita = new Visita ();
		visita.setCliente(c);
		visita.setVivienda(v);
		visita.leerOtrosDatos();
		
		status = inmo.addVisita(visita);
		switch (status)
		{
			case -1:
				mensaje = "error 1";
				break;
			case -2:
				mensaje = "error 2";
				break;
			case -3:
				mensaje = "error 3";
				break;
				
		}
		
		Pantalla.escribirString("\n" + mensaje);
		
	}

	public Vivienda solicitarVivienda() {
		// TODO Auto-generated method stub
		
		int cual;
		
		for (int i = 0; i < inmo.getNViviendas(); i++)
			inmo.getVivienda(i).verDatos();
		cual = Libreria.leerEntre(1, inmo.getNViviendas(), 
									"\nElegir vivenda");
		
		return inmo.getVivienda(cual-1);
	}

	public Cliente solictarCliente() {
		// TODO Auto-generated method stub
		
		int cual;
		
		for (int i = 0; i < inmo.getNClientes(); i++)
			inmo.getCliente(i).verDatos();
		cual = Libreria.leerEntre(1, inmo.getNClientes(), 
									"\nElegir cliente");
		
		return inmo.getCliente(cual-1);
	}

	public void insertarVivienda() {
		// TODO Auto-generated method stub
		Vivienda v;
		int tipo;
		
		tipo = Libreria.leerEntre(1, 2, "\nTipo Vivienda (1-2)");
		
		if (tipo == 1)
			v = new ViviendaLibre();
		else
			v = new ViviendaProtegida();
		
		v.leerClave();
		
		if (!inmo.existeVivienda(v))
		{
			v.leerOtroDatos();
			inmo.insertarVivienda(v);
		}
		else
			Pantalla.escribirString("\nVivienda ya existente");
	}

	public void insertarCliente() {
		// TODO Auto-generated method stub
		Cliente c = new Cliente ();
		
		c.leerClave();
		
		if (!inmo.existeCliente(c))
		{
			c.leerOtrosDatos();
			inmo.insertarCliente(c);
		}
		else
			Pantalla.escribirString("\nCliente ya existente");
		
	}

}
