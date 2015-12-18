package com.luxitec.utilitarios.exception;

/**
 * @author Danielle Delgado
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends DAOException {

	public ServiceException(String message) {
        super(message);
    }

	public ServiceException(String message, Throwable throwable) {
		  super(message, throwable);
	}
	
	public ServiceException(Throwable throwable) {
		  super(throwable);
	}
	
}
