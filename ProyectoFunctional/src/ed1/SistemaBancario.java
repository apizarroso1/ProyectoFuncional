package ed1;

public class SistemaBancario {

	public static void main(String[] args) {
		
		System.out.print("----------------------------------------");
		System.out.print("\nINICIO Programa Sistema Bancario");
		System.out.print("\n----------------------------------------");
		
		Cliente c1 = new Cliente("Federico", 19);
		Cliente c2 = new Cliente("David", 40);
		Cliente c3 = new Cliente("Juan", 36);
		CuentaBancaria b1 = new CuentaBancaria(1, 70000);
		CuentaBancaria b2 = new CuentaBancaria(2, 500);
		CuentaBancaria b3 = new CuentaBancaria(3, 1500000);
		
		System.out.println("\n");
		System.out.println(c1.toString());
		System.out.println(b1.toString());
		System.out.println(c2.toString());
		System.out.println(b2.toString());
		System.out.println(c3.toString());
		System.out.println(b3.toString());
		
		b1.ingresarDinero();
		
		System.out.println("Se ha ingresado dinero a la cuenta del usuario 1");
		System.out.println(c1.toString());
		System.out.println(b1.toString());
		System.out.println(c2.toString());
		System.out.println(b2.toString());
		System.out.println(c3.toString());
		System.out.println(b3.toString());
		
		b2.retirarDinero();
		
		System.out.println("Se ha retirado dinero de la cuenta del usuario 2");
		System.out.println(c1.toString());
		System.out.println(b1.toString());
		System.out.println(c2.toString());
		System.out.println(b2.toString());
		System.out.println(c3.toString());
		System.out.println(b3.toString());
		
		c2.darBaja();
		
		System.out.println("Se ha dado de baja la cuenta del usuario 2");
		System.out.println(c1.toString());
		System.out.println(b1.toString());
		System.out.println(c3.toString());
		System.out.println(b3.toString());
		
		System.out.print("\n----------------------------------------");
		System.out.print("\nFIN Programa Sistema Bancario");
		System.out.print("\n----------------------------------------");
	}

}
