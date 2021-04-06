package herenciaYPolimorfismoMiguel;

public class AppFigura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r;
		Circulo c;
		
		r = new Rectangulo ();
		c = new Circulo ();
		
		r.leerDatos();
		c.leerDatos();
		
		c.setColor(0);
		
		if (r.calcularPerimetro() > c.calcularPerimetro())
			r.mostrarDatos();
		else
			c.mostrarDatos();

	}

}
