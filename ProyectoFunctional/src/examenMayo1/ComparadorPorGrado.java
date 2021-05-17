package examenMayo1;

import java.util.Comparator;

public class ComparadorPorGrado implements Comparator<Via> {

	@Override
	public int compare(Via o1, Via o2) {
		return o1.getGrado() - o2.getGrado();
	}

}
