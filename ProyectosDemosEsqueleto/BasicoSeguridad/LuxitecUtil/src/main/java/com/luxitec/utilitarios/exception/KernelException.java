package com.luxitec.utilitarios.exception;

/**
 * @author Danielle Delgado
 *
 */
@SuppressWarnings("serial")
public class KernelException extends Exception {

	public KernelException(String message) {
        super(message);
    }

	public KernelException(String message, Throwable throwable) {
		  super(message, throwable);
	}

	public KernelException(Throwable throwable) {
		  super(throwable);
	}
	

}
