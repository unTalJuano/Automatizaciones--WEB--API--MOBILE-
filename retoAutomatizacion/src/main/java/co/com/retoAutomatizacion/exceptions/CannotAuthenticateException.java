package co.com.retoAutomatizacion.exceptions;

public class CannotAuthenticateException extends Exception {
	
	 public CannotAuthenticateException(String actorName) {

	        super("El actor " + actorName + " no se puede autenticar");
	    }

}
