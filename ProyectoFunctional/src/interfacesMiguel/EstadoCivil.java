import java.util.ArrayList;
import java.util.Arrays;

public enum EstadoCivil {
	// Valores del enumerado
	SOLTERO,
	CASADO
	{
		@Override
		public String toString()
		{
			return "te casaste la ca....";
		}
	}
	, 
	DIVORCIADO,
	VIUDO;
	

	
	// Convertir enumeración a un ArrayList de String
	public static ArrayList<String> getValuesAsStringArrayList ()
	{
		
		
		//String estados[] = new String [EstadoCivil.values().length];
		ArrayList<String> estados = new ArrayList<>();
		EstadoCivil estadoCivil[] = EstadoCivil.values();
		
		for (int i = 0; i < estadoCivil.length; i++)
			estados.add (estadoCivil[i].name());
		
		
		return estados;
	}
	
	
	/*
	@Override
	public String toString ()
	{
		String estado = "";
		
		switch (this)
		{
		case CASADO:
			estado = "atado";
			break;
		case DIVORCIADO:
			estado = "libre pobre";
			break;
		case SOLTERO:
			estado = "libre rico";
			break;
		case VIUDO:
			estado = "apenado";
		}
		
		return estado;
	}
	*/
}
