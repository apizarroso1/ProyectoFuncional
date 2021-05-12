package clubDeportistas;

import java.util.HashMap;
import java.util.Map;

import libreria.AppMenu;

public class AppClubDeportistas extends AppMenu{

	private Map <String, Deportista> deportistas;

	public AppClubDeportistas() {
		super();
		
		getOpciones().add("\n1. Alta deportista");
		getOpciones().add("\n2. Baja deportista");
		getOpciones().add("\n3. Edicion deportista");
		getOpciones().add("\n4. Listar deportistas por tipo");
		getOpciones().add("\n5. Salir del programa");
		
		this.deportistas  = new HashMap<>();
	}
	
	public  static void main (String args[])
	{
		AppClubDeportistas app = new AppClubDeportistas();
		
		app.escribirFichero();
		
		
		
		
	}
	
	public void escribirFichero()
	
	@Override
	public void evaluarOpcion(int opc) {
		switch (opc) {
		case 1:
			altaDeportista();
			break;
		case 2:
			bajaDeportista();
			break;
		case 3:
			edicionDeportista();
			break;
		case 4:
			listarDeportistas();
			break;
		default:
			System.out.println("Fin de programa");
		}
		
	}
	
}
