package com.luxitec.utilitarios.exception;

/**
 * @author Danielle Delgado
 *
 */
@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException(String message) {
        super(message);
    }

	public DAOException(String message, Throwable throwable) {
		  super(message, throwable);
	}

	public DAOException(Throwable throwable) {
		  super(throwable);
	}
	

}
