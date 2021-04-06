package ed1;

import java.util.Scanner;

public class CuentaBancaria {
	
	//Atributos
	private int numeroCuenta;
	private float saldoCuenta;
	
	//Construtor por parámetros
	public CuentaBancaria(int numeroCuenta, float saldoCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldoCuenta = saldoCuenta;
	}
	
	//Métodos getters
	public int getNumeroCuenta() {
		return this.numeroCuenta;
	}
	
	public float getSaldoCuenta() {
		return this.saldoCuenta;
	}
	
	//Métodos setters
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	public void setSaldoCuenta(float saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	
	//Métodos adicionales
	public void ingresarDinero() {
		
		float ingreso;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su ingreso");
		ingreso = sc.nextFloat();
		
		if (ingreso < 1) {
			System.out.println("Cantidad erronea. Error.");
		}
		
		this.saldoCuenta = this.saldoCuenta + ingreso;
		System. out. println("\nEl saldo de la cuenta es igual al saldo de la cuenta mas el importe a ingresar");
	}
	
	public void retirarDinero() {
		
		float retirada;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nIntroduzca la cantidad a retirar");
		retirada = sc.nextFloat();
		
		if (retirada < 1) {
			System.out.println("\nLa cantidad es negativa. Error.");
		}
		
		if (this.saldoCuenta > retirada)
		{
			this.saldoCuenta = this.saldoCuenta - retirada;
			System. out. println("\nEl saldo de la cuenta es igual al saldo de la cuenta menos el importe a retirar");
		}
		else 
		{
			System. out. println("\nEl saldo de la cuenta es insuficiente para retirar esa cantidad. Error.");
		}
		sc.close();
	}

	@Override
	public String toString() {
		return "CuentaBancaria = " + this.numeroCuenta + " " + this.saldoCuenta;
	}
	
}
