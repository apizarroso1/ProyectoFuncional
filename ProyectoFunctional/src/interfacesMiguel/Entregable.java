package seriesYvideojuegos;

public interface Entregable extends Comparable<Entregable> {
	public void entregar ();
	public void devolver ();
	public boolean isEntregado ();
}
