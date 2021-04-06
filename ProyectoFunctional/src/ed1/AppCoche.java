package ed1;
import daw.com.Teclado;
import daw.com.Pantalla;

public class AppCoche {

	public static void main(String[] args) {
		String color, matricula, fabricante;
		int edad;
		String nombre, dni;
		int nCoches, fondos;
		Coche c = new Coche();
		Vendedores v = new Vendedores();
		
		//Lectura de valores mediante el teclado
		color = Teclado.leerString("Teclee el color del coche");
		matricula = Teclado.leerString("Teclee la matr�cula del coche en formato 1111 AAA");
		fabricante = Teclado.leerString("Teclee el fabricante del coche");
		edad = Teclado.leerInt("Teclee la edad del coche en a�os");
		nombre = Teclado.leerString("Introduzca el nombre del comprador");
		dni = Teclado.leerString("Introduzca el dni en formato 11111111A");
		nCoches = Teclado.leerInt("Introduzca el n�mero de coches a vender");
		fondos = Teclado.leerInt("Introduzca sus fondos");
		
		int opcion2 = 0;
		opcion2 = Teclado.leerInt("Introduzca 1 para mostrar los datos del vendedor introducidos o 2 para saltarlo");
		if (opcion2 == 1) {
			Vendedores.mostrarDatosV(v.getNombre(), v.getDni(), v.getNCoches(), v.getFondos());
		}
		
		//Aplicaci�n de esos valores al objeto
		c.setColor(color);
		c.setMatricula(matricula);
		c.setFabricante(fabricante);
		c.setEdad(edad);
		
		
		
		//Men� para acceder a las opciones
		int opcion = 0;
		while ((opcion != 1) && (opcion != 2) && (opcion != 3) && (opcion != 4)) {
			opcion = Teclado.leerInt("Teclee su opci�n: 1 para valorar su coche; 2 para conducirlo; 3 para valorarlo y venderlo; 4 para salir");
			if (opcion == 1) {
				c.valorarCoche(c.getEdad());
			}
			if (opcion == 2) {
				c.conducirCoche();
			}
			if (opcion == 3) {
				int valor = c.valorarCoche(c.getEdad());
				c.venderCoche(valor);
			}
		}
	}

}
