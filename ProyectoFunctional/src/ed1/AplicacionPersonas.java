package ed1;

public class AplicacionPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creamos un objeto de tipo persona como tipo de datos de la clase Persona y mediante uno de los constructores.
		
		Personas p = new Personas();
		p.hablar("Hola �c�mo est�is?");
		// Mala pr�ctica...bad smell...cd�digo hardcodeado
		//p.presentarme("Antonio", "Mart�nez Garc�a", 59, "hetero", "29394857S");
		p.setNombre("Antonio");
		p.setApellidos("Mart�nez Garc�a");
		p.setEdad(59);
		p.setGenero("hetero");
		p.setDni("4848484849S");
		p.presentarme(p.getNombre(), p.getApellidos(), p.getEdad(), p.getGenero(), p.getDni());
	}

}
