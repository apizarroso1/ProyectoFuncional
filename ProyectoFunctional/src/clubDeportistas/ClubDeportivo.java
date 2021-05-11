package clubDeportistas;

import java.util.HashMap;
import java.util.Map;

public class ClubDeportivo {

	private Map <String, Deportista> deportistas;
	
	public ClubDeportivo(Map <String, Deportista> deportistas) {
		this.deportistas = deportistas;
	}
	
	public ClubDeportivo() {
		this.deportistas = new HashMap<>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
