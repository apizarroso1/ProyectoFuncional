package ed1;

public class Operaciones 
{
	static boolean  continuar;
	
	public static void sumar()
	{	
		float n1, n2, suma;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validarSuma(n1, n2);
		
		if (continuar)
		{
			suma = (n1 + n2);
			
			InterfazUsuario.escribirResultado(suma);
		}
	}
	
	public static void restar()
	{
		float n1, n2, resta;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validarResta(n1, n2);
		
		if (continuar)
		{
			resta = (n1 - n2);
			
			InterfazUsuario.escribirResultado(resta);
		}
	}
	
	public static void multiplicar()
	{
		float n1, n2, producto;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validarMultiplicacion(n1, n2);
		
		if (continuar)
		{
			producto = (n1 * n2);
			
			InterfazUsuario.escribirResultado(producto);
		}
	}
	
	public static void dividir()
	{
		float n1, n2, cociente;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validacionDivision(n1, n2);
		
		if (continuar)
		{
			cociente = (n1 / n2);
			
			InterfazUsuario.escribirResultado(cociente);
		}
		
	}
	
	public static void potencia()
	{
		float n1, n2, potencia;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
	
		continuar = Validacion.validarPotencia(n1, n2);
		
		if (continuar)
		{
			potencia = (float) Math.pow(n1, n2);
			
			InterfazUsuario.escribirResultado(potencia);
		}
		
	}
	
	public static void maximo()
	{
		float n1, n2, maximo;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validarMaximo(n1, n2);
		
		if (continuar)
		{
			if (n1 != n2)
			{
				if (n1 > n2) 
				{
					maximo = n1;
					
					InterfazUsuario.escribirResultado(maximo);
				}
				else 
				{
					maximo = n2;
					
					InterfazUsuario.escribirResultado(maximo);
				}
			}
			else
			{
				System.out.println("Los números son iguales");
			}
		}
	}
	
	public static void minimo()
	{
	float n1, n2, minimo;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validarMinimo(n1, n2);
		
		if (continuar)
		{
			if (n1 != n2)
			{
				if (n1 < n2) 
				{
					minimo = n1;
					
					InterfazUsuario.escribirResultado(minimo);
				}
				else 
				{
					minimo = n2;
					
					InterfazUsuario.escribirResultado(minimo);
				}
			}
			else
			{
				System.out.println("Los números son iguales");
			}
		}
	}
	
	public static void raiz()
	{
		float n1, n2, raiz;
		
		n1 = InterfazUsuario.leerNumero();
		n2 = InterfazUsuario.leerNumero();
		
		continuar = Validacion.validarRaiz(n1, n2);
		
		if (continuar)
		{
			n2 = (float) Math.pow(n2, -1);
			raiz = (float) Math.pow(n1, n2);
			
			InterfazUsuario.escribirResultado(raiz);
		}
	}
}
