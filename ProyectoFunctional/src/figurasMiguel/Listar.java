package ficherosherencia;

import java.util.ArrayList;
import java.util.List;

import daw.com.Pantalla;

public class Listar implements MenuAction {
	
	private AppFigurasBis app;
	
	public Listar (AppFigurasBis app)
	{
		this.app = app;
	}

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		List <Figura> figurasOrdenadas = new ArrayList<> (app.getFiguras().values());
		
		figurasOrdenadas.sort(new ComparadorPorArea());
		
		figurasOrdenadas.forEach(new EscribirFiguraPorPantalla());

	}

}
