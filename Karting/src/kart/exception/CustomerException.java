package kart.exception;

public class CustomerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String invalidIdException() {
		System.out.println("Invalid Id Entered");
		return ("Invalid Id Entered ") ;
	}

}