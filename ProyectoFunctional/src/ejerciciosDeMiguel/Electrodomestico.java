import daw.com.Pantalla;
import daw.com.Teclado;

public class Electrodomestico {
		
	private float precioBase;
	private String color;
	private String consumo;
	private int peso;
	
	
	public Electrodomestico(float precioBase, String color, String consumo, int peso) {
		setPrecioBase (precioBase);
		setColor (color);
		setConsumo (consumo);
		setPeso (peso);
	
	}

	public Electrodomestico(float precioBase, int peso) 
	{
		this (precioBase, "blanco", "F", peso);
		
	}

	public Electrodomestico()
	{
		this (100, "blanco", "F", 5);
	}

	public Electrodomestico (Electrodomestico original)
	{
		this (original.precioBase, original.color,
				original.consumo, original.peso);
				
	}

	public float getPrecioBase() {
		return precioBase;
	}


	private void setPrecioBase(float precioBase) {
		if (precioBase < 100)
			precioBase = 100;
		
		this.precioBase = precioBase;
	}



	public String getColor() {
		return color;
	}


	private void setColor(String color) {
		
		if (! color.equalsIgnoreCase("blanco") && 
			! color.equalsIgnoreCase("negro") &&
			! color.equalsIgnoreCase("azul") &&
			! color.equalsIgnoreCase("rojo") &&
			! color.equalsIgnoreCase("gris"))
			color = "blanco";
		
		this.color = color;
	}


	public String getConsumo() {
		return consumo;
	}


	private void setConsumo(String consumo) {
		
		if (! consumo.equalsIgnoreCase("A") &&
			! consumo.equalsIgnoreCase("B") &&
			! consumo.equalsIgnoreCase("C") &&
			! consumo.equalsIgnoreCase("D") &&
			! consumo.equalsIgnoreCase("E") &&	
			! consumo.equalsIgnoreCase("F"))
			consumo = "F";
			
		this.consumo = consumo;
	}

	public int getPeso() {
		return peso;
	}

	private void setPeso(int peso) {
		if (peso < 5)
			peso = 5;
		
		this.peso = peso;
	}
	


	
	public float getPrecioFinal ()
	{
		float precioFinal = precioBase;
		
		switch (consumo)
		{
			case "A":
			case "a":
					precioFinal += 100;
					break;
			case "B":
			case "b":
					precioFinal += 80;
					break;
			case "C":
			case "c":
					precioFinal += 60;
					break;
			case "D":
			case "d":
					precioFinal += 50;
					break;
			case "E":
			case "e":
					precioFinal += 30;
					break;
			case "F":
			case "f":
					precioFinal += 10;
					break;
		}
		
		if (peso > 80)
			precioFinal += 100;
		else if (peso > 49)
			precioFinal += 80;
		else if (peso > 19)
			precioFinal += 50;
		else
			precioFinal += 10;
		
		return precioFinal;
	}
	
	public void leerDatos ()
	{

		setPrecioBase (Teclado.leerFloat("precioBase"));
		setColor (Teclado.leerString("color"));
		setConsumo (Teclado.leerString("consumo"));
		setPeso (Teclado.leerInt("peso"));
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirFloat("precioBase ", precioBase);
		Pantalla.escribirString("\ncolor ", color);
		Pantalla.escribirString("\nconsumo ", consumo);
		Pantalla.escribirInt("peso ", peso);
		
		Pantalla.escribirFloat("precio Final " , getPrecioFinal());
	}

	@Override
	public String toString() {
		return "Electrodomestico [precioBase=" + precioBase + ", color=" + color + ", consumo=" + consumo + ", peso="
				+ peso + "]";
	}
	
	
	
}
