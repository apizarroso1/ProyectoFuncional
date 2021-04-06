import daw.com.Pantalla;

public class AppElectrodomestico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cuantos;
		Electrodomestico[] electrodomesticos;
		Electrodomestico masCaro;
		float total = 0;
		
		cuantos = Libreria.leerPositivo("cuantos?");
		
		electrodomesticos = leerElectrodomesticos (cuantos);
		
		
		// Mostrar total
		for (Electrodomestico e: electrodomesticos)
			total += e.getPrecioFinal();
		
		Pantalla.escribirString("\nValor total " + total);

		// Mostrar el electrodoméstico más caro
		
		masCaro = electrodomesticos[0];
		for (int i = 1 ; i < electrodomesticos.length; i++)
			if (electrodomesticos[i].getPrecioFinal() > 
					masCaro.getPrecioFinal())
				masCaro = electrodomesticos[i];
		
		masCaro.mostrarDatos();
		
		// Subir un 10% el precio base a los
		// electrodomésticos blancos
		// Mostrar todos
		for (int i = 0; i < cuantos; i++)
			if (electrodomesticos[i].getColor().
					equalsIgnoreCase("Blanco"))
			{

				electrodomesticos[i] = 
					new Electrodomestico(electrodomesticos[i].getPrecioBase() * 1.10f,
								electrodomesticos[i].getColor(),
								electrodomesticos[i].getConsumo(),
								electrodomesticos[i].getPeso());
			}
			
		
		for (Electrodomestico e: electrodomesticos)
			e.mostrarDatos();
		
		
		
		
	}

	public static Electrodomestico[] leerElectrodomesticos(int cuantos) {
		// TODO Auto-generated method stub
		Electrodomestico[] e = new Electrodomestico[cuantos];
		
		
		for (int i = 0; i < e.length; i++)
		{
			e[i] = new Electrodomestico();
			e[i].leerDatos();
		}
		
		return e;
	}

}
