package ed1;

public class AppCalculadora {

	public static void main(String[] args) 
	{
		
		inicio();
		
		menu();
			
	}
	
	public static void fin() 
	{
		InterfazUsuario.mostrarFin();
	}

	public static void menu() 
	{
		InterfazUsuario.mostrarMenu();
	}

	public static void inicio() 
	{
		InterfazUsuario.mostrarInicio();
	}

}
