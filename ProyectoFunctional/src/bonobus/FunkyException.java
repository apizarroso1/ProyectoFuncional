package bonobus;

public class FunkyException extends Exception{
	  
	  public FunkyException() {
		  super();
	  }
	  
	  public FunkyException(String mensaje) {
		  super(mensaje);
	  }
	  
	  public FunkyException(String mensaje, Throwable cause) {
		  super(mensaje, cause);
	  }
	  
	  public FunkyException(Throwable cause) {
		  super(cause);
	  }
}
