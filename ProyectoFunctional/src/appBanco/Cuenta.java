package appBanco;

public class Cuenta {
	
	//Atributos en private
	private String titular;
	private int cantidad;
	
	//Constructor por defecto pedido en el enunciado
	public Cuenta() {
		this.titular = "";
		this.cantidad = 0;
	}
	
	//Metodos getters
	public String getTitular() {
		return this.titular;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	//Metodos setters
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//Metodos adicionales
	public int ingresar(int cantidad) {
		int ingreso = 100;
		cantidad = cantidad + ingreso;
		return cantidad;
	}
	
	public int retirar(int cantidad) {
		int retirada = 300;
		cantidad = cantidad - retirada;
		return cantidad;
	}
}
