package garaje;

public class FactoriaVehiculo {

	public static Vehiculo getVehiculo(String tipo) {
		Vehiculo v = null;

		switch (tipo) {
		case "Coche":
			v = new Coche();
			break;
		case "Moto":
			v = new Moto();
			break;
		default:
			throw new IllegalArgumentException("tipo de veh�culo no permitido");
		}

		return v;
	}

}
