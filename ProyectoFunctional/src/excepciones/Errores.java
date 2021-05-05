package excepciones;

public class Errores {
	public static void main(String[] args) {
		int array[] = { 1, 2, 3 };

		try {

			System.out.println(array[1]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Sobrepasaste el limite del array");
		}
		
		catch (Exception e) {
			System.out.println("Cualquier otro error");
		}

	}
}
