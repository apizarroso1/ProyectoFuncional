package institutosimple;

import java.util.Comparator;

public class ComparadorMensajePorFechas implements Comparator<Mensaje> {

	@Override
	public int compare(Mensaje o1, Mensaje o2) {
		// TODO Auto-generated method stub
		return o1.getFecha().compareTo(o2.getFecha());
	}

}
