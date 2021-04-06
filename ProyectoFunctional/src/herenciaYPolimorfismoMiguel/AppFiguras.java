package herenciaYPolimorfismoMiguel;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppFiguras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura figuras[] = new Figura[3];
		int tipo;
		int pos = 0;
		int max;
		
		for (int i = 0; i < figuras.length; i++)
		{
			tipo = Teclado.leerInt("\n1.Rectángulo 2.Círculo");
			
			if (tipo == 1)
				figuras[i] = new Rectangulo ();
			else
				figuras[i] = new Circulo ();
			
			// magia -  polimorfismo
			figuras[i].leerDatos();
		}
		
		// magia ?
		max = figuras[0].calcularArea ();
		
		for (int i = 1 ; i < figuras.length; i++)
			if (figuras[i].calcularArea() > max)
			{
				pos = i;
				max = figuras[i].calcularArea();
			}
		
		Pantalla.escribirString("\nLa figura de mayor área es la " + pos);

	}

}
