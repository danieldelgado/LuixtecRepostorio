package com.luxitec.utilitarios.exception;

/**
 * @author Danielle Delgado
 *
 */
@SuppressWarnings("serial")
public class ControllerException extends ServiceException {

	public ControllerException(String message) {
        super(message);
    }

	public ControllerException(String message, Throwable throwable) {
		  super(message, throwable);
	}
	
	public ControllerException(Throwable throwable) {
		  super(throwable);
	}
	
}
