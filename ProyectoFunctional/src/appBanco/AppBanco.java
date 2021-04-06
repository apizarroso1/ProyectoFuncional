package appBanco;

public class AppBanco {
	
	public static void main(String[] args) {
		
		 System.out.println("INICIO Programa de gestion de cuentas bancarias");
		
		Cuenta cuenta1 = new Cuenta();
		
		System.out.println("\ncuenta1: Titular: " + cuenta1.getTitular() + ". Cantidad: " + cuenta1.getCantidad());
		
		cuenta1.setTitular("Rey Melchor");
		cuenta1.setCantidad(500);
		
		System.out.println("\ncuenta1: Titular: " + cuenta1.getTitular() + ". Cantidad: " + cuenta1.getCantidad());
		
		cuenta1.ingresar(cuenta1.getCantidad());
		
		System.out.println("\ncuenta1: Titular: " + cuenta1.getTitular() + ". Cantidad: " + cuenta1.getCantidad());
		
		cuenta1.retirar(cuenta1.getCantidad());
		
		System.out.println("\ncuenta1: Titular: " + cuenta1.getTitular() + ". Cantidad: " + cuenta1.getCantidad());
		
		Cuenta cuenta2 = new Cuenta();
		
		cuenta2.setTitular("Rey Baltasar");
		cuenta2.setCantidad(1000);
		
		System.out.println("\ncuenta1: Titular: " + cuenta1.getTitular() + ". Cantidad: " + cuenta1.getCantidad());
		System.out.println("\ncuenta2: Titular: " + cuenta2.getTitular() + ". Cantidad: " + cuenta2.getCantidad());
		
		System.out.println("\nFIN Programa de gestion de cuentas bancarias");
	}
	
	

}
