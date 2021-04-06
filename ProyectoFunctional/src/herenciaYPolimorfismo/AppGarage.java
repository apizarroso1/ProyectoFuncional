package herenciaYPolimorfismo;

import daw.com.Pantalla;

public class AppGarage {

	public static void main(String[] args) {
		Garage g = new Garage();

		Vehiculo garage[] = new Vehiculo[g.getnPlazas()];

		mostrarMenu(garage);
	}

	public static void mostrarMenu(Vehiculo [] garage) {
		int opcion = 0;
		do {

			Pantalla.escribirString("\n[1] Añadir un vehículo");
			Pantalla.escribirString("\n[2] Sustituir un vehículo");
			Pantalla.escribirString("\n[3] Sacar un vehículo");
			Pantalla.escribirString("\n[4] Calcular cuota de plaza");
			Pantalla.escribirString("\n[5] Calcular cuota garage");
			Pantalla.escribirString("\n[6] Salir");

			opcion = Libreria.leerEntre(1, 6, "\nIntroduzca su opción");

			switch (opcion) {
			case 1:
				aniadirVehiculo(garage);
				break;
			case 2:
				sustituirVehiculo(garage);
				break;
			case 3:
				sacarVehiculo(garage);
				break;
			case 4:
				calcularCuota(garage);
				break;
			case 5:
				calcularTotal(garage);
				break;
			case 6:
				salir();
				break;
			default:
				Pantalla.escribirString("\nOpción inválida"); // Sé que no va a ser utilizado
			}
		} while (opcion != 6);

	}
	
	public static void aniadirVehiculo(Vehiculo [] garage) {
		Vehiculo v = new Vehiculo();
		
		v.leerDatos();
		
		for (int i = 0; i < garage.length; i++) {
			if (garage.equals(v))
			{
				Pantalla.escribirString("\nEl vehículo ya se encuentra en el garage");
			}else {
				
			}
		}
	}

}
